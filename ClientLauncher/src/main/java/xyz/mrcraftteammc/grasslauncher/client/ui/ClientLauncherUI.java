package xyz.mrcraftteammc.grasslauncher.client.ui;

import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;

import javax.swing.*;
import java.awt.*;

/**
 * The User-Interface of GrassLauncher
 * @author Mr_limr267
 * @since 1.0.0-SNAPSHOT
 * @see javax.swing
 * @see java.awt
 */
public class ClientLauncherUI {
    public static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }

    public static void onStartup() {
        GrassLauncher.LOGGER.info("Init UI...");

        JFrame frame = new JFrame(GrassLauncher.NAME);
        Container container = frame.getContentPane();

        container.setBackground(Color.GREEN);

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

        GrassLauncher.LOGGER.info("UI is available now!");
    }
}
