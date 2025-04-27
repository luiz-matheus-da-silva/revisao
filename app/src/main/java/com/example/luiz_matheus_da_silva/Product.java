package com.example.luiz_matheus_da_silva;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public String nome;
    public String codigo;
    public Double preco;
    public Integer quantidadeEstoque;

    public Product(String nome, String codigo, Double preco, Integer quantidadeEstoque){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public Double getPreco() { return preco; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
}
