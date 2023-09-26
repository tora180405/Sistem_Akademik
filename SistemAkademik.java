import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class SistemAkademik{
    // deklarasi variable global
    private static int levelAcc;
    public static void main(String[] args) throws IOException{
        logIn();
        berandaUser();
    }
    // private static List<String> menuStack = new ArrayList<>();
    public static void logIn(){
        Scanner inputScanner = new Scanner(System.in);
        String username, password;
        // int levelAcc;

        System.out.println("Login User");
        System.out.print("Masukkan username : ");
        username = inputScanner.next();
        System.out.print("Masukkan password : ");
        password = inputScanner.next();

        if ("admin".equals(username) && "admin".equals(password)) {
            levelAcc = 1;
            System.out.println("Selamat datang " + username);
            System.out.println("level" + levelAcc);
        }else if("dosen".equals(username) && "dosen".equals(password)){
            levelAcc = 2;
            System.out.println("Selamat datang " + username);
            System.out.println("level" + levelAcc);
        }else if("mahasiswa".equals(username) && "mahasiswa".equals(password)){
            levelAcc = 3;
            System.out.println("Selamat datang " + username);
            System.out.println("level" + levelAcc);
        }else{
            System.out.println("username/password salah");
        }
    }

    public static void berandaUser(){
        Scanner inputScanner = new Scanner(System.in);
        String opsiUser;

    }



    private static void tampilkanData() throws IOException{

    }
}