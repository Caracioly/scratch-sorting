import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

public class App extends JFrame {

    private WindowProperties windowProperties;
    private ButtonsProperties buttonsProperties;
    private ScratchBlocks scratchBlocks;
    private Grid grid;

    public JPanel contentPanel;
    public JPanel headerPanel;

    public JLabel scratchLabel;
    public JLabel headerText;

    public App() {
        buttonsProperties = new ButtonsProperties(this);
        windowProperties = new WindowProperties();
        scratchBlocks = new ScratchBlocks();
        grid = new Grid();
        initializeUI();
    }

    private void initializeUI() {
        setVisible(true);
        loadWindowProperties();
        loadHeader();
        loadContent();
        buttonsProperties.loadButtons();
    }

    private void loadWindowProperties() {
        windowProperties.getWindowIcon();
        setTitle(windowProperties.getWindowTitle());
        setSize(windowProperties.getJanelaWidth(),
                windowProperties.getJanelaHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadHeader() {
        setHeaderText();
        setHeaderPanel();
    }

    private void setHeaderText() {
        headerText = new JLabel("Scratch Sorting");
        headerText.setFont(Fonts.robotoMonoFont64);
        headerText.setHorizontalAlignment(JLabel.CENTER);
        headerText.setForeground(WindowProperties.TEXT_COLOR);
    }

    private void setHeaderPanel() {
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(WindowProperties.HEADER_COLOR);
        headerPanel.add(headerText, BorderLayout.NORTH);
        add(headerPanel, BorderLayout.NORTH);
    }

    private void loadContent() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(WindowProperties.BACKGROUND_COLOR);
        add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(buttonsProperties.scratchButton, grid.content_CENTER);
        setContentLabel();
    }

    private void setContentLabel() {
        scratchLabel = new JLabel(" Start");
        scratchLabel.setFont(Fonts.robotoMonoFont20);
        scratchLabel.setForeground(WindowProperties.TEXT_COLOR);
        scratchLabel.setAlignmentY((float) 0.8);
        scratchLabel.setAlignmentX((float) 0.4);
        buttonsProperties.scratchButton.add(scratchLabel);
    }

    private JLabel instructionLabel = new JLabel(
            "<html>In the right, you will see an algorithm, and your task is to arrange the blocks on the left in the correct order for the algorithm to work.</html>");

    public void loadScratchScreen() {
        contentPanel.removeAll();
        showContentScratchInstruction();
        instructionLabelSettings();
    }

    private void showContentScratchInstruction() {
        contentPanel.add(instructionLabel, grid.content_CENTER);
        contentPanel.add(buttonsProperties.instructionButton, grid.content_SOUTH);
    }

    private void instructionLabelSettings() {
        instructionLabel.setPreferredSize(new Dimension(400, 300));
        instructionLabel.setFont(Fonts.robotoMonoFont24);
        instructionLabel.setForeground(WindowProperties.TEXT_COLOR);
    }

    public void showContentScratchBlocks() {
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.repaint();
        contentPanel.add(scratchBlocks.flagBlock, grid.content_CENTER);
    }

    private JLabel algoLabel = new JLabel(
            "<html>very long text test very long text test</html>");

    public void showContentScratchAlgo() {
        grid.separator.setPreferredSize(new Dimension(800, 10));
        grid.separator.setForeground(Color.RED);
        grid.separator.setBackground(Color.BLACK);

        contentPanel.add(grid.separator, grid.content_CENTER);
        contentPanel.add(algoLabel, grid.content_EAST);
        
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        App app = new App();
    }
}
