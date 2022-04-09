package com.monstersaku;
import com.monstersaku.pools.EffectivityPool;
import com.monstersaku.pools.MonsterPool;
import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static final List<String> CSV_FILE_PATHS = Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv");
    public static void main(String[] args) {
        List<CSVReader> readers = new ArrayList<CSVReader>();

        for (String fileName : CSV_FILE_PATHS) {
            try {
                readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
            } catch (Exception e) { }
        }
        MonsterPool.setReader(readers.get(0));
        Monster.setReader(readers.get(1));
        EffectivityPool.setReader(readers.get(2));
        
        EffectivityPool.readEffectivities();

        String art = """
            ███╗   ███╗ ██████╗ ███╗   ██╗███████╗████████╗███████╗██████╗     ███████╗ █████╗ ██╗  ██╗██╗   ██╗
            ████╗ ████║██╔═══██╗████╗  ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗    ██╔════╝██╔══██╗██║ ██╔╝██║   ██║
            ██╔████╔██║██║   ██║██╔██╗ ██║███████╗   ██║   █████╗  ██████╔╝    ███████╗███████║█████╔╝ ██║   ██║
            ██║╚██╔╝██║██║   ██║██║╚██╗██║╚════██║   ██║   ██╔══╝  ██╔══██╗    ╚════██║██╔══██║██╔═██╗ ██║   ██║
            ██║ ╚═╝ ██║╚██████╔╝██║ ╚████║███████║   ██║   ███████╗██║  ██║    ███████║██║  ██║██║  ██╗╚██████╔╝
            ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝    ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ 
                                                                                                                
                """;
        for (int i=0; i<art.length();i++){
            System.out.print(art.charAt(i));
        }
        System.out.println("Selamat datang di permainan MONSTER SAKU");
        System.out.println("Pilih Command");
        System.out.println("1. Start Game");
        System.out.println("2. Help");
        System.out.println("3. Exit");
        System.out.print("> ");
        

        //Tampilan Menu Section
        boolean notEnd = true;
        Help help = new Help();
        //LOOP Menu Section
        while(notEnd){ 
            int operasi = Main.scanner.nextInt();
        switch (operasi) {
            case 1:
            System.out.print("Masukkan nama untuk player 1\n> ");
            String pname1 = Main.scanner.next();
            System.out.print("Masukkan nama untuk player 2\n> ");
            String pname2 = Main.scanner.next();
            Game game = new Game(pname1, pname2);
            game.start();
            game.loop();
              break;
            case 2:
                help.start();
                System.out.print("Masukkan 1 untuk kembali ke menu: ");
                int press1 = Main.scanner.nextInt();
                help.menuMessage();
              break;
            case 3:
                System.out.println("Exiting game...");
                System.exit(0);
              break;
          }
        }
        
        // new game disini
        Main.scanner.close();
    }
}
