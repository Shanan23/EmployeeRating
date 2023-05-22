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

    public String criteriaId;
    public String criteriaName;
    public String criteriaAmount;
    public String criteriaDesc;

    public CriteriaModel() {
    }

    public String getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(String criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaAmount() {
        return criteriaAmount;
    }

    public void setCriteriaAmount(String criteriaAmount) {
        this.criteriaAmount = criteriaAmount;
    }

    public String getCriteriaDesc() {
        return criteriaDesc;
    }

    public void setCriteriaDesc(String criteriaDesc) {
        this.criteriaDesc = criteriaDesc;
    }
}
