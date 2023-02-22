/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Hugo Rivera
 */
public class Archivo {
    float altura;
    float peso;
    float bmi;
    String resultado;

    public Archivo() {
    }

    public Archivo(float altura, float peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public Archivo(float altura, float peso, float bmi, String resultado) {
        this.altura = altura;
        this.peso = peso;
        this.bmi = bmi;
        this.resultado = resultado;
    }

    

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return altura + "," + peso + "," + bmi + "," + resultado;
    }
    
}
