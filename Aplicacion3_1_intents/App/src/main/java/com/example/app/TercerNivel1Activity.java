package com.example.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USUARIO on 22/11/13.
 */
public class TercerNivel1Activity extends BaseActivity {


    private View mContentView;
    private View mLoadingView;
    private int mShortAnimationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tercer_activity1);

        Button button = (Button) findViewById(R.id.btn_goto3a2);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TercerNivel1Activity.this, TercerNivel2Activity.class);


                mContentView = findViewById(R.id.textView);
                mLoadingView = findViewById(R.id.loading_spinner);

                // Initially hide the content view.
                mContentView.setVisibility(View.GONE);



                mLoadingView.setVisibility(view.VISIBLE);


                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

            }
        });


    }





}
