package org.difin.neo.model.api;

public class Kilometers{

    private Double estimated_diameter_min;
    private Double estimated_diameter_max;

    public Double getEstimated_diameter_min() {
        return estimated_diameter_min;
    }

    public void setEstimated_diameter_min(Double estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }

    public Double getEstimated_diameter_max() {
        return estimated_diameter_max;
    }

    public void setEstimated_diameter_max(Double estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kilometers)) return false;

        Kilometers that = (Kilometers) o;

        if (!getEstimated_diameter_min().equals(that.getEstimated_diameter_min())) return false;
        return getEstimated_diameter_max().equals(that.getEstimated_diameter_max());
    }

    @Override
    public int hashCode() {
        int result = getEstimated_diameter_min().hashCode();
        result = 31 * result + getEstimated_diameter_max().hashCode();
        return result;
    }
}