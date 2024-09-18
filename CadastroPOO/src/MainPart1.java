import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;

public class MainPart1 {
    public static void main(String[] args) {

        // 1 - Inicializando o repositório para pessoas físicas (pfRepo).
        PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();

        // 2 - Inserindo três registros de pessoas físicas usando o construtor completo.
        pfRepo.inserir(new PessoaFisica("João", 30, "9812345"));
        pfRepo.inserir(new PessoaFisica("Ana", 28, "9923456"));
        pfRepo.inserir(new PessoaFisica("Pedro", 21, "9786543"));

        System.out.println("");
        System.out.println("");

        // 3 - Gravando as informações de pfRepo em um arquivo chamado "pessoasFisicasData".
        pfRepo.persistir("pessoasFisicasData");

        System.out.println("Informações de Pessoas Físicas foram salvas com sucesso.");

        // 4 - Criando um novo repositório para pessoas físicas (pfRepo2).
        PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();

        // 5 - Recuperando os dados salvos no arquivo e carregando em pfRepo2.
        pfRepo2.recuperar("pessoasFisicasData");

        // 6 - Exibindo todas as pessoas físicas recuperadas do arquivo.
        System.out.println("Pessoas Físicas recuperadas do arquivo:");
        pfRepo2.ListarTodas();


        // 7 - Inicializando o repositório para pessoas jurídicas (pjRepo).
        PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();

        // 8 - Inserindo três registros de pessoas jurídicas com o construtor completo.
        pjRepo.inserir(new PessoaJuridica("Empresa X", "35487612"));
        pjRepo.inserir(new PessoaJuridica("Loja Y", "85412389"));
        pjRepo.inserir(new PessoaJuridica("Serviços Z", "45321987"));

        // 9 - Salvando as informações de pjRepo em um arquivo chamado "pessoasJuridicasData".
        System.out.println("Dados de Pessoas Jurídicas foram salvos.");
        pjRepo.persistir("pessoasJuridicasData");

        // 10 - Criando outro repositório para pessoas jurídicas (pjRepo2).
        PessoaJuridicaRepo pjRepo2 = new PessoaJuridicaRepo();

        // 11 - Recuperando os dados do arquivo salvo anteriormente para pjRepo2.
        pjRepo2.recuperar("pessoasJuridicasData");

        // 12 - Exibindo todas as pessoas jurídicas recuperadas do arquivo.
        System.out.println("Pessoas Jurídicas recuperadas do arquivo:");
        pjRepo2.ListarTodas();
    }
}
