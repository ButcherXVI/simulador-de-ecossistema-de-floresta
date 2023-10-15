// Classe Coelho (Herda de Animal)
public class Coelho extends Animal {
    public Coelho(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está saltando.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está pastando.");
    }
}