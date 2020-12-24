package pages.groups.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.*;

import static com.codeborne.selenide.Selenide.$;

public class GroupElement extends TypifiedElement {
    private static By IMAGE = By.className("photo_img");
    private static By NAME = By.className("o two-lines group-name-link");
    private static By FOLLOWERS = By.className("friends-in-group_label");
    private static By JOIN = By.xpath(".//*[@data-l='t,join']");
    private static By OFFICIAL = By.xpath(".//*[@class='svg-ic svg-ico_official_16 __inline']");
    private static By JOINED = By.xpath(".//*[@class='svg-ic svg-ico_done_16 tico_img c-green']");

    private SelenideElement groupImage;
    private TextBlock followers;
    private Button joinButton;
    private Link groupName;

    public GroupElement(WebElement wrappedElement) {
        super(wrappedElement);
        $(IMAGE).should(Condition.exist);
        $(FOLLOWERS).should(Condition.exist);
        $(JOIN).should(Condition.exist);

        groupImage = $(IMAGE);
        followers = new TextBlock($(FOLLOWERS));
        joinButton = new Button($(JOIN));
    }

    public GroupElement join(){
        joinButton.click();
        System.out.println(followers.getText());
        return this;
    }

    public String getName() {
        return groupName.getAttribute("title");
    }

    public boolean isOfficial(){
        return $(OFFICIAL).exists();
    }

    public boolean isJoined(){
        return !$(JOINED).exists();
    }
}
