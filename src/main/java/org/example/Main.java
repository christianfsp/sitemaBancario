package org.example;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<User> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean usuarioValidado = false;
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
                                usuarioValidado = true;
                                while (usuarioValidado == true) {

                                    int opcaoLogin = 0;
                                    System.out.println("======TELA DE OPERAÇÕES======");
                                    System.out.println("BEM VINDO "+usuario.nome+"!");
                                    System.out.println("ESCOLHA ENTRE AS OPERAÇÕES A SEGUIR:");
                                    System.out.println("1 - CONSULTAR SALDO \n 2 - DEPÓSITO \n 3 - SAQUE \n 4 - SAIR");
                                    System.out.println(opcaoLogin);

                                    opcaoLogin = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcaoLogin) {
                                        case 1:
                                            usuario.mostrarSaldo();
                                            System.out.println("Voltando para o Menu de Usuário...");

                                            break;
                                        case 2:

                                            try {
                                            System.out.println("Digite o valor que deseja depositar:");
                                            double valorDeposito = scanner.nextDouble();
                                                scanner.nextLine();
                                                usuario.saldo += valorDeposito;
                                                System.out.println("Saldo atualizado com sucesso!");
                                            } catch (Exception e) {
                                                System.out.println("entrada inválida");
                                                System.out.println("retornando ao menu do usuario...");
                                                scanner.nextLine();
                                            }

                                            break;
                                        case 3:
                                            if(usuario.saldo>0){
                                                System.out.println("Digite o valor que deseja sacar: ");
                                                double valorSacar = scanner.nextDouble();
                                                scanner.nextLine();
                                                if(valorSacar<=usuario.saldo){
                                                    usuario.saldo -= valorSacar;
                                                    System.out.println("Saldo atualizado com sucesso!");

                                                }else{
                                                    System.out.println("Saldo insuficiente para sacar!");
                                                    System.out.println("Retornando para o menu de usuário...");
                                                }

                                            }
                                            break;
                                        case 4:
                                                usuarioValidado = false;
                                            System.out.println("voltando para o menu principal...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida. \n Retornando para o menu de usuário...");



                                    }


                                }


                            }else{
                                System.out.println("Nome de usuário ou senha incorretos");
                                System.out.println("Retornando ao Menu principal...");
                            }
                        }
                    } else {
                        System.out.println("Nenhum usuário encontrado");

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