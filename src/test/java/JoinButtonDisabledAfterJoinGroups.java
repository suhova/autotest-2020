import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groups.OfficialGroupsPage;
import util.GroupsTests;

public class JoinButtonDisabledAfterJoinGroups extends GroupsTests {
    @Test
    public void joinButtonDisabledAfterJoinGroups() {
        Assertions.assertTrue(OfficialGroupsPage
            .openOfficialGroupsPage()
            .joinRandomGroup()
            .isJoined());
    }
}
