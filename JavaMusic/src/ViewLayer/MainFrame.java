package ViewLayer;

import BussinessLayer.Client;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import static ViewLayer.BaseTable.TableClearer;
import static ViewLayer.BaseTable.TableFiller;
import static ViewLayer.BaseTable.TableParametrizer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends BaseFrame
{

    private Rent RentSelected=null;
    private Client ClientSelected=null;
    private ArrayList<Rent> EventList=new ArrayList<>();
    private ArrayList<Client> ClientList=new ArrayList<>();
    
    
    public MainFrame(BaseFrame previousFrame) 
    {
        super("Главное окно.", previousFrame);
        initComponents();
        
        if (sessionAPI.getCurrentUser().getType()!=Staff.StaffType.администратор)
        {
          TabbedPane.setEnabledAt(TabbedPane.indexOfComponent(ClientsPanel), false);  
        };
        
        try
        {
            TableParametrizer(this.EventsTable, ListSelectionModel.SINGLE_SELECTION, 
                new  ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e) 
                    {
                         if ((EventsTable.getSelectedRow()!=-1)&&(EventList!=null)&&(EventsTable.getSelectedRow()<EventList.size()))
                         {
                                RentSelected=EventList.get(EventsTable.getSelectedRow());
                         }
                         else
                             RentSelected=null;
                    }
                });
            WondersTablePainter();
            
            TableParametrizer(this.ClientsTable, ListSelectionModel.SINGLE_SELECTION, 
                new  ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e) 
                    {
                         if ((ClientsTable.getSelectedRow()!=-1)&&(ClientList!=null)&&(ClientsTable.getSelectedRow()<ClientList.size()))
                         {
                                ClientSelected=ClientList.get(ClientsTable.getSelectedRow());
                         }
                         else
                             ClientSelected=null;
                    }
                });
            ClientsTablePainter();
            
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;
        };
    }


    public void WondersTablePainter() throws SQLException
    {
        
        EventList=this.sessionAPI.getRent();
        
        TableClearer(this.EventsTable);
        
        int i=0;
        
        if (EventList!=null)
        for(Rent ev: EventList)
        {
            Object [] Tmp;
            
            Tmp=new Object[6];
            
            Tmp[0]=i+1;
            if (ev.getOrderer() != null)
                Tmp[1]=ev.getOrderer().getSurname()+" "+ev.getOrderer().getName().charAt(0)+". "+ev.getOrderer().getPatronym().charAt(0)+".";
            Tmp[2]=ev.getName();
            Tmp[3]=DateToString(ev.getStart());
            Tmp[4]=DateToString(ev.getEnd());
            Tmp[5]=ev.getRentCost();
                    
            TableFiller(EventsTable, i, Tmp);
            
            i++;
        };
        
    }
    
    public void ClientsTablePainter() throws SQLException
    {
        
        ClientList=this.sessionAPI.getClient();
        
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
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        EventsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EventsTable = new javax.swing.JTable();
        ViewEventTableButton = new javax.swing.JButton();
        AddEventButton = new javax.swing.JButton();
        DeleteEventButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        ClientsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientsTable = new javax.swing.JTable();
        AddClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        Logout1Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Список заказов");

        EventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "№", "Заказчик", "Название", "Начало", "Конец", "Стоимость"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(EventsTable);

        ViewEventTableButton.setText("Просмотреть");
        ViewEventTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEventTableButtonActionPerformed(evt);
            }
        });

        AddEventButton.setText("Добавить");
        AddEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEventButtonActionPerformed(evt);
            }
        });

        DeleteEventButton.setText("Удалить");
        DeleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEventButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Выйти");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EventsPanelLayout = new javax.swing.GroupLayout(EventsPanel);
        EventsPanel.setLayout(EventsPanelLayout);
        EventsPanelLayout.setHorizontalGroup(
            EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventsPanelLayout.createSequentialGroup()
                .addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EventsPanelLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel1))
                    .addGroup(EventsPanelLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EventsPanelLayout.createSequentialGroup()
                                .addComponent(ViewEventTableButton)
                                .addGap(89, 89, 89)
                                .addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EventsPanelLayout.createSequentialGroup()
                                        .addComponent(AddEventButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DeleteEventButton))
                                    .addGroup(EventsPanelLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(LogoutButton)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        EventsPanelLayout.setVerticalGroup(
            EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventsPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(EventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewEventTableButton)
                    .addComponent(AddEventButton)
                    .addComponent(DeleteEventButton))
                .addGap(64, 64, 64)
                .addComponent(LogoutButton)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Заказы", EventsPanel);

        jLabel2.setText("Список клиентов");

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

        AddClientButton.setText("Добавить");
        AddClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setText("Удалить");
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        Logout1Button.setText("Выйти");
        Logout1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientsPanelLayout = new javax.swing.GroupLayout(ClientsPanel);
        ClientsPanel.setLayout(ClientsPanelLayout);
        ClientsPanelLayout.setHorizontalGroup(
            ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientsPanelLayout.createSequentialGroup()
                .addGroup(ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientsPanelLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel2))
                    .addGroup(ClientsPanelLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClientsPanelLayout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(Logout1Button))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ClientsPanelLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(AddClientButton)
                        .addGap(80, 80, 80)
                        .addComponent(DeleteClientButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ClientsPanelLayout.setVerticalGroup(
            ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientsPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddClientButton)
                    .addComponent(DeleteClientButton))
                .addGap(59, 59, 59)
                .addComponent(Logout1Button)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Клиенты", ClientsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEventButtonActionPerformed

        RentAdd1Frame EventAdder=new RentAdd1Frame(this);
        goToFrame(EventAdder);
        
    }//GEN-LAST:event_AddEventButtonActionPerformed

    private void DeleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEventButtonActionPerformed
      
        if (RentSelected==null)
        {
            JOptionPane.showMessageDialog(null, "Выберите заказ.");
            return;
        };
        
        Rent Deleted=RentSelected;
        
        try 
        {
            this.EventsTable.getSelectionModel().clearSelection();
            
            System.out.println("RentSelId="+Deleted.getId());
            sessionAPI.deleteRentById(Deleted.getId());
            
            WondersTablePainter();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;  
        };
    }//GEN-LAST:event_DeleteEventButtonActionPerformed

    private void AddClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientButtonActionPerformed
      
        ClientAddFrame ClientAdder=new ClientAddFrame(this);
        goToFrame(ClientAdder);
        
    }//GEN-LAST:event_AddClientButtonActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
        if (ClientSelected==null)
        {
            JOptionPane.showMessageDialog(null, "Выберите клиента.");
            return;
        };
        
        Client Deleted=ClientSelected;
        
        try 
        {
            this.ClientsTable.getSelectionModel().clearSelection();
            
            sessionAPI.deleteClientById(Deleted.getId());
             WondersTablePainter();
            ClientsTablePainter();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Ошибка работы с базой данных.");
            return;  
        };
    }//GEN-LAST:event_DeleteClientButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        sessionAPI.logout();
        this.goToStartFrame();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void ViewEventTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEventTableButtonActionPerformed
        
        if (RentSelected==null)
        {
            JOptionPane.showMessageDialog(null, "Выберите событие.");
            return;
        }; 
        
        RentViewFrame EventViewer=new RentViewFrame(this, RentSelected);
        goToFrame(EventViewer);
    }//GEN-LAST:event_ViewEventTableButtonActionPerformed

    private void Logout1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout1ButtonActionPerformed
        sessionAPI.logout();
        this.goToStartFrame();
    }//GEN-LAST:event_Logout1ButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientButton;
    private javax.swing.JButton AddEventButton;
    private javax.swing.JPanel ClientsPanel;
    private javax.swing.JTable ClientsTable;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JButton DeleteEventButton;
    private javax.swing.JPanel EventsPanel;
    private javax.swing.JTable EventsTable;
    private javax.swing.JButton Logout1Button;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton ViewEventTableButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
