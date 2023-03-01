package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class RegionsTest {

    @ParameterizedTest(name = "Проверка сайта в регионе" )
    @CsvSource({
            "Самара, Самарская область",
            "Москва, Московская область",
            "Саратов, Саратовская область"
    })
    public void testRegions (String city, String state) {
        parameter("Область", state);
        parameter("Регион", city);
    step("Открываем сайт в регионе " + state);
    step("Проверяем, что город определился как " + city);
    }
}
