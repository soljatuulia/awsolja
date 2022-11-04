/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.virkkunen.springtest;

import net.virkkunen.springtest.Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Solja
 */
@Configuration
public class UtilBeans {
    
    @Bean
    public Util registerUtil() {
        System.out.println("Now register util");
        return new UtilImpl();
    }

    @Bean
    public UsingUtil secondRegisterUtil() {
        System.out.println("Then register second util");
        return new UsingUtilImpls();
    }
    
}
