import java.util.Scanner;

/**
 * SistemAkademikBeta
 */
public class SistemAkademikBeta {
  public static Scanner inputScanner = new Scanner(System.in);

  // deklarasi variabel untuk fitur input data mahasiswa
  public static String namamhs, jk, kelas, agama, alamat, tgl, email;
  public static int NIM, no_hp;

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

                System.out.println("===================masukkan data diri===================");

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
              break;
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
              break;
            case 2:
              // inNilaiMhs();
              break;
            case 3:
              // updNilaiMhs();
              break;
            case 4:
              // contact();
              break;
            case 0:
              // logOut();
            default:
              System.out.println("Pilihan tidak valid.");
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
              break;
            case 2:
              // cekJadwalKuliah();
              break;
            case 3:
              // cekDataKrsMhs();
              break;
            case 4:
              // contact();
              break;
            case 0:
              // logOut();
            default:
              System.out.println("Pilihan tidak valid.");
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