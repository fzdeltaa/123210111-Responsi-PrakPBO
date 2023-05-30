/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;
import java.util.List;
import model.DataPerpus;

/**
 *
 * @author Lab Informatika
 */
public interface DataPerpusInterface {
    public void insert(DataPerpus data);
    public void update(DataPerpus data);
    public void delete(int id);
    public List<DataPerpus> getAll();
    public List<DataPerpus> cariJudul(DataPerpus data);
    public List<DataPerpus> cariGenre(DataPerpus data);
    public List<DataPerpus> cariPenulis(DataPerpus data);
    public List<DataPerpus> cariPenerbit(DataPerpus data);
    public List<DataPerpus> cariLokasi(DataPerpus data);
    public List<DataPerpus> cariStock(DataPerpus data);
}
