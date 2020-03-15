package com.epidemic.beans;

import java.util.List;

public class DaliyEpidemicInfo {
    private String date;
    private List<EpidemicInfo> array;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EpidemicInfo> getArray() {
        return array;
    }

    public void setArray(List<EpidemicInfo> array) {
        this.array = array;
    }
}
