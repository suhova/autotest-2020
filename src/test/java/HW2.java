import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TopPhotoPage;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;

public class HW2 {

    @BeforeAll
    public static void init() {
        open("https://ok.ru");
        pages.LoginPage loginPage = new pages.LoginPage();
        Assertions.assertAll(
            loginPage::loginFieldIsExist,
            loginPage::passwordFieldIsExist
        );
        loginPage.login();
    }

    @Test
    public void Top3PhotoLikesTest() {
        open("https://ok.ru/topphoto");
        TopPhotoPage topPhotoPage = new TopPhotoPage();
        Integer top1Likes = topPhotoPage.getTopLikes(TopPhotoPage.TOP_1);
        Integer top2Likes = topPhotoPage.getTopLikes(TopPhotoPage.TOP_2);
        Integer top3Likes = topPhotoPage.getTopLikes(TopPhotoPage.TOP_3);
        Assertions.assertAll(
            () -> Assertions.assertTrue(top1Likes.compareTo(top2Likes) >= 0, "У первого места классов меньше, чем у второго"),
            () -> Assertions.assertTrue(top1Likes.compareTo(top3Likes) >= 0, "У первого места классов меньше, чем у третьего"),
            () -> Assertions.assertTrue(top2Likes.compareTo(top3Likes) >= 0, "У второго места классов меньше, чем у третьего")
        );
    }

    @Test
    public void PhotoLikesTest() {
        open("https://ok.ru/topphoto");
        TopPhotoPage topPhotoPage = new TopPhotoPage();
        Integer[] likes = topPhotoPage.getLikes();
        Integer top1Likes = topPhotoPage.getTopLikes(TopPhotoPage.TOP_1);
        Assertions.assertTrue(
            Arrays.stream(likes).allMatch(e -> top1Likes.compareTo(e) >= 0)
        );
    }


    @Test
    public void PhotoNotEqualTest() {
        open("https://ok.ru/topphoto");
        TopPhotoPage topPhotoPage = new TopPhotoPage();
        String link1 = topPhotoPage.getTopPhotoLink(TopPhotoPage.TOP_1);
        String link2 = topPhotoPage.getTopPhotoLink(TopPhotoPage.TOP_2);
        Assertions.assertNotEquals(link1,link2, "Одно фото на двух позициях");
    }
}
