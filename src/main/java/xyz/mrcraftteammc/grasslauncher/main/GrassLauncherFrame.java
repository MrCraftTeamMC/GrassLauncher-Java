package xyz.mrcraftteammc.grasslauncher.main;

import com.formdev.flatlaf.FlatLightLaf;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;

import javax.swing.*;
import java.awt.*;

public class GrassLauncherFrame extends JFrame {
    public GrassLauncherFrame() {
        super("GrassLauncher 1.0.0 | by TCBuildMC Team");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            GrassLauncher.LOG_EXCEPTION.accept(e);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(800, 600);
        this.setBackground(Color.GREEN);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        this.setVisible(true);
    }

    public static void run() {
        SwingUtilities.invokeLater(GrassLauncherFrame::new);
    }
}
