/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.lang.ProcessBuilder.Redirect.Type;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Masanari
 */
public class runnnable {

    public static void main(String[] args) {
        
    }

    public static void showConstraintViolation(ConstraintViolationException e) {
        // build constraint error
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            sb.append("Error: " + violation.getPropertyPath() + " : " + violation.getMessage() + "\n");

        }
        System.out.println(sb.toString());
//	Notification.show(sb.toString(), Type.ERROR_MESSAGE);
    }

}
