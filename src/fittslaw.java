import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fittslaw {
    private JPanel rootPanel;
    private static String text = "<html>please enter the green button ten times."
                                +"Be aware that your time start when you push on it."
                                +"the time stop after every statge and there are 3 statges";
    private static JLabel intro = new JLabel("<html><div style=\"text-align: center;\">" + text + "</html>");

    static int i=0;
    public static int j = 0 ;
    public static int x = 250, y = 300, w = 70, h = 95,mid = 350,position = 80;
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Fitts's Law Experiment");
        frame.setContentPane(new fittslaw().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,700);
        frame.setVisible(true);
        frame.setLayout(null);
        intro.setFont(intro.getFont().deriveFont(15.0f));
        intro.setForeground(Color.BLACK);
        intro.setSize(500, 100);
        intro.setLocation(0,0);
        frame.add(intro);

        Button button1 = new Button();
        Button button2 = new Button();
        button2.swapColour();

        button1.setBounds(mid-position, y, w, h);
        button2.setBounds( mid+position, y, w, h);

        frame.add(button1);
        frame.add(button2);

        StopWatch watch = new StopWatch();

        File f = new File("D:\\GithubRepositry\\fittslaw\\table.txt");
        FileWriter writer = new FileWriter(f);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.swapColour();
                button2.swapColour();
                watch.start();

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.swapColour();
                button2.swapColour();
                watch.stop();
                double t = watch.getElapsedTimeSecs();
                double id = (Math.log( 2.0 * position / (double)w) / Math.log(2));

                try {
                    writer.write(id+" "+t+"\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                j++;
                if(j>0){
                    i++;
                    j=0;
                    position+=20;
                    w-=5;
                    button1.setBounds( mid-position, y, w, h);
                    button2.setBounds(mid+position, y, w, h);
                }
                if(i>12){
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
    }
}
