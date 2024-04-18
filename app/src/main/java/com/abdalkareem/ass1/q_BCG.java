package com.abdalkareem.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class q_BCG extends AppCompatActivity {
    private CheckBox c;
    private CheckBox c2;
    private TextView show;
    private TextView show2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qbcg);
        c=findViewById(R.id.check_answer);
        c2=findViewById(R.id.check_answer2);
        show=findViewById(R.id.showanswer);
        show2=findViewById(R.id.showanswer2);
        boolean ischecked=c.isChecked();
        boolean ischecked2=c2.isChecked();
        updatetext(ischecked);


        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updatetext(buttonView.isChecked());
            }
        });
        updatetext2(ischecked2);

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updatetext2(buttonView.isChecked());
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void updatetext(boolean ischecked) {
        if(c.isChecked()){
            show.setVisibility(View.VISIBLE);
        } else{
            show.setVisibility(View.INVISIBLE);
        }
    }
    private void updatetext2(boolean ischecked) {
        if(c2.isChecked()){
            show2.setVisibility(View.VISIBLE);
        } else{
            show2.setVisibility(View.INVISIBLE);
        }
    }
    public void back(View view) {
        finish();
    }
}