import java.util.Random;

public class EcossistemaFloresta {
    private Terreno[][] grade;
    private int numLobos;
    private int numCoelhos;
    private int numPlantas;

    public EcossistemaFloresta(int numRows, int numCols, int numLobos, int numCoelhos, int numPlantas) {
        grade = new Terreno[numRows][numCols];
        this.numLobos = numLobos;
        this.numCoelhos = numCoelhos;
        this.numPlantas = numPlantas;
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

        // Adicione plantas aleatoriamente ao grid
        Random random = new Random();
        for (int i = 0; i < numPlantas; i++) {
            int x = random.nextInt(grade[0].length);
            int y = random.nextInt(grade.length);
            if (grade[y][x].getTipo().equals("Vazio")) {
                Planta planta = new Planta();
                planta.gerarPlanta(grade, x, y);
            }
        }

        // Adicione lobos e coelhos aleatoriamente ao grid
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
                } else if (grade[row][col].getTipo().equals("Planta")) {
                    System.out.print("P ");
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
            for (int row = 0; row < grade.length; row++) {
                for (int col = 0; col < grade[0].length; col++) {
                    if (grade[row][col].getElemento() != null) {
                        Animal animal = grade[row][col].getElemento();
                        animal.moverAleatoriamente(grade);
                        if (animal instanceof Coelho) {
                            Coelho coelho = (Coelho) animal;
                            coelho.comer(grade);
                            Coelho filhote = coelho.reproduzir(grade);
                            if (filhote != null) {
                                int newX = coelho.getX();
                                int newY = coelho.getY();
                                if (newX >= 0 && newX < grade[0].length && newY >= 0 && newY < grade.length) {
                                    grade[newY][newX].setElemento(filhote);
                                }
                            }
                            coelho.morrer();
                        } else if (grade[row][col] instanceof Planta) {
                            Planta planta = (Planta) grade[row][col];
                            planta.atualizarEcossistema(grade);
                        }
                    }
                }
            }
            exibirGrid();
        }
    }
    

    public static void main(String[] args) {
        // Tamanho do grid, número inicial de lobos, coelhos e plantas
        int numRows = 10;
        int numCols = 10;
        int numLobos = 5;
        int numCoelhos = 10;
        int numPlantas = 20;

        EcossistemaFloresta ecossistema = new EcossistemaFloresta(numRows, numCols, numLobos, numCoelhos, numPlantas);
    }
}
