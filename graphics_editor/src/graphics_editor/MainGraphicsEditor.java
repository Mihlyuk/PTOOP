package graphics_editor;

import graphics_editor.views.MainFrame;

import java.awt.Frame;

public class MainGraphicsEditor {
    public static void main(String[] args) {
        Frame shapeFrame = new MainFrame("Graphics editor");
        shapeFrame.setVisible(true);
    }
}
