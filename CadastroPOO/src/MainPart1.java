import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;

public class MainPart1 {
    public static void main(String[] args) {


        PessoaFisicaRepo repo1= new PessoaFisicaRepo();

        repo1.inserir(new PessoaFisica("Matheus",25,"1222611")) ;
        repo1.inserir(new PessoaFisica("Marcia",22,"1223211")) ;
        repo1.inserir(new PessoaFisica("Carlos",19,"122222")) ;

        System.out.println("");
        System.out.println("");

        repo1.persistir("listaPessoafisica");

        System.out.println("Dados Pessoa Fisica Aramzenados");

        PessoaFisicaRepo repo2= new PessoaFisicaRepo();

        repo2.recuperar("listaPessoafisica");

        System.out.println("Listar Pessoas Fisicas Recuperadas");
        repo2.ListarTodas();

        PessoaJuridicaRepo repo3= new PessoaJuridicaRepo();

        repo3.inserir(new PessoaJuridica("BB1","1222611")) ;
        repo3.inserir(new PessoaJuridica("M.LUIZA","1223211")) ;
        repo3.inserir(new PessoaJuridica("LOJAS S/A","122222")) ;

        System.out.println("Dados Pessoa Juridicas Aramzenados");
        repo3.persistir("listaPessoaJuridica");

        PessoaJuridicaRepo repo4= new PessoaJuridicaRepo();

        repo4.recuperar("listaPessoaJuridica");

        System.out.println("Dados Pessoa Juridicas Recuperados");
        repo4.ListarTodas();


    }
}