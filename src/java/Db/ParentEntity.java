/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
@Named
@Entity
@Table(name="ParentInfo")
public class ParentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String firstNameParent;
    @NotNull
    private String lastNameParent;
    @NotNull
    private String firstNameHuriganaParent;
    @NotNull
    private String lastNameHuriganaParent;
//    @NotNull
//    private String addressOneParent;
//    @NotNull
//    private String addressTwoParent;
    @NotNull
    private Integer birthYearParent;
    @NotNull
    private Integer birthMonthParent;
    @NotNull
    private Integer birthDayParent;
    @NotNull
    private String phoneNumberParent;
    @NotNull
    private String mailAddressParent;

    public ParentEntity(Integer id, String firstNameParent, String lastNameParent, 
            String firstNameHuriganaParent, String lastNameHuriganaParent, Integer birthYearParent, 
            Integer birthMonthParent, Integer birthDayParent, String phoneNumberParent,
            String mailAddressParent) {
        this.id = id;
        this.firstNameParent = firstNameParent;
        this.lastNameParent = lastNameParent;
        this.firstNameHuriganaParent = firstNameHuriganaParent;
        this.lastNameHuriganaParent = lastNameHuriganaParent;
//        this.addressOneParent = addressOneParent;
//        this.addressTwoParent = addressTwoParent;
        this.birthYearParent = birthYearParent;
        this.birthMonthParent = birthMonthParent;
        this.birthDayParent = birthDayParent;
        this.phoneNumberParent = phoneNumberParent;
        this.mailAddressParent = mailAddressParent;
    }

    public ParentEntity() {
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
//
//    public String getAddressOneParent() {
//        return addressOneParent;
//    }
//
//    public void setAddressOneParent(String addressOneParent) {
//        this.addressOneParent = addressOneParent;
//    }
//
//    public String getAddressTwoParent() {
//        return addressTwoParent;
//    }
//
//    public void setAddressTwoParent(String addressTwoParent) {
//        this.addressTwoParent = addressTwoParent;
//    }

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

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public String getMailAddressParent() {
        return mailAddressParent;
    }

    public void setMailAddressParent(String mailAddressParent) {
        this.mailAddressParent = mailAddressParent;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentEntity)) {
            return false;
        }
        ParentEntity other = (ParentEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ParentEntity[ id=" + id + " ]";
    }
    
}
