package moveme.com.br.moveme.modelos;

import java.io.Serializable;

public class Escolha implements Serializable {
    private String taxaVotos;
    private int mediaPreco;
    private int alcancePreco;
    private Double classificacaoAgregada;
    private int votos;

    public String getTaxaVotos() {
        return taxaVotos;
    }

    public void setTaxaVotos(String taxaVotos) {
        this.taxaVotos = taxaVotos;
    }

    public int getMediaPreco() {
        return mediaPreco;
    }

    public void setMediaPreco(int mediaPreco) {
        this.mediaPreco = mediaPreco;
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

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Escolha{" +
                "taxaVotos='" + taxaVotos + '\'' +
                ", mediaPreco=" + mediaPreco +
                ", alcancePreco=" + alcancePreco +
                ", classificacaoAgregada=" + classificacaoAgregada +
                ", votos=" + votos +
                '}';
    }
}
