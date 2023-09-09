import java.awt.Font;
import java.io.InputStream;

public class Fonts {

    private static final String ROBOTO_MONO_FONT_PATH = "/Fonts/RobotoMono-Regular.ttf";

    private static Font loadRobotoMonoFont(int size) {
        Font robotoMonoFont = null;
        try {
            InputStream inputStream = Fonts.class.getResourceAsStream(ROBOTO_MONO_FONT_PATH);
            robotoMonoFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            robotoMonoFont = robotoMonoFont.deriveFont(Font.PLAIN, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return robotoMonoFont;
    }

    public static Font robotoMonoFont64 = Fonts.loadRobotoMonoFont(64);
    public static Font robotoMonoFont24 = Fonts.loadRobotoMonoFont(24);
    public static Font robotoMonoFont20 = Fonts.loadRobotoMonoFont(20);
    public static Font robotoMonoFont16 = Fonts.loadRobotoMonoFont(16);

}
