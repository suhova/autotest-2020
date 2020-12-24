package pages.topPhoto;

import org.openqa.selenium.By;
import pages.UserPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.utils.HtmlElementUtils;

import static com.codeborne.selenide.Selenide.$;

public class PhotoPage {
    public final static String CREATE_ALBUM = ".//*[@data-l='t,create-photo-album'";
    Button createAlbum;
    public final static String ALBUM_NAME_PLACEHOLDER = ".//*[@data-l='t,t,textField-editor'";
    TextInput albumNamePlaceholder;

    public PhotoPage() {
        HtmlElementUtils.existsInClasspath(CREATE_ALBUM);
        createAlbum = new Button($(By.xpath(CREATE_ALBUM)));
        HtmlElementUtils.existsInClasspath(ALBUM_NAME_PLACEHOLDER);
        albumNamePlaceholder = new TextInput($(By.xpath(ALBUM_NAME_PLACEHOLDER)));
    }

    public UserPage createAlbum() {
        createAlbum.click();
        albumNamePlaceholder.clear();
        albumNamePlaceholder.sendKeys("AlbumName");
        return new UserPage();
    }


}
