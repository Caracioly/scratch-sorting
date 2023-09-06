import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class App extends JFrame {

    private WindowProperties windowProperties;
    private Fonts fonts;
    private HomeButtonsProperties homeButtonsProperties;

    private JPanel contentPanel;
    private JPanel headerPanel;

    private JLabel scratchLabel;
    private JLabel headerText;

    public App() {
        windowProperties = new WindowProperties();
        fonts = new Fonts();
        homeButtonsProperties = new HomeButtonsProperties();

        initializeUI();
    }

    private void initializeUI() {
        setWindowProperties();
        setupHeader();
        setupContent();
        setWindowIcon();
    }

    private void setWindowProperties() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(WindowProperties.BACKGROUND_COLOR);
        add(contentPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowProperties.getJanelaWidth(), windowProperties.getJanelaHeight());
        setVisible(true);
    }

    private void setupHeader() {
        setHeaderText();
        setHeaderPanel();
    }

    private void setHeaderPanel() {
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(WindowProperties.HEADER_COLOR);
        headerPanel.add(headerText, BorderLayout.NORTH);
        add(headerPanel, BorderLayout.NORTH);
    }
    
    private void setHeaderText() {
        headerText = new JLabel("Scratch Sorting");
        headerText.setFont(fonts.loadRobotoMonoFont(64));
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setForeground(WindowProperties.TEXT_COLOR);
    }

    private void setupContent() {
        setContentGrid();
        setContentLabel();
        homeButtonsProperties.configureScratchButton();
    }

    private void setContentGrid(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);
        contentPanel.add(homeButtonsProperties.scratchButton, gbc);
    }

    private void setContentLabel(){
        scratchLabel = new JLabel(" Start");
        scratchLabel.setFont(fonts.loadRobotoMonoFont(20));
        scratchLabel.setForeground(WindowProperties.TEXT_COLOR);
        scratchLabel.setAlignmentY((float) 0.8);
        scratchLabel.setAlignmentX((float) 0.4);
        homeButtonsProperties.scratchButton.add(scratchLabel);
    }

    private void setWindowIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
