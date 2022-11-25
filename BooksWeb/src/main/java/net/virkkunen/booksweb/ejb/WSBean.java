/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.booksweb.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timeout;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerService;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.util.ArrayList;

/**
 *
 * @author Solja
 */
@Singleton
@Startup
@ServerEndpoint("/monitor")
public class WSBean {
    
    @Resource
    TimerService timer;
    private ArrayList<Session> sessions = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        System.out.println("Alku");
        timer.createTimer(0,1000,null);
    }
    
    @PreDestroy
    public void loppu() {
        System.out.println("Loppu");
        for(Timer t : timer.getTimers()) {
            t.cancel();
        }
    }
    
    //@Schedule(second="*",minute="*",hour="*")
    public void ajastettu() {
        System.out.println("Tänne sekunnin välein");
    }
    
    int luku = 100;
    
    @Timeout
    public void toinenAjastettu() {
        System.out.println("Toka ajastettu");
        luku += (int)(20*Math.random()-10);
        if (luku<20) {
            luku = 20;
        } 
        if (luku>180) {
            luku = 180;
        }
        
        try {
            for (Session ses:sessions) {
                ses.getBasicRemote().sendText(""+luku);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @OnOpen
    public void sainYhteyden(Session session) {
        sessions.add(session);
    }
    
}
