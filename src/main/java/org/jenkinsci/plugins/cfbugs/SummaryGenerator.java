package org.jenkinsci.plugins.cfbugs;

import org.jenkinsci.plugins.cfbugs.Messages;

/** Creates HTML summaries for a Lint result, shown on the build page. */
public final class SummaryGenerator {

    /**
     * Returns the message to show as the result summary.
     *
     * @param result Lint result
     * @return HTML to display.
     */
    public static String createSummary(final LintResult result) {
        StringBuilder summary = new StringBuilder();
        int issues = result.getNumberOfAnnotations();

        summary.append("Lint: ");
        if (issues > 0) {
            summary.append("<a href=\"cfBugsResult\">");
        }
        summary.append(Messages.CFBugs_ResultAction_Issues(issues));
        if (issues > 0) {
            summary.append("</a>");
        }
        summary.append(".");

        return summary.toString();
    }

    /**
     * Returns the message indicating delta from previous build.
     *
     * @param result Lint result.
     * @return HTML to display.
     */
    public static String createDeltaMessage(final LintResult result) {
        StringBuilder summary = new StringBuilder();
        if (result.getNumberOfNewWarnings() > 0) {
            summary.append("<li><a href=\"cfBugsResult/new\">");
            summary.append(Messages.CFBugs_ResultAction_NewIssues(result.getNumberOfNewWarnings()));
            summary.append("</a></li>");
        }
        if (result.getNumberOfFixedWarnings() > 0) {
            summary.append("<li><a href=\"cfBugsResult/fixed\">");
            summary.append(Messages.CFBugs_ResultAction_FixedIssues(result.getNumberOfFixedWarnings()));
            summary.append("</a></li>");
        }

        return summary.toString();
    }

}
