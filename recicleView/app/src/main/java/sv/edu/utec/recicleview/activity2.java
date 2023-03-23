package sv.edu.utec.recicleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    static ImageView imgPer;
    static TextView tvnombrePer, tvCompa,tvCarg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imgPer = findViewById(R.id.imgEmpl);
        tvnombrePer = findViewById(R.id.txvNombre);
        tvCompa = findViewById(R.id.txvCompañia);
        tvCarg = findViewById(R.id.txvCargo);



        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String car = intent.getStringExtra("car");
            String com = intent.getStringExtra("com");
            int img = intent.getIntExtra("img", 0);
            tvCompa.setText(com);
            tvCarg.setText(car);
            tvnombrePer.setText(nombre);
            imgPer.setImageResource(img);
        }
    }

    public void pantalla(View v) {
        finish();
    }
}