package org.example.lr3web.logic;

public class CalculateFunction {
    double[] xValues;
    double[] yValues;

    public double calculateF(double x,double a, double b) {
        if (x>1.4) {
            return Math.pow(Math.E, a*x)*Math.cos(b*x);
        }else if (x<=0.7){
            return 1;
        }else {
            return Math.pow(a*x,2)*Math.log(x);
        }
    }
    public int stepsCalc(double start, double finish, double step) {
        return (int) ((finish-start)/step)+1;
    }
    public void arraysGenerate(double start, double finish, double step, double a, double b) {
        int size = stepsCalc(start, finish, step);
        xValues = new double[size];
        yValues = new double[size];
        for (int i = 0; i < size; i++) {
            xValues[i] = start+i*step;
            yValues[i] = calculateF(xValues[i],a,b);
        }
    }
    public int maxIndex(){
        int max = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] > yValues[max]) {
                max = i;
            }
        }
        return max;
    }
    public int minIndex(){
        int min = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] < yValues[min]) {
                min = i;
            }
        }
        return min;
    }
    public double sumYValues() {
        double sum = 0;
        for (double value : yValues) {
            sum += value;
        }
        return sum;
    }

    public double averageYValues() {
        return sumYValues() / yValues.length;
    }

    public double[] getXValues() {
        return xValues;
    }
    public double[] getYValues() {
        return yValues;
    }


}

