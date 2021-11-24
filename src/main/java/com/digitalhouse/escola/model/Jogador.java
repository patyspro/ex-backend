package com.digitalhouse.escola.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_jogadores") // nome da tabela
public class Jogador {

    @Id // precisamos identificar para o banco de dados conhecer o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento para a primary key-mais perfomático
    private Long id;
    private String nome;
    private String posicao;
    private int numero;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "time_id")
    private Time time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
