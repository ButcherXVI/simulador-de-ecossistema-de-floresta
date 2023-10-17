import java.util.Random;

public class Coelho extends Animal {
    public Coelho(String nome, int idade) {
        super(nome, idade, 40, gerarSexoAleatorio());
    }

    // Método para gerar sexo aleatório
    private static String gerarSexoAleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2); // Gera 0 ou 1 aleatoriamente

        if (numeroAleatorio == 0) {
            return "masculino";
        } else {
            return "feminino";
        }
    }

    @Override
    public void moverAleatoriamente(Terreno[][] grade) {
        int idadeAtual = getIdade();
        int vidaAtual = getVida();

        idadeAtual++;
        vidaAtual--;

        if (vidaAtual <= 0 || idadeAtual >= 30) {
            grade[getY()][getX()] = null;
            return;
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
            grade[getY()][getX()] = null;
            grade[newY][newX] = this;
            setX(newX);
            setY(newY);
        }
    }

    public void comer(Terreno[][] grade) {
        int x = getX();
        int y = getY();

        if (x < grade[0].length - 1 && grade[y][x + 1] instanceof TerrenoComida) {
            grade[y][x + 1] = null;
            setVida(getVida() + 10);
        }
    }

    public Coelho reproduzir(Coelho parceiro) {
        if (this.getSexo().equals("feminino") && parceiro.getSexo().equals("masculino")) {
            if (this.getIdade() >= 2 && parceiro.getIdade() >= 2) {
                setVida(getVida() - 10);
                parceiro.setVida(parceiro.getVida() - 10);
                return new Coelho("Filhote", 0);
            }
        }
        return null;
    }

    public void morrer() {
        setVida(0); // Define a vida do Coelho como zero para indicar que ele está morto
    }
}
