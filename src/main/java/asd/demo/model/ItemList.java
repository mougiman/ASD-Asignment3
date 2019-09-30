/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Calvin
 */
public class ItemList implements Serializable {
    
    private ArrayList<Item> list = new ArrayList<>();
    
    public ItemList(){
    }
    
    public ArrayList<Item> getList(){
        return list;
    }
    
    public Item getItem(String name){
        for (Item item: list){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }   
    
    public void addItem(Item item){
        list.add(item);
    }
    
    public void removeItem(Item item){
        if (item != null){
            list.remove(item);
        }
        else{
            System.out.print("Item does not exist");
        }
    }
    
}
