import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemAkademik{
    // deklarasi variable global
    // private static int levelAcc;
    private static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
        logIn();
    }

    public static void logOut(){
        System.out.println("Anda telah logout");
        // Redirect user to login page
        logIn();
    }
    // private static List<String> menuStack = new ArrayList<>();
    public static void logIn(){
        String username, password;
        int attempts = 0;

    while(attempts < 3){
        System.out.println("");
        System.out.println("======================");
        System.out.println("=     Login User     =");
        System.out.println("=--------------------=");
        System.out.print("Masukkan username : ");
        username = inputScanner.next();
        System.out.print("Masukkan password : ");
        password = inputScanner.next();

        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("Selamat datang " + username);
            berandaAdmin();
            
        }else if("dosen".equals(username) && "dosen".equals(password)){
            System.out.println("Selamat datang " + username);
            berandaDosen();
        }else if("mahasiswa".equals(username) && "mahasiswa".equals(password)){
            System.out.println("Selamat datang " + username);
            berandaMahasiswa();
        }else{
            System.out.println("username/password salah");
            attempts++;
        }
    }
        if (attempts == 3) {
            System.out.println("Anda telah melebihi batas upaya login");
            System.exit(0);
        }
    }

    private static void berandaAdmin(){
        while (true) {
            System.out.println("");
            System.out.println("============================");
            System.out.println("=      Sistem Akademik     =");
            System.out.println("=       BERANDA ADMIN      =");
            System.out.println("----------------------------");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Update Data Mahasiswa");
            System.out.println("3. Cek Data Mahasiswa");
            System.out.println("4. Input Nilai Mahasiswa");
            System.out.println("5. Update Nilai Mahasiswa");
            System.out.println("6. Cek Jadwal Perkuliahan");
            System.out.println("7. Update KRS Mahasiswa");
            System.out.println("8. Cek Data KRS Mahasiswa");
            System.out.println("9. Contact");
            System.out.println("0. LogOut\n");

            System.out.print("Masukkan pilihan anda: ");
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    inDataMhs();
                    break;
                case 2:
                    updDataMhs();
                    break;
                case 3:
                    cekDataMhs();
                    break;
                case 4:
                    inNilaiMhs();
                    break;
                case 5:
                    updNilaiMhs();
                    break;
                case 6:
                    cekJadwalKuliah();
                    break;
                case 7:
                    updKrsMhs();
                    break;
                case 8:
                    cekDataKrsMhs();
                    break;
                case 9:
                    contactAdmin();
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void berandaDosen(){
        while (true) {
        System.out.println("");
        System.out.println("============================");
        System.out.println("=      Sistem Akademik     =");
        System.out.println("=       BERANDA DOSEN      =");
        System.out.println("----------------------------");
        System.out.println("1. Cek Data Mahasiswa");
        System.out.println("2. Input Nilai Mahasiswa");
        System.out.println("3. Update Nilai Mahasiswa");
        System.out.println("4. Contact");
        System.out.println("0. LogOut\n");

        System.out.print("Masukkan pilihan anda: ");
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    cekDataMhs();
                    break;
                case 2:
                    inNilaiMhs();
                    break;
                case 3:
                    updNilaiMhs();
                    break;
                case 4:
                    contact();
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void berandaMahasiswa(){

        while (true) {
        System.out.println("");
        System.out.println("============================");
        System.out.println("=      Sistem Akademik     =");
        System.out.println("=     BERANDA MAHASISWA    =");
        System.out.println("----------------------------");    
        System.out.println("1. Cek Data Mahasiswa");
        System.out.println("2. Cek Jadwal Kuliah");
        System.out.println("3. Cek Data KRS Mahasiswa");
        System.out.println("4. Contact");
        System.out.println("0. LogOut\n");

        System.out.print("Masukkan pilihan anda: ");
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    cekDataMhs();
                    break;
                case 2:
                    cekJadwalKuliah();
                    break;
                case 3:
                    cekDataKrsMhs();
                    break;
                case 4:
                    contact();
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    } 

    // FITUR INPUT DATA MAHASISWA
    private static void inDataMhs() {
        while(true){
        System.out.println("INPUT DATA MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void updDataMhs() {
        while(true){
        System.out.println("UPDATE DATA MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void cekDataMhs() {
        while(true){
        System.out.println("CEK DATA MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void inNilaiMhs() {
        while(true){
        System.out.println("INPUT NILAI MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void updNilaiMhs() {
        while(true){
        System.out.println("UPDATE NILAI MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void cekJadwalKuliah() {
        while(true){
        System.out.println("CEK JADWAL KULIAH");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void updKrsMhs() {
        while(true){
        System.out.println("UPDATE KRS MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void cekDataKrsMhs() {
        while(true){
        System.out.println("CEK DATA KRS MAHASISWA");
        System.out.println("1.");
        System.out.println("2.");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // deklarasi variable global untuk fitur contact
    public static String nama, pesan;
    public static int nim;

    public static void contact() {
        while(true){
        System.out.println("CONTACT");
        System.out.print("masukkan nama : ");
        nama = inputScanner.next();
        System.out.print("masukkan nim : ");
        nim = inputScanner.nextInt();
        System.out.print("masukkan pesan : ");
        pesan = inputScanner.next();

        if (nama != "" && nim != 0 && pesan!="") {
            System.out.println("Pesan anda sedang diproses");
            return;
        }
        else{
            System.out.println("pastikan data yang anda masukkan sudah benar");
        }
        //  int choice = inputScanner.nextInt();
        //     switch (choice) {
        //         case 0:
        //             return;
        //         default:
        //             System.out.println("Pilihan tidak valid.");
        //     }
        }
    }
    public static void contactAdmin() {
        System.out.println("CONTACT");
        System.out.println("nama : " + nama);
        System.out.println("nim : " + nim);
        System.out.println("pesan : " + pesan);

    }
    
}