package projeto;

public class Desenvolvedor extends Funcionario implements Desenvolve {
    public Desenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(getNome() + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Desenvolvedor [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]");
    }
}