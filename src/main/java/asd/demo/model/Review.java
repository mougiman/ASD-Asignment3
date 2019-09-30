/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

/**
 *
 * @author Mougi
 */
public class Review {
    private String ID;
    private String ItemID;
    private String UserID;
    private String Desc;
    private String Title;
    private String DateListed;

    public Review(String ID, String ItemID, String UserID, String Desc, String Title, String DateListed) {
        this.ID = ID;
        this.ItemID = ItemID;
        this.UserID = UserID;
        this.Desc = Desc;
        this.Title = Title;
        this.DateListed = DateListed;
    }

    public Review() {
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDateListed(String DateListed) {
        this.DateListed = DateListed;
    }

    public String getID() {
        return ID;
    }

    public String getItemID() {
        return ItemID;
    }

    public String getUserID() {
        return UserID;
    }

    public String getDesc() {
        return Desc;
    }

    public String getTitle() {
        return Title;
    }

    public String getDateListed() {
        return DateListed;
    }
    
    
}
