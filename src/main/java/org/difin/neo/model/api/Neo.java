package org.difin.neo.model.api;

import java.util.List;

public class Neo {

    private Links links;
    private String neo_reference_id;
    private String name;
    private String nasa_jpl_url;
    private String absolute_magnitude_h;
    private EstimatedDiameter estimated_diameter;
    private List<CloseApproachData> close_approach_data;
    private Boolean is_potentially_hazardous_asteroid;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getNeo_reference_id() {
        return neo_reference_id;
    }

    public void setNeo_reference_id(String neo_reference_id) {
        this.neo_reference_id = neo_reference_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    public void setNasa_jpl_url(String nasa_jpl_url) {
        this.nasa_jpl_url = nasa_jpl_url;
    }

    public String getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public void setAbsolute_magnitude_h(String absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    public EstimatedDiameter getEstimated_diameter() {
        return estimated_diameter;
    }

    public void setEstimated_diameter(EstimatedDiameter estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }

    public List<CloseApproachData> getClose_approach_data() {
        return close_approach_data;
    }

    public void setClose_approach_data(List<CloseApproachData> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }

    public Boolean getIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public void setIs_potentially_hazardous_asteroid(Boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Neo)) return false;

        Neo neo = (Neo) o;

        if (!getLinks().equals(neo.getLinks())) return false;
        if (!getNeo_reference_id().equals(neo.getNeo_reference_id())) return false;
        if (!getName().equals(neo.getName())) return false;
        if (!getNasa_jpl_url().equals(neo.getNasa_jpl_url())) return false;
        if (!getAbsolute_magnitude_h().equals(neo.getAbsolute_magnitude_h())) return false;
        if (!getEstimated_diameter().equals(neo.getEstimated_diameter())) return false;
        if (getClose_approach_data() != null ? !getClose_approach_data().equals(neo.getClose_approach_data()) : neo.getClose_approach_data() != null)
            return false;
        return getIs_potentially_hazardous_asteroid().equals(neo.getIs_potentially_hazardous_asteroid());
    }

    @Override
    public int hashCode() {
        int result = getLinks().hashCode();
        result = 31 * result + getNeo_reference_id().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getNasa_jpl_url().hashCode();
        result = 31 * result + getAbsolute_magnitude_h().hashCode();
        result = 31 * result + getEstimated_diameter().hashCode();
        result = 31 * result + (getClose_approach_data() != null ? getClose_approach_data().hashCode() : 0);
        result = 31 * result + getIs_potentially_hazardous_asteroid().hashCode();
        return result;
    }
}
