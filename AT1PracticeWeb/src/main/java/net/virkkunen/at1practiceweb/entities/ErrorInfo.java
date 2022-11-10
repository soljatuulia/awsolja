/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.at1practiceweb.entities;

/**
 *
 * @author Solja
 */
public class ErrorInfo {
    private int code=23;
    private String message="Virheellistä dataa";
    
    public ErrorInfo() {
        
    }
    
    public ErrorInfo(int c,String msg){
        this.code=c;
        this.message=msg;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
