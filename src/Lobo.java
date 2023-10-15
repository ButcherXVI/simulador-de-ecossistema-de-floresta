// Classe Lobo (Herda de Animal)
public class Lobo extends Animal {
    public Lobo(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está caçando e se alimentando.");
    }
}