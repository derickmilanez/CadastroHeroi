package com.associacaodesuperherois.cadastroheroi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btCadastrar, btConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Cadastro de Heróis");
        btCadastrar = findViewById(R.id.buttonCadastrar);
        btConsultar = findViewById(R.id.buttonConsultar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCadastrar = new Intent(getApplicationContext(),Cadastrar.class);
                startActivity(itCadastrar);
            }
        });

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itConsultar = new Intent(getApplicationContext(),Consultar.class);
                startActivity(itConsultar);
            }
        });
    }
    public void onBackPressed(){
    }
}
