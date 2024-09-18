package model;

import entidades.PessoaFisica;

import java.io.*;
import java.util.*;

public class PessoaFisicaRepo {

    private List<PessoaFisica> listaPessoasFisicas;

    public PessoaFisicaRepo() {

        this.listaPessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {

        listaPessoasFisicas.add(pessoaFisica);
    }

    public boolean alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            if (listaPessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                listaPessoasFisicas.set(i, pessoaFisica);
                return true; 
            }
        }

        return false;
    }

    public boolean excluir(int id) {
        for (PessoaFisica p:listaPessoasFisicas) {
            if(p.getId()==id){
                listaPessoasFisicas.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public PessoaFisica obter(int id) {
        return listaPessoasFisicas.stream()
                .filter(pessoaFisica -> pessoaFisica.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<PessoaFisica> obterTodos() {
        return listaPessoasFisicas ;
    }
    public void persistir(String nomeArquivo) {

        if(listaPessoasFisicas.isEmpty()){
            System.out.println("Não existem registros a serem persistidos");
            return;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(listaPessoasFisicas);
        } catch (IOException e) {
            e.printStackTrace();
         }
    }


    public void recuperar(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ListarTodas(){
        for (PessoaFisica pf: listaPessoasFisicas) {
            System.out.println(pf.exibir());
        }

    }


}
