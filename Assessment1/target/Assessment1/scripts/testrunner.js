const HTTP={
	get: (url,ae) => doAjax(url,'get',null,null,ae),
	delete: (url,ae) => doAjax(url,'delete',null,null,ae),
	put: (url,data,ct=null,ae=0) => doAjax(url,'put',data,ct,ae),
	post: (url,data,ct=null,ae=0) => doAjax(url,'post',data,ct,ae)
};


$(document).ready(function(){
    let loc=window.location.href;
//    console.log("Location",window.location.pathname);

    $("article section").each((i,o) => {
        if (!i) $(o).css("display","");
        else $(o).css("display","none");
        let id=o.id;
        let title=$(o).find("h2").text();
        let test=$(`<div class="runTestDiv"><p>Paina Test-nappulaa kokeillaksesi toimiiko ratkaisusi</p>
            <p><input class="runtest" type="button" value="Test"/></p>
            <div id="${id}_result"></div></div>`);
        $(o).append(test);
        test.find("input.runtest").data("run",id);
        test.find("input.runtest").click(function(){
            let f=$(this).data("run");
            runTest(f);
        });
        let navi=$(`<div><span id="${id}_indicator" class="indicator failed"></span><span>${title}</span></div>`);
        $("aside").append(navi);
        navi.data('show',id);
        navi.click(function(){
            let id=$(this).data('show');
            $("article section").css("display","none");
            $("#"+id).css("display","");
       });
       runAllTests();
    });
});

function setAnswerStatus(obj){
    let idResult="#"+obj.id+"_result";
    let idIndicator="#"+obj.id+"_indicator";
    let idFrame="#"+obj.id+"_frame";
    $(idFrame).remove();
    if(obj.success){
        $(idResult).html(`<p>Tehtävä suoritettu oikein!</p>
                <p>Kopioi oheinen teksti vastaukseksi 
                Canvaksen kysymykseen ${obj.questionNumber}: 
                <input class="answer" value="${obj.answer}" />`);
        //$(idIndicator).text("O");
        $(idIndicator).removeClass("failed");
        $(idIndicator).addClass("success");
    }
    else{
        $(idResult).html(obj.response);
        $(idIndicator).removeClass("success");
        $(idIndicator).addClass("failed");
        //$(idIndicator).text("X");
        if (obj.extraHtml){
            $(idResult).append(`<iframe id="${obj.id}_frame"></iframe>`);
            $(idFrame).contents().find('html').html(obj.extraHtml);
        }
    }
}

function ok(ex){
    let answer=atob(testingItems[ex].answer.substring(1));
    let id=ex;
    let success=true;
    let questionNumber=testingItems[ex].questionNumber;
    let obj={id,answer,success,questionNumber};
    setAnswerStatus(obj);
}

function failed(id,note,xr=null){
    let obj={id,note,success:false, answer:''};
    if (xr){
        let response=`<p>${note}</p>
            <p>Status: ${xr.status} ${xr.statusText}</p>`;
        //let response="Status: "+xr.status+" "+xr.statusText+"<br />";
        obj.response=response;
        obj.extraHtml=xr.responseText;
    }
    else{
        obj.response=`<p>Vastaus ei ole kelvollinen: ${note}</p>`;
    }
    setAnswerStatus(obj);
}

function iterateTests(tests,i,values,cb){
    if (i>=tests.length) cb();
    let t=tests[i];
    let ct=t.contentType || 'application/json';
    if (t.method=='post'){
        HTTP.post(t.url,t.data,ct,t.acceptError).then(resp => {
            values.push(resp);
            iterateTests(tests,i+1,values,cb);
        });
    }
    else if (t.method=='put') {
        HTTP.put(t.url,t.data,ct,t.acceptError).then(resp => {
            values.push(resp)
            iterateTests(tests,i+1,values,cb);
        });
    }
    else if (t.method=='delete'){ 
        HTTP.delete(t.url,t.acceptError).then(resp => {
            values.push(resp)
            iterateTests(tests,i+1,values,cb);
        });
    }
    else {
        HTTP.get(t.url,t.acceptError).then(resp => {
            values.push(resp)
            iterateTests(tests,i+1,values,cb);
        }); 
    }
}

function runTest(ex){
    //console.log(window.testingItems);
    let test=window.testingItems[ex];
    let values=[];
    iterateTests(test.tests,0,values,function(){
        console.log("Valmista");
        let firstFailed=values.find(v => !v.success);
        if (firstFailed){
            failed(ex,"Osa testeistä epäonnistui palvelimen antaman virhekoodin takia",firstFailed.xr);
            return;
        }
        let responses=values.map(v => v.text);
        let verify="verify_"+ex;
        window[verify](ex,responses);
    });
}

function runAllTests(){
    for(let id in window.testingItems){
        runTest(id);
    }
}

function doAjax(url,method,data=null,ct=null,ae=0) {
    if (!ct) ct="application/json";
    return new Promise(function(resolve,reject){
        var xr=new XMLHttpRequest();
        xr.onreadystatechange=function(){
            if(xr.readyState==4){
                //console.log("text",xr.responseText);
                let text=xr.responseText;
                let status=xr.status;
                let success=(((xr.status>=200)&&(xr.status<300))||(xr.status==ae));
                let resp={text,status,success,xr};
                if((xr.status>=200)&&(xr.status<300)){
                    try{
                        let obj=JSON.parse(xr.responseText);
                        resp.data=obj;
                    }
                    catch(e){
                    }
                }
                resolve(resp);
            }
        };
        let pn=window.location.pathname;
        if (!pn.endsWith("/")) pn+="/";
        if (url.startsWith("/")) url=url.substring(1);
        xr.open(method,pn+url,true);
        xr.setRequestHeader("Content-Type",ct);
        //xr.setRequestHeader("Accept",accept);
        xr.send(data);
    });
}

