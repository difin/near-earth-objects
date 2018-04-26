package org.difin.neo.model.api;

public class RelativeVelocity {

    private String kilometers_per_second;
    private String kilometers_per_hour;

    public String getKilometers_per_second() {
        return kilometers_per_second;
    }

    public void setKilometers_per_second(String kilometers_per_second) {
        this.kilometers_per_second = kilometers_per_second;
    }

    public String getKilometers_per_hour() {
        return kilometers_per_hour;
    }

    public void setKilometers_per_hour(String kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelativeVelocity)) return false;

        RelativeVelocity that = (RelativeVelocity) o;

        if (!getKilometers_per_second().equals(that.getKilometers_per_second())) return false;
        return getKilometers_per_hour().equals(that.getKilometers_per_hour());
    }

    @Override
    public int hashCode() {
        int result = getKilometers_per_second().hashCode();
        result = 31 * result + getKilometers_per_hour().hashCode();
        return result;
    }
}
