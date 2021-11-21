import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowPanel {

    JFrame f = new JFrame("Enter Employees");
    JButton b = new JButton("Show Employees");


    JTextArea ta1 = new JTextArea();


    ShowPanel() {

        f.setBackground(Color.BLACK);

        ta1.setBounds(140, 40, 400, 350);


        b.setBounds(140,260,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);


        f.add(b);
        f.add(ta1);



        f.setVisible(true);
        f.setSize(650,450);
        f.setLocation(450, 150);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ta1.setText(String.valueOf(BazaUtil.readEmployees()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
