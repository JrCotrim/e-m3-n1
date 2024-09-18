package model;

import entidades.PessoaFisica;

import java.io.*;
import java.util.*;

public class PessoaFisicaRepo {

    private List<PessoaFisica> registroPessoasFisicas;

    // Construtor
    public PessoaFisicaRepo() {
        this.registroPessoasFisicas = new ArrayList<>();
    }

    // Método para adicionar uma nova pessoa física
    public void adicionar(PessoaFisica pessoaFisica) {
        registroPessoasFisicas.add(pessoaFisica);
    }

    // Método para atualizar os dados de uma pessoa física existente
    public boolean atualizar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < registroPessoasFisicas.size(); i++) {
            if (registroPessoasFisicas.get(i).getId().equals(pessoaFisica.getId())) {
                registroPessoasFisicas.set(i, pessoaFisica);
                return true;  // Retorna true para indicar que a atualização foi bem-sucedida
            }
        }
        return false;  // Retorna false se a pessoa física não foi encontrada
    }

    // Método para remover uma pessoa física pelo ID
    public boolean remover(int id) {
        return registroPessoasFisicas.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
    }

    // Método para buscar uma pessoa física pelo ID
    public PessoaFisica buscarPorId(int id) {
        return registroPessoasFisicas.stream()
                .filter(pessoaFisica -> pessoaFisica.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para obter todas as pessoas físicas registradas
    public List<PessoaFisica> listarTodas() {
        return registroPessoasFisicas;
    }

    // Método para salvar os dados em um arquivo
    public void salvarDados(String nomeArquivo) {
        if (registroPessoasFisicas.isEmpty()) {
            System.out.println("Nenhum dado disponível para salvar.");
            return;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(registroPessoasFisicas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os dados de um arquivo
    public void carregarDados(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            registroPessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para exibir todas as pessoas físicas
    public void exibirTodas() {
        for (PessoaFisica pessoaFisica : registroPessoasFisicas) {
            System.out.println(pessoaFisica.exibir());
        }
    }
}
