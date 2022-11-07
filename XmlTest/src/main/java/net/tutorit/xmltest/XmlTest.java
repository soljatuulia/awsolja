/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.xmltest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author jyrki
 */
public class XmlTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try{
                JAXBContext ctx=JAXBContext.newInstance(Person.class);
                Marshaller m=ctx.createMarshaller();
                m.marshal(new Person(), new File("person.xml"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        try{
                JAXBContext ctx=JAXBContext.newInstance(Person.class);
                Unmarshaller m=ctx.createUnmarshaller();
                Person p=(Person)m.unmarshal(new File("person.xml"));
         }
        catch(Exception ex){
            ex.printStackTrace();
        }        

        try{
                JAXBContext ctx=JAXBContext.newInstance(Company.class);
                Marshaller m=ctx.createMarshaller();
                m.marshal(new Company(), new File("company.xml"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }        
        /*
            Koita myös lukea henkilö tiedostosta
            Tutustu JAXB-annotatioihin, siirrä henkilön tiedot lapsielementeiltä attribuutteihin
            Tee Company-luokka, jolla lista muutamasta henkilöstä
            Kokeile Companyn "marshalointia"
        */
        
        ObjectMapper mapper = new ObjectMapper();
        try{
            String json = mapper.writeValueAsString(new Person());
            System.out.println(json);
            Person p = mapper.readValue(json, Person.class);
            System.out.println(p.getName()+","+p.getPhone());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        /*
            Kokeile json:a myös Companyn osalta
        */
        /*
            CSV formaatissa data on siis riveittäin pilkulla (tai puolipisteellä) eroteltuna
            Mahdollisesti myös otsikkorivi
            Nimi;Puhelinumero
            Jyrki,1233123
            Jussi,345345
            Yksinkertaiset tapaukset ovat helppoja ihan Javan omilla String-funktioilla
            Hankalammissa tapauksissa apukirjasto saattaa osoittautua tarpeelliseksi
        
            Apache commons on kokoelma eri käyttötarkoituksiin soveltuvia apukirjastoja
            Sieltä löytyy apuja myös csv:n tuottamiseen ja käsittelyyn
            Tutustu: https://commons.apache.org/proper/commons-csv/
            Ja koita saada yrityksen henkilöt (tai vain henkilölista) csv-muotoon.
        */
    }

}
