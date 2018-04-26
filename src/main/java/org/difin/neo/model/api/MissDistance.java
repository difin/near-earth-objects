package org.difin.neo.model.api;

public class MissDistance {

    private double astronomical;

    public double getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(double astronomical) {
        this.astronomical = astronomical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MissDistance)) return false;

        MissDistance that = (MissDistance) o;

        return Double.compare(that.getAstronomical(), getAstronomical()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getAstronomical());
        return (int) (temp ^ (temp >>> 32));
    }
}
