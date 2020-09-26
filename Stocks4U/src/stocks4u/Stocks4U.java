/*
*
Program Name: Stocks4U.java 
Programmer's Name: Richardson Gage Milton
Program Description: A GUI user interface. Add and remove stocks for sample portfolio
*
 */
package stocks4u;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dread Pirate Roberts
 */
public final class Stocks4U extends javax.swing.JFrame {

    Stock stock1 = new Stock();
    DefaultListModel<String> listModel = new DefaultListModel<>();

    ArrayList stkNames = new ArrayList();
    ArrayList quantities = new ArrayList();
    ArrayList purchasePrice = new ArrayList();
    ArrayList currentPrice = new ArrayList();

    int i;
    double p_price;
    double c_price;
    int qty;
// name of Java Program
    public Stocks4U() {

        initComponents();
        eventsHandler();
    }

    /**
     * Method to handle all the UI events
     */
    public void eventsHandler() {
        /*when an item in the jlist is selected, update the jtextBox output*/
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!jList1.isSelectionEmpty()) { //check if there is a selected item in th jlist
                    i = jList1.getSelectedIndex();

                    stock1.setCurrent_price((double) currentPrice.get(i));
                    stock1.setPurchase_price((double) purchasePrice.get(i));
                    stock1.setShares((int) quantities.get(i));

                    double result = Math.ceil(stock1.calc()); //round off
                    if (result > 0) {
                        display.setText("Profit of " + result);
                    } else {
                        display.setText("Loss of " + result);
                    }
                }
            }
        });

        /*When the add stock button is clicked*/
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //call the add stock method
                addStock();

                //update the jList elements
                output();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get the index of the removed jlist element
                i = jList1.getSelectedIndex();

                //remove the elements from the stock
                removeStock(i);

                //update the jlist model
                output();
            }
        });

    }

    /**
     *
     * Method handles displaying the elements in the various array-list to the
     * jList
     *
     *
     */
    public void output() {
        //remove all items currently in the listmodel
        listModel.removeAllElements();
        jList1.clearSelection(); //unselect any selected element
        display.setText(""); //Also clear the output (profit/loss) textfield

        Object[] object = stkNames.toArray(); //convert the company names into an array

        /*to avoid runtime exceptions, the jlist should only be updated if there are elements in the list */
        if (object.length > 0) {
            for (int n = 0; n < object.length; n++) {
                
                listModel.add(n, object[n].toString());
            }

            //set  only one element can be selected at given time
            jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            //set the model of the jlist(currently empty)
            jList1.setModel(listModel);
        }
    }

    public void addStock() {
        //get the user input

        String stockName = jTxtFieldStockName.getText();
        /*check if stock name has been set.[ trim() method remove any trailling whitespaces ]*/
        if (stockName.isEmpty() || stockName.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please provide the stock name", "Error", JOptionPane.ERROR_MESSAGE);
            return; //break the execution
        }

        /*use of try-catch method to catch errors such as if user enters non decimal value or if null*/
        try {
            qty = Integer.parseInt(jTxtFieldQuantity.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Quantity set!", "Error", JOptionPane.ERROR_MESSAGE);
            return; //break execution
        }
        try {
            p_price = Float.parseFloat(jTxtFieldPPrice.getText());
            c_price = Float.parseFloat(jTxtFieldCPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid price set! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;//break the execution
        }
        //add the stock details inot respective arrays
        stkNames.add(stockName);
        quantities.add(qty);
        purchasePrice.add(p_price);
        currentPrice.add(c_price);

        /*notify the user the stock has been added & clear the inputs*/
        JOptionPane.showMessageDialog(null, "New stock added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        jTxtFieldCPrice.setText("");
        jTxtFieldPPrice.setText("");
        jTxtFieldQuantity.setText("");
        jTxtFieldStockName.setText("");

    }

    public void removeStock(int index) {
        stkNames.remove(index);
        quantities.remove(index);
        purchasePrice.remove(index);
        currentPrice.remove(index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        display = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtFieldStockName = new javax.swing.JTextField();
        jTxtFieldQuantity = new javax.swing.JTextField();
        jTxtFieldPPrice = new javax.swing.JTextField();
        jTxtFieldCPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stocks 4U!!!");

        jPanel1.setVerifyInputWhenFocusTarget(false);

        jScrollPane1.setViewportView(jList1);

        display.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        display.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnRemove.setForeground(new java.awt.Color(255, 51, 51));
        btnRemove.setText("Remove stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Show stocks", jPanel1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("Stock name");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Quantity of stocks");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Purchase price");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Current price");

        jTxtFieldStockName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtFieldQuantity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtFieldPPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtFieldCPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnAdd.setForeground(new java.awt.Color(0, 204, 204));
        btnAdd.setText("Add stock");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtFieldCPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtFieldPPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtFieldStockName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFieldStockName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFieldPPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFieldCPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.addTab("Add stock", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stocks4U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stocks4U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stocks4U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stocks4U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stocks4U().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTextField display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTxtFieldCPrice;
    private javax.swing.JTextField jTxtFieldPPrice;
    private javax.swing.JTextField jTxtFieldQuantity;
    private javax.swing.JTextField jTxtFieldStockName;
    // End of variables declaration//GEN-END:variables
}
