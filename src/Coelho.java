import java.util.Random;

public class Coelho extends Animal {
    public Coelho(String nome, int idade) {
        super(nome, idade, 40, gerarSexoAleatorio());
    }

    private static String gerarSexoAleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2); 

        if (numeroAleatorio == 0) {
            return "masculino";
        } else {
            return "feminino";
        }
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
    }
    

    public void comer(Terreno[][] grade) {
        int x = getX();
        int y = getY();

        if (x < grade[0].length - 1) {
            Terreno terrenoAdjacente = grade[y][x + 1];
            terrenoAdjacente.setElemento(null);
            setVida(getVida() + 10);
            }
        }

        public Coelho reproduzir(Terreno[][] grade) {
            int x = getX();
            int y = getY();
        
            int newX = x;
            int newY = y;
        
            if (x < grade[0].length - 1 && grade[y][x + 1].getElemento() instanceof Coelho) {
                Coelho parceiro = (Coelho) grade[y][x + 1].getElemento();
                if (!getSexo().equals(parceiro.getSexo())) {
                    setVida(getVida() - 10);
                    parceiro.setVida(parceiro.getVida() - 10);
                    return new Coelho("Filhote", 0);
                }
            } else if (x > 0 && grade[y][x - 1].getElemento() instanceof Coelho) {
                Coelho parceiro = (Coelho) grade[y][x - 1].getElemento();
                if (!getSexo().equals(parceiro.getSexo())) {
                    setVida(getVida() - 10);
                    parceiro.setVida(parceiro.getVida() - 10);
                    return new Coelho("Filhote", 0);
                }
            } else if (y < grade.length - 1 && grade[y + 1][x].getElemento() instanceof Coelho) {
                Coelho parceiro = (Coelho) grade[y + 1][x].getElemento();
                if (!getSexo().equals(parceiro.getSexo())) {
                    setVida(getVida() - 10);
                    parceiro.setVida(parceiro.getVida() - 10);
                    return new Coelho("Filhote", 0);
                }
            } else if (y > 0 && grade[y - 1][x].getElemento() instanceof Coelho) {
                Coelho parceiro = (Coelho) grade[y - 1][x].getElemento();
                if (!getSexo().equals(parceiro.getSexo())) {
                    setVida(getVida() - 10);
                    parceiro.setVida(parceiro.getVida() - 10);
                    return new Coelho("Filhote", 0);
                }
            }
        
            return null;
        }

    public void morrer() {
        setVida(0);
    }
}