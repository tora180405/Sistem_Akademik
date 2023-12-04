update data mahasiswa
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