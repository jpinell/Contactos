package com.jpinell.contactos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetalleContacto extends AppCompatActivity {

    TextView nombres;
    TextView fechas;
    TextView telefonos;
    TextView emails;
    TextView descripcions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);

        nombres = findViewById(R.id.tv_nombreCompleto);
        fechas = findViewById(R.id.tv_fechaNacimiento);
        telefonos = findViewById(R.id.tv_telefono);
        emails = findViewById(R.id.tv_email);
        descripcions = findViewById(R.id.tv_descripcion);

        Bundle bundle = this.getIntent().getExtras();

        String nombre = bundle.getString("nombre");
        String fecha = bundle.getString("fecha");
        String telefono = bundle.getString("telefono");
        String email = bundle.getString("email");
        String descripcion = bundle.getString("descripcion");

        nombres.setText(nombre);
        fechas.setText("Fecha Nacimiento: "+fecha);
        telefonos.setText("Tel: "+telefono);
        emails.setText("Email: "+email);
        descripcions.setText("Descripción: "+descripcion);
    }

    public void btnEditarDatos(View view) {
        finish();
    }
}