package sv.edu.utec.calculoiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etCant;
    TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       etCant=findViewById(R.id.edtCifra);
        tvResultado=findViewById(R.id.txvResultado);
    }

    public void Iva (View v)
    {
        double num,IVA=0.134,dato1 ;
        dato1=Double.parseDouble(etCant.getText().toString());

        num = dato1+(dato1*IVA);


        tvResultado.setText("El precio con IVA es: "+String.valueOf(num));


    }
}