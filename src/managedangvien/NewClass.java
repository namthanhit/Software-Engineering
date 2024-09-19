/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedangvien;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author buingocduc
 */
public class NewClass {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Label Overlay Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Tạo JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 300, 300);

        // Tạo JLabel đầu tiên (label nền)
        JLabel backgroundLabel = new JLabel("Background Label");
        backgroundLabel.setBounds(50, 50, 200, 50);backgroundLabel.setBackground(Color.BLACK);
        

        // Tạo JLabel thứ hai (label trên nền)
        JLabel foregroundLabel = new JLabel("Foreground Label");
        foregroundLabel.setBounds(100, 75, 200, 50);
        foregroundLabel.setBackground(Color.red);

        // Thêm các label vào JLayeredPane với thứ tự layer
        layeredPane.add(backgroundLabel, Integer.valueOf(0));  // Lớp nền
        layeredPane.add(foregroundLabel, Integer.valueOf(1));  // Lớp phía trên

        // Thêm layeredPane vào JFrame
        frame.add(layeredPane);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
