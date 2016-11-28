/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "fileUploadBean")
@RequestScoped
public class FileUploadBean {
    private Part file;

    
    public String upload() {
        return null;
    }
    
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    
}
