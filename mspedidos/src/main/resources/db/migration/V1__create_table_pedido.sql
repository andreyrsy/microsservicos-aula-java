CREATE TABLE pedido(
    id BIGSERIAL PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL
)