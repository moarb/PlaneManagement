/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1996773_planemanagement;

/**
 *
 * @author mohai
 */
public class Person {
    private String name;
    private String surname;
    private String email;
    
    public Person(String personName, String personSurname, String email){
        this.name = personName;
        this.surname = personSurname;
        this.email = email;
    }
    
    public String getName(){
            return this.name;
    }
    
    public String getSurname(){
            return this.surname;
    }
    
    public String getEmail(){
            return this.email;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public void setEmail(String email){
        this.name = email;
    }
    
    public void personInfo(){
        System.out.println(this.name);
        System.out.println(this.surname);
        System.out.println(this.email);
    }
}
