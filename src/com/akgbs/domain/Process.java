package com.akgbs.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Process {

    public ArrayList<Arc> getArcList() {
        return arcList;
    }

    private final ArrayList<Arc> arcList;

    public Process(ArrayList<Arc> arcList) {
        this.arcList = arcList;
    }
}
