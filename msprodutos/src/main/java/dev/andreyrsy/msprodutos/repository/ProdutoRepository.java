package dev.andreyrsy.msprodutos.repository;

import dev.andreyrsy.msprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
