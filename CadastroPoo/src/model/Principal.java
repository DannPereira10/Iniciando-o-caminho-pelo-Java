package model;

import java.util.Scanner;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        
        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 = Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - recuperar Dados");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma Opcão:");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            try {
                switch (opcao){
                    case 1:
                        incluir(scanner, repoFisica, repoJuridica);
                        break;
                    case 2:
                        alterar(scanner, repoFisica, repoJuridica);
                        break;
                    case 3:
                        excluir(scanner, repoFisica, repoJuridica);
                        break;
                    case 4:
                        exibirPorId(scanner, repoFisica, repoJuridica);
                        break;
                    case 5:
                        exibirTodos(scanner, repoFisica, repoJuridica);
                        break;
                    case 6:
                        salvarDados(scanner, repoFisica, repoJuridica);
                        break;
                    case 7:
                        recuperarDados(scanner, repoFisica, repoJuridica);
                        break;
                    case 0:
                        System.out.println("Finalizando Sistema...");
                        break;
                    default:
                        System.out.println("Opção Invalida. Por favor tente novamente");                    
                }        
            } catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
            
        } while (opcao != 0);
        scanner.close();
    }
    private static void incluir (Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - fisica - 2 Juridica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        if (tipo == 1) {
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Idade: ");
            int idade = scanner.nextInt();
            repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
        } else if (tipo == 2){
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("CNPJ: ");
            String cnpj = scanner.nextLine();
            repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));            
        } else {
            System.out.println("Tipo Invalido!");
        }
    }
    public static void alterar (Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.println("Escolha o tipo (1 - fisica - 2 Juridica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
            
        if (tipo == 1) {
            PessoaFisica pessoa = repoFisica.obter(id);
            if (pessoa != null){
                System.out.println("Dados Atuais:");
                pessoa.exibir();
                System.out.println("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.println("CPF: ");
                String cpf = scanner.nextLine();
                System.out.println("Nova Idade: ");
                int idade = scanner.nextInt();
                pessoa.setNome(nome);
                pessoa.setCpf(cpf);
                pessoa.setIdade(idade);
                repoFisica.alterar(pessoa);
                System.out.println("Pessoa Física alterada com sucesso!");
            } else {
                System.out.println("Pessoa Física Não encontrada!");        
            }    
        } else if (tipo == 2){
            PessoaJuridica pessoa = repoJuridica.obter(id);
            if (pessoa != null){
                System.out.println("Dados Atuais:");
                pessoa.exibir();
                System.out.println("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Novo CNPJ: ");
                String cnpj = scanner.nextLine();
                pessoa.setNome(nome);
                pessoa.setCnpj(cnpj);
                repoJuridica.alterar(pessoa);
                System.out.println("Pessoa Jurídica alterada com sucesso!");
            } else {
                System.out.println("Pessoa Jurídica Não encontrada!");        
            }                
        }else {
            System.out.println("Tipo Inválido!");
           
        }        
    }
    
    private static void excluir(Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica){
        System.out.println("Escolha o tipo (1 - fisica - 2 Juridica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("ID: ");
        int id = scanner.nextInt();
        
        if (tipo == 1){
            repoFisica.excluir(id);
            System.out.println("Pessoa Física excluída com sucesso!");
        }else if (tipo == 2){
            repoJuridica.excluir(id);
            System.out.println("Pessoa Juridica excluída com sucesso!");
        }else {
            System.out.println("Tipo Inválido!");
        }
    }
    
    private static void exibirPorId(Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica){
        System.out.println("Escolha o tipo (1 - fisica - 2 Juridica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("ID: ");
        int id = scanner.nextInt();
        
        if (tipo == 1){
            PessoaFisica pessoa = repoFisica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            }else {
                System.out.println("Pessoa Física não encontrada!");
            }
        }else if (tipo == 2){
            PessoaJuridica pessoa = repoJuridica.obter(id);
            if (pessoa != null){
                pessoa.exibir();
            }else {
                System.out.println("Pessoa Jurídoca não encontrada!");
            }
        }else {
            System.out.println("Tipo Inválido!");
        }
    }
    
    public static void exibirTodos(Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica){
        System.out.println("Escolha o tipo (1 - fisica - 2 Juridica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        if (tipo == 1){
            for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                pessoa.exibir();
                System.out.println("--------------------------");
            }
        }else if (tipo == 2) {
            for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                pessoa.exibir();
                System.out.println("--------------------------");
            }
        }else {
            System.out.println("Tipo Inválido!");
        }        
    }
    public static void salvarDados(Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) throws IOException {
        System.out.println("Informe o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();
        
        repoFisica.Persistir(prefixo + ".fisica.bin");
        repoJuridica.persistir(prefixo + ".juridica.bin");
        System.out.println("Dados Salvos com sucesso!");
    }
    
    private static void recuperarDados (Scanner scanner,PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) throws IOException, ClassNotFoundException {
        System.out.println("informe o prefixo dos arquivos ");
        String prefixo = scanner.nextLine();
        
        repoFisica.recuperar(prefixo + ".fisica.bin");
        repoJuridica.recuperar(prefixo + ".juridica.bin");
        System.out.println("Dados recuperados com Sucesso!");
    }
}
