package xyz.mrcraftteammc.grasslauncher.main;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTUIMain {
    public AWTUIMain() {
    }

    public static void main(String[] args) {
        Label label = new Label("Hello World");
        label.setBounds(20, 50, 100, 20);
        label.setFont(new Font("Songti SC", Font.BOLD, 15));

        TextField field = new TextField();
        field.setBounds(20, 200, 100, 25);
        field.setEchoChar('*');  // PWD (

        Checkbox checkbox = new Checkbox("Remember");
        checkbox.setBounds(130, 200, 100, 30);

        Button button = new Button("awa");
        button.setBounds(20, 150, 100, 50);
        button.addActionListener(e -> System.out.println("TextField Content: " + field.getText() + " \n Remember: " + checkbox.getState()));

//        CheckboxGroup group = new CheckboxGroup();
//        checkbox.setCheckboxGroup(group);

        Frame frame = new Frame("GrassLauncher | 1.0.0 - SNAPSHOT");

        Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
        frame.setIconImage(image);

//        frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
//        frame.setBackground(Color.GREEN);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

//        frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        frame.setLayout(null);
        frame.add(label);
        frame.add(button);
        frame.add(field);
        frame.add(checkbox);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                frame.setVisible(false);
                frame.dispose();
                System.exit(0);
            }
        });

//        frame.pack();
        frame.setVisible(true);
    }
}
