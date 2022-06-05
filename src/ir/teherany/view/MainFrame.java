package ir.teherany.view;

import ir.teherany.controller.PersonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        intUI();
    }

    private void intUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel lblName = new JLabel("Name");
        JLabel lblFamily = new JLabel("Family");
        JLabel lblAge = new JLabel("Age");
        JLabel lblNational = new JLabel("National Code");

        JTextField textName = new JTextField(15);
        JTextField textFamily = new JTextField(15);
        JTextField textAge = new JTextField(3);
        JTextField textNational = new JTextField(15);

        JButton btnSave = new JButton("Save");

        getContentPane().add(lblName);
        getContentPane().add(textName);
        getContentPane().add(lblFamily);
        getContentPane().add(textFamily);
        getContentPane().add(lblAge);
        getContentPane().add(textAge);
        getContentPane().add(lblNational);
        getContentPane().add(textNational);
        getContentPane().add(btnSave);

        btnSave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonController personController = new PersonController();
                personController.save(textName.getText(), textFamily.getText(), Integer.valueOf(textAge.getText()), textNational.getText());
            }
        });
    }
}
