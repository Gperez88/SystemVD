package com.perezmejia.systemvd.view;

/**
 * Created by Guil on 5/15/2016.
 */
public class AutoCompleteData {
    private String value;
    private String data;

    public AutoCompleteData(String value, String data) {
        this.value = value;
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
