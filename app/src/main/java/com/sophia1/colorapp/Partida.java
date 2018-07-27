package com.sophia1.colorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Partida extends AppCompatActivity {

    int numeros[];
    String coloresT []= {"ROJO", "AMARILLO", "AZUL","VERDE" };
    int colores[] = {R.drawable.b_rojo, R.drawable.b_amarillo, R.drawable.b_azul, R.drawable.b_verde};
    int bien, mal, total;
    Button b1, b2, b3, b4;
    TextView palabra;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        palabra = findViewById(R.id.palabras);

        // INIT
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

    }

    public int random() {
        Random r = new Random();
        int n1 = r.nextInt(4);
        return  n1;
    }


    public void desordenar (){
        numeros = new int[4];

        int i=0;
        do {
            int num = random();
            if (numeros[num]==0){
                i++;
                numeros[num] =i;
            }
        } while (i<5);

        b1.setBackgroundResource(colores[numeros[0]]);
        b2.setBackgroundResource(colores[numeros[1]]);
        b3.setBackgroundResource(colores[numeros[2]]);
        b4.setBackgroundResource(colores[numeros[3]]);

    }

    int p;

    public void asignarC (){
        p = random();
        switch (p){
            case 0:
                palabra.setTextColor(Color.RED);
                break;
            case 1:
                palabra.setTextColor(Color.YELLOW);
                break;
            case 2:
                palabra.setTextColor(Color.BLUE);
                break;
            case 3:
                palabra.setTextColor(Color.GREEN);
                break;
        }
    }


    public void juego (){
        desordenar();
        asignarC();
        palabra.setText(coloresT[random()]);
        total++;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numeros[0]==p){
                    bien++;
                    f
                }
            }
        });

    }
}
