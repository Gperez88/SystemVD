package com.perezmejia.systemvd.view;

/**
 * Created by Guil on 5/10/2016.
 */
public enum SexView {
    FEMENINO("F", "Femenino"),
    MASCULINO("M", "Masculino");

    private final String id;
    private final String description;

    SexView(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
