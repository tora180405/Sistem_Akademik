import java.util.Scanner;

public class InputDataMahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nama, jk, kelas, agama, alamat, tgl, email;
        int NIM, no_hp;


        System.out.println("\n");
        System.out.println("\n");

        System.out.println("===================masukkan data diri===================");
        System.out.print("masukkan nama             :");
        nama = sc.nextLine();
        
        System.out.print("masukkan NIM              :");
        NIM = sc.nextInt();

        sc.nextLine();

        System.out.print("masukkan Jenis Kelamin    :");
        jk = sc.nextLine();
        
        System.out.print("masukkan kelas            :");
        kelas = sc.nextLine();

        System.out.print("masukkan agama            :");
        agama = sc.nextLine();
        
        System.out.print("masukkan tanggal lahir    :");
        tgl = sc.nextLine();

        System.out.print("masukkan email            :");
        email = sc.nextLine();
        
        System.out.print("masukkan nomor handpone   :");
        no_hp = sc.nextInt();

        sc.nextLine();
        
        System.out.print("masukkan alamat           :");
        alamat = sc.nextLine();
        
        System.out.println("=======================================================");
        


        


        
        System.out.println("====================DATA MAHASISWA=====================");
        System.out.println("nama                :" +(String) nama);
        System.out.println("NIM                 :" + NIM);
        System.out.println("Jenis Kelamin       :" + jk);
        System.out.println("kelas               :" + kelas);
        System.out.println("agama               :" + agama);
        System.out.println("Tanggal Lahir       :" + tgl);
        System.out.println("email               :" + email);
        System.out.println("nomor handphone     :" + no_hp);
        System.out.println("alamat              :" + alamat);
        System.out.println("=======================================================");
    }
}