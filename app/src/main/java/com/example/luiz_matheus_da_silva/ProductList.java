package com.example.luiz_matheus_da_silva;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

public class ProductList extends AppCompatActivity {
    private TextView textList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        textList = findViewById(R.id.txtList);

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> returnPage());

        ProductDb db = Room.databaseBuilder(getApplicationContext(),
                ProductDb.class, "product-database").allowMainThreadQueries().build();
        ProductDao productDao = db.productDao();

        List<Product> productList = productDao.getAllProducts();
        StringBuilder report = new StringBuilder();

        for (Product product : productList) {
            report.append("Produto: ").append(product.getNome()).append("\n")
                    .append("Código: ").append(product.getCodigo()).append("\n\n")
                    .append("Quantidade: ").append(product.getQuantidadeEstoque()).append("\n\n")
                    .append("Preço: R$").append(product.getPreco()).append("\n\n");
        }

        textList.setText(report.toString());
    }

    public void returnPage() {
        Intent intent = new Intent(ProductList.this, com.example.luiz_matheus_da_silva.MainActivity.class);
        startActivity(intent);
        finish();
    }
}
