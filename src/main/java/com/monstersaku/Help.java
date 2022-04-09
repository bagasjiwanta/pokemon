package com.monstersaku;

public class Help {
    
    public Help(){}
    public void start(){
        System.out.println("Help: ");
        System.out.println("Deskripsi permainan: ");
        System.out.println("1. Monster saku adalah game bergenre turn-based RPG. Permainan ini dimainkan tepat oleh 2 orang.");
        System.out.println("2. Setiap pemain akan diberikan 6 monster secara random kemudian setiap pemain akan melakukan giliran mereka secara bergantian.");
        System.out.println("3. Setiap turn, pemain dapat melakukan gerakan monster atau pergantian monster.");
        System.out.println("4. Eksekusi gerakan/pergantian monster terjadi apabila semua player telah menentukan apa yang dilakukan pada round tersebut.");
        System.out.println("5. Pergantan monster selalu dilakukan lebih dahulu dibandingkan move monster.");
        System.out.println("6. Setiap pemain akan melakukan hal ini terus-menerus hingga keenam monster lawan telah terkalahkan.\n");
        System.out.println("Cara bermain: ");
        System.out.println("1. Masukkan 1 di menu awal.");
        System.out.println("2. Masukkan 1 untuk melakukan move monster atau tekan 2 untuk melakukan switch monster.");
        System.out.println("3. Jika melakukan move, maka program akan menampilkan move yang monster miliki, pilih salah satu move untuk mengeksekusinya.");
        System.out.println("4. Jika melakukan switch, maka program akan menampilkan yang monster dimiliki, pilih salah satu monster untuk melakukan switch.");
        System.out.println("5. Tunggu pemain selanjutnya untuk melakukan hal yang sama.");
        System.out.println("6. Aksi setiap pemain akan dieksekusi.");
        System.out.println("7. Ulangi hingga salah satu player kehabisan monster untuk digunakkan.");
    }

    public void menuMessage(){
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
    }
    
}
