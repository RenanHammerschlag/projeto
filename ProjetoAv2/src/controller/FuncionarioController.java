package controller;

import projeto.*;
import View.FuncionarioView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final FuncionarioView view = new FuncionarioView();
    private static final String ARQUIVO = "funcionarios.txt";

    public void iniciar() {
        carregarFuncionarios();

        while (true) {
            view.exibirMenu();
            int opcao = view.capturarOpcao();

            switch (opcao) {
                case 1 -> cadastrarFuncionario();
                case 2 -> view.mostrarFuncionarios(funcionarios);
                case 3 -> atualizarFuncionario();
                case 4 -> excluirFuncionario();
                case 5 -> {
                    salvarFuncionarios();
                    System.out.println("Sistema encerrado.");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void carregarFuncionarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String tipo = dados[1];
                String nome = dados[2];
                double salario = Double.parseDouble(dados[3]);

                Funcionario f = switch (tipo) {
                    case "Desenvolvedor" -> new Desenvolvedor(id, nome, salario);
                    case "Gerente" -> new Gerente(id, nome, salario);
                    case "Treinador" -> new Treinador(id, nome, salario);
                    case "GerenteDesenvolvedor" -> new GerenteDesenvolvedor(id, nome, salario);
                    default -> null;
                };

                if (f != null) funcionarios.add(f);
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo...");
        }
    }

    private void salvarFuncionarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Funcionario f : funcionarios) {
                bw.write(f.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados!");
        }
    }

    private void cadastrarFuncionario() {
        String nome = view.capturarTexto("Nome do funcionário: ");
        double salario = view.capturarSalario("Salário do funcionário: ");
        int id = funcionarios.size() + 1;

        System.out.println("Tipos: 1-Desenvolvedor, 2-Gerente, 3-Treinador, 4-GerenteDesenvolvedor");
        int tipo = Integer.parseInt(view.capturarTexto("Escolha o tipo: "));

        Funcionario novoFuncionario = switch (tipo) {
            case 1 -> new Desenvolvedor(id, nome, salario);
            case 2 -> new Gerente(id, nome, salario);
            case 3 -> new Treinador(id, nome, salario);
            case 4 -> new GerenteDesenvolvedor(id, nome, salario);
            default -> null;
        };

        if (novoFuncionario != null) {
            funcionarios.add(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private void atualizarFuncionario() {
        int id = Integer.parseInt(view.capturarTexto("ID do funcionário a atualizar: "));
        Funcionario f = buscarFuncionario(id);

        if (f != null) {
            f.setNome(view.capturarTexto("Novo nome: "));
            f.setSalario(view.capturarSalario("Novo salário: "));
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    private void excluirFuncionario() {
        int id = Integer.parseInt(view.capturarTexto("ID do funcionário a excluir: "));
        Funcionario f = buscarFuncionario(id);

        if (f != null) {
            funcionarios.remove(f);
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    private Funcionario buscarFuncionario(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) return f;
        }
        return null;
    }
}