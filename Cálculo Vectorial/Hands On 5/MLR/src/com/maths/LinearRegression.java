package com.maths;

import com.data.DataSet;

public abstract class LinearRegression extends Model {
    protected DataSet dataSet;


    protected double getBeta(int number){
        return betas.get(number);
    }

    protected double predict(double x){
        double result = 0;
        for (int i = 0; i < betas.size(); i++) {
            result += betas.get(i) * x;
        }
        return result;
    }
    protected String getEquation(){
        return "Y = ";
    }

}
