import java.util.*;

public class Finder {

    private final String[] arrayOfStrings;

    public Finder(String[] arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }


    protected String[] find(String charsToFind) {
        LinkedList<String> result = new LinkedList<>();
        if (this.arrayOfStrings == null) {
            System.out.println(Colour.TEXT_RED + "The array is empty" + Colour.TEXT_RESET);
            return result.toArray(new String[0]);
        }
        if (charsToFind.isEmpty()) {
            System.out.println(Colour.TEXT_RED + "The input is empty" + Colour.TEXT_RESET);
            return result.toArray(new String[0]);
        }
        for (String s : this.arrayOfStrings) {
            if (isExisting(s, charsToFind)) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            System.out.println(Colour.TEXT_RED + "This word is not inside the array." + Colour.TEXT_RESET);
        } else {
            System.out.println("The word/s:" + result);
        }
        return result.toArray(new String[0]);
    }

    /**
     * Method checks if the char of 2 strings is the same.
     *
     * @param stringOfTheArray Word inside the array
     * @param stringToCheck    User Input
     * @return boolean
     */
    private static boolean isExisting(String stringOfTheArray, String stringToCheck) {
        int stringOfTheArrayLenght = stringOfTheArray.length();
        int stringToCheckLenght = stringToCheck.length();
        if (stringOfTheArrayLenght != stringToCheckLenght) {
            return false;
        }
        char[] chars1 = stringOfTheArray.toCharArray();
        char[] chars2 = stringToCheck.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }


}
