import org.junit.jupiter.api.Test;
import pages.groups.OfficialGroupsPage;
import util.GroupsTests;

public class OfficialPageContainsOnlyOfficialGroupsTest extends GroupsTests {
    @Test
    public void officialPageContainsOnlyOfficialGroupsTest() {
        OfficialGroupsPage
            .openOfficialGroupsPage()
            .checkContainOfficialGroups();
    }
}
