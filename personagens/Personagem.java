package personagens;

public abstract class Personagem {
    private String nome;
    private int hpAtual;
    private int hpMaximo;
    private int ataque;
    private int defesa;

    public Personagem(String nome, int hpMaximo, int ataque, int defesa) {
        this.nome = nome;
        this.hpMaximo = hpMaximo;
        this.hpAtual = hpMaximo;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    
    public String getNome() { return nome; }
    public int getHpAtual() { return hpAtual; }
    public void setHpAtual(int hp) { 
        if (hp < 0) this.hpAtual = 0;
        else if (hp > hpMaximo) this.hpAtual = hpMaximo;
        else this.hpAtual = hp;
    }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }

    public abstract int atacar(); 

    public void receberDano(int dano) {
        int danoReal = dano - this.defesa;
        if (danoReal < 0) danoReal = 0;
        this.hpAtual -= danoReal;
        if (this.hpAtual < 0) this.hpAtual = 0;
    }

    public boolean estaVivo() {
        
        return this.hpAtual > 0;
    }

    public String barraDeHP() {
        
        int barras = (int) ((double) hpAtual / hpMaximo * 10);
        String visual = "";
        for (int i = 0; i < 10; i++) {
            visual += (i < barras) ? "█" : "░";
        }
        return String.format("%s [%s] %d/%d", nome, visual, hpAtual, hpMaximo);
    }
}