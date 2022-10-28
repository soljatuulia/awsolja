/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
public class Mult extends CalcBase {

    public Mult(int num1, int num2) {
        super(num1, num2, '*');
    }

    public int result() {
        return num1*num2;
    }

    
}
