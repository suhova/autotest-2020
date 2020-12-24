package pages.settings;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LayoutSettingPage {

    private static final By BUTTON_1= By.xpath(".//*[@name='st.button1action']");
    private static final By BUTTON_2= By.xpath(".//*[@name='st.button2action']");
    private static final By SUBMIT = By.xpath(".//*[@name='button_save_settings']");
    private static final By LENTA_BLOCK = By.xpath(".//*[@name='st.opt_mainPagePortlet']");

    private SelenideElement button1;
    private SelenideElement button2;
    private SelenideElement submit;

    public LayoutSettingPage(){
        $(BUTTON_1).should(Condition.exist);
        $(BUTTON_2).should(Condition.exist);
        $(LENTA_BLOCK).should(Condition.exist);
        $(SUBMIT).should(Condition.exist);

        button1 = $(BUTTON_1);
        button2 = $(BUTTON_2);
        submit = $(SUBMIT);
    }
    public static LayoutSettingPage openLayoutSettings(){
        String link = "https://ok.ru/settings/layout";
        open(link);
        return new LayoutSettingPage();
    }

    public LayoutSettingPage changeButton1(int index) {
        button1.selectOption(index);
        button1.click();
        return this;
    }

    public LayoutSettingPage changeButton2(int index) {
        button2.selectOption(index);
        button2.click();
        return this;
    }
    public LayoutSettingPage saveSettings() {
        if(submit.isEnabled()){
            submit.click();
        }
        return this;
    }
    public LayoutSettingPage checkDisabledSubmit() {
        button2.click();
        submit.should(Condition.disabled);
        return this;
    }
    public LayoutSettingPage checkButton1Value(String value) {
        System.out.println(button1.getSelectedValue());
        Assertions.assertTrue(button1.getSelectedValue().equals(value));
        return this;
    }
    public LayoutSettingPage checkButton2Value(String value) {
        System.out.println(button2.getSelectedValue());
        Assertions.assertTrue(button2.getSelectedValue().equals(value));
        return this;
    }
}
