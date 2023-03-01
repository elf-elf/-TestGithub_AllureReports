package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ListenerTest {

    @Test
    public void testGitHub() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[placeholder='Search GitHub']").setValue("Selenide/selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#issues-tab").click();
        $(withText("#2172")).shouldBe(Condition.visible);
    }
}
