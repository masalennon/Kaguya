package Db;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.servlet.http.Part;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Masanari
 */
@Named
@Remote
@Entity
@Table(name = "KAGUYA")
public class OldCoupleInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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

//    private Part file;
//
//    private Part fileRoom;

    private String educationContent;

    private String message;

    private Integer payment;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imageRoom;

//    @EJB
//    OldCoupleInformationDb db;
//    @Inject
//    transient Logger log;
    public OldCoupleInformation(Integer id, String firstName, String lastName, String firstNameHurigana,
            String lastNameHurigana, String addressOne, String addressTwo, String birthYear,
            String birthMonth, String birthDay, String firstNameWife, String lastNameWife,
            String firstNameHuriganaWife, String lastNameHuriganaWife, String birthYearWife,
            String birthMonthWife, String birthDayWife, String phoneNumber, String mailAddress,
            String educationContent, String message, Integer payment, byte[] image, byte[] imageRoom) {
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
        this.payment = payment;
        this.image = image;
        this.imageRoom = imageRoom;
    }

    public OldCoupleInformation(Integer id, String addressOne, String addressTwo, String phoneNumber, String mailAddress,
            String educationContent, String message, Integer payment, byte[] image, byte[] imageRoom) {
        this.id = id;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
        this.educationContent = educationContent;
        this.message = message;
        this.payment = payment;
        this.image = image;
        this.imageRoom = imageRoom;
//        this.image = image;
//        this.imageRoom = imageRoom;

    }


    public OldCoupleInformation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

//    public Part getFile() {
//        return file;
//    }
//
//    public void setFile(Part file) {
//        this.file = file;
//    }

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

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImageRoom() {
        return imageRoom;
    }

    public void setImageRoom(byte[] imageRoom) {
        this.imageRoom = imageRoom;
    }

//    public Part getFileRoom() {
//        return fileRoom;
//    }
//
//    public void setFileRoom(Part fileRoom) {
//        this.fileRoom = fileRoom;
//    }

}
