package com.example.myapplicationnum2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioButton radio1;
    RadioButton radio2;

    public void showText(View view) {
        String noPhone = editText.getText().toString();
        String pilih ="";
        if (radio1.isChecked()){
            pilih="Laki";
        } else if (radio2.isChecked()) {
            pilih="perempuan";
        }
        Toast.makeText(this, pilih+": " + noPhone, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextText);
        radio1= findViewById(R.id.radioButton);
        radio2= findViewById(R.id.radioButton2);
        Button submit = findViewById(R.id.submit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText(v);
            }
        });
    }

}