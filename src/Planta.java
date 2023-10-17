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
        // Verifica se a planta pode aparecer e atualiza o tempo para aparecer
        if (!podeAparecer) {
            tempoParaAparecer++;
            if (tempoParaAparecer >= 12) {
                podeAparecer = true;
                tempoParaAparecer = 0;
            }
        }

        // Gera um número aleatório entre 0 e 100
        Random random = new Random();
        int chance = random.nextInt(101);

        // Se a chance é menor ou igual a 50, cria uma planta aleatoriamente no grid
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
        // Método vazio, pois a planta foi consumida por completo
    }
}
