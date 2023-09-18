import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemAkademik{

    private static String username = "admin";
    private static String password = "admin123";
    private static List<String> menuStack = new ArrayList<>();

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Username: ");
            String enteredUsername = inputScanner.nextLine();
            System.out.print("Password: ");
            String enteredPassword = inputScanner.nextLine();

            if (login(enteredUsername, enteredPassword)) {
                loggedIn = true;
                System.out.println("\nSelamat datang, " + enteredUsername + "!");
                menuStack.add("Beranda");
            } else {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
        }

        while (loggedIn) {
            System.out.println("\nMenu " + menuStack.get(menuStack.size() - 1) + ":");
            System.out.println("1. Menu 1");
            System.out.println("2. Menu 2");
            System.out.println("3. Kembali");
            System.out.println("4. Logout");
            System.out.print("Pilih menu: ");

            int menuChoice = inputScanner.nextInt();

            switch (menuChoice) {
                case 1:
                    // Implementasi logika Menu 1 di sini
                    menuStack.add("Menu 1");
                    break;
                case 2:
                    // Implementasi logika Menu 2 di sini
                    menuStack.add("Menu 2");
                    break;
                case 3:
                    if (menuStack.size() > 1) {
                        menuStack.remove(menuStack.size() - 1);
                    }
                    break;
                case 4:
                    loggedIn = false;
                    System.out.println("Anda telah logout.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        inputScanner.close();
    }

    private static boolean login(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

}