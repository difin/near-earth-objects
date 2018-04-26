package org.difin.neo.model.api;

public class CloseApproachData {

    private String close_approach_date;
    private MissDistance miss_distance;
    private RelativeVelocity relative_velocity;
    private String orbiting_body;

    public String getClose_approach_date() {
        return close_approach_date;
    }

    public void setClose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }

    public MissDistance getMiss_distance() {
        return miss_distance;
    }

    public void setMiss_distance(MissDistance miss_distance) {
        this.miss_distance = miss_distance;
    }

    public RelativeVelocity getRelative_velocity() {
        return relative_velocity;
    }

    public void setRelative_velocity(RelativeVelocity relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CloseApproachData)) return false;

        CloseApproachData that = (CloseApproachData) o;

        if (!getClose_approach_date().equals(that.getClose_approach_date())) return false;
        if (!getMiss_distance().equals(that.getMiss_distance())) return false;
        if (!getRelative_velocity().equals(that.getRelative_velocity())) return false;
        return getOrbiting_body().equals(that.getOrbiting_body());
    }

    @Override
    public int hashCode() {
        int result = getClose_approach_date().hashCode();
        result = 31 * result + getMiss_distance().hashCode();
        result = 31 * result + getRelative_velocity().hashCode();
        result = 31 * result + getOrbiting_body().hashCode();
        return result;
    }
}
