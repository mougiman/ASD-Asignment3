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
public class Rating {
    private String ID;
    private String SellerID;
    private String UserID;
    private String Desc;
    private String Title;
    private String DateListed;
    private String Score;
    
    public Rating(String ID, String SellerID, String UserID, String Desc, String Title, String DateListed, String Score) {
        this.ID = ID;
        this.SellerID = SellerID;
        this.UserID = UserID;
        this.Desc = Desc;
        this.Title = Title;
        this.Score = Score;
        this.DateListed = DateListed;
    }

    public Rating() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSellerID() {
        return SellerID;
    }

    public void setSellerID(String SellerID) {
        this.SellerID = SellerID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDateListed() {
        return DateListed;
    }

    public void setDateListed(String DateListed) {
        this.DateListed = DateListed;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String Score) {
        this.Score = Score;
    }
    
    
}
