/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeerating;

import employeerating.model.CriteriaModel;
import employeerating.model.EmployeeModel;
import employeerating.model.RatingModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
                System.out.println("Tutup Koneksi\n");
            }
        } catch (Exception ex) {
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
            
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
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
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
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
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
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        
        return id;
    }
    
    public ArrayList<CriteriaModel> SelectListCriteria() {
        ResultSet rsSelectCriteria = null;
        ArrayList<CriteriaModel> resultList = new ArrayList<CriteriaModel>();
        
        try {
            Connection conn = openConnection();
            Statement stm = conn.createStatement();
            
            rsSelectCriteria = stm.executeQuery("SELECT @n := @n + 1 AS no, a.* "
                    + "FROM (SELECT * FROM criteria ORDER BY criteria_id) AS a, "
                    + "(SELECT @n := 0) m "
            );
            
            while (rsSelectCriteria.next()) {
                CriteriaModel criteriaModel = new CriteriaModel();
                criteriaModel.setCriteriaId(rsSelectCriteria.getString("criteria_id"));
                criteriaModel.setCriteriaName(rsSelectCriteria.getString("criteria_name"));
                criteriaModel.setCriteriaAmount(rsSelectCriteria.getString("criteria_amount"));
                criteriaModel.setCriteriaDesc(rsSelectCriteria.getString("criteria_desc"));
                resultList.add(criteriaModel);
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        return resultList;
    }
    
    public CriteriaModel SelectCriteriaByIndex(String index) {
        ResultSet rsSelectCriteria = null;
        CriteriaModel criteriaModel = new CriteriaModel();
        try {
            Connection conn = openConnection();
            Statement stm = conn.createStatement();
            
            rsSelectCriteria = stm.executeQuery("SELECT * FROM "
                    + "(SELECT @n := @n + 1 AS no, a.* FROM "
                    + "(SELECT * FROM criteria ORDER BY criteria_id) AS a, "
                    + "(SELECT @n := 0) m) as b "
                    + "WHERE b.no = " + index
            );
            
            while (rsSelectCriteria.next()) {
                criteriaModel.setCriteriaId(rsSelectCriteria.getString("criteria_id"));
                criteriaModel.setCriteriaName(rsSelectCriteria.getString("criteria_name"));
                criteriaModel.setCriteriaAmount(rsSelectCriteria.getString("criteria_amount"));
                criteriaModel.setCriteriaDesc(rsSelectCriteria.getString("criteria_desc"));
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        
        return criteriaModel;
    }
    
    public int UpdateCriteriaById(String criteriaId, String criteriaName, String criteriaAmount, String criteriaDesc) {
        int id = 0;
        
        try {
            Connection connection = openConnection();
            Statement stm = connection.createStatement();
            int rsUpdateCriteria = stm.executeUpdate("UPDATE criteria SET "
                    + "criteria_name='" + criteriaName + "', "
                    + "criteria_amount='" + criteriaAmount + "', "
                    + "criteria_desc='" + criteriaDesc + "' "
                    + "WHERE criteria_id = '" + criteriaId + "'");
            id = rsUpdateCriteria;
            
            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        
        return id;
    }
    
    public int InsertEmployee(String employeeId, String employeeName, String employeePosition, String employeeAddress, String employeePhone) {
        int id = 0;
        
        try {
            Connection connection = openConnection();
            Statement stm = connection.createStatement();
            int rsInsertEmployee = stm.executeUpdate("INSERT INTO employee"
                    + "(employee_id, employee_name, employee_position, employee_address, employee_phone) VALUES "
                    + "('" + employeeId + "','" + employeeName + "','" + employeePosition + "','" + employeeAddress + "','" + employeePhone + "')");
            id = rsInsertEmployee;
            
            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        
        return id;
    }
    
    public DefaultTableModel SelectListEmployee() {
        ResultSet rsSelectEmployee = null;
        ArrayList<EmployeeModel> resultList = new ArrayList<EmployeeModel>();
        String col[] = {"No", "Nama", "Jabatan", "Alamat", "Telepon"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        try {
            Connection conn = openConnection();
            Statement stm = conn.createStatement();
            
            rsSelectEmployee = stm.executeQuery("SELECT @n := @n + 1 AS no, a.* "
                    + "FROM (SELECT * FROM employee ORDER BY employee_id) AS a, "
                    + "(SELECT @n := 0) m "
            );
            
            while (rsSelectEmployee.next()) {
                Object[] data = {String.valueOf(rsSelectEmployee.getInt("no")),
                    rsSelectEmployee.getString("employee_name"),
                    rsSelectEmployee.getString("employee_position"),
                    rsSelectEmployee.getString("employee_address"),
                    rsSelectEmployee.getString("employee_phone")};
                
                tableModel.addRow(data);
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        return tableModel;
    }
    
    public ArrayList<RatingModel> SelectListRatingWithEmployee() {
        ResultSet rsSelectRating = null;
        ArrayList<RatingModel> resultList = new ArrayList<RatingModel>();
        try {
            Connection conn = openConnection();
            Statement stm = conn.createStatement();
            
            rsSelectRating = stm.executeQuery("SELECT @n := @n + 1 AS no, a.* FROM "
                    + "(SELECT employee.*, COALESCE(rating.rating_id, '0') AS rating_id, "
                    + "COALESCE(rating.rating_value, '{}') AS rating_value, COALESCE(rating.rating_value2, '{}') AS rating_value2 "
                    + "FROM employee LEFT JOIN rating ON employee.employee_id = rating.employee_id) AS a, "
                    + "(SELECT @n := 0) m;"
            );
            
            while (rsSelectRating.next()) {
                
                RatingModel data = new RatingModel();
                data.setEmployeeId(rsSelectRating.getString("employee_id"));
                data.setEmployeeaName(rsSelectRating.getString("employee_name"));
                data.setEmployeePosition(rsSelectRating.getString("employee_position"));
                data.setEmployeeAddress(rsSelectRating.getString("employee_address"));
                data.setEmployeePhone(rsSelectRating.getString("employee_phone"));
                data.setRatingId(rsSelectRating.getString("rating_id"));
                data.setRatingValue(rsSelectRating.getString("rating_value"));
                data.setRatingValue2(rsSelectRating.getString("rating_value2"));
                
                resultList.add(data);
            }
            closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            System.out.println(DbConnection.class.getName() + " : " + ex.getMessage());
        }
        return resultList;
    }
}
