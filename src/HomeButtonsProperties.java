import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class HomeButtonsProperties{

    public JButton scratchButton = new JButton();
    
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
        System.out.println("button clicked!");
    }
    
}