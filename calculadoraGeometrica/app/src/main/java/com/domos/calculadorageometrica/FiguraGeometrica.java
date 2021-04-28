package com.domos.calculadorageometrica;

//Principios Solid aplicados a la clase FiguraGeometrica:

//-> Principio de Responsabilidad Unica: Esta clase tiene la responsabilidad única de definir las
//   operaciones y acciones que se pueden realizar con una figura geométrica

//-> Principio de Abierto y Cerrado: Esta clase define dos operaciones básicas que se pueden realizar
//   con cualquier figura geométrica, calcular el área y calcular el perimetro. En caso de querer
//   agregar un método para obtener la cantidad de lados de una figura o un método para dibujar dicha
//   figura, se agregan los respectivos métodos abstractos y es responsabilidad de la clase hija
//   realizar las respectivas implementaciones de dichos métodos.

public abstract class FiguraGeometrica {

    abstract double calcularArea();
    abstract double calcularPerimetro();


}
