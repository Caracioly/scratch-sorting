import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScratchBlocks {

    public JButton createBlock(String imagePath) {
        ImageIcon blockIcon = new ImageIcon(getClass().getResource(imagePath));
        JButton blockButton = new JButton(blockIcon);

        blockButton.setContentAreaFilled(false);
        blockButton.setBorderPainted(false);
        blockButton.setFocusPainted(false);
        blockButton.setPreferredSize(new Dimension(blockIcon.getIconWidth(), blockIcon.getIconHeight()));
        blockButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    blockButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                } 
            }
            @Override
            public void mouseExited(MouseEvent e) {
                blockButton.setCursor(Cursor.getDefaultCursor());
            }
        });

        return blockButton;
    }

    public JButton moveBlock = createBlock("/scratch-blocos/mova.png");

}
