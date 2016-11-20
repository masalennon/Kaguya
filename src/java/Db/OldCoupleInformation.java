package Db;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Masanari
 */
@Entity
@ManagedBean(name = "oldCoupleInformation")
public class OldCoupleInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String housePhoneNumberOne;
    //
    private String housePhoneNumberTwo;
    //
    private String housePhoneNumberThree;

    private String housePhoneNumber = housePhoneNumberOne + housePhoneNumberTwo + housePhoneNumberThree;

    //
    private String mailAddress;

  
//    @Inject
//    transient Logger log;

    public OldCoupleInformation(Long id, String firstName, String lastName, String firstNameHurigana,
            String lastNameHurigana, String addressOne, String addressTwo, String birthYear,
            String birthMonth, String birthDay, String firstNameWife, String lastNameWife,
            String firstNameHuriganaWife, String lastNameHuriganaWife, String birthYearWife,
            String birthMonthWife, String birthDayWife, String housePhoneNumberOne,
            String housePhoneNumberTwo, String housePhoneNumberThree, String mailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstNameHurigana = firstNameHurigana;
        this.lastNameHurigana = lastNameHurigana;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.firstNameWife = firstNameWife;
        this.lastNameWife = lastNameWife;
        this.firstNameHuriganaWife = firstNameHuriganaWife;
        this.lastNameHuriganaWife = lastNameHuriganaWife;
        this.birthYearWife = birthYearWife;
        this.birthMonthWife = birthMonthWife;
        this.birthDayWife = birthDayWife;
        this.housePhoneNumberOne = housePhoneNumberOne;
        this.housePhoneNumberTwo = housePhoneNumberTwo;
        this.housePhoneNumberThree = housePhoneNumberThree;
        this.mailAddress = mailAddress;
    }

    public OldCoupleInformation() {
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

    public String getHousePhoneNumberOne() {
        return housePhoneNumberOne;
    }

    public void setHousePhoneNumberOne(String housePhoneNumberOne) {
        this.housePhoneNumberOne = housePhoneNumberOne;
    }

    public String getHousePhoneNumberTwo() {
        return housePhoneNumberTwo;
    }

    public void setHousePhoneNumberTwo(String housePhoneNumberTwo) {
        this.housePhoneNumberTwo = housePhoneNumberTwo;
    }

    public String getHousePhoneNumberThree() {
        return housePhoneNumberThree;
    }

    public void setHousePhoneNumberThree(String housePhoneNumberThree) {
        this.housePhoneNumberThree = housePhoneNumberThree;
    }

    public String getHousePhoneNumber() {
        return housePhoneNumber;
    }

    public void setHousePhoneNumber(String housePhoneNumber) {
        this.housePhoneNumber = housePhoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
