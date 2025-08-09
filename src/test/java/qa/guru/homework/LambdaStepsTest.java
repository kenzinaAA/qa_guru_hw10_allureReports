package qa.guru.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest {

    private static final String REPOSITORY = "kenzinaAA/homework_guru3";
    private static final String title = "Issues";

    @Test
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий по пути " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("input#query-builder-test").sendKeys(REPOSITORY);
            $("input#query-builder-test").submit();
        });
        step("Кликаем по найденной ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем заголовок вкладки ", () -> {
            $("[data-tab-item='i1issues-tab']").shouldBe(visible).shouldHave(text("Issues"));
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        HomeworkWebStepsTest steps = new HomeworkWebStepsTest();

        steps.openMainPage();
        steps.searchButtonAndRepository(REPOSITORY);
        steps.clickOnFindRepository(REPOSITORY);
        steps.openIssuesPage();
        steps.shouldSeeTitleIssue(title);
    }
}
