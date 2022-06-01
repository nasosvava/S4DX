import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UserMenu {

    public static void choiceOfUserToDo()  {

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
                    break;
                case 0:
                    quit = true;
                    break;

            }
        }
    }

    private static void createStaticArray()  {
        String[] thisIsAStringArray = new String[6];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        thisIsAStringArray[5] = "sad";
        Finder finder = new Finder(thisIsAStringArray);
        System.out.println("The array is :" + Arrays.toString(thisIsAStringArray));
        finder.find(textToCheck());
    }

    private static void createArrayManualy()  {
        String[] strings = new String[arraySize()];
        for (int i = 0; i < strings.length; i++) {
            System.out.println("Give the word");
            strings[i] = validatoNotEmptyString(setString());
        }
        Finder finder = new Finder(strings);
        System.out.println("The array is :" + Arrays.toString(strings));
        finder.find(textToCheck());
    }

    private static String validatoNotEmptyString(String s){
        boolean quit = false;
        while (!quit){
            if(s == null || s.isEmpty()){
                System.out.println("The string cant be empty.");
               s = setString();
            }else{
                quit=true;
            }
        }
        return s;
    }

    private static String setString(){
        Scanner myObj = new Scanner(System.in);
        String s = myObj.nextLine();
        return s;
    }

    private static void createArrayAutomaticaly()  {
        String[] strings = new String[arraySize()];
        int stringsLength = strings.length;

        for (int i = 0; i < stringsLength; i++) {
            byte[] array = stringSize();
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            strings[i] = generatedString;
        }

        Finder finder = new Finder(strings);
        System.out.println("The array is :" + Arrays.toString(strings));
        finder.find(textToCheck());
    }

    private static int arraySize() {
        System.out.println("Give me the size of the array.");
        int size = Utils.checkingIntegers(1, 50);
        return size;
    }

    private static byte[] stringSize() {
        System.out.println("Give me the length of the string.");
        byte[] array = new byte[Utils.checkingIntegers(0, 50)];
        return array;
    }

    private static String textToCheck() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Give me word you want to check.");
        return myObj.nextLine();
    }

}
