package com.domos.calculadorageometrica;

//Principios Solid aplicados a la clase Circulo

// -> Principio de Responsabilidad Unica: La responsabilidad de esta clase es la encapsulación de
//    los atributos y métodos que abstraen las propiedades y el manejo de un Circulo
//    dentro del programa

//Principio de sustitución de Liskov
public class Circulo extends FiguraGeometrica{

    private double radio;

    public Circulo(){}

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    double calcularArea() {
        return Math.PI*Math.pow(radio,2);
    }

    @Override
    double calcularPerimetro() {
        return 2*Math.PI*radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
