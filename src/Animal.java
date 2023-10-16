import java.util.Random;

public class Animal {
    private String nome;
    private int idade;
    private int vida;
    private int vidaMaxima; // Vida máxima do animal
    private int x; // Posição X na matriz
    private int y; // Posição Y na matriz
    private String sexo; // Atributo para o sexo (masculino ou feminino)

    public Animal(String nome, int idade, int vidaMaxima) {
        this.nome = nome;
        this.idade = idade;
        this.vida = vidaMaxima; // Inicializa a vida com o valor máximo
        this.vidaMaxima = vidaMaxima;

        // Gere aleatoriamente o sexo
        Random random = new Random();
        int sexoAleatorio = random.nextInt(2); // 0 ou 1
        if (sexoAleatorio == 0) {
            this.sexo = "masculino";
        } else {
            this.sexo = "feminino";
        }
    }

    public void moverAleatoriamente(Terreno[][] grade) {
        idade++;
        vida--;

        if (vida <= 0 || idade >= 30) {
            grade[getY()][getX()] = null;
        }

        Random random = new Random();
        int direction = random.nextInt(4);

        int newX = getX();
        int newY = getY();

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
            grade[y][x] = null;
            grade[newY][newX] = this;
            x = newX;
            y = newY;
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

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
