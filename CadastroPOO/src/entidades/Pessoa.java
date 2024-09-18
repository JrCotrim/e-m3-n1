package entidades;

import utils.IDControle;
import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Integer contadorId = 0;
    private Integer identificadorUnico;
    private String nomePessoa;

    public Pessoa() {
        // Construtor padrão
    }

    public Pessoa(String nomePessoa) {
        // Atribui um ID único usando o controle de ID
        contadorId = IDControle.getID();
        this.identificadorUnico = contadorId;
        this.nomePessoa = nomePessoa;
    }

    public Integer getId() {
        return identificadorUnico;
    }

    /*
    Método desabilitado para impedir que o ID seja manualmente definido.
    public void setId(Integer identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }
    */

    public String getNome() {
        return nomePessoa;
    }

    public void setNome(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract String exibir();
}
