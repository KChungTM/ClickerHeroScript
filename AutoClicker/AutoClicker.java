import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AutoClicker
{
    public static void main(String[] args)
    {
        // Instantiating all Variables/Setting Properties
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        JFrame catcherFrame = new JFrame();
        catcherFrame.setSize(screenSize);
        catcherFrame.setLayout(new GridBagLayout());
        catcherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        catcherFrame.setVisible(true);


        JLabel label = new JLabel("Welcome to AutoClicker");
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 50));

        AutoClickBot clicker = new AutoClickBot();

        // Creating KeyListener (H+Esc Commands)
        KeyListener kl = new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e){}
        
            @Override
            public void keyReleased(KeyEvent e) {}
        
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_Z)
                {   
                    if(clicker.running == true)
                        clicker.running = false;
                    else if(clicker.running == false)
                    {
                        try{
                            Thread.sleep(5000);
                        }
                        catch(Exception er1){
                            er1.printStackTrace();
                        }

                        clicker.running = true;
                    }
                }
                if(keyCode == KeyEvent.VK_ESCAPE)
                    System.exit(0);

                label.setText(""+ clicker.running);
            }
        };

        // Adding Components
        catcherFrame.addKeyListener(kl);
        catcherFrame.add(label);
        
        // Text on Screen
        try
        {
            Thread.sleep(2000);
            label.setText("Clicking will begin in...");

            for(int i=3;i>0;i--)
            {
                label.setText(i + "...");
                Thread.sleep(1000);
            }
            label.setText("");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        label.setText(""+ clicker.running);

        // Creates new runnable
        clicker.run();
    }
}