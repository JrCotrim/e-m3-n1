package model;

import entidades.PessoaJuridica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {

    private List<PessoaJuridica> registroPessoasJuridicas;

    // Construtor
    public PessoaJuridicaRepo() {
        this.registroPessoasJuridicas = new ArrayList<>();
    }

    // Método para adicionar uma pessoa jurídica
    public void adicionar(PessoaJuridica pessoaJuridica) {
        registroPessoasJuridicas.add(pessoaJuridica);
    }

    // Método para atualizar os dados de uma pessoa jurídica
    public boolean atualizar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < registroPessoasJuridicas.size(); i++) {
            if (registroPessoasJuridicas.get(i).getId().equals(pessoaJuridica.getId())) {
                registroPessoasJuridicas.set(i, pessoaJuridica);
                return true;  // Retorna true para indicar que a atualização foi bem-sucedida
            }
        }
        return false;  // Retorna false se a pessoa jurídica não foi encontrada
    }

    // Método para remover uma pessoa jurídica pelo ID
    public boolean remover(int id) {
        return registroPessoasJuridicas.removeIf(pessoaJuridica -> pessoaJuridica.getId() == id);
    }

    // Método para buscar uma pessoa jurídica pelo ID
    public PessoaJuridica buscarPorId(int id) {
        return registroPessoasJuridicas.stream()
                .filter(pessoaJuridica -> pessoaJuridica.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para obter todas as pessoas jurídicas
    public List<PessoaJuridica> listarTodas() {
        return new ArrayList<>(registroPessoasJuridicas);
    }

    // Método para salvar os dados em um arquivo
    public void salvarDados(String nomeArquivo) {
        if (registroPessoasJuridicas.isEmpty()) {
            System.out.println("Nenhum dado disponível para salvar.");
            return;
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(registroPessoasJuridicas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os dados de um arquivo
    public void carregarDados(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            registroPessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para exibir todas as pessoas jurídicas
    public void exibirTodas() {
        for (PessoaJuridica pessoaJuridica : registroPessoasJuridicas) {
            System.out.println(pessoaJuridica.exibir());
        }
    }
}
