import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Enum.valueOf;

public abstract class TransactionUtils {

    private TransactionUtils() {
    }

    public static void addTransaction() throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Rodzaj transakcji (INCOME, EXPENDITURE): ");
        String string1 = scanner.nextLine();
        TransactionType type = TransactionType.valueOf(string1);

        System.out.println("Opis transakcji: ");
        String description = scanner.nextLine();

        System.out.println("Data transakcji (YYYY-MM-DD): ");
        String string2 = scanner.nextLine();
        java.sql.Date date = java.sql.Date.valueOf(string2);

        System.out.println("Wartość transakcji: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction transaction = new Transaction(type, description, date, amount);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.addTransaction(transaction);

        transactionDao.close();
    }

    public static void deleteTransaction() throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Id transakcji do usunięcia: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.deleteTransaction(id);

        transactionDao.close();
    }

    public static void updateTransaction() throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Id transakcji do modyfikacji: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Rodzaj transakcji (INCOME, EXPENDITURE): ");
        String string1 = scanner.nextLine();
        TransactionType type = TransactionType.valueOf(string1);

        System.out.println("Opis transakcji: ");
        String description = scanner.nextLine();

        System.out.println("Data transakcji (YYYY-MM-DD): ");
        String string2 = scanner.nextLine();
        java.sql.Date date = java.sql.Date.valueOf(string2);

        System.out.println("Wartość transakcji: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction transaction = new Transaction(id, type, description, date, amount);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.updateTransaction(transaction);

        transactionDao.close();
    }

    public static void getTransactions() throws SQLException, ClassNotFoundException {

        TransactionDao transactionDao = new TransactionDao();
        System.out.println(transactionDao.getTransactions());

        transactionDao.close();
    }
}
