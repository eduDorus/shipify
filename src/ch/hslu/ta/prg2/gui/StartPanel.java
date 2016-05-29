package ch.hslu.ta.prg2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartPanel extends JPanel {

    JLabel lbl_declareName;
    JTextField txt_nameField;
    JButton btn_LOCAL;
    JButton btn_LAN;
    BufferedImage img_Title;
    JLabel lbl_imgtitle;

    public StartPanel() {

        this.setSize(1227, 800);

        createComponents();
        addObjects();
        setOptions();

    }

    private void createComponents() {

        lbl_declareName = new JLabel("Bitte gib deinen Namen an:");
        txt_nameField = new JTextField();
        try {
            img_Title = ImageIO.read(this.getClass().getResource("title.png"));

        } catch (IOException ex) {
            System.out.println("hat nisch funktioniert");
        }
        btn_LOCAL = new JButton("Neues Spiel gegen den PC");
        btn_LAN = new JButton("Neues Spiel über LAN");

        lbl_imgtitle = new JLabel(new ImageIcon(img_Title));

    }

    private void setOptions() {
        this.setLayout(null);

        Font font1 = new Font("SansSerif", 1, 20);

        lbl_declareName.setFont(font1);

        txt_nameField.setFont(font1);

        lbl_declareName.setBounds(450, 250, 300, 50);
        txt_nameField.setBounds(450, 325, 300, 50);

        btn_LOCAL.setFont(font1);
        btn_LAN.setFont(font1);

        btn_LOCAL.setBounds(450, 425, 300, 50);
        btn_LAN.setBounds(450, 500, 300, 50);

        lbl_imgtitle.setBounds(350, 0, 500, 300);

        btn_LOCAL.addActionListener((ActionEvent e) -> {
            GUIController.localButtonClicked();
        });

        btn_LAN.addActionListener((ActionEvent e) -> {
            GUIController.lanButtonClicked();
        });

    }

    private void addObjects() {
        this.add(lbl_declareName);
        this.add(txt_nameField);

        this.add(btn_LOCAL);
        this.add(btn_LAN);

        this.add(lbl_imgtitle);
    }
}
