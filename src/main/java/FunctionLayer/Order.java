/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Hassuni
 */
public class Order {
    
    private int heigth;
    private int length;
    private int width;
    private boolean shipped;
    private int id;
    public Order(int heigth, int length, int width, boolean shipped) {
        this.heigth = heigth;
        this.length = length;
        this.width = width;
        this.shipped = shipped;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getHeigth() {
        return heigth;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isShipped() {
        return shipped;
    }
    
    
}
