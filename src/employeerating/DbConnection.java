/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeerating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author macbookpro
 */
public class DbConnection {

    public Connection conn;

    public DbConnection() {

    }

    public Connection openConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_rating?user=root&pass=");
            System.out.println("Berhasil koneksi");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Database " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi yang terbuka.");
            return null;
        }
    }

    public void closeConnection() throws SQLException {
        try {
            if (conn != null) {
                System.out.print("Tutup Koneksi\n");
            }
        } catch (Exception ex) {
            System.out.print(DbConnection.class.getName() + " : " + ex.getMessage());

        }
    }

    public ResultSet login(String username, String password) {
        ResultSet rsLogin = null;
        try {
            Connection connection = openConnection();
            Statement stm = connection.createStatement();
            rsLogin = stm.executeQuery("SELECT * FROM user WHERE user_name = '" + username + "' AND user_password = '" + password + "'");

            rsLogin.next();

            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.print(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        return rsLogin;
    }

    public boolean usernameAvailable(String username) {
        ResultSet rsLogin = null;
        boolean isAvailable = true;
        int size = 0;
        try {
            Connection connection = openConnection();
            Statement stm = connection.createStatement();
            rsLogin = stm.executeQuery("SELECT * FROM user WHERE user_name = '" + username + "'");

            rsLogin.next();
            size = rsLogin.getRow();

            if (size != 0) {
                isAvailable = false;
            }
            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.print(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        return isAvailable;
    }

    public int InsertUserRegister(String userId, String name, String password, String isActive, String userRole) {
        int id = 0;

        try {
            Connection connection = openConnection();
            Statement stm = connection.createStatement();
            int rsInsertUserProfile = stm.executeUpdate("INSERT INTO user (user_id, user_name, user_password, is_active, user_role) VALUES ('" + userId + "','" + name + "','" + password + "','" + isActive + "','" + userRole + "')");
            id = rsInsertUserProfile;

            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.print(DbConnection.class.getName() + " : " + ex.getMessage());
        }

        return id;
    }

}
