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

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);// para activar el boton home


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

            Log.i("MSOLIS","Se manda a second activity");
            startActivityForResult(i, 123);



            getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);





        }


        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 123 && resultCode == RESULT_OK){


                Log.i("MSOLIS","Se obtiene resulado de la  second activity");
                TextView textView = (TextView) getActivity().findViewById(R.id.hello_result);

                textView.setText(data.getStringExtra("restValue"));



            }

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
