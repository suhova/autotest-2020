package pages.groups.blocks;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.groups.*;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$;

public class GroupNavBlock {
    private static By RECOMMENDED = By.xpath(".//*[@hrefattrs='st.cmd=userAltGroup&st._aid=GroupsSubMenu_User_Groups_MiniFeed']");
    private static By OFFICIAL = By.xpath(".//*[@hrefattrs='st.cmd=groupCatalog&st.ci=official']");
    private static By ADVERT = By.xpath(".//*[@hrefattrs='st.cmd=groupCatalog&st.ci=adverts']");

    private Button recommendedGroupsButton;
    private Button officialGroupsButton;
    private Button advertisementBlockGroupsButton;
    private Button moderationButton;

    public GroupNavBlock(){
        $(RECOMMENDED).should(Condition.exist);
        $(OFFICIAL).should(Condition.exist);
        $(ADVERT).should(Condition.exist);

        recommendedGroupsButton = new Button($(RECOMMENDED));
        officialGroupsButton = new Button($(OFFICIAL));
        advertisementBlockGroupsButton = new Button($(ADVERT));
    }

    public RecommendedGroupsPage openRecommendedGroupsPage(){
        recommendedGroupsButton.click();
        return new RecommendedGroupsPage();
    }
    public OfficialGroupsPage openOfficialGroupsPage(){
        officialGroupsButton.click();
        return new OfficialGroupsPage();
    }
    public AdvertisementBoardsPage openAdvertisementBoardsPage(){
        advertisementBlockGroupsButton.click();
        return new AdvertisementBoardsPage();
    }
    public GroupNavBlock moderationGroup(){
        moderationButton.click();
        return this;
    }
}