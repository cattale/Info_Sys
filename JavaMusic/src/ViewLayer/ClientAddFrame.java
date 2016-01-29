package ViewLayer;

import static ViewLayer.BaseFrame.DateFromString;
import static ViewLayer.BaseFrame.sessionAPI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClientAddFrame extends BaseFrame
{
    private String Surname;
    private String Name;
    private String Patronym;

    public ClientAddFrame(BaseFrame previousFrame) 
    {    
        super("Добавление клиента.", previousFrame);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SurnameField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PatronymField = new javax.swing.JTextField();
        ToListButton = new javax.swing.JButton();
        SaveClientButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel8.setText("Клиент (создание)");

        jLabel9.setText("Фамилия:");

        jLabel11.setText("Имя:");

        jLabel12.setText("Отчество:");

        ToListButton.setText("К редактору");
        ToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToListButtonActionPerformed(evt);
            }
        });

        SaveClientButton.setText("Сохранить");
        SaveClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveClientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ToListButton)
                        .addGap(38, 38, 38)
                        .addComponent(SaveClientButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SurnameField)
                            .addComponent(PatronymField)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(SurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(PatronymField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToListButton)
                    .addComponent(SaveClientButton))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToListButtonActionPerformed
        goToPreviousFrame();
    }//GEN-LAST:event_ToListButtonActionPerformed

    private void SaveClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveClientButtonActionPerformed
        
        Integer id=null;
        boolean check=inputClientParser();
        
        if (!check)
        {
            JOptionPane.showMessageDialog(null, "Ошибка ввода.");
            return;  
        };
        
        try 
        {
            id= sessionAPI.createClient(this.Surname, this.Name, this.Patronym);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;
            
        };
        
        if (id==null)
        {
            JOptionPane.showMessageDialog(null, "Данные некорректны, клиент не сохранен.");
            return;
        };
        
        JOptionPane.showMessageDialog(null, "Клиент сохранен, id="+id);
        
        try 
        {
           
            ((MainFrame)this.previousFrame).ClientsTablePainter();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RentAdd2Frame.class.getName()).log(Level.SEVERE, null, ex);
        };

        goToFrame(this.previousFrame);
    }//GEN-LAST:event_SaveClientButtonActionPerformed

     private boolean inputClientParser()
    {
        boolean result=true;
        
        if (SurnameField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            this.Surname=SurnameField.getText();
        };
        
        if (NameField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            this.Name=NameField.getText();
        };
        
        if (PatronymField.getText().isEmpty())
        {
            result=false;
        }
        else
        {
            this.Patronym=PatronymField.getText();
        };
        
        return result;
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PatronymField;
    private javax.swing.JButton SaveClientButton;
    private javax.swing.JTextField SurnameField;
    private javax.swing.JButton ToListButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
