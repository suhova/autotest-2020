package pages.groups;

import static com.codeborne.selenide.Selenide.open;

public class RecommendedGroupsPage extends BaseGroupPage{
    public RecommendedGroupsPage() {
        super();
    }

    public static RecommendedGroupsPage openRecommendedGroupPage(){
        open("https://ok.ru/groups");
        return new RecommendedGroupsPage();
    }

    public OfficialGroupsPage openOfficialGroups(){
        return groupNavBlock.openOfficialGroupsPage();
    }
}
