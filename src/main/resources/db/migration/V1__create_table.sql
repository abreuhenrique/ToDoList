CREATE TABLE tb_todo (
    id BIGSERIAL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    prazo TIMESTAMP,
    status varchar(20) DEFAULT 'PENDENTE',
    observacao TEXT,

    CHECK (
        status IN (
            'PENDENTE',
            'EM_ANDAMENTO',
            'CONCLUIDO'
            )
        )
);