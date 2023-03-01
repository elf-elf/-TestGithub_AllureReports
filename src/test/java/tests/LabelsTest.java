package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issues")
    @Story("Поиск по Issues")
    @DisplayName("проверка работы поиска по Issues через Аннотации")
    @Owner("Alexandrov Artem")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Github", url = "https://github.com")
    public void testIssueSearch () {
    }

    @Test
    @DisplayName("проверка работы поиска по Issues через Методы")
    public void testLabelsWithMethods (){
        Allure.feature("Issues");
        Allure.story("Поиск по Issues");
        Allure.label("owner", "Alexandrov Artem");
        Allure.label("severity", SeverityLevel.NORMAL.toString());
        Allure.link("Github","https://github.com" );
    }
}
