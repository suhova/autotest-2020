package pages.groups;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.groups.blocks.*;
import ru.yandex.qatools.htmlelements.element.Button;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class BaseGroupPage {
    private static By CREATE_BTN = By.className("create-group");
    SearchBlock searchBlock;
    GroupsListBlock groupsList;
    GroupNavBlock groupNavBlock;
    Button createGroupButton;

    public BaseGroupPage() {
        $(CREATE_BTN).should(Condition.exist);

        createGroupButton = new Button($(CREATE_BTN));
        searchBlock = new SearchBlock();
        groupsList = new GroupsListBlock();
        //  groupNavBlock = new GroupNavBlock();
    }

    public BaseGroupPage searchGroupByName(String groupName) {
        searchBlock.insertGroupNameInSearch(groupName);
        return this;
    }

    public GroupElement joinRandomGroup() {
        GroupElement groupElement = groupsList.getGroups().get(0);
        if (!groupElement.isJoined()) {
            groupElement.join();
        }
        return groupElement;
    }
}
