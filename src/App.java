import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class App extends JFrame {

    private WindowProperties windowProperties;
    private ButtonsProperties buttonsProperties;
    private ScratchBlocks scratchBlocks;

    public JPanel contentPanel;
    public JPanel headerPanel;

    public JLabel scratchLabel;
    public JLabel headerText;

    public App() {
        windowProperties = new WindowProperties();
        buttonsProperties = new ButtonsProperties(this);
        scratchBlocks = new ScratchBlocks();
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
        setTitle(windowProperties.getWindowTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowProperties.getJanelaWidth(), windowProperties.getJanelaHeight());
        setVisible(true);
    }

    private void setupHeader() {
        setHeaderText();
        setHeaderPanel();
    }

    private void setHeaderText() {
        headerText = new JLabel("Scratch Sorting");
        headerText.setFont(Fonts.loadRobotoMonoFont(64));
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setForeground(WindowProperties.TEXT_COLOR);
    }

    private void setHeaderPanel() {
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(WindowProperties.HEADER_COLOR);
        headerPanel.add(headerText, BorderLayout.NORTH);
        add(headerPanel, BorderLayout.NORTH);
    }

    private void setupContent() {
        setContentHomeGrid();
        setContentLabel();
        buttonsProperties.configureScratchButton();
    }

    private void setContentHomeGrid() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);
        contentPanel.add(buttonsProperties.scratchButton, gbc);
    }

    private void setContentLabel() {
        scratchLabel = new JLabel(" Start");
        scratchLabel.setFont(Fonts.loadRobotoMonoFont(20));
        scratchLabel.setForeground(WindowProperties.TEXT_COLOR);
        scratchLabel.setAlignmentY((float) 0.8);
        scratchLabel.setAlignmentX((float) 0.4);
        buttonsProperties.scratchButton.add(scratchLabel);
    }

    private void setWindowIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        setIconImage(icon.getImage());
    }

    JLabel instructionLabel = new JLabel(
            "<html>In the right, you will see an algorithm, and your task is to arrange the blocks on the left in the correct order for the algorithm to work.</html>");

    public void loadScratchScreen() {
        contentPanel.removeAll();
        buttonsProperties.configureinstructionButton();
        setContentScratchScreenGrid();
        instructionLabelSettings();
    }

    private void setContentScratchScreenGrid() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);
        contentPanel.add(instructionLabel, gbc);
        gbc.anchor = GridBagConstraints.SOUTH;
        contentPanel.add(buttonsProperties.instructionButton, gbc);
    }

    private void instructionLabelSettings() {
        instructionLabel.setPreferredSize(new Dimension(400, 300));
        instructionLabel.setFont(Fonts.loadRobotoMonoFont(24));
        instructionLabel.setForeground(WindowProperties.TEXT_COLOR);
    }

    public void setScratchBlocks() {

    }

    public static void main(String[] args) {
        App app = new App();
    }
}
