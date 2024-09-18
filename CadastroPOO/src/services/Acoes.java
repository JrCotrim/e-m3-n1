package services;

import java.util.Scanner;

import dao.Dao;
import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import utils.Util;

public class Acoes {
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private Scanner scanner = new Scanner(System.in);
    private String opcaoPessoa;
    private String opcaoAcao;
    private String prefixo = "";
    private static Integer idBusca = 0;
    private Util utl;
    private Dao dao;
    private String nome = "";
    private String cpf = "";
    private String cnpj = "";
    private Integer idade = 0;

    public Acoes(String opcaoPessoa, String opcaoAcao) {
        this.opcaoPessoa = opcaoPessoa;
        this.opcaoAcao = opcaoAcao;
        this.utl = new Util(opcaoPessoa, opcaoAcao);
        this.dao = new Dao(opcaoPessoa);
    }

    public void executarAcoes() {
        String tpPessoa = opcaoPessoa.equals("f") ? "Pessoa Física" : "Pessoa Jurídica";
        switch (opcaoAcao) {
            case "I":
                novo();
                break;
            case "A":
                editar();
                break;
            case "R":
                excluir();
                break;
            case "B":
                mostrarItemPorId();
                break;
            case "S":
                mostrarTodos();
                break;
            case "P":
                persistirDadosBinarios();
                break;
            case "G":
                recuperarDadosBinarios();
                break;
            case "E":
                System.out.println("Saindo...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Escolha inválida. Tente novamente.");
                utl.clickMe();
        }
    }

    private void mostrarItemPorId() {
        obterId();
        if (obterDadosPorId()) {
            System.out.println("Dados encontrados:");
            exibirDadosPessoa();
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private void editar() {
        obterId();
        if (obterDadosPorId()) {
            System.out.println("Caso deseje manter o valor original, tecle [enter] para seguir ao próximo item");
            preencheDadosPessoa();
            edicaoListasPessoa();
        } else {
            System.out.println("Pessoa não encontrada para edição.");
        }
    }

    private void novo() {
        preencheDadosPessoa();
        insercaoListasPessoa();
    }

    private void excluir() {
        obterId();
        if (obterDadosPorId()) {
            System.out.println("Confirma a exclusão do item (S/N)?");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("S")) {
                dao.excluir(idBusca);
                System.out.println("Dados excluídos com sucesso.");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Pessoa não encontrada para exclusão.");
        }
    }

    private void mostrarTodos() {
        dao.obterTodos().forEach(System.out::println);
    }

    private void recuperarDadosBinarios() {
        prefixo = utl.inputDadosText("Digite o prefixo do arquivo", "O prefixo precisa ser preenchido", "");
        dao.recuperar(prefixo);
    }

    private void persistirDadosBinarios() {
        prefixo = utl.inputDadosText("Digite o prefixo do arquivo", "O prefixo precisa ser preenchido", "");
        dao.persistir(prefixo);
    }

    private void insercaoListasPessoa() {
        if (opcaoPessoa.equals("f")) {
            dao.inserir(pessoaFisica);
        } else {
            dao.inserir(pessoaJuridica);
        }
    }

    private void edicaoListasPessoa() {
        if (opcaoPessoa.equals("f")) {
            dao.alterar(pessoaFisica);
        } else {
            dao.alterar(pessoaJuridica);
        }
    }

    private void preencheDadosPessoa() {
        String nomeNovo = utl.inputDadosText("Digite o nome", "Nome precisa ser preenchido", nome);

        if (opcaoPessoa.equals("f")) {
            idade = utl.inputDadosNum("Digite a idade", "Idade deve estar entre 18 e 99 anos", idade);
            cpf = utl.inputDadosText("Digite o CPF", "CPF precisa ser definido", cpf);
            pessoaFisica = new PessoaFisica(nomeNovo, idade, cpf);
        } else {
            cnpj = utl.inputDadosText("Digite o CNPJ", "CNPJ precisa ser definido", cnpj);
            pessoaJuridica = new PessoaJuridica(nomeNovo, cnpj);
        }
    }

    private void exibirDadosPessoa() {
        if (opcaoPessoa.equals("f")) {
            System.out.println(pessoaFisica.exibir());
        } else {
            System.out.println(pessoaJuridica.exibir());
        }
    }

    private boolean obterDadosPorId() {
        Pessoa pessoa = dao.obter(idBusca);
        if (pessoa != null) {
            if (pessoa instanceof PessoaFisica) {
                pessoaFisica = (PessoaFisica) pessoa;
                nome = pessoaFisica.getNome();
                cpf = pessoaFisica.getCpf();
                idade = pessoaFisica.getIdade();
            } else if (pessoa instanceof PessoaJuridica) {
                pessoaJuridica = (PessoaJuridica) pessoa;
                nome = pessoaJuridica.getNome();
                cnpj = pessoaJuridica.getCnpj();
            }
            return true;
        }
        return false;
    }

    private void obterId() {
        while (true) {
            try {
                System.out.println("Digite o ID");
                idBusca = scanner.nextInt();
                scanner.nextLine();
                return;
            } catch (RuntimeException e) {
                System.out.println("ID inválido, valor deve ser numérico. Tente novamente.");
                utl.clickMe();
            }
        }
    }
}