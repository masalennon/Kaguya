/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import entities.Image;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Masanari
 */
@ManagedBean(eager = true, name = "dbBean")
@ApplicationScoped
public class DbBean {

    private Map<String, Image> image;
//
//    @PostConstruct
//    public void init() {
//        image = new HashMap<>();
//    }

    public Map<String, Image> getImage() {
        return image;
    }

}
