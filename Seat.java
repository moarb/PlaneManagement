/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1996773_planemanagement;

/**
 *
 * @author mohai
 */
public class Seat {

    private String name;
    public int isAvailable;
    public int price;

    public Seat(String name, int seatNumber) {
        this.name = name;
        this.isAvailable = 0;
        
        if (seatNumber >= 1 && seatNumber <= 5){
            this.price = 200;
        }
        else if (seatNumber >= 6 && seatNumber <= 9){
            this.price = 150;
        }
        else if (seatNumber >= 10 && seatNumber <= 14){
            this.price = 180;
        }
    }

    public String getName() {
        return this.name;
    }
    
    public void seatInfo(){
        System.out.println(this.name);
    }
}

