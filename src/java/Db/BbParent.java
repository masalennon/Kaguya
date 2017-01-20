/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Masanari
 */
@ViewScoped
@ManagedBean(name = "bbParent")
public class BbParent implements Serializable {

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
    @NotNull
    private Integer birthYearParent = 1980;
    @NotNull
    private Integer birthMonthParent = 1;
    @NotNull
    private Integer birthDayParent = 1;
    @NotNull
    private String phoneNumberParent;
    @NotNull
    private String mailAddressParent;
    @NotEmpty

    private String firstName;

    private String birthYear;

    private String birthMonth;

    private String birthDay;

    private String addressOne;

    private String addressTwo;

    private String educationContent;

    private String message;

    private String payment;

    private String search;

    private String mailAddress;

    private String phoneNumber;

    private final List<SelectItem> yearList = new ArrayList();
    private final List<SelectItem> monthList = new ArrayList();
    private final List<SelectItem> dayList = new ArrayList();

    @PostConstruct
    public void loadPage() {
        for (int i = 1950; i <= 2000; i++) {
            final SelectItem item = new SelectItem();
            item.setLabel(String.valueOf(i));
            item.setValue(String.valueOf(i));
            yearList.add(item);
        }
        for (int i = 1; i <= 12; i++) {
            final SelectItem item = new SelectItem();
            item.setLabel(String.valueOf(i));
            item.setValue(String.valueOf(i));
            monthList.add(item);
        }
        for (int i = 1; i <= 31; i++) {
            final SelectItem item = new SelectItem();
            item.setLabel(String.valueOf(i));
            item.setValue(String.valueOf(i));
            dayList.add(item);
        }
        System.out.println(firstName);
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        firstName = (String) flash.get("firstName");
        addressOne = (String) flash.get("addressOne");
        addressTwo = (String) flash.get("addressTwo");
        birthYear = (String) flash.get("birthYear");
        birthMonth = (String) flash.get("birthMonth");
        birthDay = (String) flash.get("birthDay");
        payment = (String) flash.get("payment");
        educationContent = (String) flash.get("educationContent");
        mailAddress = (String) flash.get("mailAddress");
        phoneNumber = (String) flash.get("phoneNumber");
    }

    public String goToConfirm() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("firstNameParent", this.firstNameParent);
        flash.put("lastNameParent", this.lastNameParent);
        flash.put("firstNameHuriganaParent", this.firstNameHuriganaParent);
        flash.put("lastNameHuriganaParent", this.lastNameHuriganaParent);
        flash.put("birthYearParent", this.birthYearParent);
        flash.put("birthMonthParent", this.birthMonthParent);
        flash.put("birthDayParent", this.birthDayParent);
        flash.put("phoneNumberParent", this.phoneNumberParent);
        flash.put("mailAddressParent", this.mailAddressParent);
        flash.put("phoneNumber", this.phoneNumber);
        flash.put("mailAddress", this.mailAddress);
        flash.put("id", this.id);
        flash.put("firstName", firstName);
        flash.put("birthYear", birthYear);
        flash.put("birthDay", birthDay);
        flash.put("birthMonth", birthMonth);
        flash.put("addressOne", addressOne);
        flash.put("addressTwo", addressTwo);
        flash.put("educationContent", educationContent);
        flash.put("payment", payment);
        flash.put("mailAddress", mailAddress);
        flash.put("phoneNumber", phoneNumber);
        
        return "/confirm-parent.xhtml?faces-redirect=true";
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

    public String getMailAddressParent() {
        return mailAddressParent;
    }

    public void setMailAddressParent(String mailAddressParent) {
        this.mailAddressParent = mailAddressParent;
    }

    public List<SelectItem> getYearList() {
        return yearList;
    }

    public List<SelectItem> getMonthList() {
        return monthList;
    }

    public List<SelectItem> getDayList() {
        return dayList;
    }

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
