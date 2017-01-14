package Db;

import Db.OldCoupleInformation;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import net.tkxtools.MailSender;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import util.PagenationHelper;
//
///**
// *
// * @author Masanari
// */
//@Named

public class SuperBb<T> extends OldCoupleInformationDb {

//    private String search;
    private final List<SelectItem> yearList = new ArrayList();
    private final List<SelectItem> monthList = new ArrayList();
    private final List<SelectItem> dayList = new ArrayList();
    //DataTableのカラムリスト
    protected List<ColumnModel> columns;

    @EJB
    protected OldCoupleInformationDb db;

    @PostConstruct
    public void loadPage() {
        for (int i = 1930; i <= 1990; i++) {
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

//        coupleList = db.getAll();
//        System.out.println("cupleList was initialized.");
        columns = new ArrayList<>();
        createDynamicColumns();
        getPagination();

//PagenationHelper getPagination();
    }

    /**
     * カラム生成
     */
    public void createDynamicColumns() {
        columns.clear();
        
        //ヘッダとエンティティの属性である変数名を記述
        columns.add(new ColumnModel("id", "id"));
        columns.add(new ColumnModel("名前", "firstName"));
        columns.add(new ColumnModel("住んでいる地域", "addressOne"));
        columns.add(new ColumnModel("丁目", "addressTwo"));
        columns.add(new ColumnModel("提供できる保育の内容", "educationContent"));
        columns.add(new ColumnModel("保護者の方への言葉", "message"));

    }



    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "home";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "home";
    }

    private PagenationHelper pagination;
    private int selectedItemIndex;
    private DataModel dtmdl;

