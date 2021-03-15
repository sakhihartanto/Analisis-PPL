/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShape;

/**
 *
 * @author User
 */
public abstract class Shape {
    String shapeName;
    
    public Shape(String shapeName){
        this.shapeName = shapeName;
    }
    abstract double area();
    
    public String toString(){
        this.shapeName = shapeName;
        return shapeName;
    }
    
}
