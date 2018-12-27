import java.util.ArrayList;

/**
 * Created by Benjamin Ehlers on 12/27/2018.
 */
public class LetterInt {

    private ArrayList<String> letters;
    private ArrayList<Integer> ints;

    public LetterInt(ArrayList<String> letters, ArrayList<Integer> ints) {
        this.letters = letters;
        this.ints = ints;
    }

    public int letterToInt(String letter) {
        return ints.get(letters.indexOf(letter));
    }

    public int wordToInt(String word) {
        String integerString = "";
        for(int i = 0; i < word.length(); i++) {
            integerString += letterToInt(word.charAt(i) + "") + "";
        }
        return Integer.parseInt(integerString);
    }

}
