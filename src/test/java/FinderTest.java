import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    private static final  String[] thisIsAStringArray = {"asd","asdd","fre","glk","lkm","sad"};

    private static final LinkedList<String> STRINGS = new LinkedList<>() {{
        add("asd");
        add("sad");
    }};
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
    @DisplayName("Should find 2 values")
    void TestTwoValursFoundSuccess() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(2, finder.find("DAS").size());
    }


    @Test
    @DisplayName("Should not find any values")
    void TestNoValuesFoundWord() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(0, finder.find("LLL").size());
    }


    @Test
    @DisplayName("Should find exactly")
    void TestFindValuesSuccess(){
        Finder finder = new Finder(thisIsAStringArray);
       assertEquals( STRINGS, finder.find("das"));
    }

    @Test
    @DisplayName("Should not find any values")
    void TestNoValuesFound(){
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals( 0, finder.find("lll").size());
    }
    @Test
    @DisplayName("This is performanse test")
    void performanceTest(){
        String[] strings = new String[9999999];

            for (int i = 0; i < strings.length ; i++) {
                byte[] array = new byte[3];
                new Random().nextBytes(array);
                String generatedString = new String(array, StandardCharsets.UTF_8);
                strings[i] = generatedString;
            }

        assertTimeout(Duration.ofSeconds(1), () -> {

            Finder finder = new Finder(strings);
            finder.find("das");
        });

    }

}
