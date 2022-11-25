
function makeTheCall(url,method,data){
    return new Promise(function(resolve,reject){
        let x=new XMLHttpRequest();
        x.onreadystatechange=function(){
            if (x.readyState==4) {
                try{
                    let obj=JSON.parse(x.responseText);
                    resolve(obj);
                }
                catch(ex){
                    reject(x);
                }
            };
        }
        x.open(method,url,true);
        x.setRequestHeader("Content-Type","application/json");
        x.setRequestHeader("Accept","application/json");
        x.send(data && JSON.stringify(data));
    });
}

let HTTP={
    get: url => makeTheCall(url,"get"),
    put: (url,data) => makeTheCall(url,"put",data),
    post: (url,data) => makeTheCall(url,"post",data),
    delete: (url) => makeTheCall(url,"delete")
};

function runFirstTest(){
    document.getElementById("ekatulos").innerText="";
    HTTP.get("/employees").then(employees =>{
        document.getElementById("ekatulos").innerText="Jep, toimii";
        let options='<option>Ei valittu</option>';
        employees.forEach(emp => {
            options+=`<option value="${emp.employeeId}">${emp.name}</option>`;
        });
        document.getElementById("superior").innerHTML=options;
        document.getElementById("eka").classList.add("hidden");
        document.getElementById("toka").classList.remove("hidden");
        
    }).catch(ex => {
        document.getElementById("ekatulos").innerText="Ei vielä ihan toimi";
    });
}

function readInput(element){
    document.getElementById(element).classList.remove("error");
    let data=document.getElementById(element).value;
    if (!data) document.getElementById(element).classList.add("error");
    return data;
}

function create(){
    let name=readInput("name");
    let employeeId=readInput("empid");
    let superiorId=document.getElementById("superior").value;
    if (!name || !employeeId) return;
    let obj={name,employeeId};
    if (superiorId) obj.superiorId=superiorId;
    HTTP.post("/employees",obj).then(emp => {
       runFirstTest(); 
    });
}

function sendFile(file) {
    let fileReader = new FileReader(); 
    fileReader.onload = function(e) { 
        let xhr = new XMLHttpRequest;
        xhr.onreadystatechange=function(rs){
            if (xhr.readyState==4){
                console.log(xhr.status,xhr.responseText);
            }
        };
        xhr.open("POST", "/employees/upload");
        xhr.setRequestHeader("Content-Type","text/csv");
        xhr.send(e.target.result);
    }; 
    fileReader.readAsText(file); 
}


function drop(e) {
  e.stopPropagation();
  e.preventDefault();
  let files = e.dataTransfer.files;	
  sendFile(files.item(0));	
}

function dragenter(e) {
  e.stopPropagation();
  e.preventDefault();
}
 
function dragover(e) {
  e.stopPropagation();
  e.preventDefault();
} 


window.onload=function(){
    document.getElementById("ekatesti").addEventListener("click",runFirstTest);
    document.getElementById("create").addEventListener("click",create);
    runFirstTest();
    let dropbox = document.getElementById("drop");
    dropbox.addEventListener("dragenter", dragenter, false);
    dropbox.addEventListener("dragover", dragover, false);
    dropbox.addEventListener("drop", drop, false);
}