import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Budżet domowy - wybierz czynność");
            System.out.println("Dodaj transakcję (1)");
            System.out.println("Usuń transakcję (2)");
            System.out.println("Modyfikuj transakcję (3)");
            System.out.println("Wyświetl transakcje (4)");
            System.out.println("Zakończenie pracy (5)");
            System.out.print("Twój wybór: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    TransactionUtils.addTransaction();
                    break;
                case "2":
                    TransactionUtils.deleteTransaction();
                    break;
                case "3":
                    TransactionUtils.updateTransaction();
                    break;
                case "4":
                    TransactionUtils.getTransactions();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Niepoprawny wybór!");
            }

        }
    }
}
