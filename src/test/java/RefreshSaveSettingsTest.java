import org.junit.jupiter.api.Test;
import pages.settings.PrivacySettingPage;
import pages.settings.SettingPage;
import util.BaseTest;
import util.RadioSettingValues;

public class RefreshSaveSettingsTest extends BaseTest {
    @Test
    public void refreshSaveSettingsTest() {
        PrivacySettingPage privacySettingPage = SettingPage.openSettings()
            .openPrivacySettings();

        privacySettingPage.changeRadioButtonValuesRefreshCheck(RadioSettingValues.ALL);
        privacySettingPage.changeRadioButtonValuesRefreshCheck(RadioSettingValues.FRIENDS);
        privacySettingPage.changeRadioButtonValuesRefreshCheck(RadioSettingValues.ONLY_ME);
    }
}
