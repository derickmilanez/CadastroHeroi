package com.associacaodesuperherois.cadastroheroi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detalhes extends AppCompatActivity {
    TextView id, nome, habilidade, descricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroi);
        id = findViewById(R.id.textViewId);
        nome = findViewById(R.id.textViewNome);
        habilidade = findViewById(R.id.textViewHabilidade);
        descricao = findViewById(R.id.textViewDescricao);

        Intent detalhes = getIntent();
        Heroi dados = (Heroi) detalhes.getExtras().getSerializable("dados");
        id.setText(String.valueOf(dados.getId()));
        nome.setText(dados.getNomeheroi());
        habilidade.setText(dados.getHabilidade());
        descricao.setText(dados.getDescricao());
    }
}
