package qa.guru.homework;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class HomeworkWebStepsTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий по пути {repo}")
    public void searchButtonAndRepository(String repo) {
        $(".search-input-container").click();
        $("input#query-builder-test").sendKeys(repo);
        $("input#query-builder-test").submit();
    }

    @Step("Кликаем по найденной ссылке репозитория {repo}")
    public void clickOnFindRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesPage() {
        $("#issues-tab").click();
    }

    @Step("Проверяем заголовок вкладки ")
    public void shouldSeeTitleIssue (String title) { $("[data-tab-item='i1issues-tab']").shouldBe(visible).shouldHave(text(title));
    }
}
