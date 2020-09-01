import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class TransactionDao {

    private static final String URL = "jdbc:mysql://localhost:3306/budget?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "magisterMielno3";
    private Connection connection;

    public TransactionDao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER, PASS);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public void addTransaction(Transaction transaction) throws SQLException {

        final String sql = "INSERT INTO transaction (type, description, date, amount) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(transaction.getType()));
        preparedStatement.setString(2, transaction.getDescription());
        preparedStatement.setDate(3, transaction.getDate());
        preparedStatement.setDouble(4, transaction.getAmount());
        preparedStatement.executeUpdate();
    }

    public void deleteTransaction(Long id) throws SQLException {

        final String sql = "DELETE FROM transaction WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public void updateTransaction(Transaction transaction) throws SQLException {

        final String sql = "UPDATE transaction SET type = ?, description = ?, date = ?, amount = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(transaction.getType()));
        preparedStatement.setString(2, transaction.getDescription());
        preparedStatement.setDate(3, transaction.getDate());
        preparedStatement.setDouble(4, transaction.getAmount());
        preparedStatement.setLong(5, transaction.getId());
        preparedStatement.executeUpdate();

    }

    public Set<Transaction> getTransactions() throws SQLException {

        Set<Transaction> transactions = new HashSet<>();

        final String sql = "SELECT * FROM transaction";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(resultSet.getLong("id"));
            transaction.setType(TransactionType.valueOf(resultSet.getString("type")));
            transaction.setDescription(resultSet.getString("description"));
            transaction.setDate(resultSet.getDate("date"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transactions.add(transaction);
        }
        return transactions;
    }
}