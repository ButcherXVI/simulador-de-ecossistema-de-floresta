// Classe Planta
public class Planta {
    private String nome;

    public Planta(String nome) {
        this.nome = nome;
    }

    public void crescer() {
        // Comportamento padrão de crescimento para plantas
        System.out.println(nome + " está crescendo.");
    }
}