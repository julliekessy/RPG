package personagens;

public class Mago extends Heroi {
    
    public Mago(String nome) {
        
        super(nome, 80, 25, 4);
    }

    @Override
    public int atacar() {
        System.out.println(getNome() + " lança um feitiço básico!");
        return getAtaque();
    }

    @Override
    public int usarHabilidade() {
         
        System.out.println(getNome() + " lança uma poderosa BOLA DE FOGO!");
        return getAtaque(); 
    }
}