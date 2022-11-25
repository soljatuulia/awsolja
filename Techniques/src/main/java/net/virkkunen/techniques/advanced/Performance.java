package net.virkkunen.techniques.advanced;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jyrki
 */

class SomeUtil{
    int value;
    
    public SomeUtil(int i){
        value=i;
    }
    
    public String toString(){
        return "Some "+value;
    }
}

public class Performance {
    
    static void doTheJobBad(){
        long begin = System.nanoTime();
        System.out.println("Begin "+begin);
        String s="";
        for(int i=0;i<10000;i++){
            String helper=LocalDate.now()+", "+i;
            s+=helper;
            s+=new SomeUtil(i);
        }
        long end=System.nanoTime();
        System.out.println("End "+end);
        System.out.println("Bad took "+((double)(end-begin))/1000000000+"s");
    }
    
    static void doTheJobBetter(){
        long begin = System.nanoTime();
        System.out.println("Begin "+begin);
        StringBuilder s=new StringBuilder();
        for(int i=0;i<10000;i++){
            String helper=LocalDate.now()+", "+i;
            s.append(helper);
            s.append(new SomeUtil(i));
        }
        long end=System.nanoTime();
        System.out.println("End "+end);
        System.out.println("Better took "+((double)(end-begin))/1000000000+"s");
        
    }
    
    static public void main(String[] args){
        doTheJobBad();
        doTheJobBetter();
    }
}
