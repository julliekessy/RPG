package dungeon;

import personagens.*;
import batalha.Batalha;
import java.util.Scanner;
import personagens.Monstro; 

public class Dungeon {
    private Heroi heroi;
    private Scanner sc;

    public Dungeon(Heroi heroi, Scanner sc) {
        this.heroi = heroi;
        this.sc = sc;
    }

    public void explorar() {
        int vitorias = 0;

        
        while (vitorias < 3 && heroi.estaVivo()) {
            System.out.println("\n=== [ SALA " + (vitorias + 1) + " ] ===");
            Monstro monstro = Monstro.gerarAleatorio();  
            System.out.println("Um " + monstro.getNome() + " apareceu!");

            Batalha batalha = new Batalha(heroi, monstro, sc);
            if (batalha.iniciar()) {
                vitorias++;
            }
        }

        
        if (heroi.estaVivo()) {
            System.out.println("\n!!! O BOSS DRACOLICH APARECEU !!!");
            Monstro boss = new Monstro("Dracolich", 180, 20, 8);
            Batalha batalhaFinal = new Batalha(heroi, boss, sc);
            
            if (batalhaFinal.iniciar()) {
                System.out.println("PARABÉNS! Você conquistou a PokéDungeon!");
            }
        }
    }
}