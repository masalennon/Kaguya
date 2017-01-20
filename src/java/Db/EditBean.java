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
        this.editList = (List) flash.get("editList");
//        addressOne = editList.get("addressOne");
        columns = new ArrayList<>();
        createDynamicColumns();
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

    public String edit(OldCoupleInformation oldCoupleInformation) {
        System.out.println("edit()");
//        imageToByte();
        addressOne = oldCoupleInformation.getAddressOne();
        addressTwo = oldCoupleInformation.getAddressTwo();
        payment = oldCoupleInformation.getPayment();
        educationContent = oldCoupleInformation.getEducationContent();
        message = oldCoupleInformation.getMessage();
        phoneNumber = oldCoupleInformation.getPhoneNumber();
        mailAddress = oldCoupleInformation.getMailAddress();
//        image = oldCoupleInformation.getImage();
//        imageRoom = oldCoupleInformation.getImageRoom();

        return null;
    }

    public void createDynamicColumns() {
        columns.clear();

        //ヘッダとエンティティの属性である変数名を記述
        columns.add(new ColumnModel("名前", "firstName"));
        columns.add(new ColumnModel("住んでいる地域", "addressOne"));
        columns.add(new ColumnModel("丁目", "addressTwo"));
        columns.add(new ColumnModel("提供できる保育の内容", "educationContent"));
        columns.add(new ColumnModel("保護者の方への言葉", "message"));
        columns.add(new ColumnModel("希望月謝", "payment"));
        columns.add(new ColumnModel("", ""));

    }

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
