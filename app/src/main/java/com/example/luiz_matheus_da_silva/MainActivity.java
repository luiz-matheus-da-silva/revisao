package com.example.luiz_matheus_da_silva;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private EditText editNome, editCodigo, editPreco, editQuantidadeEstoque;

    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editCodigo = findViewById(R.id.editCodigo);
        editPreco = findViewById(R.id.editPreco);
        editQuantidadeEstoque = findViewById(R.id.editQuantidadeEstoque);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnList = findViewById(R.id.btnList);

        ProductDb db = Room.databaseBuilder(getApplicationContext(),
                ProductDb.class, "product-database").allowMainThreadQueries().build();
        productDao = db.productDao();

        btnAdd.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Cadastrar Produto clicado!");

            String nome = editNome.getText().toString();
            String codigo = editCodigo.getText().toString();
            String preco = editPreco.getText().toString();
            String quantidadeEstoque = editQuantidadeEstoque.getText().toString();

            if (!nome.isEmpty() && !codigo.isEmpty() && !preco.isEmpty() && !quantidadeEstoque.isEmpty()) {
                Double doublePreco = Double.parseDouble(preco);
                Integer intQuantidadeEstoque = Integer.parseInt(quantidadeEstoque);

                Product product = new Product(nome, codigo, doublePreco, intQuantidadeEstoque);
                productDao.insert(product);

                Log.d("MainActivity", "Produto inserido no banco de dados.");

                Toast.makeText(MainActivity.this, "Produto cadastrado!", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("MainActivity", "Erro: Campos obrigatórios vazios!");

                Toast.makeText(MainActivity.this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
            }
        });
        btnList.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ProductList.class))
        );
    }
}