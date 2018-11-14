/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventmgmt;

/**
 *
 * @author Tabs Toro
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tabs Toro
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private float Price;
    private int qtystock;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stmt = null;

    public Item(int id, String name, String description, float Price, int qtystock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.Price = Price;
        this.qtystock = qtystock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getQtystock() {
        return qtystock;
    }

    public void setQtystock(int qtystock) {
        this.qtystock = qtystock;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    public static Item getItemById(int itemid) throws Exception {
        PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM items WHERE id = ?");
        pst.setInt(1, itemid);
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.first()){
            return new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("qty_stock"));
        } else {
            throw new  Exception("item number not found");
        }
    }
}
