import org.jcp.xml.dsig.internal.dom.DOMBase64Transform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField jtx = new JTextField();
    private JButton jbtn[][] = new JButton[3][4];
    private JLabel lab2 = new JLabel(" ",JLabel.LEFT);
    private Container cp;
    private JPanel jpannorth = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpansouth = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpancenter = new JPanel(new GridLayout(3, 4, 3, 3));
    public MainFrame() {
        init();
    }
    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 50, 800, 550);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpancenter,"Center");
        this.cp.add(this.jpannorth,"North");
        this.cp.add(this.jpansouth,"South");
        this.jpannorth.add(jtx);
        jtx.setFont(new Font(null,Font.BOLD,25));
        this.jpansouth.add(lab2);
        lab2.setFont(new Font(null,Font.BOLD,25));
        jbtn[0][0] = new JButton("0");
        jbtn[0][1] = new JButton("1");
        jbtn[0][2] = new JButton("2");
        jbtn[0][3] = new JButton("3");
        jbtn[1][0] = new JButton("4");
        jbtn[1][1] = new JButton("5");
        jbtn[1][2] = new JButton("6");
        jbtn[1][3] = new JButton("7");
        jbtn[2][0] = new JButton("8");
        jbtn[2][1] = new JButton("9");
        jbtn[2][2] = new JButton("Submit");
        jbtn[2][3] = new JButton("Exit");
        for (int i=0 ; i<3 ; i++){
            for (int j=0 ; j<4 ; j++){
                this.jpancenter.add(jbtn[i][j]);
                jbtn[i][j].setFont(new Font(null,Font.BOLD,20));
            }
        }
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<4 ; j++){
                jbtn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jbtn1 = (JButton)e.getSource();
                        switch (jbtn1.getText()) {
                            case "Exit":
                                System.exit(0);
                               break;
                            case "Submit":
                                   if(new String(jtx.getText()).equals("23323456") ){
                                       lab2.setText("Success");
                                   }
                                   else {
                                       lab2.setText("Error");
                                   }
                                   break;
                            default:
                                    jtx.setText(jtx.getText()+jbtn1.getText());

                        }
                    }
                });
            }
        }
    }
}