    public PagenationHelper getPagination() {

        if (pagination == null) {

            pagination = new PagenationHelper(10) {
                @Override
                public int getItemsCount() {
                    return db.count();
                }

                @Override
                public DataModel createPageDataModel() {

                    return new ListDataModel(db.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public DataModel getDtmdl() {
        if (dtmdl == null) {
            dtmdl = getPagination().createPageDataModel();
        }
        return dtmdl;
    }

    private void recreateModel() {
        dtmdl = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    private void updateCurrentItem() {
        int count = db.count();
        if (selectedItemIndex >= count) {

            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;

            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {

                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            OldCoupleInformation item = (OldCoupleInformation) db.findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
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

    public DataModel getdtmdl() {
        return dtmdl;
    }

    public void setDtmdl(DataModel dtmdl) {
        this.dtmdl = dtmdl;
    }
//
//    public String getSearch() {
//        return search;
//    }
//
//    public void setSearch(String search) {
//        this.search = search;
//    }

}

//
//    @EJB
//    OldCoupleInformationDb db;
//
//    @NotEmpty
//    private Long id;
//    @NotEmpty
//    private String firstName;
//    @NotEmpty
//    private String lastName;
//    @NotEmpty
//    private String firstNameHurigana;
//    @NotEmpty
//    private String lastNameHurigana;
//    @NotEmpty
//    private String addressOne;
//    @NotEmpty
//    private String addressTwo;
//    @NotEmpty
//    private String birthYear = "1940";
//    @NotEmpty
//    private String birthMonth = "1";
//    @NotEmpty
//    private String birthDay = "1";
//    @NotEmpty
//    private String firstNameWife;
//    @NotEmpty
//    private String lastNameWife;
//    @NotEmpty
//    private String firstNameHuriganaWife;
//    @NotEmpty
//    private String lastNameHuriganaWife;
//    @NotEmpty
//    private String birthYearWife = "1940";
//    @NotEmpty
//    private String birthMonthWife = "1";
//    @NotEmpty
//    private String birthDayWife = "1";
//    @NotEmpty
//    private String phoneNumber;
//
//    private String educationContent;
//
//    private String message;
//
//    private String payment;
//
//    private Part file;//byte[]に画像を変換するメソッドを作って、それをbyte[]型で格納すれば良い
//
//    InputStream is;
//
//    private byte[] image;
//
//    @NotEmpty
//    private String mailAddress;
//
//    String detail = "詳細へ";
//
//    protected OldCoupleInformation oci;
//
////    @EJB
////    protected OldCoupleInformationDb db;
////    @Inject
////    transient Logger log;
////    @EJB
////    protected MailSender sender;		// 電子メールユーティリティ
////    @Inject
////    protected MakeText text;
//    @EJB
//    CoupleDb coupleDb;
//
//    public StreamedContent getPicL() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//            return new DefaultStreamedContent();
//        } else {
//            ExternalContext sv = context.getExternalContext();
//            Map<String, String> map = sv.getRequestParameterMap();
//            String key = map.get("id");
//            OldCoupleInformation e = (OldCoupleInformation) (coupleDb.find(Long.valueOf(id)));
//            ByteArrayInputStream in = new ByteArrayInputStream(e.getImage());
//            DefaultStreamedContent ds = new DefaultStreamedContent(in);
//            return ds;
//        }
//    }
//
////    @EJB
////    protected DbBean dbBean;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstNameHurigana() {
//        return firstNameHurigana;
//    }
//
//    public void setFirstNameHurigana(String firstNameHurigana) {
//        this.firstNameHurigana = firstNameHurigana;
//    }
//
//    public String getLastNameHurigana() {
//        return lastNameHurigana;
//    }
//
//    public void setLastNameHurigana(String lastNameHurigana) {
//        this.lastNameHurigana = lastNameHurigana;
//    }
//
//    public String getAddressOne() {
//        return addressOne;
//    }
//
//    public void setAddressOne(String addressOne) {
//        this.addressOne = addressOne;
//    }
//
//    public String getAddressTwo() {
//        return addressTwo;
//    }
//
//    public void setAddressTwo(String addressTwo) {
//        this.addressTwo = addressTwo;
//    }
//
//    public String getBirthYear() {
//        return birthYear;
//    }
//
//    public void setBirthYear(String birthYear) {
//        this.birthYear = birthYear;
//    }
//
//    public String getBirthMonth() {
//        return birthMonth;
//    }
//
//    public void setBirthMonth(String birthMonth) {
//        this.birthMonth = birthMonth;
//    }
//
//    public String getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(String birthDay) {
//        this.birthDay = birthDay;
//    }
//
//    public String getFirstNameWife() {
//        return firstNameWife;
//    }
//
//    public void setFirstNameWife(String firstNameWife) {
//        this.firstNameWife = firstNameWife;
//    }
//
//    public String getLastNameWife() {
//        return lastNameWife;
//    }
//
//    public void setLastNameWife(String lastNameWife) {
//        this.lastNameWife = lastNameWife;
//    }
//
//    public String getFirstNameHuriganaWife() {
//        return firstNameHuriganaWife;
//    }
//
//    public void setFirstNameHuriganaWife(String firstNameHuriganaWife) {
//        this.firstNameHuriganaWife = firstNameHuriganaWife;
//    }
//
//    public String getLastNameHuriganaWife() {
//        return lastNameHuriganaWife;
//    }
//
//    public void setLastNameHuriganaWife(String lastNameHuriganaWife) {
//        this.lastNameHuriganaWife = lastNameHuriganaWife;
//    }
//
//    public String getBirthYearWife() {
//        return birthYearWife;
//    }
//
//    public void setBirthYearWife(String birthYearWife) {
//        this.birthYearWife = birthYearWife;
//    }
//
//    public String getBirthMonthWife() {
//        return birthMonthWife;
//    }
//
//    public void setBirthMonthWife(String birthMonthWife) {
//        this.birthMonthWife = birthMonthWife;
//    }
//
//    public String getBirthDayWife() {
//        return birthDayWife;
//    }
//
//    public void setBirthDayWife(String birthDayWife) {
//        this.birthDayWife = birthDayWife;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEducationContent() {
//        return educationContent;
//    }
//
//    public void setEducationContent(String educationContent) {
//        this.educationContent = educationContent;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getPayment() {
//        return payment;
//    }
//
//    public void setPayment(String payment) {
//        this.payment = payment;
//    }
//
//    public Part getFile() {
//        return file;
//    }
//
//    public void setFile(Part file) {
//        this.file = file;
//    }
//
//    public InputStream getIs() {
//        return is;
//    }
//
//    public void setIs(InputStream is) {
//        this.is = is;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
//
//    public String getMailAddress() {
//        return mailAddress;
//    }
//
//    public void setMailAddress(String mailAddress) {
//        this.mailAddress = mailAddress;
//    }
//
//    public String getDetail() {
//        return detail;
//    }
//
//    public void setDetail(String detail) {
//        this.detail = detail;
//    }
//
//    public OldCoupleInformation getOci() {
//        return oci;
//    }
//
//    public void setOci(OldCoupleInformation oci) {
//        this.oci = oci;
//    }
////
////    public OldCoupleInformationDb getDb() {
////        return db;
////    }
////
////    public void setDb(OldCoupleInformationDb db) {
////        this.db = db;
////    }
////
////    public Logger getLog() {
////        return log;
////    }
////
////    public void setLog(Logger log) {
////        this.log = log;
////    }
////
////    public MailSender getSender() {
////        return sender;
////    }
////
////    public void setSender(MailSender sender) {
////        this.sender = sender;
////    }
////
////    public MakeText getText() {
////        return text;
////    }
////
////    public void setText(MakeText text) {
////        this.text = text;
////    }
//
//    public CoupleDb getCoupleDb() {
//        return coupleDb;
//    }
//
//    public void setCoupleDb(CoupleDb coupleDb) {
//        this.coupleDb = coupleDb;
//    }
//    
//}
