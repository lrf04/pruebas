package com.example.holamundo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button,msj,newActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        msj=(Button)findViewById(R.id.msj);
        newActivity=(Button)findViewById(R.id.newActivity);


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String texto=editText.getText().toString();
                textView.setText(texto);
            }
        });
        msj.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"esto es un mensaje",Toast.LENGTH_SHORT).show();
            }
        });
        newActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}