package util;

import java.util.Scanner;

public class EntradaUsuario {
    
    private static Scanner scanner = new Scanner(System.in);

    
    public static Scanner getScanner() {
        return scanner;
    }

    
    public static void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}