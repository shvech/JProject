import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MarioGame extends JFrame implements KeyListener {
    private int playerX;
    private int playerY;

    public MarioGame() {
        setTitle("Mario Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        addKeyListener(this);

        playerX = 100;
        playerY = 400;

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 50, 50);

        Toolkit.getDefaultToolkit().sync();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            playerX -= 10;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            playerX += 10;
        } else if (keyCode == KeyEvent.VK_UP) {
            playerY -= 10;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            playerY += 10;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new MarioGame();
    }
}