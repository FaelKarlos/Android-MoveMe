package experimentos.br.com.wspredicao;

public class Escolha {

    private String cozinha;
    private String taxa_votos;
    private int alcance_preco;
    private int classifi_agregada;
    private int votos;

    public Escolha() {

    }

    public String getCozinha() {
        return cozinha;
    }

    public void setCozinha(String cozinha) {
        this.cozinha = cozinha;
    }

    public String getTaxa_votos() {
        return taxa_votos;
    }

    public void setTaxa_votos(String taxa_votos) {
        this.taxa_votos = taxa_votos;
    }

    public int getAlcance_preco() {
        return alcance_preco;
    }

    public void setAlcance_preco(int alcance_preco) {
        this.alcance_preco = alcance_preco;
    }

    public int getClassifi_agregada() {
        return classifi_agregada;
    }

    public void setClassifi_agregada(int classifi_agregada) {
        this.classifi_agregada = classifi_agregada;
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
                "cozinha='" + cozinha + '\'' +
                ", taxa_votos='" + taxa_votos + '\'' +
                ", alcance_preco=" + alcance_preco +
                ", classifi_agregada=" + classifi_agregada +
                ", votos=" + votos +
                '}';
    }
}
