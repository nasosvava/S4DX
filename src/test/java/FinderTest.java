import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {


    @Test
    @DisplayName("Should throw an Exception")
    void findFailTest() {
        String[] emptyArray = new String[5];
        Finder finder = new Finder(emptyArray);
        Assertions.assertThrows(RuntimeException.class, () -> {
            finder.find("lll");
        });
    }

    @Test
    @DisplayName("Should find the char")
    void findSuccessTest() {
        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        thisIsAStringArray[4] = "sad";
        Finder finder = new Finder(thisIsAStringArray);
        assertFalse(finder.find("das").isEmpty());
        assertEquals(2, finder.find("das").size());
    }

    @Test
    @DisplayName("Should not find")
    void findNotFoundWordSuccessTest() {
        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        thisIsAStringArray[4] = "sad";
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(0, finder.find("LLL").size());
    }

    @Test
    public void givenHugeNumberOfStrings() {
        String[] strings = new String[100000];
        for (int i = 0; i < strings.length; i++) {
            byte[] array = new byte[3];
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            strings[i] = generatedString;
        }
        Finder finder = new Finder(strings);
        finder.find("dds");
    }
}
