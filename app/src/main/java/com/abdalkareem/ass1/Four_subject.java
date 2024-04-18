package com.abdalkareem.ass1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Four_subject extends AppCompatActivity {
private EditText REV;
private EditText TOTAL;
private TextView PROFIT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_four_subject);
        REV=findViewById(R.id.revenue);
        TOTAL=findViewById(R.id.totalcost);
        PROFIT=findViewById(R.id.totalprofit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void equal(View view) {
        String rev=REV.getText().toString();
        String total=TOTAL.getText().toString();
        if(rev.isEmpty()){
            REV.setError("this field is required");
            REV.requestFocus();
        }
        else if(total.isEmpty()) {
            TOTAL.setError("this field is required");
            TOTAL.requestFocus();
        }
        else {
            int x=Integer.parseInt(rev);
            int y=Integer.parseInt(total);
int equal=x-y;
PROFIT.setText(String.valueOf(equal));

        }
    }

    public void back(View view) {
        finish();
    }
}