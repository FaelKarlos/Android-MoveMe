package moveme.com.br.moveme.modelos;

import java.io.Serializable;

public class Restaurante implements Serializable {

  private String nome;
  private String cidade;
  private long longitude;
  private long latitude;
  private String cozinha;
  private int alcancePreco;
  private Double classificacaoAgregada;


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

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getCozinha() {
        return cozinha;
    }

    public void setCozinha(String cozinha) {
        this.cozinha = cozinha;
    }

    public int getAlcancePreco() {
        return alcancePreco;
    }

    public void setAlcancePreco(int alcancePreco) {
        this.alcancePreco = alcancePreco;
    }

    public Double getClassificacaoAgregada() {
        return classificacaoAgregada;
    }

    public void setClassificacaoAgregada(Double classificacaoAgregada) {
        this.classificacaoAgregada = classificacaoAgregada;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", cozinha='" + cozinha + '\'' +
                ", alcancePreco=" + alcancePreco +
                ", classificacaoAgregada=" + classificacaoAgregada +
                '}';
    }
}
