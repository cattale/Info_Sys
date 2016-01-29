package Frames;

import static Frames.BaseTable.TableClearer;
import static Frames.BaseTable.TableFiller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ClientsRegistryFrame extends javax.swing.JFrame 
{

    private static String makegetClientsAsk() 
    {
        JSONObject obj=new JSONObject();
        obj.put("command","getClients");
         
        return obj.toJSONString();
    }
    
    private static ArrayList<Client> parsegetClientsResult(String result) throws ParseException 
    {
        ArrayList<Client> resL=new ArrayList<>();
         JSONParser jsonParser = new JSONParser();
         JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
         
         JSONArray nestedArr=(JSONArray)jsonObject.get("clients");
         
         for (int i = 0; i<nestedArr.size(); i++)
         {
             resL.add(new Client(Integer.parseInt(((JSONObject)(nestedArr.get(i))).get("id").toString()),
                     ((JSONObject)(nestedArr.get(i))).get("surname").toString(), 
                     ((JSONObject)(nestedArr.get(i))).get("name").toString(), 
                     ((JSONObject)(nestedArr.get(i))).get("patronym").toString()));
             
         }
        
         return  resL;
    };
    
    public void ClientsTablePainter(ArrayList<Client> ClientList) throws SQLException
    {
        
        
        TableClearer(this.ClientsTable);
        
        int i=0;
        
        if (ClientList!=null)
        for(Client cel: ClientList)
        {
            Object [] Tmp;
            
            Tmp=new Object[3];
            
            Tmp[0]=i+1;
            Tmp[1]=cel.getId();
            Tmp[2]=cel.getSurname()+" "+cel.getName()+" "+cel.getPatronym();
            
            TableFiller(ClientsTable, i, Tmp);
            
            i++;
        };
        
    }
    
    public ClientsRegistryFrame() 
    {
        initComponents();
        
         try 
        {
            Connection ToSrv=Connection.getInstance();
            
            String encodedCommand=makegetClientsAsk();
                    
            ToSrv.out.println(encodedCommand);
            
            String encodedResult=ToSrv.in.readLine();
            
            ArrayList<Client> result=parsegetClientsResult(encodedResult);
            
            if (!result.isEmpty())
            {
                ClientsTablePainter(result);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы на сокетах.");
            return;
        } 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientsTable = new javax.swing.JTable();
        logoutbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Список клиентов");

        ClientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "№", "Id", "Ф.И.О."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ClientsTable);

        logoutbutton.setText("Выйти");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(logoutbutton)))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutbutton)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
       
        try 
        {
            String encodedCommand=makeLogoutAsk();
            Connection ToSrv=Connection.getInstance();
            ToSrv.out.println(encodedCommand);
            
            ToSrv.resetInstance();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы на сокетах.");
            return;        
        };
        
            this.dispose();
            new LoginFrame().setVisible(true);
        
    }//GEN-LAST:event_logoutbuttonActionPerformed

  
    private static String makeLogoutAsk() 
    {
         JSONObject obj=new JSONObject();
         
         obj.put("command", "logout");
         
         return obj.toJSONString();
    }
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(ClientsRegistryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientsRegistryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientsRegistryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientsRegistryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientsRegistryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClientsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutbutton;
    // End of variables declaration//GEN-END:variables
}
