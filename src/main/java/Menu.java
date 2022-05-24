import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void choiceOfUserToDo() {

        boolean quit = false;
        while (!quit) {
            Instructions.instructionsChoiceOfUserToDo();
            int choice = Utils.checkingIntegers(0, 3);

            switch (choice) {
                case 1:
                    createArrayAutomaticaly();
                    break;
                case 2:
                    createArrayManualy();
                    break;
                case 3:
                    createStaticArray();
                case 0:
                    quit = true;
                    break;

            }
        }
    }

    private static void createStaticArray() {
        String[] thisIsAStringArray = new String[6];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        thisIsAStringArray[5] = "sad";
        Finder finder = new Finder(thisIsAStringArray);
        finder.find(textToCheck());
        System.out.println("The array is :" + Arrays.toString(thisIsAStringArray));
    }

    private static void createArrayManualy() {
        String[] strings = new String[arraySize()];
        for (int i = 0; i < strings.length; i++) {
            System.out.println("Give the word");
            Scanner myObj = new Scanner(System.in);
            String s = myObj.nextLine();
            strings[i] = s;
        }
        Finder finder = new Finder(strings);
        finder.find(textToCheck());
        System.out.println("The array is :" + Arrays.toString(strings));
    }

    private static void createArrayAutomaticaly() {
        String[] strings = new String[arraySize()];
        for (int i = 0; i < strings.length; i++) {
            byte[] array = stringSize();
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            strings[i] = generatedString;
        }
        Finder finder = new Finder(strings);
        finder.find(textToCheck());
        System.out.println("The array is :" + Arrays.toString(strings));
    }

    private static int arraySize() {
        System.out.println("Give me the size of the array.");
        int size = Utils.checkingIntegers(1, 50000);
        return size;
    }

    private static byte[] stringSize() {
        System.out.println("Give me the length of the string.");
        byte[] array = new byte[Utils.checkingIntegers(0, 5000)];
        return array;
    }

    private static String textToCheck() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Give me word you want to check.");
        return myObj.nextLine();
    }

}
