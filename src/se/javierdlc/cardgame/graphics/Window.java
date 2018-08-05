package se.javierdlc.cardgame.graphics;

import javax.swing.*;
import java.awt.*;

public class Window {
    final private int WIDTH = 900;
    final private int HEIGHT = 600;

    private JFrame frame;
    private JPanel panel;
    private JPanel upperContainer;
    private JPanel middleContainer;
    private JPanel lowerContainer;
    private String title;

    public Window(String title) {
        this.title = title;

        createWindow();
    }

    private void createWindow() {
        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        Dimension upperDimension = new Dimension(WIDTH, HEIGHT * 40 / 100);
        Dimension lowerDimension = new Dimension(WIDTH, HEIGHT * 15 / 100);

        frame = new JFrame(title);
        frame.setSize(new Dimension(dimension));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setPreferredSize(dimension);
        panel.setVisible(true);
        panel.setBackground(CustomColors.PRIMARY_THREE.getColor());

        upperContainer = new JPanel();
        upperContainer.setPreferredSize(upperDimension);
        upperContainer.setBackground(CustomColors.PRIMARY_THREE.getColor());

        middleContainer = new JPanel();
        middleContainer.setPreferredSize(upperDimension);
        middleContainer.setBackground(CustomColors.PRIMARY_TWO.getColor());

        lowerContainer = new JPanel();
        lowerContainer.setPreferredSize(lowerDimension);
        lowerContainer.setBackground(CustomColors.PRIMARY_THREE.getColor());

        panel.add(upperContainer);
        panel.add(middleContainer);
        panel.add(lowerContainer);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
        upperContainer.setVisible(true);
        middleContainer.setVisible(true);
        lowerContainer.setVisible(true);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getUpperContainer() {
        return upperContainer;
    }

    public JPanel getMiddleContainer() {
        return middleContainer;
    }

    public JPanel getLowerContainer() {
        return lowerContainer;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
