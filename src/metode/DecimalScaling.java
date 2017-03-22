/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import static metode.MinMax.MAX_VALUE;
import static metode.MinMax.MIN_VALUE;

/**
 *
 * @author Taufik
 */
public class DecimalScaling extends NormalisasiMetode{

    public DecimalScaling(String filePath) {
        this.setData(filePath);
       
    }

    @Override
    public float calculateWithFormula(float data, int indexHorizontal,int params) {
        return (float)(data / Math.pow(10, params));
    }
    
}
