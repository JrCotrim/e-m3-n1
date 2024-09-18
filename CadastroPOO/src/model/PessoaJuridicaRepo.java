package model;

import entidades.PessoaJuridica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {

    private List<PessoaJuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {

        this.listaPessoasJuridicas = new ArrayList<PessoaJuridica>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
         listaPessoasJuridicas.add(pessoaJuridica);
    }

    public boolean alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            if (listaPessoasJuridicas.get(i).getId() == pessoaJuridica.getId()) {
                listaPessoasJuridicas.set(i, pessoaJuridica);
                return true;
            }
        }

        return false;
    }

    public boolean excluir(int id) {
        for (PessoaJuridica p: listaPessoasJuridicas) {
            if(p.getId()==id){
                listaPessoasJuridicas.remove(p);
                return true;
            }
        }
        return false; 
    }

    public PessoaJuridica obter(int id) {
        return listaPessoasJuridicas.stream()
                .filter(pessoaJuridica -> pessoaJuridica.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<PessoaJuridica> obterTodos_1() {
        return new ArrayList<>(listaPessoasJuridicas);
    }

    public List<PessoaJuridica> obterTodos() {
        return listaPessoasJuridicas;
    }
    public void persistir(String nomeArquivo) {
        if(listaPessoasJuridicas.isEmpty()){
            System.out.println("Não existem registros a serem persistidos");
            return;
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(listaPessoasJuridicas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void recuperar(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ListarTodas(){
        for (PessoaJuridica pf: listaPessoasJuridicas) {
            System.out.println(pf.exibir());
        }
    }
}
