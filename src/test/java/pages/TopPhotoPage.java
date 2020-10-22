package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopPhotoPage {
    public final static By TOP_1 = By.xpath(".//*[@class='photo-wall-results_card __1']");
    public final static By TOP_2 = By.xpath(".//*[@class='photo-wall-results_card __2']");
    public final static By TOP_3 = By.xpath(".//*[@class='photo-wall-results_card __3']");
    public final static By LIKES_COUNT = By.xpath(".//*[@class='widget_cnt']");
    public final static By PHOTO = By.xpath(".//*[@class='photo-wall-results_card-photo']");

    public Integer getTopLikes(By likesBy) {
        return getIntegerFromString($(likesBy).waitUntil(exist, 3000)
            .$(By.className("photo-wall-results_widget"))
            .getText());
    }

    public Integer[] getLikes() {
        return $$(LIKES_COUNT).stream()
            .map(SelenideElement::getText)
            .map(TopPhotoPage::getIntegerFromString)
            .toArray(Integer[]::new);
    }
    public String getTopPhotoLink(By by) {
        return $(by).waitUntil(exist,3000)
            .$(PHOTO).waitUntil(exist,3000)
            .$(By.tagName("img"))
            .getAttribute("src");
    }

    public static Integer getIntegerFromString(String from) {
        return Integer.parseInt(from.replaceAll(" ", ""));
    }

}
