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
public class solditems {
    
    private int item_id;
    private String name;
    private String description;
    private int qty;
    private float price;

    public solditems(int item_id, String name, String description, int qty, float price) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return name;
    }
    
    
}
