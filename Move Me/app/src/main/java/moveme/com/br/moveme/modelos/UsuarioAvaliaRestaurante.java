package moveme.com.br.moveme.modelos;

import java.util.Date;

public class UsuarioAvaliaRestaurante {

    private Integer id;
    private Integer avaliacao;
    private Date dia;
    private Integer idrestaurante;
    private String cpfusuario;

    public UsuarioAvaliaRestaurante() {
    }

    public UsuarioAvaliaRestaurante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Integer getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(Integer idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public String getCpfusuario() {
        return cpfusuario;
    }

    public void setCpfusuario(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    @Override
    public String toString() {
        return "UsuarioAvaliaRestaurante{" +
                "id=" + id +
                ", avaliacao=" + avaliacao +
                ", dia=" + dia +
                ", idrestaurante=" + idrestaurante +
                ", cpfusuario='" + cpfusuario + '\'' +
                '}';
    }
}
