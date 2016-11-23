package Db;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "KAGUYA")
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
    private String phoneNumber;
    //

    //
    private String mailAddress;

//    @Inject
//    transient Logger log;


    public OldCoupleInformation(Long id, String firstName, String lastName, String firstNameHurigana,
            String lastNameHurigana, String addressOne, String addressTwo, String birthYear,
            String birthMonth, String birthDay, String firstNameWife, String lastNameWife,
            String firstNameHuriganaWife, String lastNameHuriganaWife, String birthYearWife,
            String birthMonthWife, String birthDayWife, String phoneNumber, String mailAddress) {

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
        this.phoneNumber = phoneNumber;
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

}
