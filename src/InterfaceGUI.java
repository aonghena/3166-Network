import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField addressField;
    private JTextField interfaceField;
    private JButton calcButton;
    private JLabel addressLabel;
    private JLabel interfaceLabel;
    private JTable routingTable;
    private JLabel titleLabel;
    private JButton calculateButton;

    private Table t = new Table(new String[]{"135.46.56.0/22", "135.46.60.0/22", "192.53.40.0/23"},
            new String[]{"Interface 0", "Interface 1", "Router 1", "Router 2 (DEFAULT) "});


    public InterfaceGUI(String title) {
    	super(title);
        mainPanel = new JPanel();
        addressField = new JTextField();
        interfaceField = new JTextField();
        calcButton =  new JButton();
        routingTable = new JTable();
    	
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        setSize(900,400);

        TableModel dataModel = new
                AbstractTableModel() {
                    public int getColumnCount() {
                        return 2;
                    }
                    public int getRowCount() {
                        return 5;
                    }
                    public Object getValueAt(int row, int col) {
                        Object[][] data = {{"IP Address/Subnet", "Interface"},
                                {"135.46.56.0/22", "Interface 0"},
                                {"135.46.60.0/22", "Interface 1"},
                                {"192.53.40.0/23", "Router 1"},
                                {" ", "Router 2 (DEFAULT) "}};
                        return data[row][col];
                    }
                };
        routingTable.setModel(dataModel);

        /*Object[] columns = {"IP Address/Subnet", "Interface"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        routingTable.setModel(model);*/
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IPAddress ipAd = new IPAddress(addressField.getText());
                String tempInterface = t.getHop(t.router(ipAd));
                interfaceField.setText(tempInterface);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new InterfaceGUI("Interface Router");
        frame.setVisible(true);



    }
}
