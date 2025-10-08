package br.edu.ifr.luiz.atividade1.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.ifr.luiz.atividade1.dto.Produto;

@Service
public class ProdutoService {

    private final Map<Long, Produto> produtos = new HashMap<>();

    public ProdutoService() {
        Produto p1 = new Produto();
        p1.setId(1L);
        p1.nome = "Camiseta";
        p1.preco = 59.9;
        p1.quantidade = 3;

        Produto p2 = new Produto();
        p2.setId(2L);
        p2.nome = "Boné";
        p2.preco = 39.9;
        p2.quantidade = 5;

        produtos.put(p1.getId(), p1);
        produtos.put(p2.getId(), p2);
    }

    public Collection<Produto> listProdutos() {
        return produtos.values();
    }

    public Produto retriveProduto(Long id) {
        return produtos.get(id);
    }

    public Produto createProduto(Produto produto) {
        Long novoId = (long) (produtos.size() + 1);
        produto.setId(novoId);
        produtos.put(novoId, produto);
        return produto;
    }

    public Produto updateProduto(Long id, Produto updatedProduto) {
        Produto existent = produtos.get(id);

        if(existent != null) {
            existent.setNome(updatedProduto.getNome());
            existent.setPreco(updatedProduto.getPreco());
            existent.setQuantidade(updatedProduto.getQuantidade());
            produtos.put(id, existent);
            return existent;
        }

        return null;
    }

    public Boolean deleteProduto(Long id) {
        if(produtos.containsKey(id)) {
            produtos.remove(id);
            return true;
        }
        return false;
    }

    public Collection<Produto> searchProduto(String nome) {
        return produtos.values().stream()
            .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
            .toList();
    }
}
