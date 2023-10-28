import java.util.ArrayList;
import java.util.Scanner;

/**
 * SistemAkademikBeta
 */
public class SistemAkademikBeta {
  public static Scanner inputScanner = new Scanner(System.in);

  // deklarasi variabel untuk fitur input data mahasiswa
  public static String namamhs, jk, kelas, agama, alamat, tgl, email;
  public static int NIM, no_hp;

  // deklarasi variable global untuk fitur contact
  // public static int x;
  // public static String nama[] = new String[x], kls[] = new String[x], pesan[] =
  // new String[x], hasil;
  // public static int nim[] = new int[x], key;
  public static int key;
  public static String hasil;
  public static boolean search = true;

  public static ArrayList<String> nama = new ArrayList<>();
  public static ArrayList<Integer> nim = new ArrayList<>();
  public static ArrayList<String> kls = new ArrayList<>();
  public static ArrayList<String> pesan = new ArrayList<>();

  public static void main(String[] args) {

    String username, password;
    int attempts = 0;

    while (attempts < 3) {
      boolean isLoggedOut = false;

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

                System.out.println("========================================");
                System.out.println("=          INPUT DATA MAHASISWA        =");
                System.out.println("========================================");
                System.out.println("Ketik 0 untuk kembali ke menu sebelumnya");
                System.out.println("Ketik angka lain untuk lanjut");
                choice = inputScanner.nextInt();
                if (choice == 0) {
                  break;
                  // return;
                }

                System.out.println("\n");

                System.out.println("=================== DATA DIRI ===================");

                inputScanner.nextLine();
                System.out.print("masukkan nama             :");
                namamhs = inputScanner.nextLine();
                System.out.print("masukkan NIM              :");
                NIM = inputScanner.nextInt();

                inputScanner.nextLine();
                System.out.print("masukkan Jenis Kelamin    :");
                jk = inputScanner.nextLine();
                System.out.print("masukkan kelas            :");
                kelas = inputScanner.nextLine();
                System.out.print("masukkan agama            :");
                agama = inputScanner.nextLine();
                System.out.print("masukkan tanggal lahir    :");
                tgl = inputScanner.nextLine();
                System.out.print("masukkan email            :");
                email = inputScanner.nextLine();
                System.out.print("masukkan nomor handpone   :");
                no_hp = inputScanner.nextInt();
                inputScanner.nextLine();
                System.out.print("masukkan alamat           :");
                alamat = inputScanner.nextLine();

                System.out.println("DATA BERHASIL DI TAMBAHKAN\n");
                System.out.println("=======================================================");
                System.out.print("APAKAH ANDA INGIN MENAMBAHKAN DATA MAHASISWA LAGI ?");

                System.out.println("\n");

                System.out.println("1. untuk ya");
                System.out.println("2. untuk tidak");

                System.out.println("masukkan pilihan : ");
                choice = inputScanner.nextInt();

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
              break;
            case 3:
              // cekDataMhs();
              System.out.println("================= DATA MAHASISWA ===============");
              System.out.println("NAMA          : " + namamhs);
              System.out.println("NIM           : " + NIM);
              System.out.println("JENIS KELAMIN : " + jk);
              System.out.println("KELAS         : " + kelas);
              System.out.println("AGAMA         : " + agama);
              System.out.println("TGL LAHIR     : " + tgl);
              System.out.println("EMAIL         : " + email);
              System.out.println("NO TELP       : " + no_hp);
              System.out.println("ALAMAT        : " + alamat);

              break;
            case 4:
              // inNilaiMhs();
              break;
            case 5:
              // updNilaiMhs();
              break;
            case 6:
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
            case 7:
              // updKrsMhs();
              break;
            case 8:
              // cekDataKrsMhs();
              break;
            case 9:
              // contactAdmin();
              System.out.println("CONTACT");
              for (int i = 0; i < nim.size(); i++) {
                System.out.println("Nama: " + nama.get(i));
                System.out.println("NIM: " + nim.get(i)); // Mengakses NIM dari ArrayList
                System.out.println("Kelas: " + kls.get(i));
                System.out.println("Pesan: " + pesan.get(i));
                System.out.println("=======================");
              }
              System.out.println("Apakah ingin mencari data?");
              System.out.println("yes / no");
              String jawab = inputScanner.nextLine();
              if (jawab.equalsIgnoreCase("yes")) {
                System.out.print("Msukkan key yang ingin dicari : ");
                key = inputScanner.nextInt();

                for (int i = 0; i < nim.size(); i++) {
                  if (key == nim.get(i)) {
                    System.out.println("Nama: " + nama.get(i));
                    System.out.println("NIM: " + nim.get(i)); // Mengakses NIM dari ArrayList
                    System.out.println("Kelas: " + kls.get(i));
                    System.out.println("Pesan: " + pesan.get(i));
                    System.out.println("=======================");
                    break;

                  } else {
                    System.out.println("Key tidak ditemukan dalam array");
                  }
                }
                break;
              }
              System.out.println("apakah ingin melakukan operasi selanjutnya?");
              System.out.println("- ketikkan 1 untuk lanjut");
              System.out.println("- ketikkan angka lainnya untuk logout");
              int acc = inputScanner.nextInt();

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

      } else if ("dosen".equals(username) && "dosen".equals(password)) {
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
          System.out.println("4. Contact");
          System.out.println("0. LogOut\n");

          System.out.print("Masukkan pilihan anda: ");

          int choice = inputScanner.nextInt();
          switch (choice) {
            case 1:
              // cekDataMhs();
              System.out.println("================= DATA MAHASISWA ===============");
              System.out.println("NAMA          : " + namamhs);
              System.out.println("NIM           : " + NIM);
              System.out.println("JENIS KELAMIN : " + jk);
              System.out.println("KELAS         : " + kelas);
              System.out.println("AGAMA         : " + agama);
              System.out.println("TGL LAHIR     : " + tgl);
              System.out.println("EMAIL         : " + email);
              System.out.println("NO TELP       : " + no_hp);
              System.out.println("ALAMAT        : " + alamat);
              break;
            case 2:
              // inNilaiMhs();
              break;
            case 3:
              // updNilaiMhs();
              break;
            case 4:
              // contact();
              boolean repeat = true;
              while (repeat) {
                System.out.println("========== CONTACT ===========");
                inputScanner.nextLine();
                System.out.print("Masukkan nama: ");
                String namaMhs = inputScanner.nextLine();
                nama.add(namaMhs);

                System.out.print("Masukkan nim: ");
                int nimMhs = inputScanner.nextInt();
                nim.add(nimMhs);

                inputScanner.nextLine();
                System.out.print("Masukkan kelas: ");
                String kelasMhs = inputScanner.nextLine();
                kls.add(kelasMhs);

                System.out.print("Masukkan pesan: ");
                String pesanMhs = inputScanner.nextLine();
                pesan.add(pesanMhs);

                System.out.print("Ingin input lagi? (yes/no): ");
                String jawaban = inputScanner.nextLine();
                if (!jawaban.equalsIgnoreCase("yes")) {
                  break;
                }
              }
              System.out.println("====== Pesan anda sedang diproses =====");
              repeat = false;
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
      } else if ("mahasiswa".equals(username) && "mahasiswa".equals(password)) {
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
          System.out.println("4. Contact");
          System.out.println("0. LogOut\n");

          System.out.print("Masukkan pilihan anda: ");

          int choice = inputScanner.nextInt();
          switch (choice) {
            case 1:
              // cekDataMhs();
              System.out.println("================= DATA MAHASISWA ===============");
              System.out.println("NAMA          : " + namamhs);
              System.out.println("NIM           : " + nim);
              System.out.println("JENIS KELAMIN : " + jk);
              System.out.println("KELAS         : " + kelas);
              System.out.println("AGAMA         : " + agama);
              System.out.println("TGL LAHIR     : " + tgl);
              System.out.println("EMAIL         : " + email);
              System.out.println("NO TELP       : " + no_hp);
              System.out.println("ALAMAT        : " + alamat);
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