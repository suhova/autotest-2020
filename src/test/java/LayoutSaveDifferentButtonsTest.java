import org.junit.jupiter.api.Test;
import pages.settings.LayoutSettingPage;
import util.BaseTest;

public class LayoutSaveDifferentButtonsTest extends BaseTest {

    @Test
    public void layoutSaveDifferentButtonsTest() {
        LayoutSettingPage layoutSettingPage = LayoutSettingPage.openLayoutSettings();

        layoutSettingPage
            .changeButton1(0)
            .changeButton2(1)
            .saveSettings();
    }
}
