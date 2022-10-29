import javax.swing.*;
import java.awt.*;



// This is the class that is used as buttons on the screen.
// This class also contains variables that are used to capture data
// and various counters required to keep track of where the program is
// in its sequence.

public class Button extends JButton {


    public Color buttonColourOn = null;
    private Color buttonColourOff = null;

    public Button() {
        buttonColourOn = Color.green;
        buttonColourOff = Color.GRAY;
        setBackground(buttonColourOn);
    }

    // Swaps the colour of the button.
    public void swapColour() {
        Color temp = buttonColourOn;
        buttonColourOn = buttonColourOff;
        buttonColourOff = temp;
        setBackground(buttonColourOn);
    }
}
