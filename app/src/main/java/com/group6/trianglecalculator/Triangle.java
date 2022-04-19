package com.group6.trianglecalculator;

public class Triangle {

    /*
    triangle is constructed such that each angle is directly across from its
    side counter part (e.g. angleA is across from SideA).
    */

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
    public double CalculateAAS(double angleA, double angleB, double sideA){

        double angleC = 180 - angleA - angleB;

        

        return result;
    }

}

