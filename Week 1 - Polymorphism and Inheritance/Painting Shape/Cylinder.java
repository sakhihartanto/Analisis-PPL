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
public class Cylinder extends Shape{

    private double radius;
    private double height;//radius in feet
//----------------------------------
// Constructor: Sets up the sphere.
//----------------------------------

    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }
//-----------------------------------------
// Returns the surface area of the sphere.
//-----------------------------------------

    public double area() {
        return ((2*Math.PI*radius*height)+(2*Math.PI*radius*radius));
    }
    //-----------------------------------
// Returns the sphere as a String.
//-----------------------------------

    public String toString() {
        return super.toString() + " of radius " + radius + " Height " +height;
    }
}
