package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoas = new ArrayList<>();
    
    public void inserir (PessoaFisica pessoa){
        pessoas.add(pessoa);
    }
    
    public void alterar (PessoaFisica pessoa){
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pessoa.getId()){
                pessoas.set(i, pessoa);
                break;
            }
        }
    }
    
    public void excluir(int id){
        pessoas.removeIf(p -> p.getId() == id);
    }
    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoas){
            if (pessoa.getId() == id){
                return pessoa;
            }
        }
        return null;
    }
    public ArrayList<PessoaFisica> obterTodos(){
        return pessoas;
    }
    public void Persistir (String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoas);
        }
    }
    public void recuperar (String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoas = (ArrayList<PessoaFisica>) inputStream.readObject();
        }
    }
}
