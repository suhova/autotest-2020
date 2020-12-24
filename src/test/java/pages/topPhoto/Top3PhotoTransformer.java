package pages.topPhoto;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Top3PhotoTransformer {
    public static List<Top3PhotoWrapper> wrapAddresses(List<SelenideElement> cards) {
        if (cards.isEmpty()) {
            return Collections.emptyList();
        }
        List<Top3PhotoWrapper> wrap = new ArrayList<Top3PhotoWrapper>();
        for (SelenideElement card : cards) {
            wrap.add(new Top3PhotoWrapper(card));
        }
        return wrap;
    }
}
