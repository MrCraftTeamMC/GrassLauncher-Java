package xyz.mrcraftteammc.grasslauncher.main;

import javax.swing.*;
import java.awt.*;

public class SwingUIMain {
    public SwingUIMain() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GrassLauncher | 1.0.0 - SNAPSHOT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setBackground(Color.GREEN);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

//        frame.pack();
        frame.setVisible(true);
    }
}
