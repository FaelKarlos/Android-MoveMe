package moveme.com.br.moveme.modelos;

import java.io.Serializable;

public class Motorista implements Serializable{
    private Integer id;
    private String nome;

    public Motorista() {
    }

    public Motorista(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
