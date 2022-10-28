/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.exceptions;

/**
 *
 * @author Solja
 */
public class MyException extends Exception {
    
    public String someRelevantData;

    public MyException(String data) {
        super("Something went wrong");
        someRelevantData = data;
    }
}
