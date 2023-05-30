/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class DataPerpusModel extends AbstractTableModel {

    List<DataPerpus> data;

    public DataPerpusModel(List<DataPerpus> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return data.get(row).getId();
            case 1:
                return data.get(row).getJudul();
            case 2:
                return data.get(row).getGenre();
            case 3:
                return data.get(row).getPenulis();
            case 4:
                return data.get(row).getPenerbit();
            case 5:
                return data.get(row).getLokasi();
            case 6:
                return data.get(row).getStock();
            default:
                return null;
                
        }
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "id";
            case 1:
                return "judul";
            case 2:
                return "genre";
            case 3:
                return "penulis";
            case 4:
                return "penerbit";
            case 5:
                return "lokasi";
            case 6:
                return "stock";
            default:
                return null;
            
        }
    }

}
