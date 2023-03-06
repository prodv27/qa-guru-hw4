import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://github.com";
    }

    @Test
    void checkExampleCodeForJUnit5() {

//        Откройте страницу Selenide в Github
        open("/selenide/selenide");

//        Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

//        Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        sleep(600);
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));

//        Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));

    }

}
