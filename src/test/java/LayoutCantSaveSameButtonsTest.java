import org.junit.jupiter.api.Test;
import pages.settings.LayoutSettingPage;
import util.BaseTest;

public class LayoutCantSaveSameButtonsTest extends BaseTest {
    @Test
    public void layoutCantSaveSameButtonsTest() {
        LayoutSettingPage layoutSettingPage = LayoutSettingPage.openLayoutSettings();

        layoutSettingPage
            .changeButton1(0)
            .changeButton2(0)
            .checkDisabledSubmit();
    }
}
