package com.example.it_demo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.it_demo.R;

public class LoginActivity extends AppCompatActivity {

    View login_layout,register_layout;
    Button login_register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();

    }
    private void setupUI() {
        login_layout = findViewById(R.id.login_layout);
        register_layout = findViewById(R.id.register_layout);
        login_register_button = findViewById(R.id.login_register_button);
        login_register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFloatUpAnimation(login_layout,register_layout);
            }
        });
        register_layout.setVisibility(View.GONE);
        startFloatUpAnimation(register_layout,login_layout);
    }
    private void startFloatUpAnimation(View disappearView,View displayView){
        disappearView.setVisibility(View.GONE);
        displayView.setVisibility(View.VISIBLE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(displayView, "scaleX", 0.2f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(displayView, "scaleY", 0.2f, 1.0f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);

        scaleX.start();
        scaleY.start();
    }
}