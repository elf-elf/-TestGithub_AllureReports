package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LabelsTest {

    private final static String REPOSITORY = "selenide/selenide";
    private final static int NUMBER = 2172;

    @Test
    @Feature("Issues")
    @Story("Поиск по Issues")
    @DisplayName("Проверка работы поиска по Issues через Аннотации")
    @Owner("Alexandrova Elena")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Github", url = "https://github.com")
    public void testIssueSearch () {

        step ("Открываем главную страницу", ()-> {
            open("https://github.com");
        });

        step ("Ищем репозиторий " + REPOSITORY, ()-> {
            $("[placeholder='Search GitHub']").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $$(".repo-list li").first().$("a").click();
        });

        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем, что существует Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Проверка работы поиска по Issues через Методы")
    public void testLabelsWithMethods (){

        Allure.feature("Issues");
        Allure.story("Поиск по Issues");
        Allure.label("owner", "Alexandrova Elena");
        Allure.label("severity", SeverityLevel.NORMAL.toString());
        Allure.link("Github","https://github.com" );

        step ("Открываем главную страницу", ()-> {
            open("https://github.com");
        });

        step ("Ищем репозиторий " + REPOSITORY, ()-> {
            $("[placeholder='Search GitHub']").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $$(".repo-list li").first().$("a").click();
        });

        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем, что существует Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).shouldBe(Condition.visible);
        });
    }
}
