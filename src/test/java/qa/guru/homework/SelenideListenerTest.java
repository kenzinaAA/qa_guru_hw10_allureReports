package qa.guru.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("input#query-builder-test").sendKeys("kenzinaAA/homework_guru3");
        $("input#query-builder-test").submit();

        $(linkText("kenzinaAA/homework_guru3")).click();
        $("#issues-tab").click();
        $("[data-tab-item='i1issues-tab']").shouldHave(text("Issues"));
    }

}
