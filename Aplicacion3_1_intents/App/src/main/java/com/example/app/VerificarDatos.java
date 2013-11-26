package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

/**
 * Created by USUARIO on 21/11/13.
 * Second activity
 */
public class VerificarDatos extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.second_activity);






        Bundle extras = getIntent().getExtras();

        String s = (extras != null) ? extras.getString("dato_procesado") : "No hay dato";


        TextView textView = (TextView) findViewById(R.id.resultado);
        textView.setText(s);
        Intent intent = new Intent();
        intent.putExtra("restValue", s);
        setResult(Activity.RESULT_OK, intent);

        Log.i("MSOLIS", "second activity proceso resultado (al regresar a primera activity se mostrara el resultado tocando el back button)");





        Button btn_goto3a1 = (Button)findViewById(R.id.btn_goto3a1);

        btn_goto3a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(VerificarDatos.this, TercerNivel1Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

            }
        });


    }






}
