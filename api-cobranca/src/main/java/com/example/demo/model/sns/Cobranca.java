package com.example.demo.model.sns;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cpf_cliente;

    private String mensagem;

    private LocalDateTime created_at;

    public Cobranca(){}

    public Cobranca(Long id, String cpf_cliente, String mensagem, LocalDateTime created_at) {
        this.id = id;
        this.cpf_cliente = cpf_cliente;
        this.mensagem = mensagem;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "id=" + id +
                ", cpf_cliente='" + cpf_cliente + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
