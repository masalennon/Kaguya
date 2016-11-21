/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

/**
 *
 * @author Masanari
 * @param <T>
 */
@ManagedBean(name = "bb")
@SessionScoped
public class Bb implements Serializable {

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
    private String birthYear;
    //
    private String birthMonth;
    //
    private String birthDay;
    //
    private String firstNameWife;
    //
    private String lastNameWife;
    //
    private String firstNameHuriganaWife;
    //
    private String lastNameHuriganaWife;
    //
    private String birthYearWife;
    //
    private String birthMonthWife;
    //
    private String birthDayWife;
    //
    private String phoneNumberOne;
    //
    private String phoneNumberTwo;
    //
    private String phoneNumberThree;
    private String phoneNumber = phoneNumberOne + "-" + phoneNumberTwo
            + "-" + phoneNumberThree;
    //
    private String mailAddress;
    @EJB
    OldCoupleInformationDb db;
    @Inject
    transient Logger log;

    public String goToComplete() {
        System.out.println("move to complete page.");
        System.out.println("firstName in goToComplete() = " + firstName);
        System.out.println("getFirstName()" + getFirstName());
        create();
        System.out.println("after create");
        return "complete";
    }

    public void create() {
//        Flash flash = FacesContext.getCurrentInstance().
//                getExternalContext().getFlash();
        OldCoupleInformation oldCoupleInformation = new OldCoupleInformation(id, firstName, lastName,
                firstNameHurigana, lastNameHurigana, addressOne, addressTwo, birthYear,
                birthMonth, birthDay, firstNameWife, lastNameWife, firstNameHuriganaWife,
                lastNameHuriganaWife, birthYearWife, birthMonthWife, birthDayWife, phoneNumber, mailAddress);

        try {
//            System.out.println(flash.get(firstName));
//            System.out.println(flash.get("firstName"));

            System.out.println("firstName in create() = " + firstName);
            System.out.println("this.firstName in create() = " + this.firstName);
            //oldCoupleInformation.setAddressOne();
            //System.out.println(oldCoupleInformation.getAddressOne() + "^^^^^^^^^^^^^^^^^");
            db.create(oldCoupleInformation);
            System.out.println(firstName);
//            clear();

        } catch (Exception e) {
            System.out.println("miss");
            log.fine("新規登録できない/" + firstName + "|" + e.getMessage());

        }
    }

    public String goToInput() {
        System.out.println("back to input.");
        return "input.xhtml";
    }

    public String goToConfirm() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("firstName", firstName);
        System.out.println("move to confirm page.");
        System.out.println(firstName + " in goToConfirm()");
        return "realConfirm";
    }

    public void clear() {
        firstName = lastName
                = firstNameHurigana = lastNameHurigana = addressOne = addressTwo = birthYear
                = birthMonth = birthDay = firstNameWife = lastNameWife = firstNameHuriganaWife
                = lastNameHuriganaWife = birthYearWife = birthMonthWife = birthDayWife
                = phoneNumber = mailAddress = null;
    }

    public String edit(OldCoupleInformation oldCoupleInformation) {
        firstName = oldCoupleInformation.getFirstName();
        return null;
    }

//    public List<OldCoupleInformation> getAll() {
//        return db.getAll();
//    }
//
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public void setId() {
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

    public String getPhoneNumberOne() {
        return phoneNumberOne;
    }

    public void setPhoneNumberOne(String housePhoneNumberOne) {
        this.phoneNumberOne = housePhoneNumberOne;
    }

    public String getPhoneNumberTwo() {
        return phoneNumberTwo;
    }

    public void setPhoneNumberTwo(String housePhoneNumberTwo) {
        this.phoneNumberTwo = housePhoneNumberTwo;
    }

    public String getPhoneNumberThree() {
        return phoneNumberThree;
    }

    public void setPhoneNumberThree(String housePhoneNumberThree) {
        this.phoneNumberThree = housePhoneNumberThree;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String housePhoneNumber) {
        this.phoneNumber = housePhoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Bb() {
    }

}
