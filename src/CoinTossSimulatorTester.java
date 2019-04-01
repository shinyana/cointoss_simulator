/**
 * class CoinTossSimulatorTester
 *
 * Show the simulation results to validate simulation model
 *
 */

public class CoinTossSimulatorTester
{
    public static void main(String[] args)
    {
        //////* Test that default constructor correctly create simulator *//////
        CoinTossSimulator coinTS = new CoinTossSimulator();

        System.out.println("After constructor:");
        int sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("Number of trials [exp:" + sumTrials + "]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();

        //////* Test coin toss simulator at one times *//////
        coinTS.run(1);
        sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("After run(" + 1 + "): ");
        System.out.println("Number of trials [exp:" + sumTrials +"]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();

        //////* Test cointoss simulator at ten times *//////
        coinTS.run(10);
        sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("After run(" + 10 + "): ");
        System.out.println("Number of trials [exp:" + sumTrials +"]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();

        //////* Test coin toss simulator at one hundred times *//////
        coinTS.run(100);
        sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("After run(" + 100 + "): ");
        System.out.println("Number of trials [exp:" + sumTrials +"]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();

        //////* Test to reset simulation results*//////
        coinTS.reset();
        sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("After reset: ");
        System.out.println("Number of trials [exp:"+ sumTrials + "]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();

        //////* Test coin toss simulator at one thousand times to match the number of trials *//////
        coinTS.run(1000);
        sumTrials = coinTS.getTwoHeads() + coinTS.getTwoTails() + coinTS.getHeadTails();
        System.out.println("After run(" + 1000 + "): ");
        System.out.println("Number of trials [exp:" + sumTrials +"]: " + coinTS.getNumTrials());
        System.out.println("Two-head tosses: " + coinTS.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTS.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTS.getHeadTails());
        if(coinTS.getNumTrials() == sumTrials) {
            System.out.println("Tosses add up correctly? " + true);
        }
        else {
            System.out.println("Tosses add up correctly? " + false);
        }
        System.out.println();
    }
}