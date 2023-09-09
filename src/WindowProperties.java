import java.awt.Color;

import javax.swing.ImageIcon;

public class WindowProperties {

    private String windowTitle = "Scratch Sorting";
    private int windowWidth = 640;
    private int windowHeight = 480;
    ImageIcon windowIcon = new ImageIcon(getClass().getResource("icon.png"));

    public static final Color BACKGROUND_COLOR = new Color(142, 142, 160);
    public static final Color HEADER_COLOR = new Color(52, 53, 65);
    public static final Color SCRATCH_COLOR = new Color(250, 165, 29);
    public static final Color TEXT_COLOR = Color.WHITE;

    public ImageIcon getWindowIcon() {
        return windowIcon;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public int getJanelaWidth() {
        return windowWidth;
    }

    public int getJanelaHeight() {
        return windowHeight;
    }
}
