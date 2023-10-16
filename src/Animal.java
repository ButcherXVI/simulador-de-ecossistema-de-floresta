import java.util.Random;

public class Animal {
    private String nome;
    private int idade;
    private int vida;
    private int vidaMaxima; // Vida máxima do animal
    private int x; // Posição X na matriz
    private int y; // Posição Y na matriz

    public Animal(String nome, int idade, int vidaMaxima) {
        this.nome = nome;
        this.idade = idade;
        this.vida = vidaMaxima; // Inicializa a vida com o valor máximo
        this.vidaMaxima = vidaMaxima;
    }

    public void moverAleatoriamente(Terreno[][] grade) {
        idade++; // Aumenta a idade do animal a cada movimento
        vida--;  // Diminui 1 ponto de vida a cada movimento

        if (vida <= 0 || idade >= 30) {
            // Remove o animal da matriz se a vida chegar a 0 ou a idade atingir 30
            grade[y][x] = null;
        }

        Random random = new Random();
        int direction = random.nextInt(4); // 0: Norte, 1: Sul, 2: Leste, 3: Oeste

        int newX = x;
        int newY = y;

        if (direction == 0 && newY > 0) {
            newY--;
        } else if (direction == 1 && newY < grade.length - 1) {
            newY++;
        } else if (direction == 2 && newX < grade[0].length - 1) {
            newX++;
        } else if (direction == 3 && newX > 0) {
            newX--;
        }

        if (grade[newY][newX] == null) {
            // Move o animal para a nova posição
            grade[y][x] = null;
            grade[newY][newX] = this;
            x = newX;
            y = newY;
        }
    }

    // Getters e Setters para x, y, idade, vida e vidaMaxima
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIdade() {
        return idade;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
