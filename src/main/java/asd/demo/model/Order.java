/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

/**
 *
 * @author gusck
 */
public class Order {
    private String ID;
    private String itemID;
    private String userID;
    private String address;
    private String dateListed;
    
    public Order(String ID, String itemID, String userID, String address, String dateListed) {
        this.ID = ID;
        this.itemID = itemID;
        this.userID = userID; 
        this.address = address;
        this.dateListed = dateListed;
    }

    public Order() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDateListed() {
        return dateListed;
    }

    public void setDateListed(String dateListed) {
        this.dateListed = dateListed;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}