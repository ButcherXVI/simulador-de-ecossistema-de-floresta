import java.util.Random;

public class Lobo extends Animal {
    public Lobo(String nome, int idade, String sexo) {
        super(nome, idade, 30, sexo);
    }

    @Override
    public void moverAleatoriamente(Terreno[][] grade) {
        int idadeAtual = getIdade(); // Obtém a idade atual
        int vidaAtual = getVida();   // Obtém a vida atual

        idadeAtual++;
        vidaAtual--;

        // Verifica se a vida chegou a 0 ou a idade ultrapassou 30
        if (vidaAtual <= 0 || idadeAtual >= 30) {
            getTerrenoAtual().setElemento(null);
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

        Terreno novoTerreno = grade[newY][newX];
        if (novoTerreno.getElemento() == null) {
            getTerrenoAtual().setElemento(null);
            novoTerreno.setElemento(this);
            setX(newX);
            setY(newY);
            setTerrenoAtual(novoTerreno);
        } else if (novoTerreno.getElemento() instanceof Coelho) {
            Coelho coelho = (Coelho) novoTerreno.getElemento();
            consumirCoelho(coelho);
        }
    }

    // Função para consumir um Coelho e ganhar 20 de vida
    private void consumirCoelho(Coelho coelho) {
        coelho.morrer();
        setVida(getVida() + 20);
    }

    // Função para reproduzir com outro Lobo de sexo oposto
    public Lobo reproduzir(Lobo parceiro) {
        if (this.getSexo().equals("masculino") && parceiro.getSexo().equals("feminino")) {
            // Somente Lobos de sexos opostos podem se reproduzir
            if (this.getIdade() >= 2 && parceiro.getIdade() >= 2) {
                setVida(getVida() - 10);
                parceiro.setVida(parceiro.getVida() - 10);
                return new Lobo("Filhote", 0, "aleatório");
            }
        }
        return null; // Não houve reprodução
    }
}
