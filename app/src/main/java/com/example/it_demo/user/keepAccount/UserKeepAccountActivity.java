package com.example.it_demo.user.keepAccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.it_demo.R;

public class UserKeepAccountActivity extends AppCompatActivity {

    Button btn_keep_expenses,btn_keep_assets;
    LinearLayout linearLayout_keep_assets , linearLayout_keep_expenses;
    ImageView img_food,img_traffic,img_medical,img_pet,img_3c,img_life,img_deposit,img_wallet,img_storedvalue;
    TextView tv_keep_type;
    String type = "food";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_keep_account);
        init();
    }
    private void init(){
        btn_keep_expenses = findViewById(R.id.btn_keep_expenses);
        btn_keep_assets = findViewById(R.id.btn_keep_assets);
        linearLayout_keep_assets = findViewById(R.id.linearLayout_keep_assets);
        linearLayout_keep_expenses = findViewById(R.id.linearLayout_keep_expenses);
        img_food = findViewById(R.id.img_food);
        img_traffic = findViewById(R.id.img_traffic);
        img_medical = findViewById(R.id.img_medical);
        img_pet = findViewById(R.id.img_pet);
        img_3c = findViewById(R.id.img_3c);
        img_life = findViewById(R.id.img_life);
        img_deposit = findViewById(R.id.img_deposit);
        img_wallet = findViewById(R.id.img_wallet);
        img_storedvalue = findViewById(R.id.img_storedvalue);
        tv_keep_type = findViewById(R.id.tv_keep_type);
        recyclerView = findViewById(R.id.recyclerView);
        setupUI();
    }
    private void setupUI(){
        btn_keep_expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpensesView();
            }
        });
        btn_keep_assets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAssetsView();
            }
        });
        btn_keep_expenses.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAD689")));
        btn_keep_assets.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFB")));
//        recyclerViewAdapter = new UserNoteBookAdapter(this);
//        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setAssetsView() {
        linearLayout_keep_assets.setVisibility(View.VISIBLE);
        linearLayout_keep_expenses.setVisibility(View.GONE);
        btn_keep_assets.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAD689")));
        btn_keep_expenses.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFB")));
        tv_keep_type.setText("存款");
        type = "deposit";
        img_deposit.setImageDrawable(getResources().getDrawable(R.drawable.ic_deposit_light));
        img_wallet.setImageDrawable(getResources().getDrawable(R.drawable.ic_wallet_preset));
        img_storedvalue.setImageDrawable(getResources().getDrawable(R.drawable.ic_storedvalue_preseet));

    }

    private void setExpensesView() {
        linearLayout_keep_assets.setVisibility(View.GONE);
        linearLayout_keep_expenses.setVisibility(View.VISIBLE);
        btn_keep_assets.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFB")));
        btn_keep_expenses.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAD689")));
        tv_keep_type.setText("飲食");
        type = "food";
        img_food.setImageDrawable(getResources().getDrawable(R.drawable.ic_food_light));
        img_traffic.setImageDrawable(getResources().getDrawable(R.drawable.ic_traffic_preset));
        img_medical.setImageDrawable(getResources().getDrawable(R.drawable.ic_medical_preset));
        img_pet.setImageDrawable(getResources().getDrawable(R.drawable.ic_pet_preset));
        img_3c.setImageDrawable(getResources().getDrawable(R.drawable.ic_digit_preseet));
        img_life.setImageDrawable(getResources().getDrawable(R.drawable.ic_life_preset));
    }
}