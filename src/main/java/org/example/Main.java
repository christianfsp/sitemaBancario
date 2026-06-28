package org.example;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<User> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
        System.out.println("::::::::TELA INICIAL::::::::");
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - LOGIN || 2 - CADASTRO || 3 - ENCERRAR O PROGRAMA");
        opcao = scanner.nextInt();
        scanner.nextLine();

            switch (opcao) {
                case 1:

                    if (usuarios.size() > 0) {

                        System.out.println("Digite seu nome: ");
                        String logNome = scanner.nextLine();
                        System.out.println("Digite seu senha: ");
                        String logSenha = scanner.nextLine();

                        for (int i = 0; i < usuarios.size(); i++) {
                            User usuario = usuarios.get(i);
                            if (logNome.equals(usuario.nome) && logSenha.equals(usuario.senha)) {
                                System.out.println("login efetuado com sucesso!");
                                int usuarioValidado = 1;
                            }
                        }
                    } else {
                        System.out.println("Nenhum usuário encontrado");
                        int usuarioValidado = 0;
                    }

                    break;
                case 2:
                    //CADASTRO DE USUÁRIO
                    System.out.println("#######CADASTRO DE USUÁRIO#######");
                    System.out.println("Digite o seu nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o seu saldo inicial:");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Crie uma senha: ");
                    String senha = scanner.nextLine();
                    User novoUsuario = new User(nome, senha, saldo);
                    System.out.println("Cadastro realizado com sucesso!");
                    System.out.println("Voltando ao menu principal...");
                    usuarios.add(novoUsuario);
                    break;
                default:
                    System.out.println("Encerrando o programa...");
                    break;
            }


        }
    }
}