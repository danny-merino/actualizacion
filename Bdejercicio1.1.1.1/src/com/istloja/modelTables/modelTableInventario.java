
package com.istloja.modelTables;

import com.istloja.modelo.Persona;
import com.istloja.modelo.Inventario;
import com.istloja.vistas.GestionContable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


public class modelTableInventario extends AbstractTableModel  {
    private String[] m_colNames = {"Codigo producto", "Descripcion", "Precio Compras", "Precio Ventas", "Cantidad Productos"};
    private List<Inventario> inventario;
    private GestionContable gContable;

    public modelTableInventario(List<Inventario> inventario, GestionContable gContable) {
        this.inventario = inventario;
        this.gContable = gContable;
    }

    //Determina el número de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return inventario.size();
    }

    //Determina el número de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario inevntario = inventario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventario.getCodigo_pro();
            case 1:
                return inventario.getDescripcion();
            case 2:
                return inventario.getPrecios_compras();
            case 3:
                return inventario.getPrecios_venta();
            case 4:
                return inventario.getCan_productos();
            case 5:
             
                
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickInventario(inventario.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Inventario> getProveedores() {
        return inventario;
    }

    public void setInventario(List<Inventario> inventario) {
        this.inventario = inventario;
    }
    
}
