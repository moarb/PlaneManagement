/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1996773_planemanagement;

/**
 *
 * @author mohai
 */
public class Row {

    private Seat[] seats;

    public Row(String rowName, int seatNum) {
        this.seats = new Seat[seatNum];

        for (int i = 1; i <= seatNum; i++) {
            String seatName = rowName + i;
            Seat seat = new Seat(seatName, i);
            this.seats[i - 1] = seat;
        }
    }

    public Seat[] getSeats() {
        return this.seats;
    }
}
