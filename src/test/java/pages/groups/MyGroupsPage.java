package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import util.Constants;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static util.Constants.*;

public class MyGroupsPage {
    private static final By GROUPS = By.xpath(".//*[@id='hook_Block_DetailedUserGroupsListBlock']//*[@class='ugrid_cnt']//*[@data-l='t,visit']");

    private List<SelenideElement> groups;

    public MyGroupsPage(){
        $(GROUPS).should(Condition.exist);
        groups = $$(GROUPS);
    }
    public static MyGroupsPage openMyGroups() {
        open(MY_GROUPS_LINK);
        return new MyGroupsPage();
    }
    public MyGroupsPage leaveGroups() {
        groups.forEach(element -> {
            element.click();
            new CommunityPage().leave();
            openMyGroups();
        });
        return this;
    }
}
