package br.edu.unifcv.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {
    private JTextPane MainText;
    private JPanel main;

    public MainFrame() throws HeadlessException {
        setContentPane(main);
        setTitle("UniFCV Foods");
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
