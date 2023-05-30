/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import daotabel.DataPerpusDAO;
import daoimplement.DataPerpusInterface;
import model.*;
import view.PerpusFrame;
import javax.swing.JTable;

/**
 *
 * @author Lab Informatika
 */
public class DataPerpusController {

    PerpusFrame frame;
    DataPerpusInterface datainterface;
    List<DataPerpus> data;

    public DataPerpusController(PerpusFrame frame) {
        this.frame = frame;
        datainterface = new DataPerpusDAO();
//        data = datainterface.getAll();
    }

    public void isiTabel() {
        data = datainterface.getAll();
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }

    public void insert() {
        DataPerpus data = new DataPerpus();
        data.setJudul(frame.getJjudul().getText());
        data.setGenre(frame.getJgenre().getText());
        data.setLokasi(frame.getJlokasi().getText());
        data.setPenulis(frame.getJpenulis().getText());
        data.setPenerbit(frame.getJpenerbit().getText());
        data.setStock(Integer.parseInt(frame.getJstock().getText()));
        datainterface.insert(data);
    }

    public void update() {
        DataPerpus data = new DataPerpus();
        data.setId(Integer.parseInt(frame.getJid().getText()));
        data.setJudul(frame.getJjudul().getText());
        data.setGenre(frame.getJgenre().getText());
        data.setLokasi(frame.getJlokasi().getText());
        data.setPenulis(frame.getJpenulis().getText());
        data.setPenerbit(frame.getJpenerbit().getText());
        data.setStock(Integer.parseInt(frame.getJstock().getText()));
        datainterface.update(data);
    }

    public void delete() {
        int id = Integer.parseInt(frame.getJid().getText());
        datainterface.delete(id);
    }

    public void cariJudul() {
        DataPerpus data1 = new DataPerpus();
        data1.setJudul(frame.getJcari().getText());
        data = datainterface.cariJudul(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
    public void cariGenre() {
        DataPerpus data1 = new DataPerpus();
        data1.setGenre(frame.getJcari().getText());
        data = datainterface.cariGenre(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
    public void cariPenulis() {
        DataPerpus data1 = new DataPerpus();
        data1.setPenulis(frame.getJcari().getText());
        data = datainterface.cariPenulis(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
    public void cariPenerbit() {
        DataPerpus data1 = new DataPerpus();
        data1.setPenerbit(frame.getJcari().getText());
        data = datainterface.cariPenerbit(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
    public void cariLokasi() {
        DataPerpus data1 = new DataPerpus();
        data1.setLokasi(frame.getJcari().getText());
        data = datainterface.cariLokasi(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
    public void cariStock() {
        DataPerpus data1 = new DataPerpus();
        data1.setStock(Integer.parseInt(frame.getJcari().getText()));
        data = datainterface.cariStock(data1);
        DataPerpusModel dm = new DataPerpusModel(data);
        frame.getTabeldata().setModel(dm);
    }
}
