import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SistemAkademik {
    // deklarasi variable global
    // private static int levelAcc;
    // deklarasi array untuk fitur input data mahasiswa
    public static String[][] mahasiswa = new String[4000][12];

    public static int counter;

    // Deklarasi variable untuk fitur contact
    public static String[][] contact = new String[1000][3];

    // Deklarasi Variable untuk fitur search dari semua fitur
    public static String key;
    public static boolean search = true;
    public static Scanner inputScanner = new Scanner(System.in);

    // deklarasi variable krs mahasiswa semester 1
    public static String[][] krsMhs1 = {
            { "RTI231001", "Pancasila", "1", "2", "2", "" },
            { "RTI231002", "Konsep Teknologi Informasi", "1", "2", "4", "" },
            { "RTI231003", "Critical Thinking dan Problem Solving", "1", "2", "4", "" },
            { "RTI231004", "Matematika Dasar", "1", "3", "6", "" },
            { "RTI231005", "Bahasa Inggris 1", "1", "2", "4", "" },
            { "RTI231006", "Dasar Pemograman", "1", "2", "4", "" },
            { "RTI231007", "Praktikum Dasar Pemograman", "1", "3", "6", "" },
            { "RTI231008", "Keselamatan dan Kesehatan Kerja", "1", "2", "4", "" }
    };

    // deklarasi variable nilai
    public static String[][] nilai = new String[1000][34];

    // deklarasi variable untuk jadwal matkul
    public static String jadwalMatkul1f[][];

    public static void main(String[] args) {
        logIn();
    }

    public static void logOut() {
        System.out.println("Anda telah logout");
        // Redirect user to login page
        logIn();
    }

    public static String username = "";
    public static String password = "";

    // private static List<String> menuStack = new ArrayList<>();
    public static void logIn() {
        String[][] dataLog = {
                { "admin1", "admin1", "1" },
                { "admin2", "admin2", "1" },
                { "admin3", "admin3", "1" },
                { "dosen1", "dosen1", "2" },
                { "dosen2", "dosen2", "2" },
                { "dosen3", "dosen3", "2" },
                { "dosen4", "dosen4", "2" },
                { "dosen5", "dosen5", "2" },
                { "dosen6", "dosen6", "2" },
                { "dosen7", "dosen7", "2" },
                { "dosen8", "dosen8", "2" },
                { "mahasiswa1", "mahasiswa1", "3" },
                { "mahasiswa2", "mahasiswa2", "3" },
                { "mahasiswa3", "mahasiswa3", "3" }
        };
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

            for (String[] user : dataLog) {
                String storedUsername = user[0];
                String storedPassword = user[1];
                String role = user[2];

                if (storedUsername.equals(username) && storedPassword.equals(password) && role.equals("1")) {
                    System.out.println("Selamat datang " + username);
                    berandaAdmin();

                } else if (storedUsername.equals(username) && storedPassword.equals(password) && role.equals("2")) {
                    System.out.println("Selamat datang " + username);
                    berandaDosen();
                } else if (storedUsername.equals(username) && storedPassword.equals(password) && role.equals("3")) {
                    System.out.println("Selamat datang " + username);
                    berandaMahasiswa();
                } else {
                    continue;
                }
            }
            System.out.println("username/password salah");
            attempts++;
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
            // System.out.println("4. Input Nilai Mahasiswa");
            // System.out.println("5. Update Nilai Mahasiswa");
            System.out.println("4. Cek Jadwal Perkuliahan");
            System.out.println("5. Update KRS Mahasiswa");
            System.out.println("6. Cek Data KRS Mahasiswa");
            System.out.println("7. Contact");
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
                    // inNilaiMhs();
                    // cekNilaiMhsAdmin();
                    cekJadwalKuliah();
                    break;
                case 5:
                    // updNilaiMhs();
                    updKrsMhs();
                    break;
                case 6:
                    // cekNilaiMhs();
                    cekDataKrsMhs();
                    break;
                case 7:
                    // cekJadwalKuliah();
                    contactAdmin();
                    break;
                // case 9:
                // cekDataKrsMhs();
                // break;
                // case 10:
                // contactAdmin();
                // break;
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
            System.out.println("4. Cek Nilai Mahasiswa");
            System.out.println("5. Contact");
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
                    cekNilaiMhsDosen();
                    break;
                case 5:
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
            System.out.println("4. Cek Nilai Mahasiswa");
            System.out.println("5. Cetak KTM");
            System.out.println("6. Contact");
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
                    cekNilaiMhs();
                    break;
                case 5:
                    cetakKtm();
                    break;
                case 6:
                    contact();
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // public int i = 0;
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
        boolean inpData = true;

        while (inpData) {

            // System.out.println(counter);
            int i = counter;
            while (i < mahasiswa.length) {
                System.out.println("\n");

                System.out.println("===================DATA MAHASISWA===================");
                inputScanner.nextLine();
                System.out.print("masukkan nama             :");
                mahasiswa[i][0] = inputScanner.nextLine();
                System.out.print("masukkan NIM              :");
                mahasiswa[i][1] = inputScanner.nextLine();
                System.out.print("masukkan Jurusan          :");
                mahasiswa[i][2] = inputScanner.nextLine();
                System.out.print("masukkan Program Studi    :");
                mahasiswa[i][3] = inputScanner.nextLine();
                System.out.print("masukkan Kelas            :");
                mahasiswa[i][4] = inputScanner.nextLine();
                System.out.print("masukkan Jenis Kelamin    :");
                mahasiswa[i][5] = inputScanner.nextLine();
                System.out.print("masukkan agama            :");
                mahasiswa[i][6] = inputScanner.nextLine();
                System.out.print("masukkan tanggal lahir    :");
                mahasiswa[i][7] = inputScanner.nextLine();
                System.out.print("masukkan email            :");
                mahasiswa[i][8] = inputScanner.nextLine();
                System.out.print("masukkan nomor handpone   :");
                mahasiswa[i][9] = inputScanner.nextLine();
                System.out.print("masukkan alamat           :");
                mahasiswa[i][10] = inputScanner.nextLine();

                System.out.println("DATA BERHASIL DI TAMBAHKAN\n");
                System.out.println("yang melakukan penambahan adalah : " + username);
                mahasiswa[i][11] = username;

                System.out.println("=======================================================");
                System.out.print("APAKAH ANDA INGIN MENAMBAHKAN DATA MAHASISWA LAGI ?");
                counter++;

                System.out.println("\n");

                System.out.println("1. untuk ya");
                System.out.println("2. untuk tidak");

                System.out.println("masukkan pilihan : ");
                choice = inputScanner.nextInt();

                if (choice == 1) {
                    i = counter;
                } else if (choice == 2) {
                    // berandaAdmin();
                    i = counter;
                    inpData = false;
                    break;
                } else {
                    System.out.println("pilihan anda tidak valid, data sebelumnya tidak masuk kedalam data!");
                    System.out.println("Silahkan input data kembali!");
                    --counter;
                    continue;
                }

            }
            break;
        }
    }

    private static void updDataMhs() {
        // untuk menghitung data mahasiswa yang ada nilainya(tidak null)
        int count = 0;
        for (String[] data : mahasiswa) {
            if (data[0] != null) {
                count++;
            }
        }
        // SORTING BY NAME
        int n = count;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mahasiswa[j][0].compareTo(mahasiswa[j + 1][0]) > 0) {
                    // swap mahasiswa[j+1] and mahasiswa[j]
                    String[] temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }

        System.out.println("================= UPDATE DATA MAHASISWA ===============");
        System.out.println();
        System.out.printf("| %-20s | %-15s | %-20s | %-10s | %-10s |\n", "Nama", "NIM", "Jurusan", "Program Studi",
                "Kelas");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
            }
        }

        System.out.println("Cari data yang akan di update berdasarkan NIM");
        System.out.println("Apakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("_________");
        inputScanner.nextLine();

        String jawab = inputScanner.nextLine();

        if (jawab.equalsIgnoreCase("yes")) {
            boolean finded = false;
            System.out.print("Masukkan key yang ingin dicari : ");
            key = inputScanner.nextLine();

            for (int i = 0; i < mahasiswa.length; i++) {
                if (key.equals(mahasiswa[i][1])) {
                    System.out.println("=======================");
                    System.out.println("NAMA          : " + mahasiswa[i][0]);
                    System.out.println("NIM           : " + mahasiswa[i][1]);
                    System.out.println("JURUSAN       : " + mahasiswa[i][2]);
                    System.out.println("PROGRAM STUDI : " + mahasiswa[i][3]);
                    System.out.println("KELAS         : " + mahasiswa[i][4]);
                    System.out.println("JENIS KELAMIN : " + mahasiswa[i][5]);
                    System.out.println("AGAMA         : " + mahasiswa[i][6]);
                    System.out.println("TGL LAHIR     : " + mahasiswa[i][7]);
                    System.out.println("EMAIL         : " + mahasiswa[i][8]);
                    System.out.println("NO TELP       : " + mahasiswa[i][9]);
                    System.out.println("ALAMAT        : " + mahasiswa[i][10]);
                    System.out.println("=======================");
                    System.out.println();
                    System.out.println("Modified data by : " + mahasiswa[i][11]);

                    // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                    finded = true;
                }
                if (finded) {
                    System.out.println("===================DATA MAHASISWA===================");
                    inputScanner.nextLine();
                    System.out.print("masukkan nama             :");
                    mahasiswa[i][0] = inputScanner.nextLine();
                    System.out.print("masukkan NIM              :");
                    mahasiswa[i][1] = inputScanner.nextLine();
                    System.out.print("masukkan Jurusan          :");
                    mahasiswa[i][2] = inputScanner.nextLine();
                    System.out.print("masukkan Program Studi    :");
                    mahasiswa[i][3] = inputScanner.nextLine();
                    System.out.print("masukkan Kelas            :");
                    mahasiswa[i][4] = inputScanner.nextLine();
                    System.out.print("masukkan Jenis Kelamin    :");
                    mahasiswa[i][5] = inputScanner.nextLine();
                    System.out.print("masukkan agama            :");
                    mahasiswa[i][6] = inputScanner.nextLine();
                    System.out.print("masukkan tanggal lahir    :");
                    mahasiswa[i][7] = inputScanner.nextLine();
                    System.out.print("masukkan email            :");
                    mahasiswa[i][8] = inputScanner.nextLine();
                    System.out.print("masukkan nomor handpone   :");
                    mahasiswa[i][9] = inputScanner.nextLine();
                    System.out.print("masukkan alamat           :");
                    mahasiswa[i][10] = inputScanner.nextLine();

                    System.out.println("DATA BERHASIL DI UPDATE\n");
                    System.out.println(" yang melakukan perubahan adalah : " + username);
                    mahasiswa[i][11] = username;
                    break;
                }

            }
            if (!finded) {
                System.out.println("Key dalam array tidak ditemukan");
            } else if (finded) {
                System.out.println("apakah ingin melakukan operasi selanjutnya?");
                System.out.println("- ketikkan 1 untuk lanjut");
                System.out.println("- ketikkan angka lainnya untuk logout");
                int acc = inputScanner.nextInt();

                if (acc == 1) {
                    return;
                } else {
                    logOut();
                }
            }
        }
    }

    private static void cekDataMhs() {

        // untuk menghitung data mahasiswa yang ada nilainya(tidak null)
        int count = 0;
        for (String[] data : mahasiswa) {
            if (data[0] != null) {
                count++;
            }
        }
        // SORTING BY NAME
        int n = count;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mahasiswa[j][0].compareTo(mahasiswa[j + 1][0]) > 0) {
                    // swap mahasiswa[j+1] and mahasiswa[j]
                    String[] temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }

        System.out.println("================= DATA MAHASISWA ===============");
        System.out.println();
        System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-10s |\n", "Nama", "NIM", "Jurusan", "Program Studi",
                "Kelas");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
            }

        }
        System.out.println("\nApakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("_________");
        inputScanner.nextLine();

        String jawab = inputScanner.nextLine();

        if (jawab.equalsIgnoreCase("yes")) {
            boolean finded = false;
            System.out.print("Masukkan key yang ingin dicari : ");
            key = inputScanner.nextLine();

            for (int i = 0; i < mahasiswa.length; i++) {
                if (key.equals(mahasiswa[i][1])) {
                    System.out.println("=======================");
                    System.out.println("NAMA          : " + mahasiswa[i][0]);
                    System.out.println("NIM           : " + mahasiswa[i][1]);
                    System.out.println("JURUSAN       : " + mahasiswa[i][2]);
                    System.out.println("PROGRAM STUDI : " + mahasiswa[i][3]);
                    System.out.println("KELAS         : " + mahasiswa[i][4]);
                    System.out.println("JENIS KELAMIN : " + mahasiswa[i][5]);
                    System.out.println("AGAMA         : " + mahasiswa[i][6]);
                    System.out.println("TGL LAHIR     : " + mahasiswa[i][7]);
                    System.out.println("EMAIL         : " + mahasiswa[i][8]);
                    System.out.println("NO TELP       : " + mahasiswa[i][9]);
                    System.out.println("ALAMAT        : " + mahasiswa[i][10]);
                    System.out.println("=======================");
                    System.out.println();
                    System.out.println("Modified data by : " + mahasiswa[i][11]);
                    // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                    finded = true;
                }
            }
            if (!finded) {
                System.out.println("Key dalam array tidak ditemukan");
            } else if (finded) {
                System.out.println("apakah ingin melakukan operasi selanjutnya?");
                System.out.println("- ketikkan 1 untuk lanjut");
                System.out.println("- ketikkan angka lainnya untuk logout");
                int acc = inputScanner.nextInt();

                if (acc == 1) {
                    return;
                } else {
                    logOut();
                }
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
        boolean inpData = true;

        while (inpData) {
            if (username.equalsIgnoreCase("dosen1")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i++][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------

                            System.out.println("-----------------------DASPRO----------------------");
                            System.out.print("Nilai Tugas Daspro  : ");
                            nilai[j][2] = inputScanner.nextLine();
                            System.out.print("Nilai UTS Daspro    : ");
                            nilai[j][3] = inputScanner.nextLine();
                            System.out.print("Nilai UAS Daspro    : ");
                            nilai[j][4] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahDaspro = (Double.parseDouble(nilai[j][2]) + Double.parseDouble(nilai[j][3])
                                    + Double.parseDouble(nilai[j][4])) / 3;
                            nilai[j][5] = String.valueOf(jumlahDaspro);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen2")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("------------------DASPRO PRAKTIKUM-----------------");
                            System.out.print("Nilai Tugas Daspro Praktikum : ");
                            nilai[j][6] = inputScanner.nextLine();
                            System.out.print("Nilai UTS Daspro Praktikum   : ");
                            nilai[j][7] = inputScanner.nextLine();
                            System.out.print("Nilai UAS Daspro Praktikum   : ");
                            nilai[j][8] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahDasproPraktik = (Double.parseDouble(nilai[j][6])
                                    + Double.parseDouble(nilai[j][7]) + Double.parseDouble(nilai[j][8])) / 3;
                            nilai[j][9] = String.valueOf(jumlahDasproPraktik);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen3")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("-----------------------MATDAS----------------------");
                            System.out.print("Nilai Tugas Matdas: ");
                            nilai[j][10] = inputScanner.nextLine();
                            System.out.print("Nilai UTS Matdas  : ");
                            nilai[j][11] = inputScanner.nextLine();
                            System.out.print("Nilai UAS Matdas  : ");
                            nilai[j][12] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahMatdas = (Double.parseDouble(nilai[j][10]) + Double.parseDouble(nilai[j][11])
                                    + Double.parseDouble(nilai[j][12])) / 3;
                            nilai[j][13] = String.valueOf(jumlahMatdas);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen4")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("----------------------PANCASILA--------------------");
                            System.out.print("Nilai Tugas PANCASILA : ");
                            nilai[j][14] = inputScanner.nextLine();
                            System.out.print("Nilai UTS PANCASILA   : ");
                            nilai[j][15] = inputScanner.nextLine();
                            System.out.print("Nilai UAS PANCASILA   : ");
                            nilai[j][16] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahPancasila = (Double.parseDouble(nilai[j][14])
                                    + Double.parseDouble(nilai[j][15]) + Double.parseDouble(nilai[j][16])) / 3;
                            nilai[j][17] = String.valueOf(jumlahPancasila);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen5")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("-------------------------KTI-----------------------");
                            System.out.print("Nilai Tugas KTI : ");
                            nilai[j][18] = inputScanner.nextLine();
                            System.out.print("Nilai UTS KTI   : ");
                            nilai[j][19] = inputScanner.nextLine();
                            System.out.print("Nilai UAS KTI   : ");
                            nilai[j][20] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahKTI = (Double.parseDouble(nilai[j][18]) + Double.parseDouble(nilai[j][19])
                                    + Double.parseDouble(nilai[j][20])) / 3;
                            nilai[j][21] = String.valueOf(jumlahKTI);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen6")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("-------------------------CTPS----------------------");
                            System.out.print("Nilai Tugas CTPS : ");
                            nilai[j][22] = inputScanner.nextLine();
                            System.out.print("Nilai UTS CTPS   : ");
                            nilai[j][23] = inputScanner.nextLine();
                            System.out.print("Nilai UAS CTPS   : ");
                            nilai[j][24] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahCTPS = (Double.parseDouble(nilai[j][22]) + Double.parseDouble(nilai[j][23])
                                    + Double.parseDouble(nilai[j][24])) / 3;
                            nilai[j][25] = String.valueOf(jumlahCTPS);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen7")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("----------------------B.INGGRIS--------------------");
                            System.out.print("Nilai Tugas B.INGGRIS : ");
                            nilai[j][26] = inputScanner.nextLine();
                            System.out.print("Nilai UTS B.INGGRIS   : ");
                            nilai[j][27] = inputScanner.nextLine();
                            System.out.print("Nilai UAS B.INGGRIS   : ");
                            nilai[j][28] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahBing = (Double.parseDouble(nilai[j][26]) + Double.parseDouble(nilai[j][27])
                                    + Double.parseDouble(nilai[j][28])) / 3;
                            nilai[j][29] = String.valueOf(jumlahBing);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            } else if (username.equalsIgnoreCase("dosen8")) {
                for (int i = 0; i <= mahasiswa.length; i++) {
                    if (mahasiswa[i][0] != null) {
                        for (int j = 0; j < nilai.length; j++) {
                            // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                            nilai[j][0] = mahasiswa[i][0];
                            inputScanner.nextLine();
                            System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                            // --------------------------------------------------------------------------

                            // int NIM = Integer.parseInt(mahasiswa[i][1]);

                            // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                            // nilai[j][1] = String.valueOf(NIM);
                            nilai[j][1] = mahasiswa[i++][1];
                            System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                            // --------------------------------------------------------------------------
                            System.out.println("-------------------------K-3-----------------------");
                            System.out.print("Nilai Tugas K3 : ");
                            nilai[j][30] = inputScanner.nextLine();
                            System.out.print("Nilai UTS K3   : ");
                            nilai[j][31] = inputScanner.nextLine();
                            System.out.print("Nilai UAS K3   : ");
                            nilai[j][32] = inputScanner.nextLine();
                            System.out.println("---------------------------------------------------");
                            System.out.println("\n");
                            double jumlahK3 = (Double.parseDouble(nilai[j][30]) + Double.parseDouble(nilai[j][31])
                                    + Double.parseDouble(nilai[j][32])) / 3;
                            nilai[j][33] = String.valueOf(jumlahK3);

                            if (mahasiswa[i][0] == null) {
                                berandaDosen();
                            }
                        }
                    }
                }
            }
        }
    }

    private static void updNilaiMhs() {
        if (username.equalsIgnoreCase("dosen1")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PEMOGRAMAN");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("-----------------------DASPRO----------------------");
                        System.out.print("Nilai Tugas Daspro  : ");
                        nilai[i][2] = inputScanner.nextLine();
                        System.out.print("Nilai UTS Daspro    : ");
                        nilai[i][3] = inputScanner.nextLine();
                        System.out.print("Nilai UAS Daspro    : ");
                        nilai[i][4] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahDaspro = (Double.parseDouble(nilai[i][2]) + Double.parseDouble(nilai[i][3])
                                + Double.parseDouble(nilai[i][4])) / 3;
                        nilai[i][5] = String.valueOf(jumlahDaspro);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen2")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PEMOGRAMAN PRAKTIKUM");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][6], nilai[i][7], nilai[i][8], nilai[i][9]);
                }
            }
            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("------------------DASPRO PRAKTIKUM-----------------");
                        System.out.print("Nilai Tugas Daspro Praktikum : ");
                        nilai[i][6] = inputScanner.nextLine();
                        System.out.print("Nilai UTS Daspro Praktikum   : ");
                        nilai[i][7] = inputScanner.nextLine();
                        System.out.print("Nilai UAS Daspro Praktikum   : ");
                        nilai[i][8] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahDasproPraktik = (Double.parseDouble(nilai[i][6]) + Double.parseDouble(nilai[i][7])
                                + Double.parseDouble(nilai[i][8])) / 3;
                        nilai[i][9] = String.valueOf(jumlahDasproPraktik);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen3")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH MATEMATIKA DASAR");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][10], nilai[i][11], nilai[i][12], nilai[i][13]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("-----------------------MATDAS----------------------");
                        System.out.print("Nilai Tugas Matdas: ");
                        nilai[i][10] = inputScanner.nextLine();
                        System.out.print("Nilai UTS Matdas  : ");
                        nilai[i][11] = inputScanner.nextLine();
                        System.out.print("Nilai UAS Matdas  : ");
                        nilai[i][12] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahMatdas = (Double.parseDouble(nilai[i][10]) + Double.parseDouble(nilai[i][11])
                                + Double.parseDouble(nilai[i][12])) / 3;
                        nilai[i][13] = String.valueOf(jumlahMatdas);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen4")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PANCASILA");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][14], nilai[i][15], nilai[i][16], nilai[i][17]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("----------------------PANCASILA--------------------");
                        System.out.print("Nilai Tugas PANCASILA : ");
                        nilai[i][14] = inputScanner.nextLine();
                        System.out.print("Nilai UTS PANCASILA   : ");
                        nilai[i][15] = inputScanner.nextLine();
                        System.out.print("Nilai UAS PANCASILA   : ");
                        nilai[i][16] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahPancasila = (Double.parseDouble(nilai[i][14]) + Double.parseDouble(nilai[i][15])
                                + Double.parseDouble(nilai[i][16])) / 3;
                        nilai[i][17] = String.valueOf(jumlahPancasila);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen5")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH KTI");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][18], nilai[i][19], nilai[i][20], nilai[i][21]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("-------------------------KTI-----------------------");
                        System.out.print("Nilai Tugas KTI : ");
                        nilai[i][18] = inputScanner.nextLine();
                        System.out.print("Nilai UTS KTI   : ");
                        nilai[i][19] = inputScanner.nextLine();
                        System.out.print("Nilai UAS KTI   : ");
                        nilai[i][20] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahKTI = (Double.parseDouble(nilai[i][18]) + Double.parseDouble(nilai[i][19])
                                + Double.parseDouble(nilai[i][20])) / 3;
                        nilai[i][21] = String.valueOf(jumlahKTI);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen6")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH CTPS");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][22], nilai[i][23], nilai[i][24], nilai[i][25]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("-------------------------CTPS----------------------");
                        System.out.print("Nilai Tugas CTPS : ");
                        nilai[i][22] = inputScanner.nextLine();
                        System.out.print("Nilai UTS CTPS   : ");
                        nilai[i][23] = inputScanner.nextLine();
                        System.out.print("Nilai UAS CTPS   : ");
                        nilai[i][24] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahCTPS = (Double.parseDouble(nilai[i][22]) + Double.parseDouble(nilai[i][23])
                                + Double.parseDouble(nilai[i][24])) / 3;
                        nilai[i][25] = String.valueOf(jumlahCTPS);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen7")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH B Inggris");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][26], nilai[i][27], nilai[i][28], nilai[i][29]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("----------------------B.INGGRIS--------------------");
                        System.out.print("Nilai Tugas B.INGGRIS : ");
                        nilai[i][26] = inputScanner.nextLine();
                        System.out.print("Nilai UTS B.INGGRIS   : ");
                        nilai[i][27] = inputScanner.nextLine();
                        System.out.print("Nilai UAS B.INGGRIS   : ");
                        nilai[i][28] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahBing = (Double.parseDouble(nilai[i][26]) + Double.parseDouble(nilai[i][27])
                                + Double.parseDouble(nilai[i][28])) / 3;
                        nilai[i][29] = String.valueOf(jumlahBing);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }

        } else if (username.equalsIgnoreCase("dosen8")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH K3");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][30], nilai[i][31], nilai[i][32], nilai[i][33]);
                }
            }

            System.out.println("Cari data yang akan di update berdasarkan NIM");
            System.out.println("Apakah ingin mencari data?");
            System.out.println("yes / no");
            System.out.println("___________________________");
            inputScanner.nextLine();

            String jawab = inputScanner.nextLine();

            if (jawab.equalsIgnoreCase("yes")) {
                boolean finded = false;
                System.out.print("Masukkan key yang ingin dicari : ");
                key = inputScanner.nextLine();

                for (int i = 0; i < nilai.length; i++) {
                    if (key.equals(nilai[i][1])) {
                        System.out.println(
                                "===========================================================================================================================================");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0],
                                nilai[i][1], nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                        System.out.println(
                                "===========================================================================================================================================");

                        // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                        finded = true;
                    }
                    if (finded) {
                        System.out.println("NAMA MAHASISWA      : " + nilai[i][0]);
                        System.out.println("NIM MAHASISWA       : " + nilai[i][1]);
                        // --------------------------------------------------------------------------

                        System.out.println("-------------------------K-3-----------------------");
                        System.out.print("Nilai Tugas K3 : ");
                        nilai[i][30] = inputScanner.nextLine();
                        System.out.print("Nilai UTS K3   : ");
                        nilai[i][31] = inputScanner.nextLine();
                        System.out.print("Nilai UAS K3   : ");
                        nilai[i][32] = inputScanner.nextLine();
                        System.out.println("---------------------------------------------------");
                        System.out.println("\n");
                        double jumlahK3 = (Double.parseDouble(nilai[i][30]) + Double.parseDouble(nilai[i][31])
                                + Double.parseDouble(nilai[i][32])) / 3;
                        nilai[i][33] = String.valueOf(jumlahK3);

                        System.out.println("apakah ingin melakukan operasi selanjutnya?");
                        System.out.println("- ketikkan 1 untuk lanjut");
                        System.out.println("- ketikkan angka lainnya untuk logout");
                        int acc = inputScanner.nextInt();

                        if (acc == 1) {
                            return;
                        } else {
                            logOut();
                        }
                    }
                }
                if (!finded) {
                    System.out.println("Key dalam array tidak ditemukan");
                    berandaDosen();
                }
            }
        }
    }

    private static void cekNilaiMhsDosen() {
        if (username.equalsIgnoreCase("dosen1")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PEMOGRAMAN");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][2], nilai[i][3], nilai[i][4], nilai[i][5]);
                }
            }

            double MaxDaspro = Double.parseDouble(nilai[0][5]);
            double MinDaspro = Double.parseDouble(nilai[0][5]);

            // double maxNum = Daspro;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][5] != null && !nilai[i][5].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][5]);
                    if (value > MaxDaspro) {
                        MaxDaspro = value; // Maksimum ditemukan
                    }
                    if (value < MinDaspro) {
                        MinDaspro = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi dasar pemograman   : " + MaxDaspro);
            System.out.println("nilai minimum dasar pemograman   : " + MinDaspro);

        } else if (username.equalsIgnoreCase("dosen2")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PEMOGRAMAN PRAKTIKUM");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][6], nilai[i][7], nilai[i][8], nilai[i][9]);
                }
            }

            double MaxDasproPrak = Double.parseDouble(nilai[0][9]);
            double MinDasproPrak = Double.parseDouble(nilai[0][9]);

            // double maxNum = Daspro;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][9] != null && !nilai[i][9].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][9]);
                    if (value > MaxDasproPrak) {
                        MaxDasproPrak = value; // Maksimum ditemukan
                    }
                    if (value < MinDasproPrak) {
                        MinDasproPrak = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi Dasar Pemograman Praktikum   : " + MaxDasproPrak);
            System.out.println("nilai minimum Dasar Pemograman Praktikum     : " + MinDasproPrak);

        } else if (username.equalsIgnoreCase("dosen3")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH MATEMATIKA DASAR");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][10], nilai[i][11], nilai[i][12], nilai[i][13]);
                }
            }

            double MaxMatdas = Double.parseDouble(nilai[0][13]);
            double MinMatdas = Double.parseDouble(nilai[0][13]);

            // double maxNum = Daspro;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][13] != null && !nilai[i][13].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][13]);
                    if (value > MaxMatdas) {
                        MaxMatdas = value; // Maksimum ditemukan
                    }
                    if (value < MinMatdas) {
                        MinMatdas = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi Matematika Dasar   : " + MaxMatdas);
            System.out.println("nilai minimum Matematika Dasar     : " + MinMatdas);

        } else if (username.equalsIgnoreCase("dosen4")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH DASAR PANCASILA");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][14], nilai[i][15], nilai[i][16], nilai[i][17]);
                }
            }

            double MaxPancasila = Double.parseDouble(nilai[0][17]);
            double MinPancasila = Double.parseDouble(nilai[0][17]);

            // double maxNum = Pancasila;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][17] != null && !nilai[i][17].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][17]);
                    if (value > MaxPancasila) {
                        MaxPancasila = value; // Maksimum ditemukan
                    }
                    if (value < MinPancasila) {
                        MinPancasila = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi Pancasila   : " + MaxPancasila);
            System.out.println("nilai minimum Pancasila     : " + MinPancasila);

        } else if (username.equalsIgnoreCase("dosen5")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH KTI");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][18], nilai[i][19], nilai[i][20], nilai[i][21]);
                }
            }

            double MaxKTI = Double.parseDouble(nilai[0][21]);
            double MinKTI = Double.parseDouble(nilai[0][21]);

            // double maxNum = KTI;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][21] != null && !nilai[i][21].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][21]);
                    if (value > MaxKTI) {
                        MaxKTI = value; // Maksimum ditemukan
                    }
                    if (value < MinKTI) {
                        MinKTI = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi KTI   : " + MaxKTI);
            System.out.println("nilai minimum KTI    : " + MinKTI);

        } else if (username.equalsIgnoreCase("dosen6")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH CTPS");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][22], nilai[i][23], nilai[i][24], nilai[i][25]);
                }
            }

            double MaxCTPS = Double.parseDouble(nilai[0][25]);
            double MinCTPS = Double.parseDouble(nilai[0][25]);

            // double maxNum = CTPS;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][25] != null && !nilai[i][25].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][25]);
                    if (value > MaxCTPS) {
                        MaxCTPS = value; // Maksimum ditemukan
                    }
                    if (value < MinCTPS) {
                        MinCTPS = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi CTPS   : " + MaxCTPS);
            System.out.println("nilai minimum CTPS    : " + MinCTPS);

        } else if (username.equalsIgnoreCase("dosen7")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH B Inggris");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][26], nilai[i][27], nilai[i][28], nilai[i][29]);
                }
            }

            double MaxBING = Double.parseDouble(nilai[0][29]);
            double MinBING = Double.parseDouble(nilai[0][29]);

            // double maxNum = BING;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][29] != null && !nilai[i][29].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][29]);
                    if (value > MaxBING) {
                        MaxBING = value; // Maksimum ditemukan
                    }
                    if (value < MinBING) {
                        MinBING = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi B Inggris : " + MaxBING);
            System.out.println("nilai minimum B Inggris   : " + MinBING);

        } else if (username.equalsIgnoreCase("dosen8")) {
            // untuk menghitung data nilai yang ada nilainya(tidak null)
            int count = 0;
            for (String[] data : nilai) {
                if (data[0] != null) {
                    count++;
                }
            }
            // SORTING BY NAME
            int n = count;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nilai[j][0].compareTo(nilai[j + 1][0]) > 0) {
                        // swap nilai[j+1] and nilai[j]
                        String[] temp = nilai[j];
                        nilai[j] = nilai[j + 1];
                        nilai[j + 1] = temp;
                    }
                }
            }
            System.out.println("MATA KULIAH K3");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mahasiswa", "NIM", "nilai Tugas",
                    "nilai UTS", "Nilai UAS", "Rata-rata");
            System.out.printf(
                    "+-----------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][0] != null) {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", nilai[i][0], nilai[i][1],
                            nilai[i][30], nilai[i][31], nilai[i][32], nilai[i][33]);
                }
            }

            double MaxK3 = Double.parseDouble(nilai[0][33]);
            double MinK3 = Double.parseDouble(nilai[0][33]);

            // double maxNum = K3;

            for (int i = 0; i < nilai.length; i++) {
                if (nilai[i][33] != null && !nilai[i][33].trim().isEmpty()) {
                    double value = Double.parseDouble(nilai[i][33]);
                    if (value > MaxK3) {
                        MaxK3 = value; // Maksimum ditemukan
                    }
                    if (value < MinK3) {
                        MinK3 = value; // Minimum ditemukan
                    }
                }
            }

            System.out.println("nilai tertinggi K3 : " + MaxK3);
            System.out.println("nilai minimum  K3  : " + MinK3);

        }
    }

    private static void cekNilaiMhs() {

        for(int i = 0; i <= nilai.length; i++){

        }
        

        System.out.println("================= NILAI MAHASISWA ===============");
        System.out.println();
        if (username.equalsIgnoreCase("mahasiswa1")) {
        System.out.println("Nama Mahasiswa          : " + mahasiswa[0][0]);
        System.out.println("Nomor Induk Mahasiswa   : " + mahasiswa[0][1]);

        if(nilai[0][2] == null){
            nilai[0][2] = "0";
        }
        if (nilai[0][3] == null) {
            nilai[0][3] = "0";
        }
        if (nilai[0][4] == null) {
            nilai[0][4] = "0";
        }
        if (nilai[0][5] == null) {
            nilai[0][5] = "0";
        }
        if (nilai[0][6] == null) {
            nilai[0][6] = "0";
        }
        if (nilai[0][7] == null) {
            nilai[0][7] = "0";
        }
        if (nilai[0][8] == null) {
            nilai[0][8] = "0";
        }
        if (nilai[0][9] == null) {
            nilai[0][9] = "0";
        }
        if (nilai[0][10] == null) {
            nilai[0][10] = "0";
        }
        if (nilai[0][11] == null) {
            nilai[0][11] = "0";
        }
        if (nilai[0][12] == null) {
            nilai[0][12] = "0";
        }
        if (nilai[0][13] == null) {
            nilai[0][13] = "0";
        }
        if (nilai[0][14] == null) {
            nilai[0][14] = "0";
        }
        if (nilai[0][15] == null) {
            nilai[0][15] = "0";
        }
        if (nilai[0][16] == null) {
            nilai[0][16] = "0";
        }
        if (nilai[0][17] == null) {
            nilai[0][17] = "0";
        }
        if (nilai[0][18] == null) {
            nilai[0][18] = "0";
        }
        if (nilai[0][19] == null) {
            nilai[0][19] = "0";
        }
        if (nilai[0][20] == null) {
            nilai[0][20] = "0";
        }
        if (nilai[0][21] == null) {
            nilai[0][21] = "0";
        }
        if (nilai[0][22] == null) {
            nilai[0][22] = "0";
        }
        if (nilai[0][23] == null) {
            nilai[0][23] = "0";
        }
        if (nilai[0][24] == null) {
            nilai[0][24] = "0";
        }
        if (nilai[0][25] == null) {
            nilai[0][25] = "0";
        }
        if (nilai[0][26] == null) {
            nilai[0][26] = "0";
        }
        if (nilai[0][27] == null) {
            nilai[0][27] = "0";
        }
        if (nilai[0][28] == null) {
            nilai[0][28] = "0";
        }
        if (nilai[0][29] == null) {
            nilai[0][29] = "0";
        }
        if (nilai[0][30] == null) {
            nilai[0][30] = "0";
        }
        if (nilai[0][31] == null) {
            nilai[0][31] = "0";
        }
        if (nilai[0][32] == null) {
            nilai[0][32] = "0";
        }
        if (nilai[0][33] == null) {
            nilai[0][33] = "0";
        }

        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATKUL", "nilai Tugas", "nilai UTS", "Nilai UAS", "Rata-rata");
        System.out.printf("+------------------------------------------------------------------------------------------------------------------+\n");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPRO", nilai[0][2], nilai[0][3], nilai[0][4], nilai[0][5]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPROPRAKTIKUM", nilai[0][6], nilai[0][7], nilai[0][8], nilai[0][9]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATDAS", nilai[0][20], nilai[0][11], nilai[0][12], nilai[0][13]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "PANCASILA", nilai[0][14], nilai[0][15], nilai[0][16], nilai[0][17]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "KTI", nilai[0][18], nilai[0][19], nilai[0][20], nilai[0][21]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "CTPS", nilai[0][22], nilai[0][23], nilai[0][24], nilai[0][25]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "B.INGGRIS", nilai[0][26], nilai[0][27], nilai[0][28], nilai[0][29]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "K3", nilai[0][30], nilai[0][31], nilai[0][32], nilai[0][33]);

        }else if (username.equalsIgnoreCase("mahasiswa2")) {
            System.out.println("Nama Mahasiswa          : " + mahasiswa[1][0]);
            System.out.println("Nomor Induk Mahasiswa   : " + mahasiswa[1][1]);

        if(nilai[1][2] == null){
            nilai[1][2] = "0";
        }
        if (nilai[1][3] == null) {
            nilai[1][3] = "0";
        }
        if (nilai[1][4] == null) {
            nilai[1][4] = "0";
        }
        if (nilai[1][5] == null) {
            nilai[1][5] = "0";
        }
        if (nilai[1][6] == null) {
            nilai[1][6] = "0";
        }
        if (nilai[1][7] == null) {
            nilai[1][7] = "0";
        }
        if (nilai[1][8] == null) {
            nilai[1][8] = "0";
        }
        if (nilai[1][9] == null) {
            nilai[1][9] = "0";
        }
        if (nilai[1][10] == null) {
            nilai[1][10] = "0";
        }
        if (nilai[1][11] == null) {
            nilai[1][11] = "0";
        }
        if (nilai[1][12] == null) {
            nilai[1][12] = "0";
        }
        if (nilai[1][13] == null) {
            nilai[1][13] = "0";
        }
        if (nilai[1][14] == null) {
            nilai[1][14] = "0";
        }
        if (nilai[1][15] == null) {
            nilai[1][15] = "0";
        }
        if (nilai[1][16] == null) {
            nilai[1][16] = "0";
        }
        if (nilai[1][17] == null) {
            nilai[1][17] = "0";
        }
        if (nilai[1][18] == null) {
            nilai[1][18] = "0";
        }
        if (nilai[1][19] == null) {
            nilai[1][19] = "0";
        }
        if (nilai[1][20] == null) {
            nilai[1][20] = "0";
        }
        if (nilai[1][21] == null) {
            nilai[1][21] = "0";
        }
        if (nilai[1][22] == null) {
            nilai[1][22] = "0";
        }
        if (nilai[1][23] == null) {
            nilai[1][23] = "0";
        }
        if (nilai[1][24] == null) {
            nilai[1][24] = "0";
        }
        if (nilai[1][25] == null) {
            nilai[1][25] = "0";
        }
        if (nilai[1][26] == null) {
            nilai[1][26] = "0";
        }
        if (nilai[1][27] == null) {
            nilai[1][27] = "0";
        }
        if (nilai[1][28] == null) {
            nilai[1][28] = "0";
        }
        if (nilai[1][29] == null) {
            nilai[1][29] = "0";
        }
        if (nilai[1][30] == null) {
            nilai[1][30] = "0";
        }
        if (nilai[1][31] == null) {
            nilai[1][31] = "0";
        }
        if (nilai[1][32] == null) {
            nilai[1][32] = "0";
        }
        if (nilai[1][33] == null) {
            nilai[1][33] = "0";
        }

        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATKUL", "nilai Tugas", "nilai UTS", "Nilai UAS", "Rata-rata");
        System.out.printf("+------------------------------------------------------------------------------------------------------------------+\n");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPRO", nilai[1][2], nilai[1][3], nilai[1][4], nilai[1][5]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPROPRAKTIKUM", nilai[1][6], nilai[1][7], nilai[1][8], nilai[1][9]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATDAS", nilai[1][20], nilai[1][11], nilai[1][12], nilai[1][13]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "PANCASILA", nilai[1][14], nilai[1][15], nilai[1][16], nilai[1][17]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "KTI", nilai[1][18], nilai[1][19], nilai[1][20], nilai[1][21]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "CTPS", nilai[1][22], nilai[1][23], nilai[1][24], nilai[1][25]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "B.INGGRIS", nilai[1][26], nilai[1][27], nilai[1][28], nilai[1][29]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "K3", nilai[1][30], nilai[1][31], nilai[1][32], nilai[1][33]);

        }else if (username.equalsIgnoreCase("mahasiswa3")) {
            System.out.println("Nama Mahasiswa          : " + mahasiswa[2][1]);
            System.out.println("Nomor Induk Mahasiswa   : " + mahasiswa[2][0]);

            if(nilai[2][2] == null){
            nilai[2][2] = "0";
        }
        if (nilai[2][3] == null) {
            nilai[2][3] = "0";
        }
        if (nilai[2][4] == null) {
            nilai[2][4] = "0";
        }
        if (nilai[2][5] == null) {
            nilai[2][5] = "0";
        }
        if (nilai[2][6] == null) {
            nilai[2][6] = "0";
        }
        if (nilai[2][7] == null) {
            nilai[2][7] = "0";
        }
        if (nilai[2][8] == null) {
            nilai[2][8] = "0";
        }
        if (nilai[2][9] == null) {
            nilai[2][9] = "0";
        }
        if (nilai[2][10] == null) {
            nilai[2][10] = "0";
        }
        if (nilai[2][11] == null) {
            nilai[2][11] = "0";
        }
        if (nilai[2][12] == null) {
            nilai[2][12] = "0";
        }
        if (nilai[2][13] == null) {
            nilai[2][13] = "0";
        }
        if (nilai[2][14] == null) {
            nilai[2][14] = "0";
        }
        if (nilai[2][15] == null) {
            nilai[2][15] = "0";
        }
        if (nilai[2][16] == null) {
            nilai[2][16] = "0";
        }
        if (nilai[2][17] == null) {
            nilai[2][17] = "0";
        }
        if (nilai[2][18] == null) {
            nilai[2][18] = "0";
        }
        if (nilai[2][19] == null) {
            nilai[2][19] = "0";
        }
        if (nilai[2][20] == null) {
            nilai[2][20] = "0";
        }
        if (nilai[2][21] == null) {
            nilai[2][21] = "0";
        }
        if (nilai[2][22] == null) {
            nilai[2][22] = "0";
        }
        if (nilai[2][23] == null) {
            nilai[2][23] = "0";
        }
        if (nilai[2][24] == null) {
            nilai[2][24] = "0";
        }
        if (nilai[2][25] == null) {
            nilai[2][25] = "0";
        }
        if (nilai[2][26] == null) {
            nilai[2][26] = "0";
        }
        if (nilai[2][27] == null) {
            nilai[2][27] = "0";
        }
        if (nilai[2][28] == null) {
            nilai[2][28] = "0";
        }
        if (nilai[2][29] == null) {
            nilai[2][29] = "0";
        }
        if (nilai[2][30] == null) {
            nilai[2][30] = "0";
        }
        if (nilai[2][31] == null) {
            nilai[2][31] = "0";
        }
        if (nilai[2][32] == null) {
            nilai[2][32] = "0";
        }
        if (nilai[2][33] == null) {
            nilai[2][33] = "0";
        }

        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATKUL", "nilai Tugas", "nilai UTS", "Nilai UAS", "Rata-rata");
        System.out.printf("+------------------------------------------------------------------------------------------------------------------+\n");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPRO", nilai[2][2], nilai[2][3], nilai[2][4], nilai[2][5]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "DASPROPRAKTIKUM", nilai[2][6], nilai[2][7], nilai[2][8], nilai[2][9]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "MATDAS", nilai[2][20], nilai[2][11], nilai[2][12], nilai[2][13]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "PANCASILA", nilai[2][14], nilai[2][15], nilai[2][16], nilai[2][17]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "KTI", nilai[2][18], nilai[2][19], nilai[2][20], nilai[2][21]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "CTPS", nilai[2][22], nilai[2][23], nilai[2][24], nilai[2][25]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "B.INGGRIS", nilai[2][26], nilai[2][27], nilai[2][28], nilai[2][29]);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |\n", "K3", nilai[2][30], nilai[2][31], nilai[2][32], nilai[2][33]);
        }
    }

    private static void cekJadwalKuliah() {

        inputScanner.nextLine();
        System.out.println("========================== CEK JADWAL KULIAH ==========================");
        System.out.print("Masukkan kelas : ");
        String kelas = inputScanner.nextLine();

        String[][] jadwalMatkul1f = {
                { "Senin", "10:35-14:25", "Konsep Teknologi Informasi", "Yuri Ariyanto, S.Kom., M.Kom." },
                { "Selasa", "09:30-13:15", "Critical Thinking dan Problem Solving", "Dwi Puspitasari, S.Kom., M.Kom." },
                { "Rabu", "07:00-10:35", "Keselamatan dan Kesehatan Kerja",
                        "Ariadi Retno Tri Hayati Ririd, S.Kom., M.Kom." },
                { "Rabu", "11:25-13:35", "Pancasila", "Widaningsih, S.H., M.H." },
                { "Rabu", "13:35-16:00", "Bahasa Inggris 1", "Satrio Binusa Suryadi, S.S., M.Pd." },
                { "Kamis", "07:00-09:15", "Matematika Dasar", "Yan Watequlis Syaifudin, S.T., M.MT., Ph.D." },
                { "Kamis", "11:00-17:10", "Praktikum Dasar Pemrograman", "Noprianto, S.Kom., M.Eng." },
                { "Jumat", "07:00-10:00", "Praktikum Dasar Pemrograman", "Noprianto, S.Kom., M.Eng." },
                { "Jumat", "07:00-10:00", "Matematika Dasar", "Yan Watequlis Syaifudin, S.T., M.MT., Ph.D." }
        };
        
        String [][] jadwalMatkul1a = {
            { "Senin", "07:50-11:20", "Critical Thinking dan Problem Solving", "****************"},
            { "Senin", "14:30-17:10", "Matematika Dasar", "********" },
            { "Selasa", "07:00-09:30", "Matematika Dasar", "********" },
            { "Selasa", "10:30-14:30", "Dasar Pemrograman", "********" },
            { "Rabu", "07:00-12:10", "Praktikum Dasar Pemrograman", "*********" },
            { "Kamis", "07:50-09:30", "Pancasila", "********" },
            { "Kamis", "09:30-12:10", "Bahasa Inggris 1", "***********" },
            { "Jumat", "07:00-10:30", "Konsep Teknologi Informasi", "**********" },
            { "Jumat", "11:20-15:20", "Keselamatan dan Kesehatan Kerja", "************" }
        };

        String[][] jadwalMatkul1c = {
                { "Senin", "07:00-09:30", "Matematika Dasar", "**********" },
                { "Senin", "11:20-13:40", "Pancasila", "********" },
                { "Senin", "13:40-17:10", "Critical Thinking dan Problem Solving",
                        "************" },
                { "Selasa", "11:20-15:20", "Dasar Pemrograman", "********" },
                { "Rabu", "10:30-16:20", "Praktikum Dasar Pemrograman", "*********" },
                { "Rabu", "07:00-10:30", "Bahasa Inggris 1", "***********" },
                { "Kamis", "12:50-16:20", "Konsep Teknologi Informasi", "**********" },
                { "Jumat", "07:00-09:30", "Matematika Dasar", "**********" },
                { "Jumat", "12:50-16:20", "Keselamatan dan Kesehatan Kerja", "************" }
        };

        String [][] jadwalMatkul1h = {
            { "Senin", "10:30-14:30", "Critical Thinking dan Problem Solving", "****************"},
            { "Senin", "14:30-17:10", "Matematika Dasar", "********" },
            { "Selasa", "07:00-09:30", "Matematika Dasar", "********" },
            { "Selasa", "10:30-14:30", "Dasar Pemrograman", "********" },
            { "Rabu", "07:00-12:10", "Praktikum Dasar Pemrograman", "*********" },
            { "Rabu", "12:50-16:20", "Bahasa Inggris 1", "***********" },
            { "Kamis", "10:30-14:30", "Konsep Teknologi Informasi", "**********" },
            { "Kamis", "15:30-17:10", "Pancasila", "********" },
            { "Jumat", "10:30-14:30", "Keselamatan dan Kesehatan Kerja", "************" }
        };
        
        String [][] jadwalMatkul1d = {
            { "Senin", "07:50-11:20", "Bahasa Inggris 1", "****************"},
            { "Senin", "13:40-17:10", "Critical Thinking dan Problem Solving", "****************"},
            { "Selasa", "07:00-08:40", "Pancasila", "********" },
            { "Selasa", "09:40-13:40", "Dasar Pemrograman", "********" },
            { "Selasa", "13:40-17:10", "Keselamatan dan Kesehatan Kerja", "************" },
            { "Rabu", "11:20-17:10", "Praktikum Dasar Pemrograman", "*********" },
            { "Kamis", "07:00-09:30", "Matematika Dasar", "********" },
            { "Kamis", "12:50-16:20", "Konsep Teknologi Informasi", "**********" },
            { "Jumat", "14:30-17:10", "Matematika Dasar", "********" }
        };

        String [][] jadwalMatkul1b = {
            { "Senin", "07:00-09:30", "Matematika Dasar", "********" },
            { "Senin", "11:20-17:10", "Praktikum Dasar Pemrograman", "*********" },
            { "Selasa", "08:40-12:10", "Bahasa Inggris 1", "****************"},
            { "Rabu", "09:40-13:40", "Dasar Pemrograman", "********" },
            { "Rabu", "13:40-17:10", "Konsep Teknologi Informasi", "**********" },
            { "Kamis", "07:00-10:30", "Critical Thinking dan Problem Solving", "****************"},
            { "Kamis", "10:30-12:10", "Pancasila", "********" },
            { "Kamis", "13:40-17:10", "Keselamatan dan Kesehatan Kerja", "************" },
            { "Jumat", "07:00-09:30", "Matematika Dasar", "********" }
        };

        String[][] jadwalMatkul1e = {
            { "Senin", "07:50-14:30", "Praktikum Dasar Pemrograman", "*********" },
            { "Senin", "14:30-17:10", "Matematika Dasar", "********" },
            { "Selasa", "08:40-12:10", "Bahasa Inggris 1", "****************"},
            { "Rabu", "09:40-13:40", "Dasar Pemrograman", "********" },
            { "Rabu", "13:40-17:10", "Konsep Teknologi Informasi", "**********" },
            { "Kamis", "07:00-10:30", "Critical Thinking dan Problem Solving", "****************"},
            { "Kamis", "10:30-12:10", "Pancasila", "********" },
            { "Kamis", "13:40-17:10", "Keselamatan dan Kesehatan Kerja", "************"},
            { "Jumat", "07:00-09:30", "Matematika Dasar", "********" }
             
        };

        if (kelas.equalsIgnoreCase("1f") || kelas.equalsIgnoreCase("1-f")) {
            System.out.println("========================== JADWAL KULIAH 1-F ==========================");
            System.out.println();
            System.out.printf("| %-20s | %-20s | %-50s | %-50s |\n", "HARI", "JAM", "MATA KULIAH", "DOSEN");
            System.out.printf(
                    "+-------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < jadwalMatkul1f.length; i++) {
                // System.out.println(jadwalMatkul1f[i][0] + jadwalMatkul1f[i][1]+
                // jadwalMatkul1f[i][1]+ jadwalMatkul1f[i][3]);
                System.out.printf("| %-20s | %-20s | %-50s | %-50s |\n", jadwalMatkul1f[i][0], jadwalMatkul1f[i][1],
                        jadwalMatkul1f[i][2], jadwalMatkul1f[i][3]);

            }
        } else if (kelas.equalsIgnoreCase("1c") || kelas.equalsIgnoreCase("1-c")) {
            System.out.println("========================== JADWAL KULIAH 1-C ==========================");
            System.out.println();
            System.out.printf("| %-20s | %-20s | %-50s | %-50s |\n", "HARI", "JAM", "MATA KULIAH", "DOSEN");
            System.out.printf(
                    "+-------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < jadwalMatkul1c.length; i++) {
                // System.out.println(jadwalMatkul1c[i][0] + jadwalMatkul1c[i][1]+
                // jadwalMatkul1c[i][1]+ jadwalMatkul1c[i][3]);
                System.out.printf("| %-20s | %-20s | %-50s | %-50s |\n", jadwalMatkul1c[i][0], jadwalMatkul1c[i][1],
                        jadwalMatkul1c[i][2], jadwalMatkul1c[i][3]);

            }
        }

    }

    private static void updKrsMhs() {

        System.out.println("========================== UPDATE DATA KRS MAHASISWA ==========================");
        System.out.print("Masukkan Semester : ");
        int semester = inputScanner.nextInt();

        if (semester == 1) {
            System.out.println("========================== KRS SEMESTER 1 ==========================");
            System.out.println();
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
            System.out.printf("| %-20s | %-40s | %-10s | %-10s | %-10s |\n", "KODE MK", "MATA KULIAH", "SEMESTER",
                    "SKS", "JAM");
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < krsMhs1.length; i++) {
                System.out.printf("| %-20s | %-40s | %-10s | %-10s | %-10s |\n", krsMhs1[i][0], krsMhs1[i][1],
                        krsMhs1[i][2], krsMhs1[i][3], krsMhs1[i][4]);
            }
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
        }
        System.out.println("Cari data yang akan di update berdasarkan Kode MK");
        System.out.println("Apakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("___________________________");

        inputScanner.nextLine();

        String jawab = inputScanner.nextLine();

        if (jawab.equalsIgnoreCase("yes")) {
            boolean finded = false;
            System.out.print("Masukkan key yang ingin dicari : ");
            key = inputScanner.nextLine();

            for (int i = 0; i < krsMhs1.length; i++) {
                if (key.equals(krsMhs1[i][0])) {
                    System.out.println("=======================");
                    System.out.println("KODE MK       : " + krsMhs1[i][0]);
                    System.out.println("MATA KULIAH   : " + krsMhs1[i][1]);
                    System.out.println("SEMESTER      : " + krsMhs1[i][2]);
                    System.out.println("SKS           : " + krsMhs1[i][3]);
                    System.out.println("JAM           : " + krsMhs1[i][4]);
                    System.out.println("=======================");
                    System.out.println();
                    System.out.println("Modified data by : " + krsMhs1[i][5]);

                    // jika nilai dalam if bernilai benar maka rubah value finded menjadi true
                    finded = true;
                }
                if (finded) {
                    System.out.println("===================DATA KRS MAHASISWA ===================");
                    inputScanner.nextLine();
                    System.out.print("masukkan Kode MK             :");
                    krsMhs1[i][0] = inputScanner.nextLine();
                    System.out.print("masukkan Mata Kuliah         :");
                    krsMhs1[i][1] = inputScanner.nextLine();
                    System.out.print("masukkan Semester            :");
                    krsMhs1[i][2] = inputScanner.nextLine();
                    System.out.print("masukkan SKS                 :");
                    krsMhs1[i][3] = inputScanner.nextLine();
                    System.out.print("masukkan Jam                 :");
                    krsMhs1[i][4] = inputScanner.nextLine();

                    System.out.println("DATA BERHASIL DI UPDATE\n");
                    System.out.println(" yang melakukan perubahan adalah : " + username);
                    krsMhs1[i][5] = username;
                    break;
                }
            }
            if (!finded) {
                System.out.println("Key dalam array tidak ditemukan");
            } else if (finded) {
                System.out.println("apakah ingin melakukan operasi selanjutnya?");
                System.out.println("- ketikkan 1 untuk lanjut");
                System.out.println("- ketikkan angka lainnya untuk logout");
                int acc = inputScanner.nextInt();

                if (acc == 1) {
                    return;
                } else {
                    logOut();
                }
            }
        }
    }

    private static void cekDataKrsMhs() {

        System.out.println("========================== CEK DATA KRS MAHASISWA ==========================");
        System.out.print("Masukkan Semester : ");
        int semester = inputScanner.nextInt();

        if (semester == 1) {
            System.out.println("========================== KRS SEMESTER 1 ==========================");
            System.out.println();
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
            System.out.printf("| %-20s | %-40s | %-10s | %-10s | %-10s |\n", "KODE MK", "MATA KULIAH", "SEMESTER",
                    "SKS", "JAM");
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
            for (int i = 0; i < krsMhs1.length; i++) {
                System.out.printf("| %-20s | %-40s | %-10s | %-10s | %-10s |\n", krsMhs1[i][0], krsMhs1[i][1],
                        krsMhs1[i][2], krsMhs1[i][3], krsMhs1[i][4]);
            }
            System.out.printf(
                    "+--------------------------------------------------------------------------------------------------------+\n");
        }
    }

    public static void cetakKtm() {

        String choice;
        System.out.println("=========== CETAK KARTU MAHASISWA ===========");
        System.out.println();
        inputScanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa yang ingin dicari : ");
        key = inputScanner.nextLine();
        for (int i = 0; i < mahasiswa.length; i++) {
            if (key.equals(mahasiswa[i][1])) {
                System.out.println("=======================");
                System.out.println(mahasiswa[i][0]); // Nama
                System.out.println(mahasiswa[i][1]); // Nim
                System.out.println(mahasiswa[i][4]); // Kelas
                System.out.println(mahasiswa[i][2]); // Jurusan
                System.out.println(mahasiswa[i][3]); // Prodi
                System.out.println("=======================");
            }
            System.out.println();
            System.out.println("Apakah anda ingin mencetak Kartu Tanda Mahasiswa ini? (Ya/Tidak)");
            System.out.print("masukkan pilihan : ");
            choice = inputScanner.next();
            if (choice.equalsIgnoreCase("Ya")) {
                System.out.println("Silahkan mencetak KTM di Ruang Admin.");
                break;
            } else if (choice.equalsIgnoreCase("Tidak")) {
                break;
            }
        }
    }

    public static void contact() {

        System.out.println("============ CONTACT ============");
        while (true) {
            int i = 0;
            while (i < contact.length) {
                inputScanner.nextLine();
                System.out.print("masukkan nama : ");
                contact[i][0] = inputScanner.nextLine();
                System.out.print("masukkan nim : ");
                contact[i][1] = inputScanner.nextLine();
                System.out.print("masukkan pesan : ");
                contact[i][2] = inputScanner.nextLine();

                System.out.println("Pesan anda sedang diproses");
                break;
            }
            break;
        }

    }

    public static void contactAdmin() {
        System.out.println("================= CONTACT ===============");
        System.out.println();
        System.out.printf("| %-20s | %-15s | %-50s |\n", "Nama", "NIM", "Pesan");
        System.out.printf(
                "-----------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < contact.length; i++) {
            if (contact[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-50s |\n",
                        contact[i][0], contact[i][1], contact[i][2]);
            }
        }

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
