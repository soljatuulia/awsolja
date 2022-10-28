/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Solja
 */
public class Some {
    
    private String word;
    
    public Some(String s) {
        this.word = s;
    }

    public void print() {
        System.out.println(this.toString() + " " + getWord());
    }
    
    public String toString() {
        return "Some";
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
    
}
