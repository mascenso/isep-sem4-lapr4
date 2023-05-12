package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String solution;

    @Column(nullable = false)
    private String[] solutionMatching;

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", solution='" + solution + '\'' +
                ", solutionMatching=" + Arrays.toString(solutionMatching) +
                ", solutionList=" + solutionList +
                '}';
    }

    public Long getSolutionThroughId() {
        return id;
    }

    private List<String> solutionList = new ArrayList<>();

    protected Solution(final String solution) {
        this.solution = solution;
    }

    protected Solution(final String[] solution) {
        for (int i=0;i<solution.length;i++) {
            solutionList.add(solution[i]);
        }
    }
    public static Solution valueOf(final String solution) {
        Preconditions.nonEmpty(solution, "Solution cannot be empty");
        return new Solution(solution);
    }


    public static Solution valueOf(final String[] solutions) {
        Preconditions.nonEmpty(List.of(solutions), "Solution list cannot be empty");
        return new Solution(solutions);
    }
}
