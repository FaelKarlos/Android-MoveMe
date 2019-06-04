package moveme.com.br.moveme.modelos;

import java.util.Date;

public class Viagem {

    private Integer id;
    private Date dia;
    private Integer nota;
    private String cpfusuario;
    private Integer idmotorista;
    private Integer idveiculo;

    public Viagem() {

    }

    public Viagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getCpfusuario() {
        return cpfusuario;
    }

    public void setCpfusuario(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    public Integer getIdmotorista() {
        return idmotorista;
    }

    public void setIdmotorista(Integer idmotorista) {
        this.idmotorista = idmotorista;
    }

    public Integer getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", dia=" + dia +
                ", nota=" + nota +
                ", cpfusuario='" + cpfusuario + '\'' +
                ", idmotorista=" + idmotorista +
                ", idveiculo=" + idveiculo +
                '}';
    }
}
