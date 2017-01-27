/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "editBean")
@ViewScoped
public class EditBean implements Serializable {

    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        this.addressOne = (String) flash.get("addressOne");
        this.addressTwo = (String) flash.get("addressTwo");

        this.phoneNumber = (String) flash.get("phoneNumber");
        this.mailAddress = (String) flash.get("mailAddress");
        this.educationContent = (String) flash.get("educationContent");
        this.message = (String) flash.get("message");
        this.payment = (Integer) flash.get("payment");

    }

    protected List<ColumnModel> columns;
    private List<OldCoupleInformation> editList;
    private String addressOne;
    private String addressTwo;
    private Integer payment;
    private String educationContent;
    private String phoneNumber;
    private String message;
    private String mailAddress;

    public List<OldCoupleInformation> getEditList() {
        return editList;
    }

    public void setEditList(List<OldCoupleInformation> editList) {
        this.editList = editList;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }

}
