import java.util.ArrayList;

/**
 * Created by Benjamin Ehlers on 12/27/2018.
 */
public class Equation {

    private ArrayList<Integer> summands;
    private int sum;

    public Equation(ArrayList<Integer> summands, int sum) {
        this.summands = summands;
        this.sum = sum;
    }

    public boolean isValid() {
        int sum = 0;
        for(int i = 0; i < summands.size(); i++) {
            sum += summands.get(i);
        }
        return this.sum == sum;
    }
}
