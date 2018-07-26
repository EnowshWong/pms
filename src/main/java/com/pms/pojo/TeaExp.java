package com.pms.pojo;

import java.util.List;

/**
 * @author:wong
 */
public class TeaExp extends PmsUserTea{
    private List<PmsExp> pmsExps;

    public List<PmsExp> getPmsExps() {
        return pmsExps;
    }

    public void setPmsExps(List<PmsExp> pmsExps) {
        this.pmsExps = pmsExps;
    }
}
