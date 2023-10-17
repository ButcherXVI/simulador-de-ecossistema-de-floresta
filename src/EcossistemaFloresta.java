import java.util.Random;

public class EcossistemaFloresta {
    private Terreno[][] grade;
    private int numLobos;
    private int numCoelhos;

    public EcossistemaFloresta(int numRows, int numCols, int numLobos, int numCoelhos) {
        grade = new Terreno[numRows][numCols];
        this.numLobos = numLobos;
        this.numCoelhos = numCoelhos;
        inicializarGrid();
        exibirGrid();
        simularEcossistema(10); // Simula o ecossistema por 10 passos de tempo
    }

    private void inicializarGrid() {
        // Inicialize o grid com terrenos vazios (ou outros terrenos, se necessário)
        for (int row = 0; row < grade.length; row++) {
            for (int col = 0; col < grade[0].length; col++) {
                grade[row][col] = new Terreno("Vazio");
            }
        }

        // Adicione lobos e coelhos aleatoriamente ao grid
        Random random = new Random();
        for (int i = 0; i < numLobos; i++) {
            int x = random.nextInt(grade[0].length);
            int y = random.nextInt(grade.length);
            grade[y][x] = new Terreno("Lobo");
        grade[y][x].setElemento(new Lobo("Lobo", 0, "aleatório"));
        }
        for (int i = 0; i < numCoelhos; i++) {
            int x = random.nextInt(grade[0].length);
            int y = random.nextInt(grade.length);
            grade[y][x] = new Terreno("Coelho");
            grade[y][x].setElemento(new Coelho("Coelho", 0));
        }
    }

    private void exibirGrid() {
        for (int row = 0; row < grade.length; row++) {
            for (int col = 0; col < grade[0].length; col++) {
                if (grade[row][col].getElemento() instanceof Lobo) {
                    System.out.print("L ");
                } else if (grade[row][col].getElemento() instanceof Coelho) {
                    System.out.print("C ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Método para gerar sexo aleatório para coelhos
    private static String gerarSexoAleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2); // Gera 0 ou 1 aleatoriamente

        if (numeroAleatorio == 0) {
            return "masculino";
        } else {
            return "feminino";
        }
    }

    public void simularEcossistema(int numPassos) {
        for (int passo = 1; passo <= numPassos; passo++) {
            System.out.println("Passo " + passo + ":");
            // Adicione a lógica da simulação aqui
            // Por exemplo, movimento e interações entre animais e terrenos
            // Atualize o grid e exiba o estado do ecossistema
            exibirGrid();
        }
    }

    public static void main(String[] args) {
        // Tamanho do grid, número inicial de lobos e coelhos
        int numRows = 10;
        int numCols = 10;
        int numLobos = 5;
        int numCoelhos = 10;

        EcossistemaFloresta ecossistema = new EcossistemaFloresta(numRows, numCols, numLobos, numCoelhos);
    }
}
