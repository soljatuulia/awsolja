/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;

/**
 *
 * @author jyrki
 */
public class NewspaperList extends MediaList<Newspaper> {
    
    @Override
    public String getAll(Newspaper med) {
        return med.getDescription();
    }

}
