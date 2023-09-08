import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class ButtonsProperties {

    private App app;

    public JButton scratchButton = new JButton();
    public JButton instructionButton = new JButton("Continue >>");

    public ButtonsProperties(App app) {
        this.app = app;
    }

    public void configureScratchButton() {
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
        app.headerText.setText("Scratch");
        app.headerPanel.setBackground(WindowProperties.SCRATCH_COLOR);
        scratchButton.setVisible(false);
        app.loadScratchScreen();
    }

    public void configureinstructionButton() {
        instructionButton.setFont(Fonts.loadRobotoMonoFont(16));
        instructionButton.setForeground(WindowProperties.TEXT_COLOR);
        instructionButton.setContentAreaFilled(false);
        instructionButton.setBorderPainted(false);
        instructionButton.setFocusPainted(false);
        instructionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                instructionButton.setForeground(WindowProperties.HEADER_COLOR); 
            }
            @Override
            public void mouseExited(MouseEvent e) {
                instructionButton.setForeground(WindowProperties.TEXT_COLOR);
            }
        });
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                onInstructionButtonClick();
            }
        });
    }

    public void onInstructionButtonClick(){
        System.out.println("Clicado");
    }

}