package org.difin.neo.model.api;

public class Links {

    private String self;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Links)) return false;

        Links links = (Links) o;

        return getSelf().equals(links.getSelf());
    }

    @Override
    public int hashCode() {
        return getSelf().hashCode();
    }
}
