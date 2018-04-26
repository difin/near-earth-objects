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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NeoPage)) return false;

        NeoPage neoPage = (NeoPage) o;

        if (!getNear_earth_objects().equals(neoPage.getNear_earth_objects())) return false;
        return getPage().equals(neoPage.getPage());
    }

    @Override
    public int hashCode() {
        int result = getNear_earth_objects().hashCode();
        result = 31 * result + getPage().hashCode();
        return result;
    }
}
