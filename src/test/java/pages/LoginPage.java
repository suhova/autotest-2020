package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static By LOGIN = By.name("st.email");
    private final static By PASSWORD = By.name("st.password");
    private final static String loginBot = "technopolisBot206";
    private final static String passwordBot = "technopolis16";


    public MainPage login() {
        $(LOGIN).waitUntil(exist, 3000).append(loginBot);
        $(PASSWORD).waitUntil(exist, 3000).append(passwordBot).pressEnter();
        return new MainPage();
    }

    public void loginFieldIsExist(){
        Assertions.assertTrue($(LOGIN).waitUntil(exist, 3000).exists(), "Поле логина не найдено :(");
    }

    public void passwordFieldIsExist(){
        Assertions.assertTrue($(PASSWORD).waitUntil(exist, 3000).exists(), "Поле пароля не найдено :(");
    }
}
