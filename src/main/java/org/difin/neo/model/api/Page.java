package org.difin.neo.model.api;

public class Page {

    private int total_pages;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;

        Page page = (Page) o;

        return getTotal_pages() == page.getTotal_pages();
    }

    @Override
    public int hashCode() {
        return getTotal_pages();
    }
}
