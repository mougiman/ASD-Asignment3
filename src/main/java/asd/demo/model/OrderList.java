/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gusck
 */
public class OrderList implements Serializable {
    
    private ArrayList<Order> list = new ArrayList<>();
    
    public OrderList(){
    }
    
    public ArrayList<Order> getList(){
        return list;
    }
    
    public Order getOrder(String id){
        for (Order order: list){
            if(order.getID().equals(id)){
                return order;
            }
        }
        return null;
    }    
    
}