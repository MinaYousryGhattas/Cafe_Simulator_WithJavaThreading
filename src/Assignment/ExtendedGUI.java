package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class ExtendedGUI extends JPanel
{
    private Restaurant r;
    private Timer timer;
    private Vector<JTextPane> labels;

    ExtendedGUI(Restaurant rest)
    {
        r = rest;
        labels = new Vector<>();
        double x = Math.sqrt(r.numberoftables);
        int ix = (int) Math.ceil(x);
        setLayout(new GridLayout(ix, ix));
        for (int i = 0; i < r.numberoftables; i++)
        {
            labels.addElement(new JTextPane());
            labels.elementAt(i).setBackground(Color.green);
            labels.elementAt(i).setText("Empty");
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
                    labels.elementAt(i).setText("Empty");
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
