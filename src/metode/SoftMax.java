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
public class SoftMax extends ZScore {

    public SoftMax(String file) {
        super(file);
    }

    @Override
    public float calculateWithFormula(float data, int indexHorizontal, int params) {    
        //return (data - this.stdMean[indexHorizontal].mean) / this.stdMean[indexHorizontal].std;
        float transfdata = (float) (( data - this.stdMean[indexHorizontal].getMean() ) / 
                ( params * ( this.stdMean[indexHorizontal].getStd() / ( 2 * 3.14 ) )  ));
        return (float) (1/ ( 1 + Math.pow(CalculationHelper.EKSPONENSIAL_CONST, -1 * transfdata) ));
    }

}
