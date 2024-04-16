/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w1996773_planemanagement;

/**
 *
 * @author mohai
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class W1996773_PlaneManagement {

    // METHODS
    
    static String selectSeat() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please select an row letter: ");
        String SeatRow = input.next();
        System.out.print("Please select an seat number: ");
        int SeatNum = input.nextInt();
        String seatName = SeatRow + SeatNum;

        if (((!SeatRow.equals("A") && !SeatRow.equals("D")) || (SeatNum > 14 || SeatNum < 1)) && ((!SeatRow.equals("B") && !SeatRow.equals("C")) || (SeatNum > 12 || SeatNum < 1))) {
            System.out.println("Invalid selection");
            selectSeat();
            return null;
        }
        return seatName;
    }

    static void buy_seat(Row[] plane, Ticket[] tickets) {
        String seatName = selectSeat();
        
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = input.next();
        
        System.out.print("What is your surname: ");    
        String surname = input.next();
        
        System.out.print("What is your email: ");
        String email = input.next();
        
        Person person = new Person(name, surname, email);
        
        for (int i = 0; i < plane.length; i++) {
            Row row = plane[i];
            Seat[] seats = row.getSeats();
            for (int j = 0; j < seats.length; j++) {
                Seat seat = seats[j];
                if ((seat.getName().equals(seatName)) && (seat.isAvailable == 0)) {
                    seat.isAvailable = 1;
                    tickets[j] = new Ticket(seat, row, seat.price, person);
                    tickets[j].save();
                    System.out.println("Seat " + seatName + " has been bought");
                }
            }
        }
    }

    static void cancel_seat(Row[] plane, Ticket[] tickets) {
        String seatName = selectSeat();

        for (int i = 0; i < plane.length; i++) {
            Seat[] seats = plane[i].getSeats();
            for (int j = 0; j < seats.length; j++) {
                Seat seat = seats[j];
                if ((seat.getName().equals(seatName)) && (seat.isAvailable == 1)) {
                    seat.isAvailable = 0;
                    System.out.println("Seat " + seatName + " has been cancelled");
                }
            }
        }
    }

    static Seat find_first_available(Row[] plane) {

        for (int i = 0; i < plane.length; i++) {
            Seat[] seats = plane[i].getSeats();
            for (int j = 0; j < seats.length; j++) {
                Seat seat = seats[j];
                if (seat.isAvailable == 0) {
                    return seat;
                }
            }
        }
        return null;
    }

    static void show_seating_plan(Row[] plane) {
        for (int i = 0; i < plane.length; i++) {
            Row row = plane[i];
            Seat[] seats = row.getSeats();
            for (int j = 0; j < seats.length; j++) {
                Seat seat = seats[j];
                if (seat.isAvailable == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.print("\n");
        }
    }
    
    
    static void print_tickets_info(Ticket[] tickets){
        int sum = 0;
        for (int i = 0; i < tickets.length; i++){
            Ticket ticket = tickets[i];
            if (ticket.getSeat().isAvailable == 0 || ticket.getPerson() == null){
                continue;
            }
            ticket.ticketInfo();
            sum = ticket.getPrice() + sum;
        }
        System.out.println("Sum of tickets is: £" + sum);
    }
    
    
    static void search_ticket(Ticket[] tickets){
        Scanner input = new Scanner(System.in);
        System.out.print("Please select an row letter: ");
        String seatRow = input.next();
        System.out.print("Please select an seat number: ");
        int seatNum = input.nextInt();
        String seatName = seatRow + seatNum;
        
        try {
            for (int i = 0; i < tickets.length; i++) {
                Ticket ticket = tickets[i];
                if (ticket.getSeat().isAvailable == 1 && seatName.equals(ticket.getSeat().getName())) {
                    ticket.ticketInfo();
                    return;
                } 
                else if(seatName.equals(ticket.getSeat().getName())){
                    System.out.println("This seat is available");
                }
            }
        } catch (NullPointerException e) {
                System.out.println("This seat is available");
                return;
        }
    }

    //MAIN
    public static void main(String[] args) {

        Row rowA = new Row("A", 14);
        Row rowB = new Row("B", 12);
        Row rowC = new Row("C", 12);
        Row rowD = new Row("D", 14);

        Row[] plane = new Row[4];
        plane[0] = rowA;
        plane[1] = rowB;
        plane[2] = rowC;
        plane[3] = rowD;

        Ticket[] tickets = new Ticket[52];
        
        int ticketCounter = 0;
        for (int i = 0; i < plane.length; i++) {
            Row row = plane[i];
            Seat[] seats = row.getSeats();
            for (int j = 0; j < seats.length; j++) {
                Seat seat = seats[j];
                Ticket ticket = new Ticket(seat, row, seat.price, null);
                tickets[ticketCounter] = ticket;
                ticketCounter++;
            }
        }
        
        int choice = 0;

        while (choice >= 0 || choice <= 6) {

            System.out.println(
                    "**************************************************"
                    + "\n*                     MENU                       *"
                    + "\n**************************************************");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print ticket infomation and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            System.out.println("**************************************************");
            Scanner input = new Scanner(System.in);
            System.out.print("Please select an option: ");
            

            try{
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        buy_seat(plane, tickets);
                        break;
                    case 2:
                        cancel_seat(plane, tickets);
                        break;
                    case 3:
                        Seat firstAvailableSeat = find_first_available(plane);
                        if (firstAvailableSeat == null) {
                            System.out.println("There are no available seats.");
                        } else {
                            System.out.println("The first available seat is " + firstAvailableSeat.getName());
                        }   break;
                    case 4:
                        show_seating_plan(plane);
                        break;
                    case 5:
                        print_tickets_info(tickets);
                        break;
                    case 6:
                        search_ticket(tickets);
                        break;
                    case 0:
                        System.out.println("Thank you and Goodbye");
                        return;
                    default:
                        System.out.println("Invalid input");
                        System.out.print("Please select an option: ");
                        choice = input.nextInt();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        }
    }
}

