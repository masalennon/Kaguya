/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.*;

/**
 *
 * @author Masanari
 * @param <T>
 */
@Named
@SessionScoped
public class Bb implements Serializable {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String firstNameHurigana;
    @NotNull
    private String lastNameHurigana;
    @NotNull
    private String addressOne;
    @NotNull
    private String addressTwo;
    @NotNull
    private String birthYear;
    @NotNull
    private String birthMonth;
    @NotNull
    private String birthDay;
    @NotNull
    private String firstNameWife;
    @NotNull
    private String lastNameWife;
    @NotNull
    private String firstNameHuriganaWife;
    @NotNull
    private String lastNameHuriganaWife;
    @NotNull
    private String birthYearWife;
    @NotNull
    private String birthMonthWife;
    @NotNull
    private String birthDayWife;
    @NotNull
    private String housePhoneNumberOne;
    @NotNull
    private String housePhoneNumberTwo;
    @NotNull
    private String housePhoneNumberThree;
    private String housePhoneNumber = housePhoneNumberOne + housePhoneNumberTwo + housePhoneNumberThree;
    @NotNull
    private String mobilePhoneNumberOne;
    @NotNull
    private String mobilePhoneNumberTwo;
    @NotNull
    private String mobilePhoneNumberThree;
    private String mobilePhoneNumber = mobilePhoneNumberOne + mobilePhoneNumberTwo + mobilePhoneNumberThree;
    @NotNull
    private String mailAddress;

//    @Inject
//    OldCoupleInformationDb db;
    @Inject
    transient Logger log;

//    @PersistenceContext(unitName = "KaguyaPU")
//    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;
    public String next() {
        create();
        return "null";
    }

    public String goToInput() {
        System.out.println("back to input.");
        return "input.xhtml";
    }

    public String goToConfirm() {
        System.out.println("move to confirm page.");
        System.out.println(firstName);
        return "confirm.xhtml";
    }

    public String goToComplete() {
        System.out.println("move to complete page.");
        System.out.println(firstName);
        create();
        System.out.println(firstName);
        System.out.println("after create");
        return "complete.xhtml";
    }

    public void create() {

        OldCoupleInformation oci = new OldCoupleInformation(id, firstName, lastName,
                firstNameHurigana, lastNameHurigana, addressOne, addressTwo, birthYear,
                birthMonth, birthDay, firstNameWife, lastNameWife, firstNameHuriganaWife,
                lastNameHuriganaWife, birthYearWife, birthMonthWife, birthDayWife, housePhoneNumberOne,
                housePhoneNumberTwo, housePhoneNumberThree, mobilePhoneNumberOne, mobilePhoneNumberTwo,
                mobilePhoneNumberThree, mailAddress);
        try {
            //em.persist(oci);
            OldCoupleInformationDb db = new OldCoupleInformationDb();
            System.out.println("ok1");
            db.create(oci);
            System.out.println("ok2");
            clear();
        } catch (Exception e) {
            System.out.println("miss");
            log.severe("新規登録できない/" + firstName);
        } finally {
            System.out.println("failed!!!!");
            
        }
    }

    public void clear() {
        firstName = lastName
                = firstNameHurigana = lastNameHurigana = addressOne = addressTwo = birthYear
                = birthMonth = birthDay = firstNameWife = lastNameWife = firstNameHuriganaWife
                = lastNameHuriganaWife = birthYearWife = birthMonthWife = birthDayWife = housePhoneNumberOne
                = housePhoneNumberTwo = housePhoneNumberThree = mobilePhoneNumberOne = mobilePhoneNumberTwo
                = mobilePhoneNumberThree = mailAddress = null;
    }

//    public OldCoupleInformationDb getDb() {
//        return db;
//    }
//
//    public void setDb(OldCoupleInformationDb db) {
//        this.db = db;
//    }
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

    public String getMobilePhoneNumberOne() {
        return mobilePhoneNumberOne;
    }

    public void setMobilePhoneNumberOne(String mobilePhoneNumberOne) {
        this.mobilePhoneNumberOne = mobilePhoneNumberOne;
    }

    public String getMobilePhoneNumberTwo() {
        return mobilePhoneNumberTwo;
    }

    public void setMobilePhoneNumberTwo(String mobilePhoneNumberTwo) {
        this.mobilePhoneNumberTwo = mobilePhoneNumberTwo;
    }

    public String getMobilePhoneNumberThree() {
        return mobilePhoneNumberThree;
    }

    public void setMobilePhoneNumberThree(String mobilePhoneNumberThree) {
        this.mobilePhoneNumberThree = mobilePhoneNumberThree;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

//    public OldCoupleInformationDb getOci() {
//        return oci;
//    }
//
//    public void setOci(OldCoupleInformationDb oci) {
//        this.oci = oci;
//    }
//        public Bb(Long id, String firstName, String lastName, String firstNameHurigana, String lastNameHurigana, String addressOne, String addressTwo, String birthYear, String birthMonth, String birthDay, String firstNameWife, String lastNameWife, String firstNameHuriganaWife, String lastNameHuriganaWife, String birthYearWife, String birthMonthWife, String birthDayWife, String housePhoneNumberOne, String housePhoneNumberTwo, String housePhoneNumberThree, String mobilePhoneNumberOne, String mobilePhoneNumberTwo, String mobilePhoneNumberThree, String mailAddress, UserInformationDb ui) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.firstNameHurigana = firstNameHurigana;
//        this.lastNameHurigana = lastNameHurigana;
//        this.addressOne = addressOne;
//        this.addressTwo = addressTwo;
//        this.birthYear = birthYear;
//        this.birthMonth = birthMonth;
//        this.birthDay = birthDay;
//        this.firstNameWife = firstNameWife;
//        this.lastNameWife = lastNameWife;
//        this.firstNameHuriganaWife = firstNameHuriganaWife;
//        this.lastNameHuriganaWife = lastNameHuriganaWife;
//        this.birthYearWife = birthYearWife;
//        this.birthMonthWife = birthMonthWife;
//        this.birthDayWife = birthDayWife;
//        this.housePhoneNumberOne = housePhoneNumberOne;
//        this.housePhoneNumberTwo = housePhoneNumberTwo;
//        this.housePhoneNumberThree = housePhoneNumberThree;
//        this.mobilePhoneNumberOne = mobilePhoneNumberOne;
//        this.mobilePhoneNumberTwo = mobilePhoneNumberTwo;
//        this.mobilePhoneNumberThree = mobilePhoneNumberThree;
//        this.mailAddress = mailAddress;
////        this.ui = ui;
//    }
//
    public Bb() {
    }
//
//    public void persist(Object object) {
//        try {
//            utx.begin();
//            em.persist(object);
//            utx.commit();
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }
}
