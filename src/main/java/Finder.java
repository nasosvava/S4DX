import java.util.*;

public class Finder {

    private final String[] arrayOfStrings;

    public Finder(String[] arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }


    public String[] find(String charsToFind) throws EmptyArrayException {
        checksTheExceptions(charsToFind);
        checksIfArrayIsEmpty();
        return reutrnResultOfFoundWords(charsToFind);
    }

    /**
     * The method checks if we have matched words otherwise returns an empty array.
     *
     * @param charsToFind input of user
     * @return result of the words that matches as Array
     */
    private String[] reutrnResultOfFoundWords(String charsToFind) {
        LinkedList<String> result = new LinkedList<>();
        for (String s : this.arrayOfStrings) {
            if (s.equals(charsToFind) || ((s.length() == charsToFind.length()) && isExisting(s, charsToFind))) {
                result.add(s);
            }
        }
        checkIfResultIsEmpty(result);
        return result.toArray(new String[0]);
    }

    private void checksTheExceptions(String input) {
        checksIfArrayIsNull();
        checkIfTheInputIsNull(input);
    }

    /**
     * The method checks if the user input is null.
     *
     * @param input user input
     */
    private void checkIfTheInputIsNull(String input) {
        if (input == null) {
            throw new NullPointerException();
        }
    }

    /**
     * The method check if the final result of the array is empty.
     *
     * @param result final result of matched words
     */
    private void checkIfResultIsEmpty(LinkedList<String> result) {
        if (result.isEmpty()) {
            System.out.println(Colour.TEXT_RED + "This word is not inside the array." + Colour.TEXT_RESET);
        } else {
            System.out.println("The word/s:" + result);
        }
    }

    /**
     * Method if the array is empty and throws an Exception.
     *
     * @throws EmptyArrayException if the array is empty with throw EmptyArrayException
     */
    private void checksIfArrayIsEmpty() throws EmptyArrayException {
        if (this.arrayOfStrings.length == 0) {
            throw new EmptyArrayException("The array is empty.");
        }
    }

    /**
     * Method checks if the array is Null and throws an Exception.
     */
    private void checksIfArrayIsNull() {
        if (this.arrayOfStrings == null) {
            throw new NullPointerException("The array is null.");
        }
    }


    /**
     * Method checks if the char of 2 strings is the same.
     *
     * @param stringOfTheArray Word inside the array
     * @param stringToCheck User Input
     * @return boolean
     */
    private static boolean isExisting(String stringOfTheArray, String stringToCheck) {
        char[] chars1 = stringOfTheArray.toCharArray();
        char[] chars2 = stringToCheck.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
