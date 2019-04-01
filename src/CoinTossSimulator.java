/**
 * class CoinTossSimulator
 *
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
import java.util.Random;
public class CoinTossSimulator
{
    private static final int TWO_HEADS = 0;     //Constant Value
    private static final int HEAD_TAILS = 1;
    private static final int TWO_TAILS = 2;

    private Random generator;    //Instance variables
    private int sides;
    private int countHT[];
    private int countTrials;

    /**
     Creates a coin toss simulator with no trials done yet.
     Argument: none
     */

    public CoinTossSimulator()      //Constructor with no argument
    {
        generator = new Random();
        sides = 2;              //the result of cointoss (a Head and a Tail)
        countHT = new int[3];   //store 3 kinds result ([0]:Two heads, [1]:a head and a tail and [2]:two tails)
        countTrials = 0;
    }

    /**
     Runs the simulation for numTrials more trials. Multiple calls to this method
     without a reset() between them *add* these trials to the current simulation.

     @param numTrials  number of trials to for simulation; must be >= 1
     Argument: numtrials    Return: none
     */

    public void run(int numTrials)  //Method
    {
        for (int i = 1 ; i <= numTrials; i++)
        {
            //////*Two coins are tossed*//////
            int coinAlpha = generator.nextInt(sides);
            int coinBeta = generator.nextInt(sides);

            //////*add the result of cointoss*//////
            countHT[coinAlpha + coinBeta]++;

            //////*count the number of trails*//////
            countTrials++;
        }
    }

    /**
     Get number of trials performed since last reset.
     Argument: none    return: countTrials
     */
    public int getNumTrials()   //Method
    {
        return countTrials;
    }

    /**
     Get number of trials that came up two heads since last reset.
     Argument: none    return: TWO_HEAD
     */
    public int getTwoHeads()    //Method
    {
        return countHT[TWO_HEADS];
    }

    /**
     Get number of trials that came up two tails since last reset.
     Argument: none    return: TWO_TAILS
     */
    public int getTwoTails()    //Method
    {
        return countHT[TWO_TAILS];
    }

    /**
     Get number of trials that came up one head and one tail since last reset.
     Argument: none    return: HEAD_TAILS
     */
    public int getHeadTails()   //Method
    {
        return countHT[HEAD_TAILS];
    }

    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     Argument: none    return: none
     */
    public void reset()     //Method
    {
        countTrials = 0;
        countHT[TWO_HEADS] = 0;
        countHT[TWO_TAILS] = 0;
        countHT[HEAD_TAILS] = 0;
    }
}