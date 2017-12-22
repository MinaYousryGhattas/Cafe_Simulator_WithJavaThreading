package Assignment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class ExtendedGUI extends JPanel
{
    private Restaurant r;
    Timer timer;
    private Vector<JButton> labels;

    ExtendedGUI(Restaurant rest)
    {
        r = rest;
        labels = new Vector<>();
        setPreferredSize(new Dimension(500, 150));
        double x = Math.sqrt(r.numberoftables);
        int ix = (int) Math.ceil(x);
        setLayout(new GridLayout(ix, ix));
        for (int i = 0; i < r.numberoftables; i++)
        {
            labels.addElement(new JButton());
            labels.elementAt(i).setBackground(Color.green);
            labels.elementAt(i).setText("Table: "+Integer.toString(i+1));
            add(labels.elementAt(i));
        }
        timer = new Timer(10,updater);
        timer.start();
    }
    private ActionListener updater = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            for (int i = 0;i < r.numberoftables;i++)
            {
                if (r.tables[i] == null)
                {
                    labels.elementAt(i).setBackground(Color.GREEN);
                    labels.elementAt(i).setText("Table: "+Integer.toString(i+1));
                }
                else
                {
                    labels.elementAt(i).setBackground(Color.RED);
                    labels.elementAt(i).setText(r.tables[i].name);
                }
            }
        }
    };

}
