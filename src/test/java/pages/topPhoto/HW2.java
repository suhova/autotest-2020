package pages.topPhoto;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;
import static pages.topPhoto.TopPhotoPage.TOP_PAGE_LINK;
import static util.Constants.OK_LINK;

public class HW2 {
    @BeforeAll
    public static void init() {
        open(OK_LINK);
        pages.LoginPage loginPage = new pages.LoginPage();
        loginPage.login();
    }

    @Test
    public void PhotoLikesTest() {
        open(TOP_PAGE_LINK);
        TopPhotoPage topPhotoPage = new TopPhotoPage();
        Integer[] likes = topPhotoPage.getLikes();
        Top3PhotoWrapper top1 = new Top3PhotoWrapper(1);
        Integer top1Likes = top1.getTopLikes();
        Assertions.assertTrue(
            Arrays.stream(likes).allMatch(e -> top1Likes.compareTo(e) >= 0)
        );
    }

    @Test
    public void Top3PhotoLikesTest() {
        open(TOP_PAGE_LINK);
        Top3PhotoWrapper top1 = new Top3PhotoWrapper(1);
        Top3PhotoWrapper top2= new Top3PhotoWrapper(2);
        Top3PhotoWrapper top3= new Top3PhotoWrapper(4);
        Integer top1Likes = top1.getTopLikes();
        Integer top2Likes = top2.getTopLikes();
        Integer top3Likes = top3.getTopLikes();
        Assertions.assertAll(
            () -> Assertions.assertTrue(top1Likes.compareTo(top2Likes) >= 0, "У первого места классов меньше, чем у второго"),
            () -> Assertions.assertTrue(top1Likes.compareTo(top3Likes) >= 0, "У первого места классов меньше, чем у третьего"),
            () -> Assertions.assertTrue(top2Likes.compareTo(top3Likes) >= 0, "У второго места классов меньше, чем у третьего")
        );
    }

    @Test
    public void PhotoNotEqualTest() {
        open(TOP_PAGE_LINK);
        Top3PhotoWrapper top1 = new Top3PhotoWrapper(1);
        Top3PhotoWrapper top2= new Top3PhotoWrapper(2);
        String link1 = top1.getTopPhotoLink();
        String link2 = top2.getTopPhotoLink();
        Assertions.assertNotEquals(link1,link2, "Одно фото на двух позициях");
    }
}
