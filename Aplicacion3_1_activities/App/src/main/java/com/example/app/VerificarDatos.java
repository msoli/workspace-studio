package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by USUARIO on 21/11/13.
 */
public class VerificarDatos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        Bundle extras = getIntent().getExtras();

        String s = extras.getString("dato_procesado");

        TextView textView = (TextView) findViewById(R.id.resultado);

        textView.setText(s);


    }
}
