package com.jpinell.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvDate;
    //EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    Button siguiente;
    TextInputEditText nombres;
    TextInputEditText fecha;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tv_date);
        //etDate = findViewById(R.id.et_date);
        siguiente = findViewById(R.id.btn_siguiente);
       nombres = findViewById(R.id.txt_nombre);
       fecha = findViewById(R.id.tv_date);
       telefono = findViewById(R.id.txt_telefono);
       email = findViewById(R.id.txt_email);
       descripcion = findViewById(R.id.txt_descripcion);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };

        /*etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });*/
    }

    public void btnSiguiente(View view) {
        //String nombre = nombres.getText().toString();
        //String fecha =
        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombres.getText().toString());
        bundle.putString("fecha",fecha.getText().toString());
        bundle.putString("telefono",telefono.getText().toString());
        bundle.putString("email",email.getText().toString());
        bundle.putString("descripcion",descripcion.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }
}