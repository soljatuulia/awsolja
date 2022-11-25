/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.techniques.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jyrki
 */
public class Hierarchies {
    
    
    static void iterate(Organization o,int level){
        String prefix=" ".repeat(level);
        System.out.println(prefix+o.getName().toUpperCase());
        prefix+="  ";
        for(Person p:o.getPersons()){
            System.out.println(prefix+p.getName());
        }
        for(Organization sub:o.getChildren()){
            iterate(sub,level+1);
        }
    }
    
    static Organization flatToHierarchy(List<Organization> ol){
        Organization root=new Organization("Root");
        ol.stream().forEach(o -> {
            Organization parent=ol.stream().filter(op -> op.getId()==o.getParentId()).findFirst().orElse(null);
            if (parent!=null) parent.addChild(o);
            else root.addChild(o);
        });
        return root;
    }
    
    static public void main(String[] args){
        Organization root=new Organization("Beat Less Corp","John","Paul","Ringo","George");
        Organization sub1=new Organization("Hurr IGanes","Remu","Cisse","Ile");
        Organization sub2=new Organization("Hanoi Roks","Michael","Nasty","Andy");
        Organization sub3=new Organization("Din Go","Nipa","Quuppa","Jonttu");
        root.addChild(sub1);
        root.addChild(sub3);
        sub1.addChild(sub2);
        iterate(root,0);
        System.out.println("Let's start form flat list");
        ArrayList<Organization> ol=new ArrayList<>();
        ol.add(new Organization("Beat Less Corp",1,0));
        ol.add(new Organization("Hurr IGanes",2,1));
        ol.add(new Organization("Hanoi Roks",3,2));
        ol.add(new Organization("Din go",4,1));
        Organization oh=flatToHierarchy(ol);
        iterate(oh,0);
    }
}
