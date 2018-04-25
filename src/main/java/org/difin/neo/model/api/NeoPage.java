package org.difin.neo.model.api;

import java.util.List;

public class NeoPage {

    private List<Neo> near_earth_objects;
    private Page page;

    public List<Neo> getNear_earth_objects() {
        return near_earth_objects;
    }

    public void setNear_earth_objects(List<Neo> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
