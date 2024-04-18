package com.abdalkareem.ass1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText EDNAME;
    private EditText EDGMAIL;
    private EditText EDPASS;
    private Spinner LAN_SPIN;
    private CheckBox Check;
    private  final String[] languages={"select languages " , "English" , "Arabic"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EDNAME=findViewById(R.id.ed_name);
        EDGMAIL=findViewById(R.id.ed_gmail);
        EDPASS=findViewById(R.id.ed_pass);
        LAN_SPIN=findViewById(R.id.spn_languge);
        Check=findViewById(R.id.checkBox);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LAN_SPIN.setAdapter(adapter);
        LAN_SPIN.setSelection(0);
        LAN_SPIN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang=parent.getItemAtPosition(position).toString();
                if(selectedLang.equals("English")){
                    setlocal(MainActivity.this,"English");
                    finish();
                    startActivity(getIntent());
                } else if ( selectedLang.equals("Arabic") ) {
                    setlocal(MainActivity.this,"hi");
                    finish();
                    startActivity(getIntent());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void setlocal(Activity activity,String langcode){
        Locale locale = new Locale(langcode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());


    }

    public void log_in(View view) {
        String nametext=EDNAME.getText().toString().trim();
        String gmailtext=EDGMAIL.getText().toString().trim();
        String passtext=EDPASS.getText().toString().trim();
        if(nametext.isEmpty()){
            EDNAME.setError("this field is required");
            EDNAME.requestFocus();
        }
        else if (gmailtext.isEmpty()){
            EDGMAIL.setError("this field is required");
            EDGMAIL.requestFocus();
        }
        else if (passtext.isEmpty()) {
            EDPASS.setError("this foeld is reqiored");
            EDPASS.requestFocus();
        } else {
            if(Check.isChecked()){
                shared();
            }
            Intent intent = new Intent(this, Subj2.class);
            String user_name = EDNAME.getText().toString();
            intent.setType("text/plain");
            intent.putExtra("name", user_name);
            startActivity(intent);
        }
    }
    public void shared() {
        SharedPreferences sharedPrefrence = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefrence.edit();
        editor.putString("name", EDNAME.getText().toString());
        editor.putString("password", EDPASS.getText().toString());
        editor.putString("Gmail", EDGMAIL.getText().toString());
        editor.apply();
    }
    public void onStart(){
        super.onStart();
        Log.d("activity_main","in the onStart event " );


    }
public void onPause(){
        super.onPause();
        Log.d("activity_main","in the onPause event ");
}

public void onStop(){
    super.onStop();
    Log.d("activity_main","in the onstop event ");

}





}