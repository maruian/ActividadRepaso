package com.example.admin.actividadrepaso;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, localizacion;
    private TextView cuadro;
    private boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText)findViewById(R.id.editNombre);
        localizacion = (EditText)findViewById(R.id.editLocalizacion);
        cuadro = (TextView)findViewById(R.id.cuadro);

        registerForContextMenu(nombre);
        registerForContextMenu(localizacion);


        cuadro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bandera==true) {
                    cuadro.setBackgroundColor(Color.RED);
                    bandera=false;
                }else {
                    cuadro.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    bandera=true;
                }
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copiar :
                Toast.makeText(getApplicationContext(), "Has seleccionado copiar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pegar:
                Toast.makeText(getApplicationContext(), "Has seleccionado pegar", Toast.LENGTH_SHORT).show();
                return true;
            default: return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.configuraciones: Toast.makeText(getApplicationContext(),"Has seleccionado configuraciones",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.preferencias: Toast.makeText(getApplicationContext(),"Has seleccionado preferencias",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.datos: Toast.makeText(getApplicationContext(),"Has seleccionado datos",Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
