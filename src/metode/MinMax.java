/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Taufik
 */
public class MinMax extends NormalisasiMetode {

    public static int MIN_VALUE = 0;
    public static int MAX_VALUE = 1;

    MinMaxValue[] minMaxData;

    public MinMax(String filePath) {
        this.setData(filePath);

        if (this.data.size() > 0) {
            minMaxData = new MinMaxValue[ this.data.get(0).length ];
        }else{
            minMaxData = new MinMaxValue[0];            
        }
        this.setMinMaxValue();
    }

    @Override
    public float calculateWithFormula(float data, int indexHorizontal, int params) {
        return (data - this.minMaxData[indexHorizontal].min) * (MAX_VALUE - MIN_VALUE)
                / (this.minMaxData[indexHorizontal].max - this.minMaxData[indexHorizontal].min)
                + MIN_VALUE;
    }

    private void setMinMaxValue() {

        int lengthOfHorizontalData = this.data.size() > 0 ? this.data.get(0).length : 0;
        int lengthOfVerticalData = this.data.size();
        for (int i = 0; i < lengthOfHorizontalData; i++) {
            ArrayList<Float> listofData = new ArrayList();
            for (int j = 0; j < lengthOfVerticalData; j++) {
                listofData.add(this.data.get(j)[i]);
            }

            minMaxData[i] = new MinMax.MinMaxValue(
                    Collections.min(listofData), Collections.max(listofData));
        }
    }

    public MinMaxValue[] getMinMaxData() {
        return minMaxData;
    }

    public class MinMaxValue {

        private float min, max;

        public MinMaxValue(float min, float max) {
            this.min = min;
            this.max = max;
        }

        public float getMax() {
            return max;
        }

        public float getMin() {
            return min;
        }

    }

}
