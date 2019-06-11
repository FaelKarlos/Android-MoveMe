package experimentos.br.com.wspredicao;

import java.io.Serializable;

public class Restaurante implements Serializable{

    private String nome;
    private String cidade;
    private Double longitude;
    private Double latitude;
    private String cozinha;
    private int alcance_preco;
    private double classifi_agregada;
    private String taxa_votos;
    private int votos;

    public Restaurante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCozinha() {
        return cozinha;
    }

    public void setCozinha(String cozinha) {
        this.cozinha = cozinha;
    }

    public int getAlcance_preco() {
        return alcance_preco;
    }

    public void setAlcance_preco(int alcance_preco) {
        this.alcance_preco = alcance_preco;
    }

    public double getClassifi_agregada() {
        return classifi_agregada;
    }

    public void setClassifi_agregada(int classifi_agregada) {
        this.classifi_agregada = classifi_agregada;
    }

    public String getTaxa_votos() {
        return taxa_votos;
    }

    public void setTaxa_votos(String taxa_votos) {
        this.taxa_votos = taxa_votos;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", cozinha='" + cozinha + '\'' +
                ", alcance_preco=" + alcance_preco +
                ", classifi_agregada=" + classifi_agregada +
                ", taxa_votos='" + taxa_votos + '\'' +
                ", votos=" + votos +
                '}';
    }
}
