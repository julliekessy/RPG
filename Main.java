import personagens.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Tela Inicial
        System.out.println("############################################################");
        System.out.println("#                                                          #");
        System.out.println("#    ____       _        _____                             #");
        System.out.println("#   |  _ \\ ___ | | _____| ____|   _ _ __   __ _  ___  ___  #");
        System.out.println("#   | |_) / _ \\| |/ / _ \\  _|  | | | '_ \\ / _` |/ _ \\/ _ \\ #");
        System.out.println("#   |  __/ (_) |   <  __/ |__| |_| | | | | (_| |  __/ (_) |#");
        System.out.println("#   |_|   \\___/|_|\\_\\___|_____\\__,_|_| |_|\\__, |\\___|\\___/ #");
        System.out.println("#                                         |___/            #");
        System.out.println("#                                                          #");
        System.out.println("#              --- EXPLORE A MASMORRA ---                  #");
        System.out.println("#                                                          #");
        System.out.println("############################################################");
        System.out.println();
        
        System.out.println("Nome do heroi: ");
        String nome = sc.nextLine();
        
        System.out.println("Escolha a classe: [1] Guerreiro [2] Mago [3] Arqueiro");
        int opcao = sc.nextInt();
        Heroi heroi;
        
        // Implementação das classes 
        if (opcao == 2) heroi = new Mago(nome);
        else if (opcao == 3) heroi = new Arqueiro(nome);
        else heroi = new Guerreiro(nome); 

        int vitorias = 0;
        
        // Loop das Salas 
        while (heroi.estaVivo() && vitorias < 3) {
            System.out.println("\n--- SALA " + (vitorias + 1) + " ---");
            
            Monstro monstro = Monstro.gerarAleatorio(); 
            System.out.println("Um " + monstro.getNome() + " apareceu!");

            batalha.Batalha luta = new batalha.Batalha(heroi, monstro, sc);
            if (luta.iniciar()) {
                vitorias++;
            }
        }

        
        if (heroi.estaVivo()) {
            System.out.println("\n!!! O BOSS APARECEU !!!");
            Monstro boss = new Monstro("Dracolich", 180, 20, 8);
            
            batalha.Batalha lutaFinal = new batalha.Batalha(heroi, boss, sc);
            lutaFinal.iniciar();
        }

        
        boolean venceu = (vitorias >= 3 && heroi.estaVivo());
        exibirPlacarFinal(heroi, vitorias, venceu);

        sc.close();
    } 


    public static void exibirPlacarFinal(Heroi heroi, int vitorias, boolean ganhou) {
        System.out.println("\n==========================================================");
        if (ganhou) {
            System.out.println("||                  VITORIA NAS DUNGEONS                ||");
        } else {
            System.out.println("||                  FIM DE JOGO (DEFEAT)                ||");
        }
        System.out.println("==========================================================");
        
        System.out.println(String.format("||  Heroi: %-40s ||", heroi.getNome()));
        System.out.println(String.format("||  Salas Concluidas: %-31d ||", vitorias));
        System.out.println(String.format("||  HP Final: %-39s ||", heroi.getHpAtual() + "/100")); 
        System.out.println(String.format("||  Ataque Base: %-36d ||", heroi.getAtaque()));
        System.out.println(String.format("||  Defesa Base: %-36d ||", heroi.getDefesa()));
        
        System.out.println("==========================================================");
        
        if (ganhou) {
            System.out.println("||          PARABENS! VOCE SE TORNOU UMA LENDA          ||");
        } else {
            System.out.println("||          TENTE NOVAMENTE NA PROXIMA VIDA...          ||");
        }
        System.out.println("==========================================================\n");
    }
} 