/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalisasidata;

import java.util.ArrayList;
import java.util.Arrays;
import metode.DecimalScaling;
import metode.MinMax;
import metode.NormalisasiMetode;
import metode.Sigmoidal;
import metode.SoftMax;
import metode.ZScore;

/**
 *
 * @author Taufik
 */
public class NormalisasiData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //IRIS
        NormalisasiMetode obj = new ZScore("iris.txt");
        System.out.println("=========iris===========");        
        printData(obj.calculate(1));
        System.out.println("======newthyroid==========");
        obj = new ZScore("newthyroid.txt");        
        printData(obj.calculate(1));
        
    }
    
    public static void printData(ArrayList<Float[]> obj){
        for (Float[] data : obj) {
            System.out.println(Arrays.toString(data));
        }        
    }

}
