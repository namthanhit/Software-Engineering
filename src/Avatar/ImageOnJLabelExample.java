/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Avatar;

/**
 *
 * @author buingocduc
 */
import javax.swing.*;
import java.awt.*;

public class ImageOnJLabelExample {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Hiển thị hình ảnh trên JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Tạo ImageIcon từ file ảnh
        ImageIcon imageIcon = new ImageIcon("/src/Avatar/anhTheNam.jpeg"); // Thay thế bằng đường dẫn tới ảnh của bạn

        // Tạo JLabel và gán ImageIcon vào JLabel
        JLabel label = new JLabel(imageIcon);
        
        // Thêm JLabel vào JFrame
        frame.add(label);
        
        // Hiển thị JFrame
        frame.setVisible(true);
    }
}

