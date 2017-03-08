package pl.mariusz.zagala.datebase;

import org.sqlite.SQLiteConfig;

import java.sql.*;

/**
 * Created by MariuszZ on 2017-03-07.
 */
public class Datebase {
    private static final String DB = "jdbc:sqlite:Dictionary.db"; //nazwe bazy danych
    private static final String DRV = "org.sqlite.JDBC"; //nazwe sterownika ktory zarzadza polaczenie mz baza danych
    private static Connection conn; //zmienna do zarzadzania polaczeniem z baza danych
    private static Statement stat; //zmienna do zarzadzania zapytaniami sql

    //metoda ustanawiajaca polaczenie z baza danych
    public static void connect()
    {

        try {
            Class.forName(DRV);
            SQLiteConfig conf = new SQLiteConfig();
            conf.enforceForeignKeys(true);
            conn = DriverManager.getConnection(DB, conf.toProperties());
            stat = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void createTables()
    {
        String createTableWords =
                "CREATE TABLE IF NOT EXISTS Words"
                        + "("
                        + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + "wordPl VARCHAR(50) NOT NULL,"
                        + "wordAn VARCHAR(50) NOT NULL"
                        + ");";


        try {
            stat.execute(createTableWords);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void insertWords(String wordPl, String wordAn)
    {
        String insertW =
                "INSERT INTO Words"
                        + "(wordPl, wordAn)"
                        + "VALUES"
                        + "(?, ?);";
        //znaki zapytania to miejsca pod ktore wstawimy wartosci zmiennych przekazanych jako argument
        //w tym celu posluzymy sie klasa PreparedStaement, ktora zajmuje sie konfiguracja wartosci


        try {
            PreparedStatement ps = conn.prepareStatement(insertW);
            ps.setString(1, wordPl);
            ps.setString(2, wordAn);
            ps.execute(); //trzeba wyslac zparametryzowane zapytanie

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void updateWords(int id, String wordPl, String wordAn){
        String updateS = "UPDATE Words SET wordPl = ?, wordAn = ?WHERE id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(updateS);
            ps.setString(1, wordPl);
            ps.setString(2, wordAn);
            ps.setInt(3, id);
            ps.execute(); //trzeba wyslac zparametryzowane zapytanie
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void deleteWords(int id)
    {
        String deleteW = "DELETE FROM Words WHERE id = ? ;";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteW);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
