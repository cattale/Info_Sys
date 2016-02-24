package ViewLayer;

import BussinessLayer.Subject;
import static ViewLayer.BaseFrame.sessionAPI;
import static ViewLayer.BaseTable.TableClearer;
import static ViewLayer.BaseTable.TableFiller;
import static ViewLayer.BaseTable.TableParametrizer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RentAdd2Frame extends BaseFrame
{
    private Integer ClientId;
    private Date Start;
    private Date End;
    private String Name;
    private ArrayList<Subject> Items=new ArrayList<Subject>();

    public RentAdd2Frame(RentAdd1Frame aThis, Integer ClientId, Date Start, Date End, String Name)
    {
        super("Создание заказа. Шаг#2", aThis);
        initComponents();
        this.ClientId=ClientId;
        this.Start=Start;
        this.End=End;
        this.Name=Name;

        try
        {
            EventAssociatedRentsTablePainter();
        }
        catch (SQLException| ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;
        };

    };

     private void EventAssociatedRentsTablePainter() throws SQLException, ClassNotFoundException
    {

        TableClearer(this.AssociatedRentsTable);

        TableParametrizer(this.AssociatedRentsTable, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION,
                new  ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        Items.clear();

                        if (AssociatedRentsTable.getSelectedRows().length!=0)
                        {

                            for (int it: AssociatedRentsTable.getSelectedRows())
                            {
                                try
                                {
                                    Items.add(sessionAPI.getFreeSubject(Start, End).get(it));
                                }
                                catch (SQLException ex)
                                {
                                    Logger.getLogger(RentAdd2Frame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            };
                        };

                    };
                });

        int i=0;


        for(Subject r: sessionAPI.getSubject(Start, End))
        {

            Object [] Tmp;

            Tmp=new Object[6];

            Tmp[0]=i+1;
            Tmp[1]=r.getId();
            Tmp[2]=r.getType();
            Tmp[3]=r.getOwner();
            Tmp[4]=r.GetHourFee();
            Tmp[5]= r.state == 0 ? "Свободен"  : r.state == 1 ? "Забронирован" : "Занят";

            TableFiller(this.AssociatedRentsTable, i, Tmp);
            i++;
        };
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AssociatedRentsTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        SaveEventButton = new javax.swing.JButton();
        ToListButton = new javax.swing.JButton();
        ToPreviousStep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setText("Заказ (Создание)");

        AssociatedRentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "№", "Id", "Тип", "Собственник", "Плата", "Состояние"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(AssociatedRentsTable);

        jLabel14.setText("Ассоциированные ренты:");

        SaveEventButton.setText("Сохранить");
        SaveEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveEventButtonActionPerformed(evt);
            }
        });

        ToListButton.setText("К редактору");
        ToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToListButtonActionPerformed(evt);
            }
        });

        ToPreviousStep.setText("К предыдущему шагу");
        ToPreviousStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToPreviousStepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)
                                .addGap(130, 130, 130)))))
                .addGap(0, 272, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ToListButton)
                        .addGap(38, 38, 38)
                        .addComponent(SaveEventButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(ToPreviousStep)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addGap(31, 31, 31)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToListButton)
                    .addComponent(SaveEventButton))
                .addGap(18, 18, 18)
                .addComponent(ToPreviousStep)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToListButtonActionPerformed
        goToFrame(this.previousFrame.previousFrame);
    }//GEN-LAST:event_ToListButtonActionPerformed

    private void SaveEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveEventButtonActionPerformed

        Integer id=null;

        try
        {
            id= sessionAPI.createRent(ClientId,Start, End,
                    Name, Items);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;

        };

        if (id==null)
        {
            JOptionPane.showMessageDialog(null, "Данные некорректны, заказ не сохранен.");
            return;
        };

        JOptionPane.showMessageDialog(null, "Заказ сохранен, id="+id);

        try
        {
            ((MainFrame)this.previousFrame.previousFrame).WondersTablePainter();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RentAdd2Frame.class.getName()).log(Level.SEVERE, null, ex);
        };

        goToFrame(this.previousFrame.previousFrame);
    }//GEN-LAST:event_SaveEventButtonActionPerformed

    private void ToPreviousStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToPreviousStepActionPerformed
        goToFrame(this.previousFrame);
    }//GEN-LAST:event_ToPreviousStepActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssociatedRentsTable;
    private javax.swing.JButton SaveEventButton;
    private javax.swing.JButton ToListButton;
    private javax.swing.JButton ToPreviousStep;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
