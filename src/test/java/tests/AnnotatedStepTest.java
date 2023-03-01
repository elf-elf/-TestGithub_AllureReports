package tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String REPOSITORY = "selenide/selenide";
    private final static int NUMBER = 2172;
    private WebSteps steps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository () {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);
    }
}
