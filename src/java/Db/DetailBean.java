/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.PhaseId;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "db")
@ViewScoped
public class DetailBean implements Serializable {

    private Integer id;
    private String firstName;
    private String addressOne;
    private String addressTwo;
    private String educationContent;

    private String message;

    private String payment;

    private String search;

    private List<OldCoupleInformation> filteredList;
    private List<ColumnModel> filteredColumns;

    @EJB
    protected OldCoupleInformationDb db;
    protected OldCoupleInformation oci;
    protected Bb bb;

    @PostConstruct
    public void getDetail() {
//        Flash flash = FacesContext.getCurrentInstance()
//                .getExternalContext().getFlash();
//        oci = (OldCoupleInformation) flash.get("oci");
//        this.id = (Integer) flash.get("id");
        System.out.println("@PostConstruct in DetailBean");

    }

    public StreamedContent getPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("id");
            OldCoupleInformation e = db.find(Integer.valueOf(key));

            ByteArrayInputStream in = new ByteArrayInputStream(e.getImage());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }

    public StreamedContent getRoomPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("id");
            OldCoupleInformation e = db.find(Integer.valueOf(key));

            ByteArrayInputStream in = new ByteArrayInputStream(e.getImageRoom());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }

    
//    bb.getPic();
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

    public List<OldCoupleInformation> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<OldCoupleInformation> filteredList) {
        this.filteredList = filteredList;
    }

    public List<ColumnModel> getFilteredColumns() {
        return filteredColumns;
    }

    public void setFilteredColumns(List<ColumnModel> filteredColumns) {
        this.filteredColumns = filteredColumns;
    }

    public OldCoupleInformationDb getDb() {
        return db;
    }

    public void setDb(OldCoupleInformationDb db) {
        this.db = db;
    }

    public OldCoupleInformation getOci() {
        return oci;
    }

    public void setOci(OldCoupleInformation oci) {
        this.oci = oci;
    }

    public Bb getBb() {
        return bb;
    }

    public void setBb(Bb bb) {
        this.bb = bb;
    }

}
