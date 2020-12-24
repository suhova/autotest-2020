package pages.topPhoto;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class TopPhotoPage {
    public final static By LIKES_COUNT = By.xpath(".//*[@class='photo-wall-results_widget']");
    public final static String TOP_PAGE_LINK = "https://ok.ru/topphoto/results";


    public Integer[] getLikes() {
        return $$(LIKES_COUNT).stream()
            .map(SelenideElement::getText)
            .map(TopPhotoPage::getIntegerFromString)
            .toArray(Integer[]::new);
    }

    public static Integer getIntegerFromString(String from) {
        return Integer.parseInt(from.replaceAll(" ", ""));
    }
}
