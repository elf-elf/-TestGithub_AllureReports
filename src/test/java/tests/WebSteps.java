package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repository}")
    public void searchForRepository (String repository){
        $("[placeholder='Search GitHub']").setValue(repository).pressEnter();
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository (String repository){
        $$(".repo-list li").first().$("a").click();
    }
    @Step("Переходим в раздел Issues")
    public void openIssuesTab (){
        $("#issues-tab").click();
    }
    @Step("Проверяем, что существует Issue с номером {number}")
    public void shouldSeeIssueWithNumber (int number ){
        $(withText("#" + number)).shouldBe(Condition.visible);
    }
}
