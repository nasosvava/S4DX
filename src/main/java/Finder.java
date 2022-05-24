import java.util.*;

public class Finder {

    private String[] arrayOfStrings ;

    public Finder(String[] arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }


    /**
     * The method controls whether the parameter falls within a value in the table or throws a NullPointerException
     * @param charsToFind
     * @return result
     */
    protected LinkedList<String> find(String charsToFind){
            if(this.arrayOfStrings !=  null){
                LinkedList<String> result  = new LinkedList<>();
                for(String s : this.arrayOfStrings){
                    if(isExisting(s,charsToFind)){
                        result.add(s);
                    }
                }
                if(result.isEmpty()){
                    System.out.println("This word is not inside the array.");
                }else{
                    System.out.println("The word/s:" + result);
                }
                return result;
            }
        throw new NullPointerException("Array is empty");
        }

    /**
     * Method checks if the char of 2 strings is the same.
     * @param stringOfTheArray
     * @param stringToCheck
     * @return boolean
     */
    private static boolean isExisting(String stringOfTheArray , String  stringToCheck){
        char[] chars1 = stringOfTheArray.toCharArray();
        char[] chars2 = stringToCheck.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);
    }
}
