/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeerating.model;

/**
 *
 * @author macbookpro
 */
public class EmployeeModel {

    public static String employeeId;
    public static String employeeaName;
    public static String employeePosition;
    public static String employeeAddress;
    public static String employeePhone;

    public EmployeeModel() {
    }

    public static String getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(String employeeId) {
        EmployeeModel.employeeId = employeeId;
    }

    public static String getEmployeeaName() {
        return employeeaName;
    }

    public static void setEmployeeaName(String employeeaName) {
        EmployeeModel.employeeaName = employeeaName;
    }

    public static String getEmployeePosition() {
        return employeePosition;
    }

    public static void setEmployeePosition(String employeePosition) {
        EmployeeModel.employeePosition = employeePosition;
    }

    public static String getEmployeeAddress() {
        return employeeAddress;
    }

    public static void setEmployeeAddress(String employeeAddress) {
        EmployeeModel.employeeAddress = employeeAddress;
    }

    public static String getEmployeePhone() {
        return employeePhone;
    }

    public static void setEmployeePhone(String employeePhone) {
        EmployeeModel.employeePhone = employeePhone;
    }

}
