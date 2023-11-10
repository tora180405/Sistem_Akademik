import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemAkademik {
    // deklarasi variable global
    // private static int levelAcc;
    ;
    // Deklarasi Variable untuk fitur search dari semua fitur
    public static String key;
    public static boolean search = true;
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
    public static int counter;

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
            int i = counter;
            mahasiswa = new String[4000][9];

            while (i < mahasiswa.length) {
                System.out.println("\n");

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
                i++;

                System.out.println("=======================================================");
                System.out.print("APAKAH ANDA INGIN MENAMBAHKAN DATA MAHASISWA LAGI ?");

                System.out.println("\n");

                System.out.println("1. untuk ya");
                System.out.println("2. untuk tidak");

                System.out.println("masukkan pilihan : ");
                choice = inputScanner.nextInt();

                if (choice == 1) {
                    counter = i;

                } else if (choice == 2) {
                    // berandaAdmin();
                    inpData = false;
                    break;
                } else {
                    System.out.println("pilihan anda tidak valid");
                    inDataMhs();
                }

            }
            counter = i;
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
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.println("================= UPDATE DATA MAHASISWA ===============");
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

            for (int i = 0; i < mahasiswa.length; i++) {
                if (key.equals(mahasiswa[i][1])) {
                    System.out.println("=======================");
                    System.out.println("NAMA          : " + mahasiswa[i][0]);
                    System.out.println("NIM           : " + mahasiswa[i][1]);
                    System.out.println("JENIS KELAMIN : " + mahasiswa[i][2]);
                    System.out.println("KELAS         : " + mahasiswa[i][3]);
                    System.out.println("AGAMA         : " + mahasiswa[i][4]);
                    System.out.println("TGL LAHIR     : " + mahasiswa[i][5]);
                    System.out.println("EMAIL         : " + mahasiswa[i][6]);
                    System.out.println("NO TELP       : " + mahasiswa[i][7]);
                    System.out.println("ALAMAT        : " + mahasiswa[i][8]);
                    System.out.println("=======================");
                    System.out.println();

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

                    System.out.println("DATA BERHASIL DI UPDATE\n");
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
        System.out.println("Apakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("___________________________");
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
                    System.out.println("JENIS KELAMIN : " + mahasiswa[i][2]);
                    System.out.println("KELAS         : " + mahasiswa[i][3]);
                    System.out.println("AGAMA         : " + mahasiswa[i][4]);
                    System.out.println("TGL LAHIR     : " + mahasiswa[i][5]);
                    System.out.println("EMAIL         : " + mahasiswa[i][6]);
                    System.out.println("NO TELP       : " + mahasiswa[i][7]);
                    System.out.println("ALAMAT        : " + mahasiswa[i][8]);
                    System.out.println("=======================");
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

    public static String[][] nilai;

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
            nilai = new String[4000][4];

            for (int i = 0; i < nilai.length; i++) {
                if (mahasiswa[i][0] != null) {
                    System.out.println("================= DATA MAHASISWA ===============");
                    inputScanner.nextLine();
                    System.out.println("NAMA          : ");
                    System.out.println("Nilai Tugas   : ");
                    nilai[i][1] = inputScanner.nextLine();

                    System.out.println("DATA BERHASIL DI TAMBAHKAN\n");

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
                        // berandaAdmin();
                        inpData = false;
                    } else {
                        System.out.println("pilihan anda tidak valid");
                        inDataMhs();
                    }
            }
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

    private static void cekJadwalKuliah() {
        System.out.println("========================== CEK JADWAL KULIAH ==========================");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|" + "NO" + "|" + "HARI   " + "|" + "JAM           " + "|" + "MATA KULIAH                           "
                        + "|" + "DOSEN                                         " + "|");
        System.out.println(
                "|" + "1 " + "|" + "Senin  " + "|" + "10:35 - 14:25 " + "|" + "Konsep Teknologi Informasi            "
                        + "|" + "Yuri Ariyanto, S.Kom., M.Kom.                 " + "|");
        System.out.println(
                "|" + "2 " + "|" + "Selasa " + "|" + "09:30 - 13:15 " + "|" + "Critical Thinking dan Problem Solving "
                        + "|" + "Dwi Puspitasari, S.Kom., M.Kom.               " + "|");
        System.out.println(
                "|" + "3 " + "|" + "Rabu   " + "|" + "07:00 - 10:35 " + "|" + "Keselamatan dan Kesehatan Kerja       "
                        + "|" + "Ariadi Retno Tri Hayati Ririd, S.Kom., M.Kom. " + "|");
        System.out.println(
                "|" + "4 " + "|" + "Rabu   " + "|" + "11:25 - 13:35 " + "|" + "Pancasila                             "
                        + "|" + "Widaningsih, S.H., M.H.                       " + "|");
        System.out.println(
                "|" + "5 " + "|" + "Rabu   " + "|" + "13:35 - 16:00 " + "|" + "Bahasa Inggris 1                      "
                        + "|" + "Satrio Binusa Suryadi, S.S., M.Pd.            " + "|");
        System.out.println(
                "|" + "6 " + "|" + "Kamis  " + "|" + "07:00 - 09:15 " + "|" + "Matematika Dasar                      "
                        + "|" + "Yan Watequlis Syaifudin, S.T., M.MT., Ph.D.   " + "|");
        System.out.println(
                "|" + "7 " + "|" + "Kamis  " + "|" + "11:00 - 17:10 " + "|" + "Praktikum Dasar Pemrograman           "
                        + "|" + "Noprianto, S.Kom., M.Eng.                     " + "|");
        System.out.println(
                "|" + "8 " + "|" + "Jumat  " + "|" + "07:00 - 10:00 " + "|" + "Dasar Pemrograman                     "
                        + "|" + "Noprianto, S.Kom., M.Eng.                     " + "|");
        System.out.println(
                "|" + "9 " + "|" + "Jumat  " + "|" + "07:00 - 10:00 " + "|" + "Matematika Dasar                      "
                        + "|" + "Yan Watequlis Syaifudin, S.T., M.MT., Ph.D.   " + "|");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------");
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