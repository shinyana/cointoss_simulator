import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * class CoinSimComponent
 *
 * Store the coin toss simulation results and create bar constructors
 * after setting graph component.
 */

public class CoinSimComponent extends JComponent
{
    private static final int BAR_WIDTH = 50;                //Constant value(Specification: Fixed value)
    private static final int BAR_VERTICAL_BUFFER = 50;      //Constant value(Specification: Fixed value)
    private static final int NUM_GRAPHS = 3;                //The number of graphs in the component
    private static final int PERCENTAGE = 100;              //Convert dismal to percentage

    private int numTwoHeads;        //Instance variables
    private int numHeadTails;
    private int numTwoTails;
    private int totalTrails;

    /**
     Creates a coin toss simulator component.
     Argument: numTrials
     */

    public CoinSimComponent(int numTrials)
    {
        //* The constructor creates simulator to runs after getting information from main method*//
        CoinTossSimulator CoinSim = new CoinTossSimulator();
        CoinSim.run(numTrials);

        //////*Store simulation results to instance valuables*//////
        numTwoHeads = CoinSim.getTwoHeads();
        numHeadTails = CoinSim.getHeadTails();
        numTwoTails = CoinSim.getTwoTails();
        totalTrails = CoinSim.getNumTrials();
    }

    /**
     Creates graph component.
     Argument: Graphics g
     */

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        //////* Get the component size *//////
        int cpWidth = getWidth();
        int cpHeight = getHeight();

        //////* Define the left position of each graph *//////
        int xLeftTwoHeads = (cpWidth - NUM_GRAPHS * BAR_WIDTH) / (NUM_GRAPHS + 1); //width between each bar, and between the end bars and each side of the window
        int xLeftHeadTails = xLeftTwoHeads + BAR_WIDTH + xLeftTwoHeads;
        int xLeftTwoTails = xLeftHeadTails + BAR_WIDTH + xLeftTwoHeads;

        //////* Define the bottom of graphs *//////
        int yBottom = cpHeight - BAR_VERTICAL_BUFFER;

        //////* Define scale of graphs *//////
        double scaleBar = (double)(cpHeight - BAR_VERTICAL_BUFFER * 2) / totalTrails;  //2: upper and lower margin

        //////* Calculate percentile of result *//////
        double dummyPerTwoHeads = (double)numTwoHeads / totalTrails;
        int perTwoHeads = (int)Math.round(dummyPerTwoHeads * PERCENTAGE);

        double dummyPerHeadTails = (double)numHeadTails / totalTrails;
        int perHeadTails = (int)Math.round(dummyPerHeadTails * PERCENTAGE);

        double dummyPerTwoTails = (double)numTwoTails / totalTrails;
        int perTwoTails = (int)Math.round(dummyPerTwoTails * PERCENTAGE);

        //////* Pass graph components to these constructors*//////
        Bar barTwoHeads = new Bar(yBottom, xLeftTwoHeads, BAR_WIDTH, numTwoHeads,
                scaleBar, Color.RED,"Two Heads: " + numTwoHeads + " (" + perTwoHeads + "%)");

        Bar barHeadTails = new Bar(yBottom, xLeftHeadTails, BAR_WIDTH, numHeadTails,
                scaleBar, Color.GREEN, "A Head and a Tail: " + numHeadTails + " (" + perHeadTails + "%)");

        Bar barTwoTails = new Bar(yBottom, xLeftTwoTails, BAR_WIDTH, numTwoTails,
                scaleBar, Color.BLUE, "Two Tails: " + numTwoTails + " (" + perTwoTails + "%)");

        //////* Call draw method in bar class *//////
        barTwoHeads.draw(g2);
        barHeadTails.draw(g2);
        barTwoTails.draw(g2);
    }
}