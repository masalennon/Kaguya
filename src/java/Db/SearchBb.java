/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "searchBb")
@ViewScoped
public class SearchBb extends SuperBb {

    @NotEmpty
    private Integer id;
    @NotEmpty
    private String firstName;
    private String addressOne;
    private String addressTwo;
    private String educationContent;

    private String message;

    private String payment;

    private String search;
    private String secondSearch;
    private String thirdSearch;

    private List<OldCoupleInformation> filteredList;
    private List<ColumnModel> filteredColumns;

    @EJB
    protected OldCoupleInformationDb db;
    protected OldCoupleInformation oci;

    @PostConstruct
    public void loadpage() {
        System.out.println("loadpage() in searchBb");
        filter();
        System.out.println("search in searchBb = " + search);
        filteredColumns = new ArrayList<>();
        createDynamicColumns();

    }

    public StreamedContent getPic() {
        System.out.println("pic in searchBb");
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("if");
            return new DefaultStreamedContent();
        } else {
            System.out.println("if else");
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("id");
            OldCoupleInformation e = find(Integer.valueOf(key));

            ByteArrayInputStream in = new ByteArrayInputStream(e.getImage());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }

    public StreamedContent getRoomPic() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("if");
            return new DefaultStreamedContent();
        } else {
            System.out.println("if else");
            ExternalContext sv = context.getExternalContext();
            Map<String, String> map = sv.getRequestParameterMap();
            String key = map.get("id");
            OldCoupleInformation e = find(Integer.valueOf(key));

            ByteArrayInputStream in = new ByteArrayInputStream(e.getImageRoom());
            DefaultStreamedContent ds = new DefaultStreamedContent(in);
            return ds;
        }
    }

    public String detail(OldCoupleInformation oldcoupleinformation) {
        System.out.println("detail() in SearchBb");
        oci = oldcoupleinformation;
//        return "filtered-detail-content.xhtml";
        return "/filtered-detail-content.xhtml?faces-redirect=true";

    }

    public void filter() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        search = (String) flash.get("search");
        System.out.println("filter()");
        System.out.println("search in filter() = " + search);

        if (search != null) {
            setSecondSearch(search);
        }
        System.out.println("secondSearch in filter() = " + secondSearch);

//        this.search = getSearch();
//        System.out.println(this.search);
        if (secondSearch != null) {
            this.filteredList = db.filterTable(secondSearch);
        } else {
            System.out.println("not found");
        }

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

    public OldCoupleInformation getOci() {
        return oci;
    }

    public void setOci(OldCoupleInformation oci) {
        this.oci = oci;
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

    public OldCoupleInformationDb getDb() {
        return db;
    }

    public void setDb(OldCoupleInformationDb db) {
        this.db = db;
    }

    public String getSecondSearch() {
        return secondSearch;
    }

    public void setSecondSearch(String secondSearch) {
        this.secondSearch = secondSearch;
    }

    public String getThirdSearch() {
        return thirdSearch;
    }

    public void setThirdSearch(String thirdSearch) {
        this.thirdSearch = thirdSearch;
    }

}
