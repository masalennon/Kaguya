/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import javax.ejb.Stateless;

/**
 *
 * @author Masanari
 */
@Stateless
public class CoupleDb extends TryCatchDb {

    public CoupleDb() {
        super(OldCoupleInformation.class);
    }
}
