/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveCircleExc;

/**
 *
 * @author User
 */
// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {

    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private JButton left, right, up, down;
    private Color c;
//---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------

    public CirclePanel(int width, int height) {
// Set coordinates so circle starts in middle
        x = (width / 2) - (CIRCLE_SIZE / 2);
        y = (height / 2) - (CIRCLE_SIZE / 2);
        c = Color.green;
// Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
// Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
// Add listeners to the buttons
        left.addActionListener(new MoveListener(-20, 0));
        right.addActionListener(new MoveListener(20, 0));
        up.addActionListener(new MoveListener(0, -20));
        down.addActionListener(new MoveListener(0, 20));
// Need a panel to put the buttons on or they'll be on
// top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
// Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");

        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);

        left.setToolTipText("Kekiri 20pix");
        right.setToolTipText("Kekanan 20pix");
        up.setToolTipText("Keatas 20pix");
        down.setToolTipText("Kebawah 20pix");
    }
//---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
    }
//---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------

    private class MoveListener implements ActionListener {

        private int dx;
        private int dy;
//---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------

        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
//---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------

        public void actionPerformed(ActionEvent e) {
            right.setEnabled(true);
            left.setEnabled(true);
            down.setEnabled(true);
            up.setEnabled(true);
            x += dx;
            y += dy;

            if (x > getSize().getWidth() - CIRCLE_SIZE) {
                right.setEnabled(false);
            }
            if (x < 25) {
                left.setEnabled(false);
            }
            if (y > getSize().getHeight() - CIRCLE_SIZE - 50) {
                down.setEnabled(false);
            }
            if (y < 10) {
                up.setEnabled(false);
            }
            repaint();
        }
    }
}
