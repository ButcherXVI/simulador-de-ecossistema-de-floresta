import java.util.Random;

public class Planta extends Terreno {
    private boolean podeAparecer;
    private int tempoParaAparecer;

    public Planta() {
        super("Planta");
        this.podeAparecer = true;
        this.tempoParaAparecer = 0;
    }

    public void gerarPlanta(Terreno[][] grade, int x, int y) {
        grade[y][x] = new Terreno("Planta");
    }

    public void atualizarEcossistema(Terreno[][] grade) {
        if (!podeAparecer) {
            tempoParaAparecer++;
            if (tempoParaAparecer >= 12) {
                podeAparecer = true;
                tempoParaAparecer = 0;
            }
        }

        Random random = new Random();
        int chance = random.nextInt(101);
        if (chance <= 50) {
            Random randomPosition = new Random();
            int x = randomPosition.nextInt(grade[0].length);
            int y = randomPosition.nextInt(grade.length);

            if (grade[y][x].getTipo().equals("Vazio")) {
                gerarPlanta(grade, x, y);
            }
        }
    }

    public void consumirPlanta() {
    }
}
