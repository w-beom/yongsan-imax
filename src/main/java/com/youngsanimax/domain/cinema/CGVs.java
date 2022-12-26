package com.youngsanimax.domain.cinema;

import java.util.List;
import java.util.Objects;

public class CGVs {
    private List<CGV> cgvs;

    private CGVs(List<CGV> cgvs) {
        this.cgvs = cgvs;
    }

    public static CGVs of(List<CGV> cgvs) {
        return new CGVs(cgvs);
    }

    public boolean equals(CGVs cgvs) {
        boolean isEquals = false;

        if (this == cgvs) {
            return true;
        }

        if (Objects.equals(cgvs, cgvs.cgvs)) {
            return true;
        }
        for (int i = 0; i < this.cgvs.size(); i++) {

        }

        return isEquals;
    }

    public int hashCode() {
        return Objects.hash(cgvs);
    }
}
