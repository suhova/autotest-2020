import org.junit.jupiter.api.Test;
import pages.settings.LayoutSettingPage;
import util.BaseTest;

import static com.codeborne.selenide.Selenide.refresh;

public class SaveRefreshLayoutSettingTest extends BaseTest {
    @Test
    public void saveRefreshLayoutSettingTest() {
        LayoutSettingPage layoutSettingPage = LayoutSettingPage.openLayoutSettings();

        layoutSettingPage
            .changeButton1(0)
            .changeButton2(1)
            .saveSettings();
        refresh();

        layoutSettingPage = LayoutSettingPage.openLayoutSettings();
        layoutSettingPage.checkButton1Value("NONE")
            .checkButton2Value("MESSAGE");

    }
}
