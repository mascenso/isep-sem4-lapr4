package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Embeddable
public class Solution {

    @Column(nullable = false)
    private String solution;


    @ElementCollection
    private List<String> solutionList = new ArrayList<>();


    protected Solution(final String solution) {
        Preconditions.noneNull(solution);
        this.solution = solution;
    }

    protected Solution(final String[] solutionMatching) {
        Preconditions.noneNull(solutionMatching);
        for (int i = 0; i < solutionMatching.length; i++) {
            this.solutionList.add(solutionMatching[i]);
        }
    }

    protected Solution() {
        //for ORM only
    }

    public static Solution valueOf(final String solution) {
        Preconditions.nonEmpty(solution, "Solution cannot be empty");
        return new Solution(solution);
    }


    public static List<String> valueOf(final String[] solutions) {
        Preconditions.noneNull(solutions, "Solution list cannot be empty");
        List<String> solutionList = new ArrayList<>();
        for (String solution : solutions) {
            solutionList.add(solution);
        }
        return solutionList;
    }
}
