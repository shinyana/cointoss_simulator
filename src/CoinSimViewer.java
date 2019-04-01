import javax.swing.JFrame;
import java.util.Scanner;

/**
 * class CoinSimViewer
 *
 * Input the number of simulation, then output the simulation result on graphs
 *
 */

public class CoinSimViewer
{
    private static final int COMPONENT_WIDTH = 800;
    private static final int COMPONENT_HEIGHT = 500;

    public static void main (String[] args)
    {
        /////////////////////* Frame set */////////////////////
        JFrame frame = new JFrame();
        frame.setSize(COMPONENT_WIDTH,COMPONENT_HEIGHT);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //////////////////* Simulation start *//////////////////
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of trials: ");
        int numTrials = in.nextInt();

        while(numTrials <= 0)
        {
                System.out.println("Number entered must be greater than 0.");
                System.out.print("Enter number of trials: ");
                numTrials = in.nextInt();
        }
        //////* Pass the information to the constructor *//////
        CoinSimComponent component = new CoinSimComponent(numTrials);

        ////////////////* Describe result *////////////////
        frame.add(component);
        frame.setVisible(true);
    }
}