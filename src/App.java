import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private static WindowProperties windowProperties = new WindowProperties();
    private Fonts fonts = new Fonts();

    private JLabel headerText = new JLabel();
    private JPanel contentPanel = new JPanel(new GridBagLayout());
    private JPanel headerPanel = new JPanel(new BorderLayout());
    JButton scratchButton = new JButton();
    JLabel scratchLabel = new JLabel(" Start");

    public App() {
        super(windowProperties.getWindowTitle());
        initializeUI();
    }

    private void initializeUI() {
        fonts.loadRobotoMonoFont();
        fonts.loadRobotoMonoFontButton();
        setWindowProperties();
        setupHeader();
        setupContent();
        setWindowIcon();
    }

    private void setWindowProperties() {
        contentPanel.setBackground(WindowProperties.BACKGROUND_COLOR);
        add(contentPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowProperties.getJanelaWidth(), windowProperties.getJanelaHeight());
        this.setVisible(true);
    }

    private void setupHeader() {
        setHeaderText();
        headerPanel.setBackground(WindowProperties.HEADER_COLOR);
        headerPanel.add(headerText, BorderLayout.NORTH);
        add(headerPanel, BorderLayout.NORTH);
    }

    private void setHeaderText() {
        headerText.setText("Scratch Sorting");
        headerText.setFont(Fonts.robotoMonoFont_HeaderTitle);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setForeground(WindowProperties.TEXT_COLOR);
    }

    private void setupContent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);

        contentPanel.add(scratchButton, gbc);

        scratchLabel.setFont(Fonts.robotoMonoFont_HomeButton);
        scratchLabel.setForeground(WindowProperties.TEXT_COLOR);
        scratchLabel.setAlignmentY((float) 0.8);
        scratchLabel.setAlignmentX((float) 0.4);
        scratchButton.add(scratchLabel);
        configureScratchButton();
    }

    private void configureScratchButton() {
        ImageIcon scratchIcon = new ImageIcon(getClass().getResource("scratchButton.png"));
        scratchButton.setIcon(scratchIcon);
        scratchButton.setBackground(WindowProperties.HEADER_COLOR);
        scratchButton.setPreferredSize(new Dimension(scratchIcon.getIconWidth(), scratchIcon.getIconHeight()));
        scratchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onScratchButtonClick();
            }
        });
    }

    private void onScratchButtonClick() {
        System.out.println("button clicked!");
    }

    private void setWindowIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
