/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taufik
 */
public class NormalisasiMetode {

    public ArrayList<Float[]> data;
    private BufferedReader bufferedReader;
    private FileReader fileReader;

    public NormalisasiMetode() {
        this.data = new ArrayList();
    }

    public void setData(String filePath) {

        File file = new File(filePath);
        this.setData(file);
    }

    public void setData(File file) {
        try {
            String value;
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((value = bufferedReader.readLine()) != null) {
                
                String[] stringData = value.contains(",") ? 
                        value.split(",") : value.split("\\t");
                Float[] floatData = new Float[stringData.length - 1];
                for (int i = 0; i < stringData.length - 1; i++) {
                    try {
                        floatData[i] = Float.parseFloat(stringData[i]);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.data.add(floatData);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found : " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(NormalisasiMetode.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public float calculateWithFormula(float data, int indexHorizontal,int params) {
        return 0;
    }


    public ArrayList<Float[]> getData() {
        return data;
    }

    
    public ArrayList<Float[]> calculate() {
        return this.calculate(0);
    }
    
    public ArrayList<Float[]> calculate(int params) {
        ArrayList<Float[]> changedData = new ArrayList<>();        
        
        for( Float[] data : this.data ){
            for (int i = 0; i < data.length; i++) {
                data[i] = calculateWithFormula(data[i], i,params);
            }
            changedData.add(data);
        }
        return changedData;
    }

}
