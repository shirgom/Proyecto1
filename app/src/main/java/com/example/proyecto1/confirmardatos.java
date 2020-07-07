package com.example.proyecto1;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmardatos extends AppCompatActivity {

    private TextView tvname;
    private TextView tvtel;
    private TextView tvmail;
    private TextView tvfecha;
    private TextView tvdesc;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmardatos);

        Bundle confirmar =getIntent().getExtras();
        String nombre = confirmar.getString("nombre");
        String telefono= confirmar.getString("tel");
        String mail=confirmar.getString(("mail"));
        String fecha=confirmar.getString(("fecha"));
        String descripcion=confirmar.getString(("descripcion"));

        tvname= (TextView) findViewById(R.id.tvnombre);
        tvtel= (TextView) findViewById(R.id.tvtelefono);
        tvmail= (TextView) findViewById(R.id.tvmail);
        tvfecha= (TextView) findViewById(R.id.tvfecha);
        tvdesc= (TextView) findViewById(R.id.tvdesc);
        editar = (Button)findViewById(R.id.button2);

        tvname.setText(nombre);
        tvtel.setText(telefono);
        tvmail.setText(mail);
        tvfecha.setText(fecha);
        tvdesc.setText(descripcion);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();


            }
        });

    }
}