package matematica;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numerador da primeira fração:");
        int numerador1 = scanner.nextInt();

        System.out.println("Digite o denominador da primeira fração:");
        int denominador1 = scanner.nextInt();

        Fracao f1 = new Fracao(numerador1, denominador1);

        System.out.println("Digite o numerador da segunda fração:");
        int numerador2 = scanner.nextInt();

        System.out.println("Digite o denominador da segunda fração:");
        int denominador2 = scanner.nextInt();

        Fracao f2 = new Fracao(numerador2, denominador2);

        System.out.println("Escolha a operação matemática que deseja realizar:");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");

        int operacao = scanner.nextInt();

        Fracao resultado = null;

        switch (operacao) {
            case 1:
                resultado = f1.somar(f2);
                break;
            case 2:
                resultado = f1.subtrair(f2);
                break;
            case 3:
                resultado = f1.multiplicar(f2);
                break;
            case 4:
                resultado = f1.dividir(f2);
                break;
            default:
                System.out.println("Operação inválida.");
        }
        scanner.close();

    }
}

