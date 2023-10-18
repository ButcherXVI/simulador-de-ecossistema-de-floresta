import java.util.Random;

public class Lobo extends Animal {
    public Lobo(String nome, int idade, String sexo) {
        super(nome, idade, 30, sexo);
    }

    @Override
    public void moverAleatoriamente(Terreno[][] grade) {
        int idadeAtual = getIdade();
        int vidaAtual = getVida();
    
        idadeAtual++;
        vidaAtual--;
    
        if (vidaAtual <= 0 || idadeAtual >= 30) {
            if (getTerrenoAtual() != null) {
                getTerrenoAtual().setElemento(null);
            }
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
    
        if (newX >= 0 && newX < grade[0].length && newY >= 0 && newY < grade.length) {
            Terreno novoTerreno = grade[newY][newX];
            if (novoTerreno.getElemento() == null) {
                if (getTerrenoAtual() != null) {
                    getTerrenoAtual().setElemento(null);
                }
                novoTerreno.setElemento(this);
                setX(newX);
                setY(newY);
                setTerrenoAtual(novoTerreno);
            }
        } else {
            if (getTerrenoAtual() != null) {
                getTerrenoAtual().setElemento(null);
            }
        }
    }
    
    private void consumirCoelho(Coelho coelho) {
        coelho.morrer();
        setVida(getVida() + 20);
    }

    public Lobo reproduzir(Lobo parceiro) {
        if (this.getSexo().equals("masculino") && parceiro.getSexo().equals("feminino")) {
            if (this.getIdade() >= 2 && parceiro.getIdade() >= 2) {
                setVida(getVida() - 10);
                parceiro.setVida(parceiro.getVida() - 10);
                return new Lobo("Filhote", 0, "aleatório");
            }
        }
        return null;
    }
}
