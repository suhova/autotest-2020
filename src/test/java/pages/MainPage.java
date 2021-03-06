package pages;

import org.openqa.selenium.By;
import pages.topPhoto.PhotoPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.utils.HtmlElementUtils;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final String PHOTO_PAGE_BUTTON = ".//*[@data-l='t,t,userPhotos'";
    private final Button photoPageButton;

    public MainPage() {
        HtmlElementUtils.existsInClasspath(PHOTO_PAGE_BUTTON);
        photoPageButton = new Button($(By.xpath(PHOTO_PAGE_BUTTON)));
    }

    public PhotoPage openPhotoPage() {
        photoPageButton.click();
        return new PhotoPage();
    }
}
