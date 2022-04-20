package com.group6.trianglecalculator;

import android.util.Log;

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
    public void CalculateAAA(double angle1, double angle2)
    {
        this.angleA = angle1;
        this.angleB = angle2;
        double result = 180 - angle1 - angle2;

        if (result <= 0)
        {
            System.out.println("The sum of the two angles must be less than 180 degrees");
            return;
        }else{
            this.angleC = result;
        }
    }

    /* Calculate the sides and angles of a triangle given two angles and a side */
    public void CalculateAAS(double angleA, double angleB, double sideA){

        this.angleA = angleA;
        this.angleB = angleB;
        this.sideA = sideA;

        this.CalculateAAA(angleA, angleB);


        double lawOfSinesValue = Math.sin(Math.toRadians(angleA))/sideA;
        this.sideB = Math.sin(Math.toRadians(angleB))/lawOfSinesValue;
        this.sideC = Math.sin(Math.toRadians(angleC))/lawOfSinesValue;


    }

    /* calculate the angles and sides of the triangle given an Angle, Side, and Angle */
    public void CalculateASA(double angleA, double sideC, double angleB){
        this.angleA = angleA;
        this.sideC = sideC;
        this.angleB = angleB;

        this.CalculateAAA(angleA, angleB);

        double lawOfSinesValue = Math.sin(Math.toRadians(angleC))/sideC;

        this.sideA = Math.sin(Math.toRadians(angleA))/lawOfSinesValue;
        this.sideB = Math.sin(Math.toRadians(angleB))/lawOfSinesValue;

    }


    /* calculate the angles and sides of the triangle given a Side, an Angle, and a Side */
    public void CalculateSAS(double sideC, double angleB, double sideA){

        this.sideC = sideC;
        this.angleB = angleB;
        this.sideA = sideA;

        double sideASquared = sideA * sideA;
        double sideCSquared = sideC * sideC;


        this.sideB = Math.sqrt(sideASquared + sideCSquared - (2*sideA*sideC*Math.cos(Math.toRadians(angleB))));


        this.angleA = Math.asin(Math.sin(angleB) * sideA / sideB);

        this.angleC = 180 - angleA - angleB;


    }

    /* calculate the angles and sides of the triangle given Three sides */
    public void CalculateSSS(double angleA, double sideC, double angleB){

    }

    /* function to print values of triangle during debugging */

    public void debugLog(){
        Log.d("t", String.format("Angle A: %.2f", angleA) );
        Log.d("t", String.format("Angle B: %.2f", angleB) );
        Log.d("t", String.format("Angle C: %.2f", angleC) );
        Log.d("t", String.format("Side A: %.2f", sideA) );
        Log.d("t", String.format("Side B: %.2f", sideB) );
        Log.d("t", String.format("Side C: %.2f", sideC) );

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

