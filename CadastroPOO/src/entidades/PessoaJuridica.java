package entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numeroCnpj;

    public PessoaJuridica() {
        // Construtor vazio
    }

    public PessoaJuridica(String numeroCnpj) {
        this.numeroCnpj = numeroCnpj;
    }

    public PessoaJuridica(String nomeEmpresa, String numeroCnpj) {
        super(nomeEmpresa);
        this.numeroCnpj = numeroCnpj;
    }

    public PessoaJuridica(Integer identificador, String nomeEmpresa, String numeroCnpj) {
        super(nomeEmpresa);
        this.numeroCnpj = numeroCnpj;
    }

    public String getNumeroCnpj() {
        return numeroCnpj;
    }

    public void setNumeroCnpj(String numeroCnpj) {
        this.numeroCnpj = numeroCnpj;
    }

    @Override
    public String exibir() {
        return
                "ID: " + getId() + "\n" +
                "Empresa: " + getNome() + "\n" +
                "CNPJ: " + getNumeroCnpj() + "\n";
    }
}
