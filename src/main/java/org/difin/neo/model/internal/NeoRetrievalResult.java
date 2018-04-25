package org.difin.neo.model.internal;

import org.difin.neo.model.api.Neo;

import java.util.List;
import java.util.Optional;

public class NeoRetrievalResult {

    private List<Neo> neoList;
    private Optional<Neo> largestNeo;
    private Optional<Neo> closestNeo;

    public List<Neo> getNeoList() {
        return neoList;
    }

    public void setNeoList(List<Neo> neoList) {
        this.neoList = neoList;
    }

    public Optional<Neo> getLargestNeo() {
        return largestNeo;
    }

    public void setLargestNeo(Optional<Neo> largestNeo) {
        this.largestNeo = largestNeo;
    }

    public Optional<Neo> getClosestNeo() {
        return closestNeo;
    }

    public void setClosestNeo(Optional<Neo> closestNeo) {
        this.closestNeo = closestNeo;
    }
}
