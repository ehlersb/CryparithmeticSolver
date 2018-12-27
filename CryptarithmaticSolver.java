import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Benjamin Ehlers on 12/27/2018.
 */
public class CryptarithmaticSolver {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        ArrayList<Integer> digits = initializeDigits();
        ArrayList<String> summandWords = new ArrayList<>();
        ArrayList<String> allWords = new ArrayList<>();
        String sumWord = "";

        while(scan.hasNext()) {
            String curWord = scan.next();
            if(curWord.equals("==")) {
                curWord = scan.next();
                sumWord = curWord;
                allWords.add(curWord);
                continue;

            }
            else if(curWord.equals("+")) {
                continue;
            }
            allWords.add(curWord);
            summandWords.add(curWord);
        }

        ArrayList<String> uniqueLetters = uniqueLetters(allWords);
        LetterInt letterInt = generateLetterInt(uniqueLetters);
        ArrayList<Integer> summandInts = new ArrayList<>();
        for (int i = 0; i < summandWords.size(); i++) {
            summandInts.add(letterInt.wordToInt(summandWords.get(i)));
        }
        Equation equation = new Equation(summandInts, letterInt.wordToInt(sumWord));
        while(!equation.isValid()) {
            letterInt = generateLetterInt(uniqueLetters);
            summandInts = new ArrayList<>();
            for (int i = 0; i < summandWords.size(); i++) {
                summandInts.add(letterInt.wordToInt(summandWords.get(i)));
            }
            equation = new Equation(summandInts, letterInt.wordToInt(sumWord));
        }
        for(int i = 0; i < uniqueLetters.size(); i++) {
            System.out.println(uniqueLetters.get(i) + " = " + letterInt.letterToInt(uniqueLetters.get(i)));
        }
    }

    private static ArrayList<Integer> initializeDigits() {
        ArrayList<Integer> digits = new ArrayList<>(); //0 thru 9
        for(int i = 0; i < 10; i++) {
            digits.add(i);
        }
        return digits;
    }

    private static LetterInt generateLetterInt(ArrayList<String> uniqueLetters) {
        ArrayList<Integer> digits = initializeDigits();
        ArrayList<Integer> ints = new ArrayList<>();
        Random rand = new Random();
        int randInt = rand.nextInt(9) + 1;
        ints.add(randInt);
        digits.remove(randInt);
        for(int i = 1; i < uniqueLetters.size(); i++) {
            randInt = rand.nextInt(10 - i);
            ints.add(digits.get(randInt));
            digits.remove(randInt);
        }
        return new LetterInt(uniqueLetters, ints);
    }

    private static ArrayList<String> uniqueLetters(ArrayList<String> allWords) {
        ArrayList<String> uniqueLetters = new ArrayList<>();
        for(int i = 0; i < allWords.size(); i++) {
            for(int j = 0; j < allWords.get(i).length(); j++) {
                String curLetter = allWords.get(i).charAt(j) + "";
                if(uniqueLetters.contains(curLetter));
                else {
                    uniqueLetters.add(curLetter);
                }
            }
        }
        return uniqueLetters;
    }


}
