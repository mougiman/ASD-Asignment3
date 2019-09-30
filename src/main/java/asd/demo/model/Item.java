/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

import java.io.Serializable;

/**
 *
 * @author Calvin
 */
public class Item implements Serializable {

    private String ID;
    private String name;
    private String dateListed;
    private int stock;
    private double price;
    private String description;
    private String category;
    private String expDate;
    private String sellerID;
    private boolean ifAuc;
    private String image;

    public Item(String ID, String name, String dateListed, int stock, double price,
            String description, String category, String sellerID, String expDate, boolean ifAuc, String image) {

        this.ID = ID;
        this.name = name;
        this.dateListed = dateListed;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.category = category;
        this.expDate = expDate;
        this.sellerID = sellerID;
        this.ifAuc = ifAuc;
        this.image = image;
    }

    public Item() {
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * @return the expDate
     */
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateListed
     */
    public String getDateListed() {
        return dateListed;
    }

    /**
     * @param dateListed the dateListed to set
     */
    public void setDateListed(String dateListed) {
        this.dateListed = dateListed;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    public boolean ifAuc() {
        return ifAuc;
    }
}
