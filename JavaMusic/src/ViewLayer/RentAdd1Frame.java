package ViewLayer;

import BussinessLayer.Staff;
import BussinessLayer.Rent;
import static ViewLayer.BaseFrame.sessionAPI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class RentAdd1Frame extends BaseFrame
{
    private Integer ClientId;
    private Date Start;
    private Date End;
    private String Name;

    public RentAdd1Frame(BaseFrame previousFrame) 
    {
        super("Создание заказа. Шаг#1", previousFrame);
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        ClientIdField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        StartField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        EndField = new javax.swing.JTextField();
        ToListButton = new javax.swing.JButton();
        ToRentsChoiseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setText("Заказ (создание)");

        jLabel9.setText("Клиент (id):");

        jLabel11.setText("Название:");

        jLabel12.setText("Начало:");

        jLabel13.setText("Конец:");

        ToListButton.setText("К редактору");
        ToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToListButtonActionPerformed(evt);
            }
        });

        ToRentsChoiseButton.setText("Далее");
        ToRentsChoiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToRentsChoiseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(StartField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(ClientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(18, 18, 18)
                                    .addComponent(EndField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ToListButton)
                                .addGap(38, 38, 38)
                                .addComponent(ToRentsChoiseButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel8)))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel8)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ClientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(StartField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(EndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToListButton)
                    .addComponent(ToRentsChoiseButton))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean inputRentParser()
    {
        boolean result=true;
        
        if (ClientIdField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            try
            {
                this.ClientId=Integer.parseInt(ClientIdField.getText());
            }
            catch (NumberFormatException e)
            {
                result=false;  
            };
        };
        
        if (StartField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            try
            {
                this.Start=DateFromString(StartField.getText());
            }
            catch (ParseException e)
            {
                result=false;
            }
        };
        
        if (EndField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            try
            {
                this.End=DateFromString(EndField.getText());
            }
            catch (ParseException e)
            {
                result=false;
            }
        };
        
        if (NameField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            this.Name=NameField.getText();
        };
        
        return result;
    };
    
    private void ToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToListButtonActionPerformed
        goToPreviousFrame();
    }//GEN-LAST:event_ToListButtonActionPerformed

    private void ToRentsChoiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToRentsChoiseButtonActionPerformed
        boolean result=inputRentParser();
        
        if (!result)
        {
            JOptionPane.showMessageDialog(null, "Ошибка ввода.");
            return;  
        }
        else
        {
                RentAdd2Frame EventAdder2step=new RentAdd2Frame(this, ClientId, Start, End, Name);
                goToFrame(EventAdder2step);
        };
        
    }//GEN-LAST:event_ToRentsChoiseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClientIdField;
    private javax.swing.JTextField EndField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField StartField;
    private javax.swing.JButton ToListButton;
    private javax.swing.JButton ToRentsChoiseButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
