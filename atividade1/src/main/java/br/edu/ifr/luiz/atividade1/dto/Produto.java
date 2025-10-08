package br.edu.ifr.luiz.atividade1.dto;

public class Produto {
    private Long id;
    public String nome;
    public Double preco;
    public Integer quantidade;

    public Long getId() {return id;};
    public void setId(Long id) {this.id = id;}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}

