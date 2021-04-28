package com.domos.calculadorageometrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Cuadrado cuadrado;
    Rectangulo rectangulo;
    Triangulo triangulo;
    Circulo circulo;

    Spinner figuras, operaciones;
    TextInputLayout lyValor1, lyValor2, lyValor3;
    TextInputEditText valor1, valor2, valor3;
    Button btnCalcular;
    TextView txtResultado;

    String operacion, figura, combinacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        combinacion = "Cuadrado";
        inicializarUI();
        inicializarDependencias();
        actualizarUI(combinacion);
    }

    public void inicializarUI(){

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        lyValor1 = (TextInputLayout) findViewById(R.id.lyValor1);
        lyValor2 = (TextInputLayout) findViewById(R.id.lyValor2);
        lyValor3 = (TextInputLayout) findViewById(R.id.lyValor3);

        valor1 = (TextInputEditText) findViewById(R.id.valor1);
        valor2 = (TextInputEditText) findViewById(R.id.valor2);
        valor3 = (TextInputEditText) findViewById(R.id.valor3);

        figuras = (Spinner) findViewById(R.id.spinnerFiguras);
        operaciones = (Spinner) findViewById(R.id.spinnerOperaciones);

        ArrayAdapter<CharSequence> adapterFiguras = ArrayAdapter.createFromResource(this, R.array.figuras, android.R.layout.simple_spinner_item);
        adapterFiguras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        figuras.setAdapter(adapterFiguras);
        figuras.setOnItemSelectedListener(MainActivity.this);

        ArrayAdapter<CharSequence> adapterOperaciones = ArrayAdapter.createFromResource(this, R.array.operaciones, android.R.layout.simple_spinner_item);
        adapterOperaciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operaciones.setAdapter(adapterOperaciones);
        operaciones.setOnItemSelectedListener(MainActivity.this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion();
            }
        });

    }
    public void inicializarDependencias(){
        cuadrado = new Cuadrado();
        rectangulo = new Rectangulo();
        triangulo = new Triangulo();
        circulo = new Circulo();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.spinnerFiguras:
                figura = parent.getItemAtPosition(position).toString();
                operacion = operaciones.getSelectedItem().toString();
                break;
            case R.id.spinnerOperaciones:
                figura = figuras.getSelectedItem().toString();
                operacion = parent.getItemAtPosition(position).toString();
                break;
        }

        if(figura.equals("Triangulo")){
            combinacion = figura + "-" + operacion;
        }else {
            combinacion = figura;
        }


        actualizarUI(combinacion);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void actualizarUI(String ui){
        limpiarCampos();

        switch (ui){
            case "Cuadrado":
                valor1.setVisibility(View.VISIBLE);
                valor2.setVisibility(View.GONE);
                valor3.setVisibility(View.GONE);
                lyValor1.setHint("Lado");
                break;
            case "Circulo":
                valor1.setVisibility(View.VISIBLE);
                valor2.setVisibility(View.GONE);
                valor3.setVisibility(View.GONE);
                lyValor1.setHint("Radio");
                break;
            case "Rectangulo":
                valor1.setVisibility(View.VISIBLE);
                valor2.setVisibility(View.VISIBLE);
                valor3.setVisibility(View.GONE);
                lyValor1.setHint("Base");
                lyValor2.setHint("Altura");
                break;
            case "Triangulo-Area":
                valor1.setVisibility(View.VISIBLE);
                valor2.setVisibility(View.VISIBLE);
                valor3.setVisibility(View.GONE);
                lyValor1.setHint("Base");
                lyValor2.setHint("Altura");
                break;
            case  "Triangulo-Perimetro":
                valor1.setVisibility(View.VISIBLE);
                valor2.setVisibility(View.VISIBLE);
                valor3.setVisibility(View.VISIBLE);
                lyValor1.setHint("Base");
                lyValor2.setHint("Lado Izquierdo");
                lyValor3.setHint("Lado Derecho");
                break;
        }
    }

    public void realizarOperacion(){
        switch (figura){
            case "Cuadrado":
                if(!TextUtils.isEmpty(valor1.getText())){
                    cuadrado.setLado(Double.parseDouble(valor1.getText().toString()));
                    mostrarResultado(cuadrado);
                }else {
                    Toast.makeText(MainActivity.this, "Brinde todos los datos", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Circulo":
                if(!TextUtils.isEmpty(valor1.getText())){
                    circulo.setRadio(Double.parseDouble(valor1.getText().toString()));
                    mostrarResultado(circulo);
                }else {
                    Toast.makeText(MainActivity.this, "Brinde todos los datos", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Rectangulo":
                if(!TextUtils.isEmpty(valor1.getText()) && !TextUtils.isEmpty(valor2.getText())){
                    rectangulo.setBase(Double.parseDouble(valor1.getText().toString()));
                    rectangulo.setAltura(Double.parseDouble(valor2.getText().toString()));
                    mostrarResultado(rectangulo);
                }else {
                    Toast.makeText(MainActivity.this, "Brinde todos los datos", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Triangulo":
                if(operacion.equals("Perimetro")){
                    if(!TextUtils.isEmpty(valor1.getText()) && !TextUtils.isEmpty(valor2.getText()) && !TextUtils.isEmpty(valor3.getText())){
                        triangulo.setBase(Double.parseDouble(valor1.getText().toString()));
                        triangulo.setLadoIzquierdo(Double.parseDouble(valor2.getText().toString()));
                        triangulo.setLadoDerecho(Double.parseDouble(valor3.getText().toString()));
                        mostrarResultado(triangulo);
                    }else{
                        Toast.makeText(MainActivity.this, "Brinde todos los datos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(!TextUtils.isEmpty(valor1.getText()) && !TextUtils.isEmpty(valor2.getText())){
                        triangulo.setBase(Double.parseDouble(valor1.getText().toString()));
                        triangulo.setAltura(Double.parseDouble(valor2.getText().toString()));
                        mostrarResultado(triangulo);
                    }else{
                        Toast.makeText(MainActivity.this, "Brinde todos los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }

    public void limpiarCampos(){
        lyValor1.setHint("");
        lyValor2.setHint("");
        lyValor3.setHint("");
        txtResultado.setText("");
        valor1.setText("");
        valor2.setText("");
        valor3.setText("");
    }
    
    //Principio solid aplicado a la clase MainActivity
    // -> Principio de sustitución de Liskov: En este método las clases Circulo, Cuadrado, Rectangulo,
    //    Triangulo son sustituidas por un objeto de su clase padre (Figura Geométrica) y el programa
    //    Sigue funcionando con normalidad
    
    public void mostrarResultado(FiguraGeometrica figuraGeometrica){
        String resultado = "";
        if(operacion.equals("Perimetro")){
            resultado += operacion+": "+String.format("%.2f",figuraGeometrica.calcularPerimetro()) +" u";
        }else{
            resultado += operacion+": "+String.format("%.2f",figuraGeometrica.calcularArea()) +" u^2";
        }
        txtResultado.setText(resultado);
    }
}