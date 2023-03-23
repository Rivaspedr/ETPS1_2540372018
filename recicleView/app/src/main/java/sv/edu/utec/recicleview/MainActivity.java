package sv.edu.utec.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mrecyclerView = findViewById(R.id.rvPeliculas);
    mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new Adaptador(this, getListado());
    mrecyclerView.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new Adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Modelo modelo) {
                Intent intent = new Intent(MainActivity.this, activity2.class);
                intent.putExtra("nombre", modelo.getNombrePersona());
                intent.putExtra("car", modelo.getCargo());
                intent.putExtra("com", modelo.getCompania());
                intent.putExtra("img", modelo.getImgPersona());
                startActivity(intent);
            }
        });


        /*mrecyclerView.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Toast.makeText(getApplicationContext(), "prueba",Toast.LENGTH_LONG).show();
                                             }
                                         });
*/
        mrecyclerView.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(),"Selecionar",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

      /*  adaptador.set (new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 Toast.makeText(parent.getContext(),"seleccionar",Toast.LENGTH_LONG).show();
                                             }
                                         });
*/

    }

    private ArrayList<Modelo> getListado(){
        ArrayList<Modelo> modelos=new ArrayList<>();
        Modelo modelista = new Modelo();

        modelista.setNombrePersona("Alexander Pierrot");
        modelista.setCargo("CEO");
        modelista.setCompania("Insures S.O.");
        modelista.setImgPersona(R.drawable.lead_photo_1);
        modelos.add(modelista);


        modelista = new Modelo();
        modelista.setNombrePersona("Carlos Lopez");
        modelista.setCargo("Asistente");
        modelista.setCompania("Hospital Blue");
        modelista.setImgPersona(R.drawable.lead_photo_2);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Sara Bonz");
        modelista.setCargo("Directora de Marketing");
        modelista.setCompania("Ciencia ficcion");
        modelista.setImgPersona(R.drawable.lead_photo_3);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Liliana Clarence");
        modelista.setCargo("Diseñadora de Producto");
        modelista.setCompania("Creativa Appn");
        modelista.setImgPersona(R.drawable.lead_photo_4);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Benito Peralta");
        modelista.setCargo("Supervisor de Ventas");
        modelista.setCompania("Neumáticos Press");
        modelista.setImgPersona(R.drawable.lead_photo_5);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Juan Jaramillo");
        modelista.setCargo("CEO");
        modelista.setCompania("Banco Nacional");
        modelista.setImgPersona(R.drawable.lead_photo_6);
        modelos.add(modelista);


        modelista = new Modelo();
        modelista.setNombrePersona("Christian Steps");
        modelista.setCargo("CTO");
        modelista.setCompania("Cooperativa Verde");
        modelista.setImgPersona(R.drawable.lead_photo_7);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Alexa Giraldo");
        modelista.setCargo("Lead Programmer");
        modelista.setCompania("Frutisofy");
        modelista.setImgPersona(R.drawable.lead_photo_8);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Linda Murillo");
        modelista.setCargo("Directora de Marketing");
        modelista.setCompania("Seguros Boliver");
        modelista.setImgPersona(R.drawable.lead_photo_9);
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNombrePersona("Lizeth Astrada");
        modelista.setCargo("CEO");
        modelista.setCompania("Concesionario Motolox");
        modelista.setImgPersona(R.drawable.lead_photo_10);
        modelos.add(modelista);



        return modelos;
    }



}