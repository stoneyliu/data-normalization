/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

/**
 *
 * @author Taufik
 */
public class Sigmoidal extends ZScore{

    public Sigmoidal(String file) {
        super(file);
    }

    @Override
    public float calculateWithFormula(float data, int indexHorizontal, int params) {        
        float zScore = super.calculateWithFormula(data, indexHorizontal, params); //To change body of generated methods, choose Tools | Templates.
        return (float) (( 1 - Math.pow(CalculationHelper.EKSPONENSIAL_CONST, -1 * zScore) )
                /( 1 + Math.pow(CalculationHelper.EKSPONENSIAL_CONST, -1 * zScore) ));
    }
    
    
}
