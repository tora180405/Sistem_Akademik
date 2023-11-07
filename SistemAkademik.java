import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemAkademik {
    // deklarasi variable global
    // private static int levelAcc;
    ;
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        logIn();
    }

    public static void logOut() {
        System.out.println("Anda telah logout");
        // Redirect user to login page
        logIn();
    }

    // private static List<String> menuStack = new ArrayList<>();
    public static void logIn() {
        String[][] dataLog = {
                { "admin", "admin" },
                { "dosen", "dosen" },
                { "mahasiswa", "mahasiswa" }
        };
        String username = "", password = "";
        int attempts = 0;

        while (attempts < 3) {
            System.out.println("");
            System.out.println("======================");
            System.out.println("|     Login User     |");
            System.out.println("=--------------------=");

            System.out.print("Masukkan username : ");
            username = inputScanner.next();
            System.out.print("Masukkan password : ");
            password = inputScanner.next();

            if (dataLog[0][0].equals(username) && dataLog[0][1].equals(password)) {
                System.out.println("Selamat datang " + username);
                berandaAdmin();

            } else if (dataLog[1][0].equals(username) && dataLog[1][1].equals(password)) {
                System.out.println("Selamat datang " + username);
                berandaDosen();
            } else if (dataLog[2][0].equals(username) && dataLog[2][1].equals(password)) {
                System.out.println("Selamat datang " + username);
                berandaMahasiswa();
            } else {
                System.out.println("username/password salah");
                attempts++;
            }
        }
        if (attempts == 3) {
            System.out.println("Anda telah melebihi batas upaya login");
            System.exit(0);
        }
    }

    private static void berandaAdmin() {
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

    private static void berandaDosen() {
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

    private static void berandaMahasiswa() {

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

    // deklarasi array untuk fitur input data mahasiswa
    public static String[][] mahasiswa;

    // FITUR INPUT DATA MAHASISWA
    private static void inDataMhs() {

        int choice;
        System.out.println("========================================");
        System.out.println("=          INPUT DATA MAHASISWA        =");
        System.out.println("========================================");
        System.out.println("Ketik 0 untuk kembali ke menu sebelumnya");
        System.out.println("Ketik angka lain untuk lanjut");
        choice = inputScanner.nextInt();
        if (choice == 0)
            return;

        while (true) {
            System.out.print("Masukkan jumlah Mahasiswa : ");
            int jmlMhs = inputScanner.nextInt();
            int i = 0;
            mahasiswa = new String[4000][9];

            while (i < mahasiswa.length) {
                System.out.println("\n");
                i++;

                System.out.println("===================DATA MAHASISWA===================");

                inputScanner.nextLine();
                System.out.print("masukkan nama             :");
                mahasiswa[i][0] = inputScanner.nextLine();
                System.out.print("masukkan NIM              :");
                mahasiswa[i][1] = inputScanner.nextLine();
                System.out.print("masukkan Jenis Kelamin    :");
                mahasiswa[i][2] = inputScanner.nextLine();
                System.out.print("masukkan kelas            :");
                mahasiswa[i][3] = inputScanner.nextLine();
                System.out.print("masukkan agama            :");
                mahasiswa[i][4] = inputScanner.nextLine();
                System.out.print("masukkan tanggal lahir    :");
                mahasiswa[i][5] = inputScanner.nextLine();
                System.out.print("masukkan email            :");
                mahasiswa[i][6] = inputScanner.nextLine();
                System.out.print("masukkan nomor handpone   :");
                mahasiswa[i][7] = inputScanner.nextLine();
                System.out.print("masukkan alamat           :");
                mahasiswa[i][8] = inputScanner.nextLine();

                System.out.println("DATA BERHASIL DI TAMBAHKAN\n");

                if (i == jmlMhs) {
                    System.out.println("=======================================================");
                    System.out.print("APAKAH ANDA INGIN MENAMBAHKAN DATA MAHASISWA LAGI ?");

                    System.out.println("\n");

                    System.out.println("1. untuk ya");
                    System.out.println("2. untuk tidak");

                    System.out.println("masukkan pilihan : ");
                    choice = inputScanner.nextInt();

                    if (choice == 1) {
                        inDataMhs();
                    } else if (choice == 2) {
                        berandaAdmin();
                    } else {
                        System.out.println("pilihan anda tidak valid");
                        inDataMhs();
                    }
                    break;

                }

            }
            break;
        }
    }

    private static void updDataMhs() {
        while (true) {
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

        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.println("================= DATA MAHASISWA ===============");
                System.out.println("NAMA          : " + mahasiswa[i][0]);
                System.out.println("NIM           : " + mahasiswa[i][1]);
                System.out.println("JENIS KELAMIN : " + mahasiswa[i][2]);
                System.out.println("KELAS         : " + mahasiswa[i][3]);
                System.out.println("AGAMA         : " + mahasiswa[i][4]);
                System.out.println("TGL LAHIR     : " + mahasiswa[i][5]);
                System.out.println("EMAIL         : " + mahasiswa[i][6]);
                System.out.println("NO TELP       : " + mahasiswa[i][7]);
                System.out.println("ALAMAT        : " + mahasiswa[i][8]);
            }
        }
    }

    private static void inNilaiMhs() {

        int choice;
        System.out.println("========================================");
        System.out.println("=         INPUT NILAI MAHASISWA        =");
        System.out.println("========================================");
        System.out.println("Ketik 0 untuk kembali ke menu sebelumnya");
        System.out.println("Ketik angka lain untuk lanjut");
        choice = inputScanner.nextInt();

        if (choice == 0)
            return;

        while (true) {
            for (String[] a : mahasiswa) {
                System.out.println("nama Mahasiswa : " + mahasiswa[0][0]);

                break;
            }
        }
    }

    private static void updNilaiMhs() {
        while (true) {
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

    public static String [][] jadwal = {
        {"Senin", "10:35 - 14:25", "RTI231002", "Konsep Teknologi Informasi", "Yuri Ariyanto, S.Kom., M.Kom."},
        {"Rabu", "07:00 - 10:35", "RTI231008", "Keselamatan dan Kesehatan Kerja", "Ariadi Retno Tri Hayati Ririd, S.Kom., M.Kom."}
    };

    private static void cekJadwalKuliah() {
        inputScanner.nextLine();
        System.out.println("masukkan kelas");
        String kelas = inputScanner.nextLine();

        if (kelas.equalsIgnoreCase("1f") || kelas.equalsIgnoreCase("1-f")) {
            System.out.println("Kelas   : 1-F");
            System.out.println("========================== CEK JADWAL KULIAH ==========================");
            System.out.println("\n");
            System.out.format("+------------------------------------------------------------------------------------+%n");
            System.out.format("|Hari    |    Jam    |     Kode MK    |       Mata kuliah       |       Dosen        |%n");
            for(int i = 0; i < jadwal.length; i++){
                System.out.format(jadwal[i][0] + "      " + jadwal[i][1] + "      " + jadwal[i][2] + jadwal[i][3] + jadwal[i][4] + "\n");
            }
            System.out.format("+------------------------------------------------------------------------------------+%n");
        }
        
    }

    private static void updKrsMhs() {
        while (true) {
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
        System.out.println("========================== CEK DATA KRS MAHASISWA ==========================");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|" + "NO" + "|" + "MATA KULIAH                           " + "|" + "SEMESTER " + "|" + "SKS"
                + "|" + "JAM" + "|");
        System.out.println("|" + "1." + "|" + "Pancasila                             " + "|" + "1        " + "|" + "2  "
                + "|" + "2  " + "|");
        System.out.println("|" + "2." + "|" + "Konsep Teknologi Informasi            " + "|" + "1        " + "|" + "2  "
                + "|" + "4  " + "|");
        System.out.println("|" + "3." + "|" + "Critical Thinking dan Problem Solving " + "|" + "1        " + "|" + "2  "
                + "|" + "4  " + "|");
        System.out.println("|" + "4." + "|" + "Matematika Dasar                      " + "|" + "1        " + "|" + "3  "
                + "|" + "6  " + "|");
        System.out.println("|" + "5." + "|" + "Bahasa Inggris 1                      " + "|" + "1        " + "|" + "2  "
                + "|" + "4  " + "|");
        System.out.println("|" + "6." + "|" + "Dasar Pemograman                      " + "|" + "1        " + "|" + "2  "
                + "|" + "4  " + "|");
        System.out.println("|" + "7." + "|" + "Praktikum Dasar Pemograman            " + "|" + "1        " + "|" + "3  "
                + "|" + "6  " + "|");
        System.out.println("|" + "8." + "|" + "Keselamatan dan Kesehatan Kerja       " + "|" + "1        " + "|" + "2  "
                + "|" + "4  " + "|");
        System.out.println("-------------------------------------------------------------");
    }

    // deklarasi variable global untuk fitur contact
    public static String nama, pesan;
    public static int nim;

    public static void contact() {

        System.out.println("CONTACT");
        inputScanner.nextLine();
        System.out.print("masukkan nama : ");
        nama = inputScanner.nextLine();

        System.out.print("masukkan nim : ");
        nim = inputScanner.nextInt();

        inputScanner.nextLine();
        System.out.print("masukkan pesan : ");
        pesan = inputScanner.nextLine();

        System.out.println("Pesan anda sedang diproses");

    }

    public static void contactAdmin() {
        System.out.println("CONTACT");
        System.out.println("nama : " + nama);
        System.out.println("nim : " + nim);
        System.out.println("pesan : " + pesan);

        System.out.println("apakah ingin melakukan operasi selanjutnya?");
        int acc = inputScanner.nextInt();

        System.out.println("ketikkan 1 untuk lanjut");
        System.out.println("ketikkan angka lainnya untuk logout");

        if (acc == 1) {
            return;
        } else {
            logOut();
        }
    }

}