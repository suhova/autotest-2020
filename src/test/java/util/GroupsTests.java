package util;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groups.OfficialGroupsPage;
import util.BaseTest;

import static pages.groups.MyGroupsPage.openMyGroups;

public class GroupsTests extends BaseTest {

    @After
    public void leaveGroups(){
        openMyGroups()
        .leaveGroups();
    }
}
