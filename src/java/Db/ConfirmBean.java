/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.servlet.http.Part;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "cb")
@ViewScoped//ViewScopedじゃないとだめ！！！
public class ConfirmBean implements Serializable {
    //

    private Long id;
    //
    private String firstName;
    //
    private String lastName;
    //
    private String firstNameHurigana;
    //
    private String lastNameHurigana;
    //
    private String addressOne;
    //
    private String addressTwo;
    //
    private String birthYear = "1940";
    //
    private String birthMonth = "1";
    //
    private String birthDay = "1";
    //
    private String firstNameWife;
    //
    private String lastNameWife;
    //
    private String firstNameHuriganaWife;
    //
    private String lastNameHuriganaWife;
    //
    private String birthYearWife = "1940";
    //
    private String birthMonthWife = "1";
    //
    private String birthDayWife = "1";
    //
    private String phoneNumber;

    private String mailAddress;

    private Part file;

    
    @EJB
    OldCoupleInformationDb db;

    @Inject
    transient Logger log;

    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        this.id = (Long) flash.get("id");
        this.firstName = (String) flash.get("firstName");
        this.lastName = (String) flash.get("lastName");
        this.firstNameHurigana = (String) flash.get("firstNameHurigana");
        this.lastNameHurigana = (String) flash.get("lastNameHurigana");
        this.addressOne = (String) flash.get("addressOne");
        this.addressTwo = (String) flash.get("addressTwo");
        this.birthYear = (String) flash.get("birthYear");
        this.birthMonth = (String) flash.get("birthMonth");
        this.birthDay = (String) flash.get("birthDay");
        this.firstNameWife = (String) flash.get("firstNameWife");
        this.lastNameWife = (String) flash.get("lastNameWife");
        this.firstNameHuriganaWife = (String) flash.get("firstNameHuriganaWife");
        this.lastNameHuriganaWife = (String) flash.get("lastNameHuriganaWife");
        this.birthYearWife = (String) flash.get("birthYearWife");
        this.birthMonthWife = (String) flash.get("birthMonthWife");
        this.birthDayWife = (String) flash.get("birthYearWife");
        this.phoneNumber = (String) flash.get("phoneNumber");
        this.mailAddress = (String) flash.get("mailAddress");
        System.out.println("firstName in init() = " + firstName);
        
        
    }

    public void clear() {
        firstName = lastName
                = firstNameHurigana = lastNameHurigana = addressOne = addressTwo = birthYear
                = birthMonth = birthDay = firstNameWife = lastNameWife = firstNameHuriganaWife
                = lastNameHuriganaWife = birthYearWife = birthMonthWife = birthDayWife
                = phoneNumber = mailAddress = null;
    }

    public void create() {

        OldCoupleInformation oldCoupleInformation = new OldCoupleInformation(id, firstName, lastName,
                firstNameHurigana, lastNameHurigana, addressOne, addressTwo, birthYear,
                birthMonth, birthDay, firstNameWife, lastNameWife, firstNameHuriganaWife,
                lastNameHuriganaWife, birthYearWife, birthMonthWife, birthDayWife, phoneNumber, mailAddress);

        try {

            db.create(oldCoupleInformation);
            clear();

        } catch (Exception e) {
            System.out.println("miss");
            log.fine("新規登録できない/" + firstName + "|" + e.getMessage());

        }
    }

    public String goToComplete() {
        create();
        return "/complete.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameHurigana() {
        return firstNameHurigana;
    }

    public void setFirstNameHurigana(String firstNameHurigana) {
        this.firstNameHurigana = firstNameHurigana;
    }

    public String getLastNameHurigana() {
        return lastNameHurigana;
    }

    public void setLastNameHurigana(String lastNameHurigana) {
        this.lastNameHurigana = lastNameHurigana;
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

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstNameWife() {
        return firstNameWife;
    }

    public void setFirstNameWife(String firstNameWife) {
        this.firstNameWife = firstNameWife;
    }

    public String getLastNameWife() {
        return lastNameWife;
    }

    public void setLastNameWife(String lastNameWife) {
        this.lastNameWife = lastNameWife;
    }

    public String getFirstNameHuriganaWife() {
        return firstNameHuriganaWife;
    }

    public void setFirstNameHuriganaWife(String firstNameHuriganaWife) {
        this.firstNameHuriganaWife = firstNameHuriganaWife;
    }

    public String getLastNameHuriganaWife() {
        return lastNameHuriganaWife;
    }

    public void setLastNameHuriganaWife(String lastNameHuriganaWife) {
        this.lastNameHuriganaWife = lastNameHuriganaWife;
    }

    public String getBirthYearWife() {
        return birthYearWife;
    }

    public void setBirthYearWife(String birthYearWife) {
        this.birthYearWife = birthYearWife;
    }

    public String getBirthMonthWife() {
        return birthMonthWife;
    }

    public void setBirthMonthWife(String birthMonthWife) {
        this.birthMonthWife = birthMonthWife;
    }

    public String getBirthDayWife() {
        return birthDayWife;
    }

    public void setBirthDayWife(String birthDayWife) {
        this.birthDayWife = birthDayWife;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public OldCoupleInformationDb getDb() {
        return db;
    }

    public void setDb(OldCoupleInformationDb db) {
        this.db = db;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

}
