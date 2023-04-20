package sv.edu.utec.prcaial_3_etps1_pedrorivas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.prcaial_3_etps1_pedrorivas.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtNom,txtApe , txtTel, txtCor;
    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnNav);
        txtNom=findViewById(R.id.edtNom);
        txtApe=findViewById(R.id.edtApe);
        txtTel=findViewById(R.id.edtTel);
        txtCor=findViewById(R.id.edtCor);


        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones,menu);
        return true ;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case R.id.insert:
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                    SQLiteDatabase bd= admin.getWritableDatabase();
                    String tel=txtTel.getText().toString();
                    String nom=txtNom.getText().toString();
                    String ape=txtApe.getText().toString();
                    String cor=txtCor.getText().toString();

                    ContentValues informacion =new ContentValues();
                    informacion.put("idTel",tel);
                    informacion.put("nombre",nom);
                    informacion.put("apellido",ape);
                    informacion.put("correo",cor);
                    try {
                        bd.insert("Contactos", null, informacion);

                        Toast.makeText(getApplicationContext(), "Se inserto el contacto", Toast.LENGTH_LONG).show();
                        bd.close();

                    } catch (Exception e){
                        //pendiente imprimir error
                        Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                    }
                    bd.close();
                    break;
                case R.id.update:

                    AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                    SQLiteDatabase bd2= admin2.getWritableDatabase();
                    String tel2=txtTel.getText().toString();
                    String nom2=txtNom.getText().toString();
                    String ape2=txtApe.getText().toString();
                    String cor2=txtCor.getText().toString();
                    ContentValues informacion2 =new ContentValues();
                    informacion2.put("idTel",tel2);
                    informacion2.put("nombre",nom2);
                    informacion2.put("apellido",ape2);
                    informacion2.put("correo",cor2);

                    int cat=bd2.update("Contactos",informacion2,
                            "idTel="+tel2,null);
                    bd2.close();
                    if(cat==1){
                        Toast.makeText(getApplicationContext(),"Se modifico el producto",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No se modifico el producto",Toast.LENGTH_LONG).show();

                    }

                    break;
                case R.id.delete:
                    AdminSQLiteOpenHelper admin3 = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                    SQLiteDatabase bd3= admin3.getWritableDatabase();
                    String tel3=txtTel.getText().toString();

                    int cat2=bd3.delete("Contactos",
                            "idTel="+tel3,null);
                    bd3.close();

                    txtTel.setText("");
                    txtNom.setText("");
                    txtApe.setText("");
                    txtCor.setText("");

                    if(cat2==1){
                        Toast.makeText(getApplicationContext(),"Se borro el CONTACTO",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No se borro el producto",Toast.LENGTH_LONG).show();

                    }

                    break;
            }

            return true;

        }



    };

    public boolean onOptionsItemSelected(MenuItem items){


        switch (items.getItemId()){

            case R.id.opcion1:

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String nom=txtNom.getText().toString();

                Cursor filas=bd.rawQuery("SELECT apellido, idTel, correo FROM Contactos WHERE nombre = '"+nom+"'", null);

                if(filas.moveToFirst()){
                    txtApe.setText(filas.getString(0));
                    txtTel.setText(filas.getString(1));
                    txtCor.setText(filas.getString(2));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd.close();

                return true;
            case R.id.opcion2:

                AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(getApplicationContext(), "Parcial",null,2);
                SQLiteDatabase bd2= admin2.getWritableDatabase();

                String ap=txtApe.getText().toString();

                Cursor filas2=bd2.rawQuery("SELECT nombre, idTel, correo FROM Contactos WHERE apellido = '"+ap+"'", null);

                if(filas2.moveToFirst()){
                    txtNom.setText(filas2.getString(0));
                    txtTel.setText(filas2.getString(1));
                    txtCor.setText(filas2.getString(2));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd2.close();
                return true;
            case R.id.opcion3:

                AdminSQLiteOpenHelper admin3 = new AdminSQLiteOpenHelper(getApplicationContext(), "Parcial",null,2);
                SQLiteDatabase bd3= admin3.getWritableDatabase();

                String tel=txtTel.getText().toString();

                Cursor filas3=bd3.rawQuery("SELECT nombre, apellido, correo FROM Contactos WHERE idTel = '"+tel+"'", null);

                if(filas3.moveToFirst()){
                    txtNom.setText(filas3.getString(0));
                    txtApe.setText(filas3.getString(1));
                    txtCor.setText(filas3.getString(2));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd3.close();

                return true;
            case R.id.opcion4:

                AdminSQLiteOpenHelper admin4 = new AdminSQLiteOpenHelper(getApplicationContext(), "Parcial",null,2);
                SQLiteDatabase bd4= admin4.getWritableDatabase();

                String cor=txtCor.getText().toString();

                Cursor filas4=bd4.rawQuery("SELECT nombre, apellido, idTel FROM Contactos WHERE correo = '"+cor+"'", null);

                if(filas4.moveToFirst()){
                    txtNom.setText(filas4.getString(0));
                    txtApe.setText(filas4.getString(1));
                    txtTel.setText(filas4.getString(2));

                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el producto",Toast.LENGTH_LONG).show();

                }
                bd4.close();

                return true;


        }

        return super.onOptionsItemSelected(items);
    }
}