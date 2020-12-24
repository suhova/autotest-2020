package util;

import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static util.Constants.OK_LINK;

public class BaseTest {

    @BeforeAll
    public static void init() {
        open(OK_LINK);
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
}
