package moveme.com.br.moveme.modelos;

public class Veiculo {

    private Integer id;
    private Integer numeroVagas;

    public Veiculo() {
    }

    public Veiculo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", numeroVagas=" + numeroVagas +
                '}';
    }
}
