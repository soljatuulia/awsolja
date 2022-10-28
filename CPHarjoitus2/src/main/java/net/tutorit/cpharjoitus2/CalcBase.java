/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
public abstract class CalcBase {
    protected int num1;
    protected int num2;
    protected char operator;

    public CalcBase(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }    
    
    public abstract int result();
    
    public void print() {
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result());
     }
}
