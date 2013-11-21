package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by USUARIO on 21/11/13.
 */
public class VerificarDatos extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        Bundle extras = getIntent().getExtras();

        String s = extras.getString("dato_procesado");

        TextView textView = (TextView) findViewById(R.id.resultado);

        textView.setText(s);

        Intent intent = new Intent();
        intent.putExtra("restValue", s);
        setResult(RESULT_OK, intent);

        Log.i("MSOLIS", "second activity proceso resultado (al regresar a primera activitu se mostrara el resultado)");



    }


}
