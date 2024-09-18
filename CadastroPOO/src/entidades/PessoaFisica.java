package entidades;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idadePessoa;
    private String documentoCpf;

    public PessoaFisica() {
        // Construtor padrão sem parâmetros
    }

    public PessoaFisica(Integer idadePessoa, String documentoCpf) {
        this.idadePessoa = idadePessoa;
        this.documentoCpf = documentoCpf;
    }

    public PessoaFisica(String nomePessoa, Integer idadePessoa, String documentoCpf) {
        super(nomePessoa);  // Chama o construtor da classe Pai (Pessoa)
        this.idadePessoa = idadePessoa;
        this.documentoCpf = documentoCpf;
    }

    public Integer getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(Integer idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public String getDocumentoCpf() {
        return documentoCpf;
    }

    public void setDocumentoCpf(String documentoCpf) {
        this.documentoCpf = documentoCpf;
    }

    @Override
    public String exibir() {
        return
                "ID: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Idade: " + idadePessoa + "\n" +
                "CPF: '" + documentoCpf + "\n";
    }
}
