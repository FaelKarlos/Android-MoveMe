package moveme.com.br.moveme.modelos;

public class UsuarioViagemPK {

    private int idviagem;
    private String cpfusuario;

    public UsuarioViagemPK() {
    }

    public UsuarioViagemPK(int idviagem, String cpfusuario) {
        this.idviagem = idviagem;
        this.cpfusuario = cpfusuario;
    }

    public int getIdviagem() {
        return idviagem;
    }

    public void setIdviagem(int idviagem) {
        this.idviagem = idviagem;
    }

    public String getCpfusuario() {
        return cpfusuario;
    }

    public void setCpfusuario(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    @Override
    public String toString() {
        return "UsuarioViagemPK{" +
                "idviagem=" + idviagem +
                ", cpfusuario='" + cpfusuario + '\'' +
                '}';
    }
}
