package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static By LOGIN = By.name("st.email");
    private final static By PASSWORD = By.name("st.password");
    private final static String loginBot = "technopolisBot206";
    private final static String passwordBot = "technopolis16";

    public LoginPage(){
        $(LOGIN).should(exist);
       $(PASSWORD).should(exist);
    }

    public MainPage login() {
        $(LOGIN).append(loginBot);
        $(PASSWORD).append(passwordBot).pressEnter();
        return new MainPage();
    }
}
