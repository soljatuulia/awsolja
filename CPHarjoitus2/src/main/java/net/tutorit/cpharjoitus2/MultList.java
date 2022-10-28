/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

import java.util.ArrayList;

/**
 *
 * @author jyrki
 */
public class MultList extends CalcList<Mult> {

    public void print(){
        for(Mult m:calculations){
            System.out.println("Tulo "+m.result());
        }
    }
}
