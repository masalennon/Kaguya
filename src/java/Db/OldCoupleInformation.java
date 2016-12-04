package Db;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.servlet.http.Part;
import org.hibernate.validator.constraints.NotEmpty;

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

public class OldCoupleInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String firstNameHurigana;
    @NotEmpty
    private String lastNameHurigana;
    @NotEmpty
    private String addressOne;
    @NotEmpty
    private String addressTwo;
    @NotEmpty
    private String birthYear;
    @NotEmpty
    private String birthMonth;
    @NotEmpty
    private String birthDay;
    @NotEmpty
    private String firstNameWife;
    @NotEmpty
    private String lastNameWife;
    @NotEmpty
    private String firstNameHuriganaWife;
    @NotEmpty
    private String lastNameHuriganaWife;
    @NotEmpty
    private String birthYearWife;
    @NotEmpty
    private String birthMonthWife;
    @NotEmpty
    private String birthDayWife;
    @NotEmpty
    private String phoneNumber;
    //
    @NotEmpty
    private String mailAddress;

    private Part file;

    private String educationContent;

    private String message;

//    @Inject
//    transient Logger log;
    public OldCoupleInformation(Long id, String firstName, String lastName, String firstNameHurigana,
            String lastNameHurigana, String addressOne, String addressTwo, String birthYear,
            String birthMonth, String birthDay, String firstNameWife, String lastNameWife,
            String firstNameHuriganaWife, String lastNameHuriganaWife, String birthYearWife,
            String birthMonthWife, String birthDayWife, String phoneNumber, String mailAddress, String educationContent, String message) {

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
        this.educationContent = educationContent;
        this.message = message;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
