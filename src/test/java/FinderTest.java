import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    private static final  String[] thisIsAStringArray = {"asd","asdd","fre","glk","lkm","sad"};


    @Test
    @DisplayName("Should throw an Exception")
    void TestFindNullPointerException() {
        String[] emptyArray = null;
        Finder finder = new Finder(emptyArray);
        Assertions.assertThrows(NullPointerException.class, () -> {
            finder.find("lll");
        });
    }

    @Test
    @DisplayName("Should find the char")
    void TestFindSuccess() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(2, finder.find("das").size());
    }


    @Test
    @DisplayName("Should not find any char")
    void TestFindNotFoundWord() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(0, finder.find("LLL").size());
    }


}
