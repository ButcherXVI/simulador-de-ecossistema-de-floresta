public class EcossistemaFloresta {
    public static void main(String[] args) {
        Lobo lobo = new Lobo("Lobo", 5);
        Coelho coelho = new Coelho("Coelho", 2);
        Planta planta = new Planta("Carvalho");
        Terreno floresta = new Terreno("Floresta");

        lobo.mover();
        lobo.comer();
        coelho.mover();
        coelho.comer();
        planta.crescer();
        floresta.chover();
    }
}