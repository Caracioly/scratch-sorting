import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JSeparator;

public class Grid {

    JSeparator separator = new JSeparator(JSeparator.VERTICAL);

    private GridBagConstraints createGridBagConstraints(int x, int y, int anchor, int insetsTop, int insetsRight, int insetsBottom, int insetsLeft) {
        GridBagConstraints contentGrid = new GridBagConstraints();
        contentGrid.gridx = x;
        contentGrid.gridy = y;
        contentGrid.anchor = anchor;
        contentGrid.insets = new Insets(insetsTop, insetsLeft, insetsBottom, insetsRight);
        return contentGrid;
    }
    
    public GridBagConstraints content_CENTER = createGridBagConstraints(0, 0, GridBagConstraints.CENTER, 20, 20, 20, 20);
    public GridBagConstraints content_NORTH = createGridBagConstraints(0, 5, GridBagConstraints.NORTH, 20, 20, 20, 20);
    public GridBagConstraints content_SOUTH = createGridBagConstraints(0, -5, GridBagConstraints.SOUTH, 20, 20, 20, 20);
    public GridBagConstraints content_EAST = createGridBagConstraints(5, 0, GridBagConstraints.EAST, 20, 20, 20, 20);
    public GridBagConstraints content_WEST = createGridBagConstraints(-5, 0, GridBagConstraints.WEST, 20, 20, 20, 20);
}


