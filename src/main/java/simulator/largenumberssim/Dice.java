package simulator.largenumberssim;

import java.util.Random;

public class Dice {
    private final int numFaces = 6; // Number of faces on dice
    //    private int diceValue;  // Value of the dice (ex, if value is 1 then it will be storing probability for when the dice rolls a 1)
//                            // if Value is 0, the dice is used for rolling only
    private double probability;
    private int tally = 0; // Number of times this dice has occurred
    private static int totalRolls = 0; // Number of times all dice have been rolled
    private Random random = new Random();

//    public Dice(int diceVal) {
//        this.diceValue = diceVal;
//    }

    public void setProbability(Double newProbability) {
        this.probability = newProbability;
    }

    public void incrementTally() {
        tally++;
    }

    public void incrementTotalRolls() {
        totalRolls++;
    }

    public double getProbability() {
//        this.setProbability((double) (tally / totalRolls));

        return probability;
    }

    public int getTally() {
        return tally;
    }

    public int getTotalRolls(){ return totalRolls; }


    public int getNumberOfSides() {
        return numFaces;
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }

}
