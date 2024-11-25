package projeto;

public class Gerente extends Funcionario implements Gerencia {
    public Gerente(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Gerente [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]");
    }
}