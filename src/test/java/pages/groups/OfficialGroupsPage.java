package pages.groups;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class OfficialGroupsPage extends BaseGroupPage{
    public OfficialGroupsPage() {
        super();
    }

    public OfficialGroupsPage checkContainOfficialGroups(){
        groupsList.getGroups().subList(0,6)
            .forEach(e -> Assertions.assertTrue(e.isOfficial(),"Not official group!"));
        return this;
    }

    public static OfficialGroupsPage openOfficialGroupsPage(){
        open("https://ok.ru/groups/official");
        return new OfficialGroupsPage();
    }
}
