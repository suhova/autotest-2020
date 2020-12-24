package pages.groups.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupsListBlock {
    By groupList = By.xpath(".//*[@class='ucard-v __s __rounded __h ']");

    public GroupsListBlock(){
        $(groupList).should(exist);

        groups = new ArrayList<>();
        $$(groupList).forEach(e -> groups.add(new GroupElement(e)));
    }

    private List<GroupElement> groups;

    public List<GroupElement> getGroups() {
        return groups;
    }

    public GroupElement findGroupByName(String name){
        for (GroupElement group: groups) {
            if (group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }
}
