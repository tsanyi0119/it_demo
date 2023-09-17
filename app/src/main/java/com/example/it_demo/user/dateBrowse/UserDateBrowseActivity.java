package com.example.it_demo.user.dateBrowse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.it_demo.R;
import com.example.it_demo.user.keepAccount.UserKeepAccountActivity;

public class UserDateBrowseActivity extends AppCompatActivity {

    private ImageView img_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_date_browse);
        init();
    }

    private void init(){
        img_add = findViewById(R.id.img_add);
        setupUI();
    }

    private void setupUI(){
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDateBrowseActivity.this, UserKeepAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}