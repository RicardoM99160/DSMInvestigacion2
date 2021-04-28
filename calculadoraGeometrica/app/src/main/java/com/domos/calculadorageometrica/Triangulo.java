package com.domos.calculadorageometrica;

//Principios Solid aplicados a la clase Triangulo

// -> Principio de Responsabilidad Unica: La responsabilidad de esta clase es la encapsulación de
//    los atributos y métodos que abstraen las propiedades y el manejo de un Triangulo
//    dentro del programa

//Principio de sustitución de Liskov:
public class Triangulo extends FiguraGeometrica {

    private double base;
    private double altura;
    private double ladoIzquierdo;
    private double ladoDerecho;

    public Triangulo(){}

    public Triangulo(double base, double altura, double ladoIzquierdo, double ladoDerecho){
        this.base = base;
        this.altura = altura;
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
    }


    @Override
    double calcularArea() {
        return (this.base*this.altura)/2;
    }

    @Override
    double calcularPerimetro() {
        return base + ladoDerecho + ladoIzquierdo;
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

    public double getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(double ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public double getLadoDerecho() {
        return ladoDerecho;
    }

    public void setLadoDerecho(double ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }
}
