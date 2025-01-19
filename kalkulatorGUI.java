import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kalkulatorGUI {
    private JTextField display;
    private kalkulator kalkulator;

    public kalkulatorGUI() {
        kalkulator = new kalkulator(); // Membuat objek kalkulator
        JFrame frame = new JFrame("Kalkulator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        display = new JTextField();
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        
        String[] tombol = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};
        for (String label : tombol) {
            JButton button = new JButton(label);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    String currentText = display.getText();

                    if (command.equals("=")) {
                        String result = kalkulator.hitung(currentText); // Menggunakan Kalkulator untuk hitung
                        display.setText(result);
                    } else if (command.equals("C")) {
                        display.setText(""); // Clear
                    } else {
                        display.setText(currentText + command); // Tambahkan angka/operator ke display
                    }
                }
            });
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new kalkulatorGUI(); // Memulai aplikasi
    }
}
