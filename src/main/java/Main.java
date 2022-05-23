

public class Main {
    public static void main(String[] args) {
        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        thisIsAStringArray[4] = "sad";
        Finder finder = new Finder(thisIsAStringArray);
        finder.find("lala");

    }
}