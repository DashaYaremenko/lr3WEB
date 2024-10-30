package org.example.lr3web.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateFunctionTest {

    @Test
    void calculateF() {
        CalculateFunction calculate=new CalculateFunction();
        assertEquals(Math.pow(Math.E,2.0*1.5)*Math.cos(3.0*1.5),calculate.calculateF(1.5,2.0,3.0),0.0001);
        assertEquals(1,calculate.calculateF(0.5,2.0,3.0),0.0001);
        assertEquals(Math.pow(2.0*1.0,2) * Math.log(1.0), calculate.calculateF(1.0,2.0,3.0),0.0001);
    }
    @Test
    void stepsCalc(){
        CalculateFunction calculate=new CalculateFunction();
        assertEquals(11, calculate.stepsCalc(0, 10, 1));
        assertEquals(5, calculate.stepsCalc(0, 2, 0.5));
        assertEquals(1, calculate.stepsCalc(0, 5, 10));
    }

    @Test
    void arraysGenerate() {
        CalculateFunction calculate = new CalculateFunction();
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        double a = -0.5;
        double b = 2.0;
        calculate.arraysGenerate(start, finish, step, a, b);
        assertEquals(0.7, calculate.xValues[175], 0.0001);
        assertEquals(-0.043692680632494714, calculate.yValues[175], 0.0001);

        assertEquals(1.4, calculate.xValues[350], 0.0001);
        assertEquals(-0.46789376727999865, calculate.yValues[350], 0.0001);

        assertEquals(3.0, calculate.xValues[750], 0.0001);
        assertEquals(0.21424294983005995, calculate.yValues[750], 0.0001);
    }

    @Test
    void maxIndex1(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{1.0, 2.5, 3.7, 4.2, 3.0};
        assertEquals(calculate.maxIndex(), 3);
    }
    @Test
    void maxIndex2(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{3.0};
        assertEquals(0, calculate.maxIndex());
    }
    @Test
    void minIndex1(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{3.0, 1.5, 2.7, 0.2, 2.0};
        assertEquals(3, calculate.minIndex());
    }
    @Test
    void minIndex2(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{2.5};
        assertEquals(0, calculate.minIndex());
    }
    @Test
    void sumYValues(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{1.0, -2.0, 3.0, -4.0, 5.0};
        assertEquals(3.0, calculate.sumYValues(), 0.0001);
    }
    @Test
    void averageYValues(){
        CalculateFunction calculate=new CalculateFunction();
        calculate.yValues = new double[]{1.0, -2.0, 3.0, -4.0, 5.0};
        assertEquals(0.6, calculate.averageYValues(), 0.0001);
    }

}