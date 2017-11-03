package Assignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUIrestaurant {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton runButton;
    private JPanel panel1;
    int noOfTables;
    int noOfCustomers;
    Restaurant r;
    Vector<Customer> v  = new Vector<Customer>();

    public GUIrestaurant() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nT=(textField1.getText());
                noOfTables=Integer.parseInt(nT);
                r = new Restaurant(noOfTables);

                String nC=(textField2.getText());
                noOfCustomers=Integer.parseInt(nC);

                String name = textField3.getText();
                String[] names = name.split(" ");
                for (int i = 0; i < noOfCustomers; i++) {
                    Customer c = new Customer(names[i], r);
                    v.addElement(c);
                }
                for (int i = 0; i < noOfCustomers; i++) {
                    v.elementAt(i).start();
                }
                JFrame frame = new JFrame("Restaurant view");
                frame.setContentPane(new ExtendedGUI(r));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurant");
        frame.setContentPane(new GUIrestaurant().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
