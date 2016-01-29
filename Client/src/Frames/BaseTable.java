package Frames;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public abstract class BaseTable 
{
    
    protected static void TableParametrizer(JTable Table, int SelectionModel, ListSelectionListener x)
    {
        Table.setSelectionMode(SelectionModel);
        
        Table.getSelectionModel().addListSelectionListener(x);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        Table.setDefaultRenderer(Object.class, centerRenderer);
        Table.getTableHeader().setDefaultRenderer(centerRenderer);
        
        Table.setGridColor(Color.BLACK);
        Table.setShowGrid(true);
         
    };
    
    protected static void TableClearer(JTable Table)
    {
        DefaultTableModel TModel=(DefaultTableModel)Table.getModel();
        
        for (int i=0; i< TModel.getRowCount(); i++)
        {
            for (int k=0; k<TModel.getColumnCount(); k++)
                 TModel.setValueAt(null, i, k); 
        };
    };
    
    protected static void TableFiller(JTable Table,int rowIteration, Object [] Tmp)
    {
        DefaultTableModel Model=(DefaultTableModel) Table.getModel();
        
        if (rowIteration<Model.getRowCount())
        {
            for (int k=0; k<Model.getColumnCount(); k++)
                Model.setValueAt(Tmp[k], rowIteration, k);
        }
        else
            Model.addRow(Tmp);
    };
    
}
