package personagens;

public class Guerreiro extends Heroi {
    public Guerreiro(String nome) {
        super(nome, 120, 15, 10); 
    }

    @Override
    public int usarHabilidade() {
        System.out.println(getNome() + " usa Golpe Devastador!");
        return getAtaque() * 2;
    }
}