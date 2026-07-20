package org.example;

public class User {
    String nome;
    String senha;
    double saldo;
    User(String nome,String senha, double saldo) {
        this.saldo = saldo;
        this.nome = nome;
        this.senha = senha;

    }




    public void mostrarSaldo(){
        System.out.println("Seu saldo é: "+saldo);
    }
    public void mostrarNome(){
        System.out.println("Seu nome é: "+nome);
    }
    public void mostrarDados(){
        System.out.println("Seu nome é: " + nome);
        System.out.println("Seu saldo é: " + saldo);
    }
}
