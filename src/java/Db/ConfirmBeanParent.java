/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import entities.ParentEntity;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "ConfirmBeanParent")
@ViewScoped
public class ConfirmBeanParent implements Serializable {

    @NotNull
    private Integer id;
    @NotNull
    private String firstNameParent;
    @NotNull
    private String lastNameParent;
    @NotNull
    private String firstNameHuriganaParent;
    @NotNull
    private String lastNameHuriganaParent;
//    @NotNull
//    private String addressOneParent;
//    @NotNull
//    private String addressTwoParent;
    @NotNull
    private Integer birthYearParent;
    @NotNull
    private Integer birthMonthParent;
    @NotNull
    private Integer birthDayParent;
    @NotNull
    private String phoneNumberParent;
    @NotNull
    private String mailAddressParent;

    @EJB
    OldCoupleInformationDb db;

    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        this.id = (Integer) flash.get("id");
        this.firstNameParent = (String) flash.get("firstName");
        this.lastNameParent = (String) flash.get("lastName");
        this.firstNameHuriganaParent = (String) flash.get("firstNameHurigana");
        this.lastNameHuriganaParent = (String) flash.get("lastNameHurigana");
//        this.addressOneParent = (String) flash.get("addressOne");
//        this.addressTwoParent = (String) flash.get("addressTwo");
        this.birthYearParent = (Integer) flash.get("birthYear");
        this.birthMonthParent = (Integer) flash.get("birthMonth");
        this.birthDayParent = (Integer) flash.get("birthDay");

        this.phoneNumberParent = (String) flash.get("phoneNumber");
        this.mailAddressParent = (String) flash.get("mailAddress");

    }

    public String goToComplete() {
        ParentEntity parentEntity = new ParentEntity(id, firstNameParent, lastNameParent,
                firstNameHuriganaParent, lastNameHuriganaParent, birthYearParent, birthMonthParent, birthDayParent,
                phoneNumberParent, mailAddressParent);

        try {

            db.createa(parentEntity);
            clear();

        } catch (Exception e) {
            System.out.println("miss");
//            log.fine("新規登録できない/" + firstName + "|" + e.getMessage());

        }
        return "";
    }

    public void clear() {
        firstNameParent = lastNameParent = firstNameHuriganaParent = 
                lastNameHuriganaParent = phoneNumberParent = mailAddressParent = null;
        id = birthYearParent = birthMonthParent = birthDayParent = null;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameParent() {
        return firstNameParent;
    }

    public void setFirstNameParent(String firstNameParent) {
        this.firstNameParent = firstNameParent;
    }

    public String getLastNameParent() {
        return lastNameParent;
    }

    public void setLastNameParent(String lastNameParent) {
        this.lastNameParent = lastNameParent;
    }

    public String getFirstNameHuriganaParent() {
        return firstNameHuriganaParent;
    }

    public void setFirstNameHuriganaParent(String firstNameHuriganaParent) {
        this.firstNameHuriganaParent = firstNameHuriganaParent;
    }

    public String getLastNameHuriganaParent() {
        return lastNameHuriganaParent;
    }

    public void setLastNameHuriganaParent(String lastNameHuriganaParent) {
        this.lastNameHuriganaParent = lastNameHuriganaParent;
    }

//    public String getAddressOneParent() {
//        return addressOneParent;
//    }
//
//    public void setAddressOneParent(String addressOneParent) {
//        this.addressOneParent = addressOneParent;
//    }
//
//    public String getAddressTwoParent() {
//        return addressTwoParent;
//    }
//
//    public void setAddressTwoParent(String addressTwoParent) {
//        this.addressTwoParent = addressTwoParent;
//    }

    public Integer getBirthYearParent() {
        return birthYearParent;
    }

    public void setBirthYearParent(Integer birthYearParent) {
        this.birthYearParent = birthYearParent;
    }

    public Integer getBirthMonthParent() {
        return birthMonthParent;
    }

    public void setBirthMonthParent(Integer birthMonthParent) {
        this.birthMonthParent = birthMonthParent;
    }

    public Integer getBirthDayParent() {
        return birthDayParent;
    }

    public void setBirthDayParent(Integer birthDayParent) {
        this.birthDayParent = birthDayParent;
    }

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public String getMailAddressParent() {
        return mailAddressParent;
    }

    public void setMailAddressParent(String mailAddressParent) {
        this.mailAddressParent = mailAddressParent;
    }

}
