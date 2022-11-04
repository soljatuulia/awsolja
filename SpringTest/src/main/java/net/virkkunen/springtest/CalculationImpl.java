/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springtest;

import org.springframework.stereotype.Component;

/**
 *
 * @author Solja
 */
@Component
public class CalculationImpl implements Calculation {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
    
}
