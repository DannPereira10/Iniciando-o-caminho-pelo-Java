package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo { 
    private ArrayList<PessoaJuridica> pessoas = new ArrayList<>();
    
    public void inserir(PessoaJuridica pessoa) {
        pessoas.add(pessoa);
    }
    
    public void alterar (PessoaJuridica pessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pessoa.getId()) {
                pessoas.set(i, pessoa);
                break;
            }
        }
    }
    
    public void excluir(int id){
        pessoas.removeIf(p -> p.getId() == id);
    }
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoas;
    }
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoas);
        }
    }
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoas = (ArrayList<PessoaJuridica>) inputStream.readObject();
        }
    }
}
