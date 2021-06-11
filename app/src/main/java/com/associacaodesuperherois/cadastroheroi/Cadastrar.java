package com.associacaodesuperherois.cadastroheroi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastrar extends AppCompatActivity {
    EditText nome, nomeheroi, idade, cpf,  habilidade, desc;
    Button enviar;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().setTitle("Cadastrar Herói");
        nome = findViewById(R.id.editTextNomeReal);
        nomeheroi = findViewById(R.id.editTextNomeHeroi);
        idade = findViewById(R.id.editTextIdade);
        cpf = findViewById(R.id.editTextCPF);
        habilidade = findViewById(R.id.editTextHabilidade);
        desc = findViewById(R.id.editTextDescricao);
        enviar = findViewById(R.id.buttonEviar);

        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null
        );

        db.execSQL(Banco.criarTabela());

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().toString().equals("") || nomeheroi.getText().toString().equals("") || idade.getText().toString().equals("") || cpf.getText().toString().equals("") || habilidade.getText().toString().equals("") || desc.getText().toString().equals("")) {
                    Toast.makeText(Cadastrar.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }else{
                    String xpto = idade.getText().toString();
                    int idade2 = Integer.parseInt(xpto);
                    if (idade2 <= 18 || idade2 >= 60) {
                        Toast.makeText(Cadastrar.this, "Você precisa ter entre 18 e 60 anos.", Toast.LENGTH_SHORT).show();
                    }else{
                        ContentValues dados = new ContentValues();
                        dados.put("nomereal", nome.getText().toString());
                        dados.put("nomeheroi", nomeheroi.getText().toString());
                        dados.put("idade", idade.getText().toString());
                        dados.put("cpf", cpf.getText().toString());
                        dados.put("habilidade", habilidade.getText().toString());
                        dados.put("descricao", desc.getText().toString());

                        db.insert(
                                Banco.tabela(),
                                null,
                                dados
                        );

                        Intent itCadastrado = new Intent(getApplicationContext(), Cadastrado.class);
                        startActivity(itCadastrado);
                    }
                }
            }
        });
    }
}