import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    JFrame f = new JFrame("Perzistencija");
    JButton unos = new JButton("Unos");
    JButton izmjena = new JButton("Izmjena podataka");
    JButton brisanje = new JButton("Brisanje");
    JButton pri2 = new JButton("Prikaz svih zaposlenih");

    Main() {

        izmjena.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdatePanel();
            }
        });

        unos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertPanel();
            }
        });

        brisanje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePanel();
            }
        });

        pri2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowPanel();
            }
        });

        unos.setBounds(10, 80, 160, 40);
        brisanje.setBounds(215, 80, 160, 40);
        pri2.setBounds(110, 30, 160, 40);
        izmjena.setBounds(110, 130, 160, 40);


        f.add(unos);
        f.add(izmjena);
        f.add(brisanje);
        f.add(pri2);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
        BazaUtil.getConnection();
    }
}


