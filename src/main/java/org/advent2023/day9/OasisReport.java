package org.advent2023.day9;

import java.util.ArrayList;
import java.util.List;

public class OasisReport {

    List<ReportLine> lines;

    public OasisReport(List<String> lines) {
        parseLines(lines);
    }

    private void parseLines(List<String> lines) {
        this.lines = new ArrayList<>();
        for (String line : lines) {
            ReportLine reportLine = new ReportLine(line);
            this.lines.add(reportLine);
        }
    }

    Long extrapolateLinesAndSum() {

        return lines.stream().mapToLong(l -> l.extrapolatedValue).sum();
    }

    Long extrapolateLinesFirstValueAndSum() {

        return lines.stream().mapToLong(l -> l.extrapolatedFirstValue).sum();
    }
}
