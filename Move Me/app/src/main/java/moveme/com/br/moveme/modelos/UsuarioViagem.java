package moveme.com.br.moveme.modelos;

public class UsuarioViagem {

    protected UsuarioViagemPK usuarioViagemPK;
    private Integer avaliacao;
    private Long preco;

    public UsuarioViagem() {
    }

    public UsuarioViagem(UsuarioViagemPK usuarioViagemPK) {
        this.usuarioViagemPK = usuarioViagemPK;
    }

    public UsuarioViagem(int idviagem, String cpfusuario) {
        this.usuarioViagemPK = new UsuarioViagemPK(idviagem, cpfusuario);
    }

    public UsuarioViagemPK getUsuarioViagemPK() {
        return usuarioViagemPK;
    }

    public void setUsuarioViagemPK(UsuarioViagemPK usuarioViagemPK) {
        this.usuarioViagemPK = usuarioViagemPK;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }
}
