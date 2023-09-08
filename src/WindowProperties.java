import java.awt.Color;

public class WindowProperties {

    private String windowTitle = "Scratch Sorting";
    private int WindowWidth = 640;
    private int WindowHeight = 480;

    public static final Color BACKGROUND_COLOR = new Color(142, 142, 160);
    public static final Color HEADER_COLOR = new Color(52, 53, 65);
    public static final Color SCRATCH_COLOR = new Color(250, 165, 29);
    public static final Color TEXT_COLOR = Color.WHITE;

    public String getWindowTitle() {
        return windowTitle;
    }

    public int getJanelaWidth() {
        return WindowWidth;
    }

    public int getJanelaHeight() {
        return WindowHeight;
    }
}
