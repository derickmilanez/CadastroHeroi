package com.associacaodesuperherois.cadastroheroi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastrado extends AppCompatActivity {
    Button btOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrado);
        getSupportActionBar().setTitle("Cadastrado com sucesso");
        btOk = findViewById(R.id.buttonOk);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itOk = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(itOk);
            }
        });
    }
}