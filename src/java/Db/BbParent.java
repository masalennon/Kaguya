/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
@Named

public class BbParent {

    @NotNull
    private String firstNameParent;
    @NotNull
    private String lastNameParent;
    @NotNull
    private String firstNameHuriganaParent;
    @NotNull
    private String lastNameHuriganaParent;
    @NotNull
    private String addressOneParent;
    @NotNull
    private String addressTwoParent;
    @NotNull
    private Integer birthYearParent;
    @NotNull
    private Integer birthMonthParent;
    @NotNull
    private Integer birthDayParent;
    @NotNull
    private int sexParent;
    @NotNull
    private String housePhoneNumberOneParent;
    @NotNull
    private String housePhoneNumberTwoParent;
    @NotNull
    private String housePhoneNumberThreeParent;
    private String housePhoneNumberParent = housePhoneNumberOneParent + housePhoneNumberTwoParent + housePhoneNumberThreeParent;
    @NotNull
    private String mobilePhoneNumberOneParent;
    @NotNull
    private String mobilePhoneNumberTwoParent;
    @NotNull
    private String mobilePhoneNumberThreeParent;
    private String mobilePhoneNumberParent = mobilePhoneNumberOneParent + mobilePhoneNumberTwoParent + mobilePhoneNumberThreeParent;
    @NotNull
    private String mailAddressParent;

    private static Map<Integer, Integer> items;

    static {
        for (int i = 1930; i < 1990; i++) {
            items = new LinkedHashMap<>();
            items.put(i, i);
        }
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }

//    @Override
//    public String goToInput() {
//        System.out.println("back to input.");
//        return "indexParent.xhtml";
//    }
//
//    @Override
//    public String goToConfirm() {
//        return "confirmParent.xhtml";
//    }


//    @Override
//    public String goToComplete() {
//        create();
//        return "complete.xhtml";
//    }

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

    public String getAddressOneParent() {
        return addressOneParent;
    }

    public void setAddressOneParent(String addressOneParent) {
        this.addressOneParent = addressOneParent;
    }

    public String getAddressTwoParent() {
        return addressTwoParent;
    }

    public void setAddressTwoParent(String addressTwoParent) {
        this.addressTwoParent = addressTwoParent;
    }

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

    public int getSexParent() {
        return sexParent;
    }

    public void setSexParent(int sexParent) {
        this.sexParent = sexParent;
    }

    public String getHousePhoneNumberOneParent() {
        return housePhoneNumberOneParent;
    }

    public void setHousePhoneNumberOneParent(String housePhoneNumberOneParent) {
        this.housePhoneNumberOneParent = housePhoneNumberOneParent;
    }

    public String getHousePhoneNumberTwoParent() {
        return housePhoneNumberTwoParent;
    }

    public void setHousePhoneNumberTwoParent(String housePhoneNumberTwoParent) {
        this.housePhoneNumberTwoParent = housePhoneNumberTwoParent;
    }

    public String getHousePhoneNumberThreeParent() {
        return housePhoneNumberThreeParent;
    }

    public void setHousePhoneNumberThreeParent(String housePhoneNumberThreeParent) {
        this.housePhoneNumberThreeParent = housePhoneNumberThreeParent;
    }

    public String getHousePhoneNumberParent() {
        return housePhoneNumberParent;
    }

    public void setHousePhoneNumberParent(String housePhoneNumberParent) {
        this.housePhoneNumberParent = housePhoneNumberParent;
    }

    public String getMobilePhoneNumberOneParent() {
        return mobilePhoneNumberOneParent;
    }

    public void setMobilePhoneNumberOneParent(String mobilePhoneNumberOneParent) {
        this.mobilePhoneNumberOneParent = mobilePhoneNumberOneParent;
    }

    public String getMobilePhoneNumberTwoParent() {
        return mobilePhoneNumberTwoParent;
    }

    public void setMobilePhoneNumberTwoParent(String mobilePhoneNumberTwoParent) {
        this.mobilePhoneNumberTwoParent = mobilePhoneNumberTwoParent;
    }

    public String getMobilePhoneNumberThreeParent() {
        return mobilePhoneNumberThreeParent;
    }

    public void setMobilePhoneNumberThreeParent(String mobilePhoneNumberThreeParent) {
        this.mobilePhoneNumberThreeParent = mobilePhoneNumberThreeParent;
    }

    public String getMobilePhoneNumberParent() {
        return mobilePhoneNumberParent;
    }

    public void setMobilePhoneNumberParent(String mobilePhoneNumberParent) {
        this.mobilePhoneNumberParent = mobilePhoneNumberParent;
    }

    public String getMailAddressParent() {
        return mailAddressParent;
    }

    public void setMailAddressParent(String mailAddressParent) {
        this.mailAddressParent = mailAddressParent;
    }

}
