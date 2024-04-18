package com.abdalkareem.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Subj2 extends AppCompatActivity {
    private TextView SHOW_NAME;
    private ListView LIST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subj2);
        SHOW_NAME = findViewById(R.id.show_name);
        Intent intent2 = getIntent();
        String user_name = intent2.getStringExtra("name");
        SHOW_NAME.setText(" Welcome "+ user_name + " to entrepreneurship course ");
        LIST=findViewById(R.id.list);
        List<String> list = new ArrayList<>();
        list.add("1. Supply ");
        list.add("2.Demand");
        list.add("3.Equilibrium");
        list.add("4.Profit");
        list.add("5.4C’s");
        list.add("6.Characteristics of entrepreneurs");
        list.add("7.BCG Matrix");


        ArrayAdapter arrayadapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        LIST.setAdapter(arrayadapter);
        LIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent fint = new Intent(Subj2.this, First_subject.class);
                    startActivity(fint);

                } else if (position==1){
                    Intent sint = new Intent(Subj2.this, Secod_subject.class);
                    startActivity(sint);
                }
                else if (position==2){
                    Intent tint = new Intent(Subj2.this, Ther_subject.class);
                    startActivity(tint);
                }
                else if (position==3){
                    Intent fint = new Intent(Subj2.this, Four_subject.class);
                    startActivity(fint);
                }
                else if (position==4){
                    Intent FIint = new Intent(Subj2.this, five_subject.class);
                    startActivity(FIint);
                }
                else if (position==5){
                    Intent siint = new Intent(Subj2.this, six_subject.class);
                    startActivity(siint);
                }
                else if (position==6){
                    Intent seint = new Intent(Subj2.this, seven_subject.class);
                    startActivity(seint);
                }


            }

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onStart(){
        super.onStart();
        Log.d("activity","in the onPause event ");
    }
    public void onStop(){
        super.onStop();
        Log.d("activity","in the onPause event ");
    }

}