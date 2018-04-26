package org.difin.neo.model.api;

public class EstimatedDiameter {

    private Kilometers kilometers;

    public Kilometers getKilometers() {
        return kilometers;
    }

    public void setKilometers(Kilometers kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstimatedDiameter)) return false;

        EstimatedDiameter that = (EstimatedDiameter) o;

        return getKilometers().equals(that.getKilometers());
    }

    @Override
    public int hashCode() {
        return getKilometers().hashCode();
    }
}