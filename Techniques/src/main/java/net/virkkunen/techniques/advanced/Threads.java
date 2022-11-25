package net.virkkunen.techniques.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Point{
    private int x,y;
    
    static void justWait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(Exception ex){}
    }
    
    public void set(int val){
        x=val;
        justWait(100);
        y=val;
    }
    
    public String toString(){
        return "("+x+","+y+")";
    }
}


public class Threads extends Thread{
    static Point pt=new Point();
    private int threadId;
    static private Object myMutex=new Object();
    
    public Threads(int tid){
        threadId=tid;
        start();
    }
    
    public void run(){
        for(int i=0;i<10;i++){
            pt.set(threadId);
            Point.justWait(10);
            System.out.println("Thread "+threadId+":"+pt);
        }
    }
    
    static public void main(String[] args){
        new Threads(1);
        new Threads(2);
        new Threads(3);
        new Threads(4);
        new Threads(5);
    }
    
    static Point getPoint(int v){
        Point pt=new Point();
        pt.set(v);
        try{
            Thread.sleep(2000);
        }
        catch(Exception ex){
            
        }
        return pt;
    }
    
    static public void otherSamplesForStartingAThread(String[] args){
        ExecutorService threadPool=Executors.newFixedThreadPool(6);
        threadPool.execute(new Threads(1));
        threadPool.execute(new Threads(2));
        threadPool.execute(new Threads(3));
        threadPool.execute(new Threads(4));
        threadPool.execute(new Threads(5));
        
        Future<Point> fut=threadPool.submit(() -> getPoint(6));
        threadPool.shutdown();
        try{
            System.out.println("Waiting for point");
            System.out.println(fut.get());
        }
        catch(Exception ex){
            
        }
        System.out.println("Kohta käynnistyy....");
        ScheduledExecutorService ses=Executors.newScheduledThreadPool(2);
        ses.schedule(() -> System.out.println("Scheduled"),10,TimeUnit.SECONDS);
        ses.shutdown();
    }
}
