package nl.schulte.advent.day04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ElvePair {

    private final List<Integer> sectionIDsElveOne;
    private final List<Integer> sectionIDsElveTwo;

    public ElvePair(String line) {
        final String[] sectionIdRanges = line.split(",");
        this.sectionIDsElveOne = getSectionIDs(sectionIdRanges[0]);
        this.sectionIDsElveTwo = getSectionIDs(sectionIdRanges[1]);
    }

    public boolean hasFullOverlap() {
        return new HashSet<>(sectionIDsElveOne).containsAll(sectionIDsElveTwo) ||
                new HashSet<>(sectionIDsElveTwo).containsAll(sectionIDsElveOne);
    }

    public boolean hasOverlap() {
        return sectionIDsElveOne.stream().anyMatch(sectionIDsElveTwo::contains);
    }

    private List<Integer> getSectionIDs(String sectionRange) {
        final int sectionBeginNumberElveOne = getSectionBeginNumber(sectionRange);
        final int sectionEndNumberElveOne = getSectionEndNumber(sectionRange);

        final List<Integer> sectionIDs = new ArrayList<>();
        for (int i = sectionBeginNumberElveOne; i <= sectionEndNumberElveOne; i++) {
            sectionIDs.add(i);
        }
        return sectionIDs;
    }

    private int getSectionBeginNumber(String sectionRage) {
        return parseInt(sectionRage.split("-")[0]);
    }

    private int getSectionEndNumber(String sectionRage) {
        return parseInt(sectionRage.split("-")[1]);
    }
}
