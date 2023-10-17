import java.util.Random;

public class Animal {
    private String nome;
    private int idade;
    private int vida;
    private int vidaMaxima;
    private int x;
    private int y;
    private String sexo;
    private Terreno terrenoAtual;

    public Animal(String nome, int idade, int vidaMaxima, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.vida = vidaMaxima;
        this.vidaMaxima = vidaMaxima;
        this.sexo = sexo;
    }

    public void moverAleatoriamente(Terreno[][] grade) {
        idade++;
        vida--;

        if (vida <= 0 || idade >= 30) {
            terrenoAtual.setElemento(null);
        }

        Random random = new Random();
        int direction = random.nextInt(4);

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

        Terreno novoTerreno = grade[newY][newX];
        if (novoTerreno.getElemento() == null) {
            terrenoAtual.setElemento(null);
            terrenoAtual = novoTerreno;
            terrenoAtual.setElemento(this);
            x = newX;
            y = newY;
        }
    }

    // Resto do código...

    public void setTerrenoAtual(Terreno terreno) {
        this.terrenoAtual = terreno;
    }
    
    public Terreno getTerrenoAtual() {
        return terrenoAtual;
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

    protected void setVida(int novaVida) {
        vida = novaVida;
    }
}
