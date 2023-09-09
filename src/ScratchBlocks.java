import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

    // load a imagem from path, resize the image for 30% of original size
    // remove any border and focus from the button
    // set the image to be the actual area
    // mouse interactable

public class ScratchBlocks {
    
    private JButton createScratchBlock(String imagePath) {
        ImageIcon BlockIcon = resizeBlockImage(imagePath);
        JButton blockButton = createBlockButton(BlockIcon);
        setupMouseListener(blockButton);
        return blockButton;
    }

    private ImageIcon resizeBlockImage(String imagePath) {
        ImageIcon blockIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = blockIcon.getImage();
        int width = (int) (blockIcon.getIconWidth() * 0.3);
        int height = (int) (blockIcon.getIconHeight() * 0.3);
        Image resizedImage = image.getScaledInstance(
            width, 
            height, 
            Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private JButton createBlockButton(ImageIcon resizedBlockIcon) {
        JButton blockButton = new JButton(resizedBlockIcon);
        blockButton.setContentAreaFilled(false);
        blockButton.setBorderPainted(false);
        blockButton.setFocusPainted(false);
        blockButton.setPreferredSize
        (new Dimension(
            resizedBlockIcon.getIconWidth(), 
            resizedBlockIcon.getIconHeight())
        );
        return blockButton;
    }

    private void setupMouseListener(JButton blockButton) {
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
    }

    public JButton flagBlock = createScratchBlock("/scratch-blocks-en/flag.png");
}
