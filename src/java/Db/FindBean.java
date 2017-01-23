///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Db;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Stateful;
//import javax.ejb.Stateless;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
///**
// *
// * @author Masanari
// */
////@Stateful
//@ManagedBean(name = "fb")
//public class FindBean implements Serializable {
//
////        protected List<ColumnModel> columns;
//    protected OldCoupleInformation oci;
//
//    @EJB
//    protected OldCoupleInformationDb db;
//
////    protected Bb bb;
////    @PostConstruct
////    public void filt() {
////        System.out.println("filt()");
////        coupleList = db.getAll();
//////        coupleList = db.filterTable(search);
//////        coupleList.clear();
////        System.out.println(search);
////        System.out.println("coupleList = db.filterTable(search);\n");
//////        columns = new ArrayList<>();
//////        createDynamicColumns();
//////        setListFlag(true);
//////        System.out.println("setListFlag(true);\n");
//////        Flash flash = FacesContext.getCurrentInstance()
//////                .getExternalContext().getFlash();
////    }
//
////
////    public String getSearch() {
////        return search;
////    }
////
////    public void setSearch(String search) {
////        this.search = search;
////    }
////
////    public List<OldCoupleInformation> getCoupleList() {
////        return coupleList;
////    }
////
////    public void setCoupleList(List<OldCoupleInformation> coupleList) {
////        this.coupleList = coupleList;
////    }
//
//    public OldCoupleInformation getOci() {
//        return oci;
//    }
//
//    public void setOci(OldCoupleInformation oci) {
//        this.oci = oci;
//    }
//
//}
