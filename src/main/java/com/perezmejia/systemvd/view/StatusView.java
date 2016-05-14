package com.perezmejia.systemvd.view;

/**
 * Created by Guil on 5/14/2016.
 */
public enum StatusView {
    INACTIVO(0, "Inactivo"),
    ACTIVO(1, "Activo");

    private final int id;
    private final String description;

    StatusView(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
