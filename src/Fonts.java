import java.awt.Font;
import java.io.InputStream;

public class Fonts {

    public static Font robotoMonoFont_HeaderTitle;
    public static Font robotoMonoFont_HomeButton;
      
    public void loadRobotoMonoFont() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/Fonts/RobotoMono-Regular.ttf");
            robotoMonoFont_HeaderTitle = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            robotoMonoFont_HeaderTitle = robotoMonoFont_HeaderTitle.deriveFont(Font.PLAIN, 64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadRobotoMonoFontButton() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/Fonts/RobotoMono-Regular.ttf");
            robotoMonoFont_HomeButton = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            robotoMonoFont_HomeButton = robotoMonoFont_HomeButton.deriveFont(Font.PLAIN, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
