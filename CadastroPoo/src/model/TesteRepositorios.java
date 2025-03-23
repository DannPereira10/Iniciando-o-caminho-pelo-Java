package model;

import java.io.IOException;

public class TesteRepositorios {
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(3421,"Daniel Souza Pereira", "222.333.111-10", 27));
            repo1.inserir(new PessoaFisica(4511, "Karen Sateles", "111.111.444.555-10", 27));
            
            String arquivoPessoasFisicas = "pessoas_fisicas.dat";
            repo1.Persistir(arquivoPessoasFisicas);
            
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar(arquivoPessoasFisicas);
            
            System.out.println("Pessoas Físicas Recuperadas!");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
                System.out.println("----------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular o repositória de Pessoas Físicas: " + e.getMessage());
        }
        
        try {
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1997,"Dann Tech", "10.123.456/0001-00"));
            repo3.inserir(new PessoaJuridica(2025, "Karen Nutri", "20.321.456/0001-00"));
            
            String arquivoPessoasJuridicas = "pessoas_juridicas.dat";
            repo3.persistir(arquivoPessoasJuridicas);
            
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar(arquivoPessoasJuridicas);
            
            System.out.println("\nPessoas Jurídicas Recuperadas!");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
                System.out.println("----------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular o repositória de Pessoas Jurídicas: " + e.getMessage());    
        }        
    }
}
