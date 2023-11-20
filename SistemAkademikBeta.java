
import java.util.Scanner;

/**
 * SistemAkademikBeta
 */
public class SistemAkademikBeta {
  public static Scanner inputScanner = new Scanner(System.in);

    // deklarasi array untuk fitur input data mahasiswa
    public static String[][] mahasiswa;
    public static int counter;

    public static String jawab;

    public static int n = 0;
    public static int count = 0;

    // deklarasi array untuk data nilai mahasiswa
    public static String[][] nilai;

    //     // deklarasi variable global untuk fitur contact
    public static String nama, pesan;
    public static int nim;

    // deklarasi array krs
    public static String krsMhs1[][];

    public static String jadwalMatkul1f[][];

  // Deklarasi Variable untuk fitur search dari semua fitur
  public static String key;
  public static boolean search = true;

  public static void logOut() {
    System.out.println("Anda telah logout");
    // Redirect user to login page
    System.exit(0);
}
  public static void main(String[] args) {
    String[][] dataLog = {
      { "admin", "admin" },
      { "dosen", "dosen" },
      { "mahasiswa", "mahasiswa" }
};
    String username, password;
    int attempts = 0;

    while (attempts < 3) {
      boolean isLoggedOut = false;

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
        System.out.println("\n");

        // berandaAdmin();
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
          System.out.println("4. Cek Nilai Mahasiswa");
          System.out.println("5. Cek Jadwal Perkuliahan");
          System.out.println("6. Update KRS Mahasiswa");
          System.out.println("7. Cek Data KRS Mahasiswa");
          System.out.println("8. Contact");
          System.out.println("0. LogOut\n");  

          System.out.print("Masukkan pilihan anda: ");
          int choice = inputScanner.nextInt();
          switch (choice) {
            case 1:
              // inDataMhs();
              // int choice;

              do {
                // seleksi lagi, jika pilihan selain 1 dan 2 akan diarahkan kembali ke input
                // data mahasiswa tetapi dengan catatan pilihan tidak valid
                // memang hampir sama dengan kita menginputkan nilai 1, tetapi yang membedakan
                // adalah statement yang diberikan jika nilai yang diinputkan selain 1 dan 2
                if (choice != 1 && choice != 2) {
                  System.out.println("Pilihan anda tidak valid");
                }

                System.out.println("============================================");
                System.out.println("=             INPUT DATA MAHASISWA         =");
                System.out.println("============================================");
                System.out.println("| Ketik 0 untuk kembali ke menu sebelumnya |");
                System.out.println("| Ketik angka lain untuk lanjut            |");
                System.out.println("============================================");
                choice = inputScanner.nextInt();
                if (choice == 0) {
                  break;
                  // return;
                }

                System.out.println("\n");
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
                            return;
                            // inDataMhs();
                        }
        
                    }
                    counter = i;
                    break;
                }

              }

              // berandaAdmin();
              // akan melakukan perulangan jika yang dipilih adalah 1, atau selain angka 1 dan
              // 2 yang kemudian nantinya akan diseleksi lagi pada saat kembali ke do
              // selain angka 1 dan 2 ini nanti akan diseleksi lagi
              while (choice == 1 || (choice != 1 && choice != 2));

              // jadi ketika kita menginputkan angka 2 akan kembali ke menu beranda admin.
              // karna bernilai false.

