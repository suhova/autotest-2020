package pages.groups.blocks;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.codeborne.selenide.Selenide.$;

public class SearchBlock {
    private final By SEARCH_INPUT = By.xpath(".//input[@name='st.query']");
    private final By RESULTS = By.xpath(".//input[@class='dropdown-results__4nym2 __wide__4nym2 __fadein__4nym2']");

    private TextInput searchTextInput;
    private Button searchButton;
    private TextInput searchQuery;

    public SearchBlock insertGroupNameInSearch(String groupName) {
        searchQuery.click();
        searchQuery.sendKeys(groupName);
        return this;
    }

    public SearchBlock() {
        $(SEARCH_INPUT).should(Condition.exist);
        searchQuery = new TextInput($(SEARCH_INPUT));
    }


}
