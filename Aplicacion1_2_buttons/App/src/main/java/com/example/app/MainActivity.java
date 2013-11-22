package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    private EditText entrada;
    private TextView salida;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.fragment_main);


        entrada = (EditText) findViewById(R.id.entrada);

        salida = (TextView) findViewById(R.id.salida);



/*        if (savedInstanceState == null) {

            DetailsFragment details = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.container);

            DetailsFragment details = new DetailsFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.container, new DetailsFragment()).commit();


        }*/





    }



    public void sePulsa(View view){

        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
        salida.setText(String.valueOf(Float.parseFloat(entrada.getText().toString()) * 2.0));



    }

    public void sePulsaButton2(View view){


        //Log.i("MSOLIS", entrada.getText().toString());
        //entrada.setText(entrada.getText()+"0");
        entrada.setText(entrada.getText()+(String)view.getTag());


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailsFragment extends Fragment {



        public DetailsFragment() {


        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);



            return rootView;



        }



    }

}
