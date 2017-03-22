/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.util.ArrayList;

/**
 *
 * @author Taufik
 */
public class ZScore extends NormalisasiMetode {

    protected ZScoreMeanStd stdMean[];

    public ZScore(String file) {
        this.setData(file);
        if (this.data.size() > 0) {
            stdMean = new ZScoreMeanStd[this.data.get(0).length];
        } else {
            stdMean = new ZScoreMeanStd[0];
        }
        this.setMeanStd();
    }

    @Override
    public float calculateWithFormula(float data, int indexHorizontal, int params) {
        return (data - this.stdMean[indexHorizontal].mean) / this.stdMean[indexHorizontal].std;
    }

    private void setMeanStd() {

        int lengthOfHorizontalData = this.data.size() > 0 ? this.data.get(0).length : 0;
        int lengthOfVerticalData = this.data.size();
        for (int i = 0; i < lengthOfHorizontalData; i++) {
            float[] listofData = new float[lengthOfVerticalData];

            for (int j = 0; j < lengthOfVerticalData; j++) {
                listofData[j] = this.data.get(j)[i];
            }

            float mean = CalculationHelper.getMean(listofData);
            this.stdMean[i] = new ZScoreMeanStd(mean,
                    CalculationHelper.getStd(listofData, mean));
        }
    }

    public ZScoreMeanStd[] getStdMean() {
        return stdMean;
    }

    public class ZScoreMeanStd {

        private float mean, std;

        public ZScoreMeanStd(float mean, float std) {
            this.mean = mean;
            this.std = std;
        }

        public float getMean() {
            return mean;
        }

        public float getStd() {
            return std;
        }

        @Override
        public String toString() {
            return "[ " + mean + "," + std + " ]";
        }

    }

}
