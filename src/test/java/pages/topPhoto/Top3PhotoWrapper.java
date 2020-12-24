package pages.topPhoto;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static pages.topPhoto.TopPhotoPage.getIntegerFromString;

public class Top3PhotoWrapper {
    public final static By PHOTO = By.xpath(".//*[@class='photo-wall-results_card-photo']");
    public final By ALL_LIKES = By.className("photo-wall-results_widget");
    public final String PREFIX = ".//*[@class='photo-wall-results_card __";
    public final String SUFFIX = "']";
    SelenideElement element;

    public Top3PhotoWrapper(Integer num) {
        this.element = $(By.xpath(PREFIX+num+SUFFIX)).waitUntil(exist,3000);
    }
    public Top3PhotoWrapper(SelenideElement element) {
        this.element = element.waitUntil(exist,3000);
    }
    public Integer getTopLikes() {
        return getIntegerFromString(element
            .$(ALL_LIKES)
            .getText());
    }

    public String getTopPhotoLink() {
        return element
            .$(PHOTO)
            .$(By.tagName("img"))
            .getAttribute("src");
    }
}
