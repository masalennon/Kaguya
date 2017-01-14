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
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
@SessionScoped
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
    private String addressOneParent;
    @NotNull
    private String addressTwoParent;
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
    }

    public String goToConfirm() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("firstName", this.firstNameParent);
        flash.put("lastName", this.lastNameParent);
        flash.put("firstNameHurigana", this.firstNameHuriganaParent);
        flash.put("lastNameHurigana", this.lastNameHuriganaParent);
        flash.put("addressOne", this.addressOneParent);
        flash.put("addressTwo", this.addressTwoParent);
        flash.put("birthYear", this.birthYearParent);
        flash.put("birthMonth", this.birthMonthParent);
        flash.put("birthDay", this.birthDayParent);
        flash.put("phoneNumber", this.phoneNumberParent);
        flash.put("mailAddress", this.mailAddressParent);

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

}
