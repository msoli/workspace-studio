package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

/**
 * Created by USUARIO on 21/11/13.
 *
 * para al extender de esta clase se cree el menu en todas las activiti
 */
public class BaseActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);// para activar el boton home
        actionBar.setDisplayHomeAsUpEnabled(true);//para mostrar la flecha




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.setQwertyMode(true);
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

        if (id == R.id.acercade_settings) {
            lanzarAcercaDe(null);
        }

        //android.R.id.home para tomar el R.id del boton home del actionbar
        if (id == android.R.id.home){
            navigateUp2();
        }

        return super.onOptionsItemSelected(item);
    }





    public void lanzarAcercaDe(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }


    public void navigateUp(){

        NavUtils.navigateUpFromSameTask(this);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }


    public void navigateUp2(){

        Intent upIntent = NavUtils.getParentActivityIntent(this);

        Log.i("MSOLIS", upIntent.toString());
        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
            // This activity is NOT part of this app's task, so create a new task
            // when navigating up, with a synthesized back stack.

            TaskStackBuilder.create(this)
                    // Add all of this activity's parents to the back stack
                    .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                    .startActivities();
        } else {
            // This activity is part of this app's task, so simply
            // navigate up to the logical parent activity.
            NavUtils.navigateUpTo(this, upIntent);
        }



        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }


    public  void backToHome(){
        Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

    }


    public void backToHome2(){
        Intent homeIntent= new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

    }

}
