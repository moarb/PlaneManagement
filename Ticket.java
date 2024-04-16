/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1996773_planemanagement;

/**
 *
 * @author mohai
 */
import java.io.File;  
import java.io.IOException;
import java.io.FileWriter; 

public class Ticket {
    private Seat seat;
    private Row row;
    private int price;
    private Person person;
    
    public Ticket(Seat seat, Row row, int price, Person person){
        this.seat = seat;
        this.row = row;
        this.price = price;
        this.person = person;
    }
    
    public Seat getSeat(){
        return this.seat;
    }
    
    public Row getRow(){
        return this.row;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public Person getPerson(){
        return this.person;
    }
    
    public void setSeat(Seat seat){
        this.seat = seat;
    }
    
    public void setRow(Row row){
        this.row = row;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
    
    public void ticketInfo(){
        this.seat.seatInfo();
        System.out.println(this.price);
        this.person.personInfo();
        System.out.println("\n");
    }
    
    
    public void save(){
        try {
          String fileName = this.seat.getName()+".txt";
          File myObj = new File(fileName);
          if (myObj.createNewFile()) {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(this.seat.getName() 
                    + "\n" + this.price 
                    + "\n" + this.person.getName() 
                    + "\n" + this.person.getSurname() 
                    + "\n" + this.person.getEmail() );
            myWriter.close();
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
    
    
}

