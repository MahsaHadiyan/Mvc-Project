package org.j2os.project.common.wrapper;

import java.sql.SQLException;

/**
 * //TODO explain Functionality of this class
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.10   Hadian
 */
public class ExceptionWrapper {

    public static String getError(Exception e){
        e.printStackTrace();
        if (e instanceof ArithmeticException) {
            return "NAKON";
        } else if (e instanceof SQLException) {
            return "DATABASE ERROR";
        } else if (e instanceof ClassNotFoundException) {
            return "DEPENDENCY ERROR";
        } else {
            return "CONNECT TO SUPPORT";
        }
    }
}
