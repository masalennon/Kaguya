/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
public class BbMom {
 @NotNull
    private String firstNameMom;
    @NotNull
    private String lastNameMom;
    @NotNull
    private String firstNameHuriganaMom;
    @NotNull
    private String lastNameHuriganaMom;
    @NotNull
    private String addressOneMom;
    @NotNull
    private String addressTwoMom;
    @NotNull
    private String birthYearMom;
    @NotNull
    private String birthMonthMom;
    @NotNull
    private String birthDayMom;
    @NotNull
    private int sexMom;
    @NotNull
    private String housePhoneNumberOneMom;
    @NotNull
    private String housePhoneNumberTwoMom;
    @NotNull
    private String housePhoneNumberThreeMom;
    private String housePhoneNumberMom = housePhoneNumberOneMom + housePhoneNumberTwoMom + housePhoneNumberThreeMom;
    @NotNull
    private String mobilePhoneNumberOneMom;
    @NotNull
    private String mobilePhoneNumberTwoMom;
    @NotNull
    private String mobilePhoneNumberThreeMom;
    private String mobilePhoneNumberMom = mobilePhoneNumberOneMom + mobilePhoneNumberTwoMom + mobilePhoneNumberThreeMom;
    @NotNull
    private String mailAddressMom;   

    public String getFirstNameMom() {
        return firstNameMom;
    }

    public void setFirstNameMom(String firstNameMom) {
        this.firstNameMom = firstNameMom;
    }

    public String getLastNameMom() {
        return lastNameMom;
    }

    public void setLastNameMom(String lastNameMom) {
        this.lastNameMom = lastNameMom;
    }

    public String getFirstNameHuriganaMom() {
        return firstNameHuriganaMom;
    }

    public void setFirstNameHuriganaMom(String firstNameHuriganaMom) {
        this.firstNameHuriganaMom = firstNameHuriganaMom;
    }

    public String getLastNameHuriganaMom() {
        return lastNameHuriganaMom;
    }

    public void setLastNameHuriganaMom(String lastNameHuriganaMom) {
        this.lastNameHuriganaMom = lastNameHuriganaMom;
    }

    public String getAddressOneMom() {
        return addressOneMom;
    }

    public void setAddressOneMom(String addressOneMom) {
        this.addressOneMom = addressOneMom;
    }

    public String getAddressTwoMom() {
        return addressTwoMom;
    }

    public void setAddressTwoMom(String addressTwoMom) {
        this.addressTwoMom = addressTwoMom;
    }

    public String getBirthYearMom() {
        return birthYearMom;
    }

    public void setBirthYearMom(String birthYearMom) {
        this.birthYearMom = birthYearMom;
    }

    public String getBirthMonthMom() {
        return birthMonthMom;
    }

    public void setBirthMonthMom(String birthMonthMom) {
        this.birthMonthMom = birthMonthMom;
    }

    public String getBirthDayMom() {
        return birthDayMom;
    }

    public void setBirthDayMom(String birthDayMom) {
        this.birthDayMom = birthDayMom;
    }

    public int getSexMom() {
        return sexMom;
    }

    public void setSexMom(int sexMom) {
        this.sexMom = sexMom;
    }

    public String getHousePhoneNumberOneMom() {
        return housePhoneNumberOneMom;
    }

    public void setHousePhoneNumberOneMom(String housePhoneNumberOneMom) {
        this.housePhoneNumberOneMom = housePhoneNumberOneMom;
    }

    public String getHousePhoneNumberTwoMom() {
        return housePhoneNumberTwoMom;
    }

    public void setHousePhoneNumberTwoMom(String housePhoneNumberTwoMom) {
        this.housePhoneNumberTwoMom = housePhoneNumberTwoMom;
    }

    public String getHousePhoneNumberThreeMom() {
        return housePhoneNumberThreeMom;
    }

    public void setHousePhoneNumberThreeMom(String housePhoneNumberThreeMom) {
        this.housePhoneNumberThreeMom = housePhoneNumberThreeMom;
    }

    public String getHousePhoneNumberMom() {
        return housePhoneNumberMom;
    }

    public void setHousePhoneNumberMom(String housePhoneNumberMom) {
        this.housePhoneNumberMom = housePhoneNumberMom;
    }

    public String getMobilePhoneNumberOneMom() {
        return mobilePhoneNumberOneMom;
    }

    public void setMobilePhoneNumberOneMom(String mobilePhoneNumberOneMom) {
        this.mobilePhoneNumberOneMom = mobilePhoneNumberOneMom;
    }

    public String getMobilePhoneNumberTwoMom() {
        return mobilePhoneNumberTwoMom;
    }

    public void setMobilePhoneNumberTwoMom(String mobilePhoneNumberTwoMom) {
        this.mobilePhoneNumberTwoMom = mobilePhoneNumberTwoMom;
    }

    public String getMobilePhoneNumberThreeMom() {
        return mobilePhoneNumberThreeMom;
    }

    public void setMobilePhoneNumberThreeMom(String mobilePhoneNumberThreeMom) {
        this.mobilePhoneNumberThreeMom = mobilePhoneNumberThreeMom;
    }

    public String getMobilePhoneNumberMom() {
        return mobilePhoneNumberMom;
    }

    public void setMobilePhoneNumberMom(String mobilePhoneNumberMom) {
        this.mobilePhoneNumberMom = mobilePhoneNumberMom;
    }

    public String getMailAddressMom() {
        return mailAddressMom;
    }

    public void setMailAddressMom(String mailAddressMom) {
        this.mailAddressMom = mailAddressMom;
    }
    
    
}
