package personagens;

public class Monstro extends Personagem {
    
    
    public Monstro(String nome, int hpMaximo, int ataque, int defesa) {
        super(nome, hpMaximo, ataque, defesa);
    }

    @Override
    public int atacar() {
        
        return getAtaque();
    }

    
    public static Monstro gerarAleatorio() {
        double chance = Math.random();
        if (chance < 0.25) return new Monstro("Esqueleto", 45, 8, 2);
        if (chance < 0.50) return new Monstro("Zumbi Lento", 70, 6, 0);
        if (chance < 0.75) return new Monstro("Aranha Gigante", 35, 14, 0);
        return new Monstro("Dragãozinho", 60, 12, 5);
    }
}