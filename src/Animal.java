public class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void mover() {
        // Comportamento padrão de movimento para animais
        System.out.println(nome + " está se movendo.");
    }

    public void comer() {
        // Comportamento padrão de comer para animais
        System.out.println(nome + " está comendo.");
    }
}