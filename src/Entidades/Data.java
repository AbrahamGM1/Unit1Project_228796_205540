/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Hugo Rivera, Abraham Gómez
 */
public class Data {
    
    //The variables needed to get the BMI
    float height;
    float weight;
    float bmi;
    String result;

    /**
     * Empty constructor
     */
    public Data() {
    }

    /**
     * Constructor that recieves the height and the weight entered as a parameters
     * @param height - the height from the user
     * @param weight - the weight from the user
     */
    public Data(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }
    
    /**
     * Constructor that receive all the variable information needed
     * @param height - the height from the user
     * @param weight - the weight from the user
     * @param bmi - the bmi calculated
     * 
     */
    public Data(float height, float weight, float bmi, String result) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.result = result;
    }

    
    /**
     * Returns the height stored in the object
     * @return - the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Assigns a height to the object
     * @param height - the height to assign
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Returns the weight stored in the object
     * @return - the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Assigns a weight to the object
     * @param weight - the weight to assign
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Returns the BMI stored in the object
     * @return - the bmi
     */
    public float getBmi() {
        return bmi;
    }

    /**
     * Assigns a bmi to the object
     * @param bmi - the bmi to assign
     */
    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    /**
     * Returns the result stored in the object
     * @return - the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Assigns a result to the object
     * @param result - the result to assign
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Method toString from the object
     * @return - the string with the elements of the object
     */
    @Override
    public String toString() {
        return height + "," + weight + "," + bmi + "," + result;
    }
    
}
