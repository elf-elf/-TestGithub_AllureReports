package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private final static String REPOSITORY = "selenide/selenide";
    private final static int NUMBER = 2038;

    @Test
    public void testRepositoryIssue (){
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
