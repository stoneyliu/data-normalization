/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.text.DecimalFormat;

/**
 *
 * @author Taufik
 */
public class CalculationHelper {

    public static float EKSPONENSIAL_CONST = 2.718281828f;
    
    public static float getMean(float[] data) {
        return getSumOfData(data) / data.length;
    }

    public static float getSumOfData(float[] data) {
        float sum = 0;
        for (float detailData : data) {
            sum += detailData;
        }
        return sum;
    }

    public static float getStd(float[] data) {
        return getStd(data, getMean(data));
    }

    public static float getStd(float[] data, float mean) {
        float[] dataKuadrat = new float[data.length];
        for (int i = 0; i < data.length; i++) {           
            dataKuadrat[i] = (float) Math.pow(data[i], 2);
        }        
        
        float sumOfData = getSumOfData(data);
        float sumKuadratOfData = getSumOfData(dataKuadrat);
        
        return (float) Math.sqrt( ( sumKuadratOfData - ( Math.pow(sumOfData, 2) / data.length ) ) / (data.length - 1) );
        
//        return (float) Math.sqrt(getSumOfData(data) / data.length);        
    }

}
