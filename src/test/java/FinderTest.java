import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    private static final  String[] thisIsAStringArray = {"asd","asdd","fre","glk","lkm","sad"};


    @Test
    @DisplayName("Should throw an Exception")
    void testFindNullPointerException() {
        String[] emptyArray = null;
        Finder finder = new Finder(emptyArray);
        assertEquals(0, finder.find("lll").length);
    }

    @Test
    @DisplayName("Input is null")
    void testIfInputIsNull(){
        Finder finder = new Finder(thisIsAStringArray);
        Assertions.assertThrows(NullPointerException.class, () -> {
            finder.find(null);
        });
    }

    @Test
    @DisplayName("Should find 2 values")
    void TestTwoValursFoundSuccess() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(2, finder.find("das").length);
    }


    @Test
    @DisplayName("Should not find any values")
    void testNoValuesFoundWord() {
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals(0, finder.find("LLL").length);
    }

    @Test
    @DisplayName("Should not find any values")
    void testNoValuesFound(){
        Finder finder = new Finder(thisIsAStringArray);
        assertEquals( 0, finder.find("lll").length);
    }

    @Test
    @DisplayName("This is performanse test")
    void performanceTest(){
        long start2 = System.currentTimeMillis();
        String[] strings = new String[9999999];

            for (int i = 0; i < strings.length ; i++) {
                byte[] array = new byte[3];
                new Random().nextBytes(array);
                String generatedString = new String(array, StandardCharsets.UTF_8);
                strings[i] = generatedString;
            }

        assertTimeout(Duration.ofSeconds(1), () -> {

            Finder finder = new Finder(strings);
            finder.find("ksm");
        });
        long end2 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
    }

}
