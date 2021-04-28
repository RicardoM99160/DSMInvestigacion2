package com.domos.calculadorageometrica;

//Principios Solid aplicados a la clase Cuadrado

// -> Principio de Responsabilidad Unica: La responsabilidad de esta clase es la encapsulación de
//    los atributos y métodos que abstraen las propiedades y el manejo de un Cuadrado
//    dentro del programa

//Principio de sustitución de Liskov
public class Cuadrado extends FiguraGeometrica{

    private double lado;

    public Cuadrado(){}

    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    double calcularArea() {
        return this.lado*this.lado;
    }

    @Override
    double calcularPerimetro() {
        return 4*this.lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
