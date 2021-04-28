package com.domos.calculadorageometrica;

//Principios Solid aplicados a la clase Rectangulo

// -> Principio de Responsabilidad Unica: La responsabilidad de esta clase es la encapsulación de
//    los atributos y métodos que abstraen las propiedades y el manejo de un Rectangulo
//    dentro del programa

//Principio de sustitución de Liskov
public class Rectangulo extends FiguraGeometrica{

    private double base;
    private double altura;

    public Rectangulo(){}

    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return this.base*this.altura;
    }

    @Override
    double calcularPerimetro() {
        return (2*(this.base)) + (2*(this.altura));
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
