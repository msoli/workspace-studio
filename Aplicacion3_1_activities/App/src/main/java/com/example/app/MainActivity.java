package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    public void lanzarAcercaDe(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);


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

        if (id == R.id.close_settings) {
            this.finish();
        }

        if (id == R.id.acercade_settings) {
            lanzarAcercaDe(null);
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }


        public void lanzarAcercaDe(View view) {
            Intent i = new Intent(getActivity(), AcercaDe.class);
            startActivity(i);


        }

        public void lanzarVerify(View view) {

            Intent i = new Intent(getActivity(), VerificarDatos.class);


            TextView dato = (TextView) getActivity().findViewById(R.id.input_dato);

            //para leer el strings.xml
            Resources res = getResources();
            String text = String.format(res.getString(R.string.msg_verify), dato.getText().toString());

            i.putExtra("dato_procesado", text);
            Log.i("MSOLIS", text);


            startActivity(i);


        }




        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Button butAcercade = (Button) rootView.findViewById(R.id.btn_acercade);
            butAcercade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lanzarAcercaDe(view);
                }
            });


            Button btnVerify = (Button) rootView.findViewById(R.id.btn_verify);

            btnVerify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lanzarVerify(view);
                }
            });









            return rootView;
        }


    }

}
