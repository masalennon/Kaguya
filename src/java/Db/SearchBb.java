/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "searchBb")
@ViewScoped
public class SearchBb {

    @EJB
    private OldCoupleInformationDb oldCoupleInformationDb;

//    @NotEmpty
    private Integer id;
    private String mailAddress;

    List<OldCoupleInformation> editList;

    public String searchToEdit() {
        editList = oldCoupleInformationDb.searchToEdit(mailAddress, id);
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("editList", editList);

        return "edit.xhtml";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public List<OldCoupleInformation> getEditList() {
        return editList;
    }

    public void setEditList(List<OldCoupleInformation> editList) {
        this.editList = editList;
    }

}
