// Classe Terreno
public class Terreno {
    private String tipo;

    public Terreno(String tipo) {
        this.tipo = tipo;
    }

    public void chover() {
        // Simulação de chuva no terreno
        System.out.println("Chuva caindo sobre o terreno " + tipo);
    }
}