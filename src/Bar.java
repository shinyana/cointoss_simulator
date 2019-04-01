// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 *
 */
public class Bar
{

    /**
     Creates a labeled bar.  You give the height of the bar in application
     units (e.g., population of a particular state), and then a scale for how
     tall to display it on the screen (parameter scale).

     @param bottom  location of the bottom of the bar
     @param left  location of the left side of the bar
     @param width  width of the bar (in pixels)
     @param barHeight  height of the bar in application units
     @param scale  how many pixels per application unit
     @param color  the color of the bar
     @param label  the label at the bottom of the bar
     */
    private int yTop;       //Instance variables
    private int xLeft;
    private int bW;
    private int bH;
    private Color cLR;
    private String lBL;

    public Bar(int bottom, int left, int width, int barHeight,      //Constructor with arguments
               double scale, Color color, String label)
    {
        //////* Set graph component to instance variables *//////
        bW = width;
        bH = (int)(barHeight * scale);  //Scaling graph height
        yTop = bottom - bH;             //Adjust start point of a graph
        xLeft = left;
        cLR = color;
        lBL = label;
    }

    /**
     Draw the labeled bar.
     @param g2  the graphics context
     */
    public void draw(Graphics2D g2) //Method
    {
        Rectangle bar_Graph = new Rectangle(xLeft, yTop, bW, bH);
        if(bH == 0)
        {
            //////* Do not draw a graph if a bar height is zero *//////
        }
        else
        {
            //////* Draw a graph *//////
            g2.draw(bar_Graph);
            g2.setColor(cLR);
            g2.fill(bar_Graph);
        }

        //////*Confirm the size of the label*//////
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(lBL, context);
        int widthOfLabel = (int)labelBounds.getWidth();
        int heightOfLabel = (int)labelBounds.getHeight();

        //////*Adjust label positions*//////
        int xLabel = xLeft - (widthOfLabel - bW) / 2;
        int yLabel = yTop + heightOfLabel + bH;

        //////*Change the color of strings and draw it*//////
        g2.setColor(Color.BLACK);
        g2.drawString(lBL,xLabel,yLabel);
    }
}