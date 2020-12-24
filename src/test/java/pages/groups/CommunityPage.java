package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import static com.codeborne.selenide.Selenide.$;

public class CommunityPage {
    private static By JOIN = By.xpath(".//*[@data-l='t,join']");
    private static By LEAVE = By.xpath(".//*[@class='dropdown_i']");

    SelenideElement join;
    public CommunityPage() {
        $(JOIN).should(Condition.exist);
        join = $(JOIN);
    }

    public CommunityPage leave () {
        join.click();
        $(LEAVE).click();
        return this;
    }

}

