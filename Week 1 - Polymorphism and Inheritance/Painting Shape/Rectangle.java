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
public class Rectangle extends Shape{
    private double length;
    private double width;//radius in feet
//----------------------------------
// Constructor: Sets up the sphere.
//----------------------------------

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }
//-----------------------------------------
// Returns the surface area of the sphere.
//-----------------------------------------

    public double area() {
        return length * width;
    }
    //-----------------------------------
// Returns the sphere as a String.
//-----------------------------------

    public String toString() {
        return super.toString() + " of length " + length + " width "+  width;
    }
}

