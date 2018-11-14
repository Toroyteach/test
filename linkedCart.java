/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventmgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tabs Toro
 */
public class linkedCart {
    public final String Name;
    public final int Quantity;
    public final Float UnitPrice;
    public final Float Total;
    private int id;
    private String Query;
    private String Query2;
    
    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;
    Statement stmt = null;
    
    private int count = 0;
    
    
    public linkedCart(String Name, int Quantity, Float UnitPrice){
        this.Name = Name;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.count ++;
        this.Total = Quantity * UnitPrice;
    }
    
    int salesid = 1002;
    
    public int getId(){
        return id;
    }
    public String getName() {
        return Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Float getUnitPrice() {
        return UnitPrice;
    }

    public Float getTotal() {
        return Total;
    }
    
    
    public void insertDatabase(){
        Query = "INSERT INTO sold_items(sales_id, product_Name, item_id, qty, price) VALUES ('"+salesid+"', '"+Name+"', '"+count+"', '"+Quantity+"', '"+Total+"')";
        Query2 = "UPDATE items SET qty_stock = qty_stock - '"+Quantity+"' WHERE name = '"+Name+"'";
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/stockmanagementdb", "root", "");
            pst = conn.prepareStatement(Query);
            pst2 = conn.prepareStatement(Query2);
            pst.executeUpdate();
            pst2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(linkedCart.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public int getCount(){
        return count;
    }
}
