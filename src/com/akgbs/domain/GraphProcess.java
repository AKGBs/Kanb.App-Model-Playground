package com.akgbs.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GraphProcess {

    public ArrayList<Arc> getArcList() {
        return arcList;
    }

    private final ArrayList<Arc> arcList;

    public GraphProcess(ArrayList<Arc> arcList) {
        this.arcList = arcList;
    }
}
