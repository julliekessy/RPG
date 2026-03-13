package personagens;

public class Heroi extends Personagem {
    
    public Heroi(String nome, int hpMaximo, int ataque, int defesa) {
        
        super(nome, hpMaximo, ataque, defesa);
    }
 @Override
 public int atacar() {
       
        return getAtaque();
 }
 public int usarHabilidade() {
      
        return 0;
 }
}