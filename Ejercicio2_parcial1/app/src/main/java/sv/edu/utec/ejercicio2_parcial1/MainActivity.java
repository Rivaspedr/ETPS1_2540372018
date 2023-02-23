package sv.edu.utec.ejercicio2_parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etP, etA;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etP=findViewById(R.id.edtP);
        etA=findViewById(R.id.edtA);

        tvResultado=findViewById(R.id.txvMensaje);
    }

    public void valor (View v)
    {
        tvResultado.setText(" Críticamente Bajo de Peso");
        float dato1, dato2, resultado;


        dato1=Float.parseFloat(etP.getText().toString());
        dato2=Float.parseFloat(etA.getText().toString());
        resultado=(dato1)/(dato2 * dato2);




        if (resultado>0 && resultado<=10.5){
            tvResultado.setText(String.valueOf(resultado)+" Críticamente Bajo de Peso ");


        }
        else if (resultado>10.5 && resultado<=15.9){
            tvResultado.setText(String.valueOf(resultado)+" Severamente Bajo de Peso");
        }
        else if (resultado>15.9 && resultado<=18.5){
            tvResultado.setText(String.valueOf(resultado)+" Bajo de Peso");
        }

        else if (resultado>18.5 && resultado<=25){
            tvResultado.setText(String.valueOf(resultado)+" Normal (peso saludable)");
        }
        else if (resultado>25 && resultado<=30)
        {
            tvResultado.setText(String.valueOf(resultado)+" Sobrepeso");
        }
        else if (resultado>30 && resultado<=35){

            tvResultado.setText(String.valueOf(resultado)+" Obesidad Clase 1 - Moderadamente Obeso");
        }
        else if (resultado>35 && resultado<=40){

            tvResultado.setText(String.valueOf(resultado)+" Obesidad Clase 2 - Severamente Obeso");
        }
        else if (resultado>50){

            tvResultado.setText(String.valueOf(resultado)+" Obesidad Clase 3 - Críticamente Obeso");
        }else {

            tvResultado.setText("No se puede calcular");

        }

    }
}