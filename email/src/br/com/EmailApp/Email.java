package br.com.EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String depart;
    private String email;
    private int capacity = 500;
    private int defaultPasswordLenght = 10;
    private String alternative;
    private String company = "excompany.com";

    // Construtor para nome e sobrenome
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    
    // Chamar e retornar metodo pedindo departamento
    this.depart = setDepart();
    
    // Chamar metodo para retornar senha aleatoria
    this.password = randomPassword(8);
    System.out.println("Sua senha é: " + this.password);
    
    // Gerar email
    email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + depart + "." + company;
    }

    // Pedir o departamento
        private String setDepart(){
            System.out.print("Funcionário novo: " + firstName + "\nCÓDIGO DE DEPARTAMENTOS\n1 para Vendas\n2 para Desenvolvimento\n3 para Contabilidade\n0 para Nenhum\n Digite o código do seu departamento: ");
            Scanner scanner = new Scanner(System.in);
            int dep = scanner.nextInt();
            if(dep == 1){
                return "vendas";
            } else if(dep == 2){
                return "dev";
            } else if(dep == 3){
                return "contabilidade";
            } else {
                return "";
            }
        }

    // Gerar senha aleatoria
    private String randomPassword(int lenght){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[lenght];
        for(int i = 0; i < lenght; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Definir capacidade da caixa de entrada do email
    public void setCapacity(int auxCapacity){
        this.capacity = auxCapacity;
    }

    // Definir email alternativo
    public void setAlternative(String altEmail){
        this.alternative = altEmail;
    }

    // Mudar a senha
    public void changePassword(String password){
        this.password = password;
    }

    public int getCapacity(){
        return capacity;
    }
    public String getAlternative(){
        return alternative;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Nome: " + firstName + " " + lastName +
        "\nEmail Corporativo: " + email +
        "\nCapacidade da Caixa de Entrada: " + capacity + "mb";
    }
}
