package personagens;

public class Arqueiro extends Heroi {
    
    public Arqueiro(String nome) {
       
        super(nome, 100, 18, 6);
    }

    @Override
    public int atacar() {
        System.out.println(getNome() + " dispara uma flecha comum!"); 
        return getAtaque();
    }

    @Override
    public int usarHabilidade() {
        
        System.out.println(getNome() + " mira com precisão para um Tiro Certeiro!");
        
        if (Math.random() <= 0.8) {
            System.out.println("CRÍTICO! O dano foi triplicado!");
            return getAtaque() * 3;
        } else {
            System.out.println("O herói errou o ponto vital... Dano normal aplicado.");
            return getAtaque();
        }
    }
}