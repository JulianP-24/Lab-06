package edu.eci.cvds.servlet.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.lang.Math;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class Bean {
    private ArrayList<Double> valores;
    private double media;
    private double varianza;
    private double res;
    private double moda;
    
    public void calculator(String lista) {
        valores = new ArrayList<Double>();
        for (String b : lista.split(";")) {
            valores.add(Double.valueOf(b));
        }
        calculateMean(valores);
        calculateVariance(valores);
        calculateMode(valores);
        calculateStandardDeviation(valores);
    }

    public void calculateMean(ArrayList<Double> valores) {
        //this.valores = valores;
        double total = 0;
        for (int i = 0; i < valores.size(); i++) {
            total += valores.get(i);
        }
        total = total / valores.size();
        media = total;
    }

    public void calculateVariance(ArrayList<Double> valores) {
        //this.valores = valores;
        double sumatoria = calcularSumatoria(valores);
        double varianza = sumatoria / valores.size();
        this.varianza = varianza;

    }
    
    public double calcularSumatoria(ArrayList<Double> valores) {
        double total = 0;
        double diferencia;
        double mediaa = media;
        for (int i = 0; i < valores.size(); i++) {
            diferencia = Math.pow((valores.get(i) - mediaa),2);
            total += diferencia;
        }
        return total;
    }

    public void calculateStandardDeviation(ArrayList<Double> valores) {
        double res = Math.sqrt(varianza);
        this.res = res;
    }

    public void calculateMode(ArrayList<Double> valores) {
        int contador = 0;
        double moda = 0;
        for (int i = 0; i < valores.size(); i++) {
            int x = 0;
            for (int j = 0; j < valores.size(); j++) {
                if (valores.get(i) == valores.get(j)) {
                    x += 1;
                }
            }
            if (contador < x) {
                moda = valores.get(i);
            }
        }
        //this.moda = moda;
    }

    public void restart(){  
        setMedia(0); 
        setModa(0); 
        setVarianza(0); 
        setRes(0); 
        ArrayList<Double>valores=new ArrayList<>(); 
    }
    
    public ArrayList<Double> getValores() {
        return valores;
    }

    public void setIntentos(ArrayList<Double> valores) {
        this.valores = valores;
    }

    public double getMedia() {
        return media;
    }
    
    public void setMedia(double media) {
        this.media = media;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public double getRes() {
        return res;
    }
    
    public void setRes(double res) {
        this.res = res;
    }
    
    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

}
