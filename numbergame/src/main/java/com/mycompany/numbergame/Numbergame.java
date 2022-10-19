/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.numbergame;
import java.util.Scanner;

public class Numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = 0;
        
        int secret=(int)(Math.random()*100+1);
        
        System.out.println("Arvaa luku!");
        
        while (true) {
            int number = scanner.nextInt();
            
            if (number > secret) {
                count++;
                System.out.println("Liian iso numero.");
            } else if (number < secret) {
                count++;
                System.out.println("Liian pieni numero.");
            } else if (number == secret && count == 0) {
                count++;
                System.out.println("Oikein! Tarvitsit yhden arvauksen.");
                break;
            } else if (number == secret && count > 0) {
                count++;
                System.out.println("Oikein! Tarvitsit " + count + " arvausta.");
                break;
            }
        }
    }
}
