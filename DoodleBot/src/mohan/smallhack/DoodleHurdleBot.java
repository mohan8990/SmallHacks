/**
 * 
 */
package mohan.smallhack;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Mohan
 *
 */
public class DoodleHurdleBot 
{

    /**
     * The URL for the Google's hurdles doodle (2012 olympics)
     */
	public final String myHurdlesDoodleURI = 
	        "http://www.google.com/doodles/hurdles-2012";
	
	/**
	 * Launches the hurdles doodle URI in the default browser.
	 */
	public void launchDefaultBrowser()
	{
        try
        {
            Desktop.getDesktop().browse(new URI(myHurdlesDoodleURI));
        } 
        catch (IOException | URISyntaxException e)
        {
            // TODO: Change it to log4j
            System.err.println("Exception while trying to open the hurdles " +
                               "doodle page in your default web broweser.");
        }
	}
	
	public static void main(String[] args) throws IOException, AWTException, InterruptedException
    {
	 
	    
	    System.out.println("A browser will be launched. Place the mouse over " + 
	                       "the doodle image... U have 5 seconds to do that");
	    
	    // Give user some time to read
	    Thread.sleep(5750);
	    DoodleHurdleBot bot = new DoodleHurdleBot();
        bot.launchDefaultBrowser();
        
	    // TODO: Make sure the web page is loaded before this and 
	    //       also position the cursor yourself.
	    
	    Thread.sleep(6000);
	    
	    Robot jBot = new Robot();
	    jBot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    jBot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    
	    for (int i = 0; i < 1000; i++) 
	    {
    	    jBot.keyPress(KeyEvent.VK_LEFT);
    	    jBot.keyRelease(KeyEvent.VK_LEFT);
    	    
    	    jBot.keyPress(KeyEvent.VK_RIGHT);
            jBot.keyRelease(KeyEvent.VK_RIGHT);
	    }
    }
	
}
