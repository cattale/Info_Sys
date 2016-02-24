package ViewLayer;

import BussinessLayer.Rent;
import BussinessLayer.Subject;
import BussinessLayer.Staff.StaffType;
import static ViewLayer.BaseTable.TableClearer;
import static ViewLayer.BaseTable.TableFiller;
import static ViewLayer.BaseTable.TableParametrizer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class RentViewFrame extends BaseFrame
{
   private Rent RentSelected=null;

    public RentViewFrame(BaseFrame previousFrame, Rent RentSelected)
    {
        super("Просмотр заказа.", previousFrame);
        this.RentSelected=RentSelected;
        initComponents();

        try
        {

           CardFiller();
           EventAssociatedRentsTablePainter();
        }
        catch (SQLException | ClassNotFoundException ex)
        {
           JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
           return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ClientField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EmployeeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        StartField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EndField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssociatedRentsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ToListButton = new javax.swing.JButton();
        IdHolderLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        EventIdField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        EventCostField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        EndField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Заказ (просмотр)");

        jLabel2.setText("Клиент:");

        ClientField.setEditable(false);

        jLabel3.setText("Сотрудник:");

        EmployeeField.setEditable(false);

        jLabel4.setText("Название:");

        NameField.setEditable(false);

        jLabel5.setText("Начало:");

        StartField.setEditable(false);

        jLabel6.setText("Конец:");

        EndField.setEditable(false);

        AssociatedRentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "№", "Id", "Тип", "Собственник", "Плата"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AssociatedRentsTable);

        jLabel7.setText("Ассоциированные ренты:");

        ToListButton.setText("К редактору");
        ToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToListButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Id:");

        EventIdField.setEditable(false);

        jLabel9.setText("Стоимость:");

        EventCostField.setEditable(false);

        jButton1.setText("Оплачено");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Оплачено:");

        EndField1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(ClientField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(StartField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(EndField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(EventIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(EmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(EndField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)
                        .addGap(0, 432, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(165, 165, 165))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(195, 195, 195))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(IdHolderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ToListButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EventCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(EventIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(ClientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(IdHolderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(EmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(StartField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(EndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(EndField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EventCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ToListButton)
                                    .addComponent(jButton1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EventAssociatedRentsTablePainter() throws SQLException, ClassNotFoundException
    {

        TableClearer(this.AssociatedRentsTable);

        TableParametrizer(this.AssociatedRentsTable, ListSelectionModel.SINGLE_SELECTION,
                null);

        int i=0;


        for(Subject r: this.RentSelected.getItems())
        {

            Object [] Tmp;

            Tmp=new Object[5];

            Tmp[0]=i+1;
            Tmp[1]=r.getId();
            Tmp[2]=r.getType();
            Tmp[3]=r.getOwner();
            Tmp[4]=r.GetHourFee();

            TableFiller(this.AssociatedRentsTable, i, Tmp);
            i++;
        };
    };

    private void CardFiller()
    {
        this.EventIdField.setText(RentSelected.getId().toString());
        this.ClientField.setText(RentSelected.getOrderer().getSurname()+" "+RentSelected.getOrderer().getName()+" "+RentSelected.getOrderer().getPatronym());
        this.IdHolderLabel.setText("id="+RentSelected.getOrderer().getId().toString());
        this.EmployeeField.setText(RentSelected.getWorker().getSurname()+" "+RentSelected.getWorker().getName()+" "+RentSelected.getWorker().getPatronym());
        this.NameField.setText(RentSelected.getName());
        this.StartField.setText(DateToString(RentSelected.getStart()));
        this.EndField.setText(DateToString(RentSelected.getEnd()));
        this.EventCostField.setText(RentSelected.getRentCost().toString());
        this.EndField1.setText(RentSelected.isPaid() ? "Да" : "Нет"); //RentSelected.isPaid()
        this.jButton1.setVisible(sessionAPI.getCurrentUser().getType() == StaffType.финдиректор);
    };

    private void ToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToListButtonActionPerformed
        goToPreviousFrame();
    }//GEN-LAST:event_ToListButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RentSelected.changePaid();
        CardFiller();
       
       try {
           sessionAPI.changeRentPaid(RentSelected.getId(), RentSelected.isPaid());
       } catch (SQLException ex) {
           Logger.getLogger(RentViewFrame.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
       }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssociatedRentsTable;
    private javax.swing.JTextField ClientField;
    private javax.swing.JTextField EmployeeField;
    private javax.swing.JTextField EndField;
    private javax.swing.JTextField EndField1;
    private javax.swing.JTextField EventCostField;
    private javax.swing.JTextField EventIdField;
    private javax.swing.JLabel IdHolderLabel;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField StartField;
    private javax.swing.JButton ToListButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
