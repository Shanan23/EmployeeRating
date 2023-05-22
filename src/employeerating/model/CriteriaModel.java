/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeerating.model;

/**
 *
 * @author macbookpro
 */
public class CriteriaModel {
        public static String criteriaId;
        public static String criteriaName;
        public static String criteriaAmount;
        public static String criteriaDesc;

    public CriteriaModel() {
    }

    public static String getCriteriaId() {
        return criteriaId;
    }

    public static void setCriteriaId(String criteriaId) {
        CriteriaModel.criteriaId = criteriaId;
    }

    public static String getCriteriaName() {
        return criteriaName;
    }

    public static void setCriteriaName(String criteriaName) {
        CriteriaModel.criteriaName = criteriaName;
    }

    public static String getCriteriaAmount() {
        return criteriaAmount;
    }

    public static void setCriteriaAmount(String criteriaAmount) {
        CriteriaModel.criteriaAmount = criteriaAmount;
    }

    public static String getCriteriaDesc() {
        return criteriaDesc;
    }

    public static void setCriteriaDesc(String criteriaDesc) {
        CriteriaModel.criteriaDesc = criteriaDesc;
    }
        
        

}
