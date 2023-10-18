public class Terreno {
    private String tipo;
    private Animal elemento;

    public Terreno(String tipo) {
        this.tipo = tipo;
        this.elemento = null;
    }

    public String getTipo() {
        return tipo;
    }

    public Animal getElemento() {
        return elemento;
    }

    public void setElemento(Animal animal) {
        this.elemento = animal;
    }
}
