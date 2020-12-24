package pages.settings;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.utils.HtmlElementUtils;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SettingPage {
    private Logger logger = LoggerFactory.getLogger(SettingPage.class);

    private static final String MAIN_SETTINGS_NAV_BAR = ".//*[@data-l='t,settings']";
    private static final String PUBLICITY_SETTINGS_NAV_BAR = ".//*[@data-l='t,publicity_settings']";

    @Name("Main settings in navigation bar")
    private final Button mainSettings;
    @Name("Publicity settings in navigation bar")
    private final Button publicitySettings;

    public SettingPage() {
        HtmlElementUtils.existsInClasspath(MAIN_SETTINGS_NAV_BAR);
        logger.debug("MAIN_SETTINGS_NAV_BAR");
        HtmlElementUtils.existsInClasspath(PUBLICITY_SETTINGS_NAV_BAR);
        logger.debug("PUBLICITY_SETTINGS_NAV_BAR");
        mainSettings = new Button($(By.xpath(MAIN_SETTINGS_NAV_BAR)));
        publicitySettings = new Button($(By.xpath(PUBLICITY_SETTINGS_NAV_BAR)));
    }

    public static SettingPage openSettings(){
        String link = "https://ok.ru/settings";
        open(link);
        return new SettingPage();
    }

    public PrivacySettingPage openPrivacySettings() {
        publicitySettings.click();
        logger.debug("Click on publicity settings button");
        return new PrivacySettingPage();
    }

}
