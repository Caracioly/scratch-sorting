import java.awt.Font;
import java.io.InputStream;

public class Fonts {
    private static final String ROBOTO_MONO_FONT_PATH = "/Fonts/RobotoMono-Regular.ttf";

    public static Font loadRobotoMonoFont(int size) {
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
}
