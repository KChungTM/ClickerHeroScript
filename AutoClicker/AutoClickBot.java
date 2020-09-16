import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClickBot implements Runnable
{
    private Robot bot;
    private int delay;
    public boolean running;

    public AutoClickBot()
    {
        try
        {
           bot = new Robot();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        delay = 300;
        running = true;
    }

    public void clickMouse()
    {
        try{
            bot.mousePress(InputEvent.BUTTON1_MASK);
            bot.delay(100);
            bot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }

    @Override
    public void run()
    {
        while (true)
        {
            try{
                Thread.sleep(25);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            while(running)
            {
                this.clickMouse();
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void setRunning()
    {
        running = !running;
    }
}