              break;
            case 2:
              // updDataMhs();
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
        System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n", "Nama", "NIM", "Jenis Kelamin", "Kelas",
                "Agama");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
                // System.out.println("TGL LAHIR : " + mahasiswa[i][5]);
                // System.out.println("EMAIL : " + mahasiswa[i][6]);
                // System.out.println("NO TELP : " + mahasiswa[i][7]);
                // System.out.println("ALAMAT : " + mahasiswa[i][8]);
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
          break;
            case 3:
        count = 0;
        n = 0;
       // untuk menghitung data mahasiswa yang ada nilainya(tidak null)
        for (String[] data : mahasiswa) {
            if (data[0] != null) {
                count++;
            }
        }
        // SORTING BY NAME
        n = count;
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
        System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n", "Nama", "NIM", "Jenis Kelamin", "Kelas",
                "Agama");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
                // System.out.println("TGL LAHIR : " + mahasiswa[i][5]);
                // System.out.println("EMAIL : " + mahasiswa[i][6]);
                // System.out.println("NO TELP : " + mahasiswa[i][7]);
                // System.out.println("ALAMAT : " + mahasiswa[i][8]);
            }

        }
        System.out.println("\nApakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("___________________________");
        inputScanner.nextLine();
        jawab = inputScanner.nextLine();

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

              break;
            case 4:
              // inNilaiMhs();
              break;
            case 5:
              // updNilaiMhs();
              break;
            case 6:
              // cekJadwalKuliah();
              break;
            case 7:
              // updKrsMhs();
              break;
            case 8:
              // cekDataKrsMhs();
              break;
            case 9:
              // contactAdmin();
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
          
                  System.out.println("apakah ingin melakukan operasi selanjutnya?");
                  System.out.println("- ketikkan 1 untuk lanjut");
                  System.out.println("- ketikkan angka lainnya untuk logout");
                  acc = inputScanner.nextInt();

                  if (acc == 1) {
                    break;
                  } else {
                    // logOut();
                    System.out.println("Anda telah logout");
                    isLoggedOut = true; // Mengatur isLoggedOut menjadi true
                    break; // Keluar dari switch case
                  }
              

              // break;s
            case 0:
              // logOut();
              System.out.println("Anda telah logout");
              isLoggedOut = true; // Mengatur isLoggedOut menjadi true
              break; // Keluar dari switch case
            default:
              System.out.println("Pilihan tidak valid.");
          }

          // fitur logout
          if (isLoggedOut) {
            break; // Keluar dari loop while
          }
        }

      } else if (dataLog[1][0].equals(username) && dataLog[1][1].equals(password)) {
        System.out.println("Selamat datang " + username);
        System.out.println("\n");

        // berandaDosen();
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
          System.out.println("0. LogOut\n");

          System.out.print("Masukkan pilihan anda: ");

          int choice = inputScanner.nextInt();
          switch (choice) {
            case 1:
              // cekDataMhs();
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
        System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n", "Nama", "NIM", "Jenis Kelamin", "Kelas",
                "Agama");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
                // System.out.println("TGL LAHIR : " + mahasiswa[i][5]);
                // System.out.println("EMAIL : " + mahasiswa[i][6]);
                // System.out.println("NO TELP : " + mahasiswa[i][7]);
                // System.out.println("ALAMAT : " + mahasiswa[i][8]);
            }

        }
        System.out.println("\nApakah ingin mencari data?");
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
              break;
            case 2:
              // inNilaiMhs();
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
                  nilai = new String[4000][34];
      
                  // int i = 0;
      
                  // while (i < mahasiswa.length) {
      
                  // }
      
                  for (int i = 0; i < mahasiswa.length; i++) {
                      System.out.println("================= NILAI MAHASISWA ===============");
                      inputScanner.nextLine();
                      if (mahasiswa[i][0] != null) {
                          for (int j = 0; j < nilai.length; j++) {
                              // mengisi array nilai pada kolom 0 dengan mahasiswa kolom 0 yang berisi nama
                              nilai[j][0] = mahasiswa[i][0];
                              System.out.println("NAMA MAHASISWA      : " + nilai[j][0]);
                              // --------------------------------------------------------------------------
      
                              // int NIM = Integer.parseInt(mahasiswa[i++][1]);
      
                              // mengisi array nilai pada kolom 1 dengan mahasiswa kolom 1 yang berisi NIM
                              // nilai[j][1] = String.valueOf(NIM);
                              nilai[j][1] = mahasiswa[i++][1];
                              System.out.println("NIM MAHASISWA       : " + nilai[j][1]);
                              // --------------------------------------------------------------------------
      
                              // input nilai setiap matkul uwaw banyak kali
                              System.out.println("-----------------------DASPRO----------------------");
                              System.out.print("Nilai Tugas Daspro  : ");
                              nilai[j][2] = inputScanner.nextLine();
                              System.out.print("Nilai UTS Daspro    : ");
                              nilai[j][3] = inputScanner.nextLine();
                              System.out.print("Nilai UAS Daspro    : ");
                              nilai[j][4] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("------------------DASPRO PRAKTIKUM-----------------");
                              System.out.print("Nilai Tugas Daspro Praktikum : ");
                              nilai[j][6] = inputScanner.nextLine();
                              System.out.print("Nilai UTS Daspro Praktikum   : ");
                              nilai[j][7] = inputScanner.nextLine();
                              System.out.print("Nilai UAS Daspro Praktikum   : ");
                              nilai[j][8] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("-----------------------MATDAS----------------------");
                              System.out.print("Nilai Tugas Matdas: ");
                              nilai[j][10] = inputScanner.nextLine();
                              System.out.print("Nilai UTS Matdas  : ");
                              nilai[j][11] = inputScanner.nextLine();
                              System.out.print("Nilai UAS Matdas  : ");
                              nilai[j][12] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("----------------------PANCASILA--------------------");
                              System.out.print("Nilai Tugas PANCASILA : ");
                              nilai[j][14] = inputScanner.nextLine();
                              System.out.print("Nilai UTS PANCASILA   : ");
                              nilai[j][15] = inputScanner.nextLine();
                              System.out.print("Nilai UAS PANCASILA   : ");
                              nilai[j][16] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("-------------------------KTI-----------------------");
                              System.out.print("Nilai Tugas KTI : ");
                              nilai[j][18] = inputScanner.nextLine();
                              System.out.print("Nilai UTS KTI   : ");
                              nilai[j][19] = inputScanner.nextLine();
                              System.out.print("Nilai UAS KTI   : ");
                              nilai[j][20] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("-------------------------CTPS----------------------");
                              System.out.print("Nilai Tugas CTPS : ");
                              nilai[j][22] = inputScanner.nextLine();
                              System.out.print("Nilai UTS CTPS   : ");
                              nilai[j][23] = inputScanner.nextLine();
                              System.out.print("Nilai UAS CTPS   : ");
                              nilai[j][24] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("----------------------B.INGGRIS--------------------");
                              System.out.print("Nilai Tugas B.INGGRIS : ");
                              nilai[j][26] = inputScanner.nextLine();
                              System.out.print("Nilai UTS B.INGGRIS   : ");
                              nilai[j][27] = inputScanner.nextLine();
                              System.out.print("Nilai UAS B.INGGRIS   : ");
                              nilai[j][28] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              System.out.println("-------------------------K-3-----------------------");
                              System.out.print("Nilai Tugas K3 : ");
                              nilai[j][30] = inputScanner.nextLine();
                              System.out.print("Nilai UTS K3   : ");
                              nilai[j][31] = inputScanner.nextLine();
                              System.out.print("Nilai UAS K3   : ");
                              nilai[j][32] = inputScanner.nextLine();
                              System.out.println("---------------------------------------------------");
                              System.out.println("\n");
                              // --------------------------------------------------------------------------
      
                              // variabel untuk menghitung rata rata setiap matkul :) uwaw
                              double jumlahDaspro = (Double.parseDouble(nilai[j][2]) + Double.parseDouble(nilai[j][3])
                                      + Double.parseDouble(nilai[j][4])) / 3;
                              double jumlahDasproPraktik = (Double.parseDouble(nilai[j][6]) + Double.parseDouble(nilai[j][7])
                                      + Double.parseDouble(nilai[j][8])) / 3;
                              double jumlahMatdas = (Double.parseDouble(nilai[j][10]) + Double.parseDouble(nilai[j][11])
                                      + Double.parseDouble(nilai[j][12])) / 3;
                              double jumlahPancasila = (Double.parseDouble(nilai[j][14]) + Double.parseDouble(nilai[j][15])
                                      + Double.parseDouble(nilai[j][16])) / 3;
                              double jumlahKTI = (Double.parseDouble(nilai[j][18]) + Double.parseDouble(nilai[j][19])
                                      + Double.parseDouble(nilai[j][20])) / 3;
                              double jumlahCTPS = (Double.parseDouble(nilai[j][22]) + Double.parseDouble(nilai[j][23])
                                      + Double.parseDouble(nilai[j][24])) / 3;
                              double jumlahBing = (Double.parseDouble(nilai[j][26]) + Double.parseDouble(nilai[j][27])
                                      + Double.parseDouble(nilai[j][28])) / 3;
                              double jumlahK3 = (Double.parseDouble(nilai[j][30]) + Double.parseDouble(nilai[j][31])
                                      + Double.parseDouble(nilai[j][32])) / 3;
                              // ----------------------------------------------------------
      
                              // mengisi array dengan variabel yang berisi rata rata matkul
                              nilai[j][5] = String.valueOf(jumlahDaspro);
                              nilai[j][9] = String.valueOf(jumlahDasproPraktik);
                              nilai[j][13] = String.valueOf(jumlahMatdas);
                              nilai[j][17] = String.valueOf(jumlahPancasila);
                              nilai[j][21] = String.valueOf(jumlahKTI);
                              nilai[j][25] = String.valueOf(jumlahCTPS);
                              nilai[j][29] = String.valueOf(jumlahBing);
                              nilai[j][33] = String.valueOf(jumlahK3);
                              // ----------------------------------------------------------
      
                              // //print nilai rata rata
                              // System.out.println("-----------------NILAI RATA RATA-------------------");
                              // System.out.println("Nilai Rata-rata Daspro : " + nilai[j][5]);
                              // System.out.println("Nilai Rata-rata Daspro Praktikum : " + nilai[j][9]);
                              // System.out.println("Nilai Rata-rata MATDAS : " + nilai[j][13]);
                              // System.out.println("Nilai Rata-rata PANCASILA : " + nilai[j][17]);
                              // System.out.println("Nilai Rata-rata KTI : " + nilai[j][21]);
                              // System.out.println("Nilai Rata-rata CTPS : " + nilai[j][25]);
                              // System.out.println("Nilai Rata-rata B.INGGRIS : " + nilai[j][29]);
                              // System.out.println("Nilai Rata-rata K3 : " + nilai[j][33]);
                              // System.out.println("---------------------------------------------------");
                              // System.out.println("\n");
                              // //----------------------------------------------------------
      
                              if (mahasiswa[i][0] == null) {
                                  // berandaAdmin();
                                  return;
                              }
                          }
                      }
                  }
              }
              break;
            case 3:
              // updNilaiMhs();
              // untuk menghitung data mahasiswa yang ada nilainya(tidak null)
        count = 0;
        for (String[] data : mahasiswa) {
            if (data[0] != null) {
                count++;
            }
        }
        // SORTING BY NAME
        n = count;
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
        System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n", "Nama", "NIM", "Jenis Kelamin", "Kelas",
                "Agama");
        System.out.printf("---------------------------------------------------------------------------------------\n");
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i][0] != null) {
                System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                        mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
                // System.out.println("TGL LAHIR : " + mahasiswa[i][5]);
                // System.out.println("EMAIL : " + mahasiswa[i][6]);
                // System.out.println("NO TELP : " + mahasiswa[i][7]);
                // System.out.println("ALAMAT : " + mahasiswa[i][8]);
            }
        }

        System.out.println("Cari data yang akan di update berdasarkan NIM");
        System.out.println("Apakah ingin mencari data?");
        System.out.println("yes / no");
        System.out.println("___________________________");
        inputScanner.nextLine();

        jawab = inputScanner.nextLine();

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
              break;
            case 4:
              // contact();
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
              break;
            case 0:
              // logOut();
              System.out.println("Anda telah logout");
              isLoggedOut = true; // Mengatur isLoggedOut menjadi true
              break; // Keluar dari switch case
            default:
              System.out.println("Pilihan tidak valid.");
          }
          if (isLoggedOut) {
            break; // Keluar dari loop while
          }
        }
      } else if (dataLog[2][0].equals(username) && dataLog[2][1].equals(password)) {
        System.out.println("Selamat datang " + username);
        System.out.println("\n");

        // berandaMahasiswa();
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
          System.out.println("0. LogOut\n");

          System.out.print("Masukkan pilihan anda: ");

          int choice = inputScanner.nextInt();
          switch (choice) {
            case 1:
              // cekDataMhs();
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
              System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n", "Nama", "NIM", "Jenis Kelamin", "Kelas",
                      "Agama");
              System.out.printf("---------------------------------------------------------------------------------------\n");
              for (int i = 0; i < mahasiswa.length; i++) {
                  if (mahasiswa[i][0] != null) {
                      System.out.printf("| %-20s | %-15s | %-15s | %-10s | %-10s |\n",
                              mahasiswa[i][0], mahasiswa[i][1], mahasiswa[i][2], mahasiswa[i][3], mahasiswa[i][4]);
                      // System.out.println("TGL LAHIR : " + mahasiswa[i][5]);
                      // System.out.println("EMAIL : " + mahasiswa[i][6]);
                      // System.out.println("NO TELP : " + mahasiswa[i][7]);
                      // System.out.println("ALAMAT : " + mahasiswa[i][8]);
                  }
      
              }
              System.out.println("\nApakah ingin mencari data?");
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
              break;
            case 2:
              // cekJadwalKuliah();
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
              break;
            case 3:
              // cekDataKrsMhs();
              System.out.println("========================== CEK DATA KRS MAHASISWA ==========================");
              System.out.println("-------------------------------------------------------------");
              System.out
                  .println("|" + "NO" + "|" + "MATA KULIAH                           " + "|" + "SEMESTER " + "|" + "SKS"
                      + "|" + "JAM" + "|");
              System.out
                  .println("|" + "1." + "|" + "Pancasila                             " + "|" + "1        " + "|" + "2  "
                      + "|" + "2  " + "|");
              System.out
                  .println("|" + "2." + "|" + "Konsep Teknologi Informasi            " + "|" + "1        " + "|" + "2  "
                      + "|" + "4  " + "|");
              System.out
                  .println("|" + "3." + "|" + "Critical Thinking dan Problem Solving " + "|" + "1        " + "|" + "2  "
                      + "|" + "4  " + "|");
              System.out
                  .println("|" + "4." + "|" + "Matematika Dasar                      " + "|" + "1        " + "|" + "3  "
                      + "|" + "6  " + "|");
              System.out
                  .println("|" + "5." + "|" + "Bahasa Inggris 1                      " + "|" + "1        " + "|" + "2  "
                      + "|" + "4  " + "|");
              System.out
                  .println("|" + "6." + "|" + "Dasar Pemograman                      " + "|" + "1        " + "|" + "2  "
                      + "|" + "4  " + "|");
              System.out
                  .println("|" + "7." + "|" + "Praktikum Dasar Pemograman            " + "|" + "1        " + "|" + "3  "
                      + "|" + "6  " + "|");
              System.out
                  .println("|" + "8." + "|" + "Keselamatan dan Kesehatan Kerja       " + "|" + "1        " + "|" + "2  "
                      + "|" + "4  " + "|");

              System.out.println("-------------------------------------------------------------");
              break;
            case 4:
              // contact();
              // System.out.println("======== CONTACT =======");
              // inputScanner.nextLine();
              // System.out.print("masukkan nama : ");
              // nama = inputScanner.nextLine();

              // System.out.print("masukkan nim : ");
              // nim = inputScanner.nextInt();

              // inputScanner.nextLine();
              // System.out.print("masukkan pesan : ");
              // pesan = inputScanner.nextLine();

              // System.out.println("Pesan anda sedang diproses");
              break;
            // return;s

            // break;
            case 0:
              // logOut();
              System.out.println("Anda telah logout");
              isLoggedOut = true; // Mengatur isLoggedOut menjadi true
              break; // Keluar dari switch case
            default:
              System.out.println("Pilihan tidak valid.");
          }
          if (isLoggedOut) {
            break; // Keluar dari loop while
          }
        }
      } else {
        System.out.println("username/password salah");
        System.out.println("\n");

        attempts++;
      }
    }
    if (attempts == 3) {
      System.out.println("Anda telah melebihi batas upaya login");
      System.exit(0);
    }
  }

}