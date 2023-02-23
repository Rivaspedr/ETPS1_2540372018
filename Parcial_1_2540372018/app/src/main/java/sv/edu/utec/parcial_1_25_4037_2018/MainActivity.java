package sv.edu.utec.parcial_1_25_4037_2018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLog;
    EditText edtU, edtP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLog=findViewById(R.id.btnEnviar);
        edtU=findViewById(R.id.edtUser);
        edtP=findViewById(R.id.edtPass);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtU.getText().toString();
                String pass = edtP.getText().toString();

                if (user.equals("parcialETps1") &&  pass.equals("p4rC14l#tp$")){


                    Intent intento=new Intent(getApplicationContext(),Login.class);
                    startActivity(intento);


                }
                else{
                    Toast mensaje= Toast.makeText( MainActivity.this,"contraseña y usuario no son correctos",Toast.LENGTH_SHORT);
                    mensaje.show();
                }


            }
        });


    }
}