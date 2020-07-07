package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout name;
    private EditText nombre;
    private EditText tel;
    private EditText mail;
    private EditText desc;
    private TextView fec;
    private DatePickerDialog.OnDateSetListener fechaSetListener;
    private Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //name = (TextInputLayout)findViewById(R.id.txt_nombre);
        nombre = (EditText) findViewById(R.id.campo_nombre);
        tel = (EditText) findViewById(R.id.campo_telefono);
        mail = (EditText) findViewById(R.id.campo_correo);
        desc = (EditText) findViewById(R.id.campo_descripcion);
        fec = (TextView) findViewById(R.id.tv_fecha);
        siguiente= (Button)findViewById(R.id.button);

        fec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        fechaSetListener,
                        año,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        fechaSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes = mes + 1;
                //Log.d(T, "onDateSet: mm/dd/yyy: " + mes + "/" + dia + "/" + año);

                String date = mes + "/" + dia + "/" + año;
                fec.setText(date);

            }
        };

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, confirmardatos.class);
                //intent.putExtra ("nombre", String.valueOf(name));
                intent.putExtra ("nombre",nombre.getText().toString());
                intent.putExtra ("tel", tel.getText().toString());
                intent.putExtra ("mail", mail.getText().toString());
                intent.putExtra ("descripcion", desc.getText().toString());
                intent.putExtra("fecha", fec.getText().toString());
                startActivity(intent);


            }
        });
    }
}