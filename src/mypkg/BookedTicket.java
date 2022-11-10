/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class BookedTicket {
    private String ride;
    private String date;
    private String name;
    private String phone;
    private String packg;
    private String ticketNum;
    private int bookingNo;

    public BookedTicket(String ride, String date, String name, String phone, String packg, String ticketNum, int bookingNo) {
        this.ride = ride;
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.packg = packg;
        this.ticketNum = ticketNum;
        this.bookingNo = bookingNo;
    }

    

    
    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPackg() {
        return packg;
    }

    public void setPackg(String packg) {
        this.packg = packg;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }
    
    
}
