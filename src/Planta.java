import java.util.Random;

public class Planta extends Terreno {
    private boolean podeAparecer;
    private int tempoParaAparecer;

    public Planta() {
        super("Planta");
        this.podeAparecer = true;
        this.tempoParaAparecer = 0;
    }

    public void atualizarEcossistema() {
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

        // Se a planta pode aparecer e a chance é menor ou igual a 20, ela aparece
        if (podeAparecer && chance <= 20) {
            // Coloque a planta no grid
            podeAparecer = false; // Define que a planta não pode aparecer até ser consumida
        }
    }

    public void consumirPlanta() {
        // Método vazio, pois a planta foi consumida por completo
    }
}
