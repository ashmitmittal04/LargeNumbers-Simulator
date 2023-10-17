package simulator.largenumberssim;

import java.util.ArrayList;

public class DiceList {
    private final ArrayList<Dice> diceList;
    private final Dice rollingDice = new Dice();

    public DiceList() {
        diceList = new ArrayList<>();

        initializeList();

    }

    private void initializeList() {
        for (int i = 0; i < 6; i++) {
            diceList.add(new Dice());
        }
    }

    public void updateProbabilityOfAllDice() {
        double newProb;
        for (Dice dice: diceList) {
            newProb = (double) dice.getTally() /dice.getTotalRolls();
            dice.setProbability(newProb);
        }
    }

    public void rollList(int numRolls) {
        int rollVal;

        for (int i = 0; i < numRolls; i++) {
            rollVal = rollingDice.roll();
            rollingDice.incrementTotalRolls();
            diceList.get(rollVal -1 ).incrementTally();

        }
    }

    public double getProbabilityOfDice(int diceNum) {
        return ((double) Math.round((diceList.get(diceNum - 1).getProbability()) * 100) / 100);
    }

    public int getTallyOfDice(int diceNum) {
        return diceList.get(diceNum - 1).getTally();
    }

    public int getTotalRolls() {
        return rollingDice.getTotalRolls();
    }


}
