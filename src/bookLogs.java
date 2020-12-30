/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
public class bookLogs {
    private String b_ID,m_ID,B_date,R_date;

    
    
    public bookLogs(String b_ID, String m_ID, String B_date, String R_date) {
        this.b_ID = b_ID;
        this.m_ID = m_ID;
        this.B_date = B_date;
        this.R_date = R_date;
    }

    public String getB_ID() {
        return b_ID;
    }

    public String getM_ID() {
        return m_ID;
    }

    public String getB_date() {
        return B_date;
    }

    public String getR_date() {
        return R_date;
    }
    
    
    
}
