package View;

import projeto.Funcionario;

import java.util.List;
import java.util.Scanner;

public class FuncionarioView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento de Funcionários ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Funcionário");
        System.out.println("4. Excluir Funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void mostrarFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("\n--- Lista de Funcionários ---");
            for (Funcionario f : funcionarios) {
                f.mostrarDetalhes();
            }
        }
    }

    public int capturarOpcao() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String capturarTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public double capturarSalario(String mensagem) {
        System.out.print(mensagem);
        return Double.parseDouble(scanner.nextLine());
    }
}