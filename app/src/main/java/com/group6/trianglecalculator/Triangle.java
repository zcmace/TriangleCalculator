package com.group6.trianglecalculator;

public class Triangle {

    /*
    triangle is constructed such that each angle is directly across from its
    side counter part (e.g. angleA is across from SideA).
    */

    private double angleA;
    private double angleB;
    private double angleC;

    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(){

    }

    /* Calculate the final angle of a triangle given two angles */
    public double CalculateAAA(double angle1, double angle2)
    {
        double result = 180 - angle1 - angle2;

        if (result <= 0)
        {
            System.out.println("The sum of the two angles must be less than 180 degrees");
            return -1;
        }

        return result;
    }

    /* Calculate the sides and angles of a triangle given two angles and a side */
    public void CalculateAAS(double angleA, double angleB, double sideA){

        this.angleA = angleA;
        this.angleB = angleB;
        this.sideA = sideA;

        this.angleC = CalculateAAA(angleA, angleB);

        double lawOfSinesValue = Math.sin(angleA)/sideA;
        this.sideB = Math.sin(angleB)/lawOfSinesValue;
        this.sideC = Math.sin(angleC)/lawOfSinesValue;

    }


    //getters and setters
    public double getAngleA() {
        return angleA;
    }

    public void setAngleA(double angleA) {
        this.angleA = angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public void setAngleB(double angleB) {
        this.angleB = angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public void setAngleC(double angleC) {
        this.angleC = angleC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}

