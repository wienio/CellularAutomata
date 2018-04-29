package modeling.cellularautomata;

/**
 * Created by Wienio on 2018-04-24.
 */
public class RuleCalculator {

    private String ruleInBinary;

    public RuleCalculator(int ruleNo) {
        this.ruleInBinary = String.format("%8s", Integer.toBinaryString(ruleNo)).replace(" ", "0");
    }

    public char calcValue(int position1, int position2, int position3) {
        if (position1 == 1 && position2 == 1 && position3 == 1) return ruleInBinary.charAt(0);
        else if (position1 == 1 && position2 == 1) return ruleInBinary.charAt(1);
        else if (position1 == 1 && position3 == 1) return ruleInBinary.charAt(2);
        else if (position1 == 1) return ruleInBinary.charAt(3);
        else if (position2 == 1 && position3 == 1) return ruleInBinary.charAt(4);
        else if (position2 == 1) return ruleInBinary.charAt(5);
        else if (position3 == 1) return ruleInBinary.charAt(6);
        else return ruleInBinary.charAt(7);
    }

}
