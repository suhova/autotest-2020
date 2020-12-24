package pages.settings;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.utils.HtmlElementUtils;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class PrivacySettingPage {
    private static final By AGE_VISIBILITY_RADIO = By.xpath(".//*[@name='st.accessForAGE_VISIBILITY']");
    private static final By GAMES_APPS_VISIBILITY = By.xpath(".//*[@name='st.accessForGAMES_APPS_VISIBILITY']");
    private static final By GROUPS_VISIBILITY = By.xpath(".//*[@name='st.accessForGROUPS_VISIBILITY']");
    private static final By SUBSCRIPTION_VISIBILITY = By.xpath(".//*[@name='st.accessForSUBSCRIPTION_VISIBILITY']");
    private static final By MAKE_PHOTOPINS = By.xpath(".//*[@name='st.accessForRELATIONS_BLOCK_VISIBILITY']");
    private static final By SUBMIT = By.xpath(".//*[@name='button_changeProfileType']");

    private static final String ALL_RADIO = ".//*[@data-photo-visibility-name='st.accessForPHOTOS_VISIBILITY']//*[@type='radio']";

    public PrivacySettingPage() {
        HtmlElementUtils.existsInClasspath(ALL_RADIO);

        $(AGE_VISIBILITY_RADIO).should(Condition.exist);
        $(GAMES_APPS_VISIBILITY).should(Condition.exist);
        $(GROUPS_VISIBILITY).should(Condition.exist);
        $(SUBSCRIPTION_VISIBILITY).should(Condition.exist);
        $(SUBMIT).should(Condition.exist);
    }


    public PrivacySettingPage changeValuesFromAllRadioButtons(String value, List<SelenideElement> radioButtons) {
        radioButtons.forEach(radio -> { radio.selectRadio(value).click(); });
        return this;
    }

    public PrivacySettingPage checkSelectedValue(String expected, List<SelenideElement> radioButtons) {
        radioButtons.forEach(radio -> {
            Assert.assertEquals("The value of the radio button is not as expected! " + radio.getAttribute("name"),
                expected,
                new Radio(radio).getSelectedButton().getAttribute("value"));
        });
        return this;
    }

    public PrivacySettingPage submitSettings() {
        $(SUBMIT).scrollTo().click();
        return this;
    }

    public PrivacySettingPage changeRadioButtonValuesRefreshCheck(String radioValue) {
        List<SelenideElement> radioButtons = new ArrayList<>();
        radioButtons.add($(AGE_VISIBILITY_RADIO));
        radioButtons.add($(GAMES_APPS_VISIBILITY));
        radioButtons.add($(GROUPS_VISIBILITY));
        radioButtons.add($(SUBSCRIPTION_VISIBILITY));

        changeValuesFromAllRadioButtons(radioValue, radioButtons);

        checkSelectedValue(radioValue, radioButtons);
        System.out.println("Value " + radioValue + " on all radio buttons");

        submitSettings();
        refresh();

        $(AGE_VISIBILITY_RADIO).should(Condition.exist);
        $(GAMES_APPS_VISIBILITY).should(Condition.exist);
        $(GROUPS_VISIBILITY).should(Condition.exist);
        $(SUBSCRIPTION_VISIBILITY).should(Condition.exist);

        checkSelectedValue(radioValue, radioButtons);
        System.out.println("Value " + radioValue + " on all radio buttons after refresh");
        return this;
    }
}
