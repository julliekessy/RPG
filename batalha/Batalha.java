package batalha;

import personagens.*;
import java.util.Scanner;

public class Batalha {
    private Heroi heroi;
    private Monstro monstro;
    private Scanner sc;

    public Batalha(Heroi heroi, Monstro monstro, Scanner sc) {
        this.heroi = heroi;
        this.monstro = monstro;
        this.sc = sc;
    }

    public boolean iniciar() {
        int turnosQueimadura = 0; 

        while (heroi.estaVivo() && monstro.estaVivo()) {
            System.out.println("\n" + heroi.barraDeHP());
            System.out.println(monstro.barraDeHP());
            System.out.println("Sua ação: [1] Atacar [2] Habilidade [3] Fugir");
            System.out.print(">> ");
            int acao = sc.nextInt();

           
            if (acao == 1) {
                monstro.receberDano(heroi.atacar());
            } else if (acao == 2) {
                int danoHab = heroi.usarHabilidade();
                monstro.receberDano(danoHab);
                if (heroi instanceof Mago) turnosQueimadura = 3;
            } else {
                System.out.println("Você tentou fugir, mas a dungeon não permite!");
            }

            
            if (turnosQueimadura > 0 && monstro.estaVivo()) {
                System.out.println("O monstro está queimando! (-5 HP)");
                monstro.setHpAtual(monstro.getHpAtual() - 5);
                turnosQueimadura--;
            }

            
            if (monstro.estaVivo()) {
                System.out.println(monstro.getNome() + " contra-ataca!");
                heroi.receberDano(monstro.atacar());
            }
        }

        if (heroi.estaVivo()) {
            System.out.println("Vitória! " + monstro.getNome() + " foi derrotado.");
            return true;
        } else {
            System.out.println("Game Over... Você foi derrotado.");
            return false;
        }
    }
}