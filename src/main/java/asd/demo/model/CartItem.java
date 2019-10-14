/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asd.demo.model;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class CartItem implements Serializable{
    private String userID;
    private String itemID;

    public CartItem() {
    }

    public CartItem(String userID, String itemID) {
        this.userID = userID;
        this.itemID = itemID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
    
    
}
