
package net.virkkunen.report;

import java.time.LocalDate;

/**
 *
 * @author Solja
 */
public class Person {
    
    private String name = "";
    private int age = 0;
    private LocalDate birthday = LocalDate.of(1900, 1, 1);
    
    public Person() {
        
    }
    
    public Person(String name, int age) {
       this.name = name;
       this.age = age;
    }

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
}
