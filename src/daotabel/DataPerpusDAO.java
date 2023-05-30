/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotabel;

import daoimplement.DataPerpusInterface;
import java.sql.*;
import java.util.*;
import connector.Connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab Informatika
 */
public class DataPerpusDAO implements DataPerpusInterface {

    Connection koneksi;
    final String select = "SELECT * FROM dataperpus";
    final String selectJudul = "SELECT * FROM dataperpus WHERE judul=?";
    final String selectGenre = "SELECT * FROM dataperpus WHERE genre=?";
    final String selectPenulis = "SELECT * FROM dataperpus WHERE penulis=?";
    final String selectPenerbit = "SELECT * FROM dataperpus WHERE penerbit=?";
    final String selectLokasi = "SELECT * FROM dataperpus WHERE lokasi=?";
    final String selectStock = "SELECT * FROM dataperpus WHERE stock=?";
    final String insert = "INSERT INTO dataperpus(judul, genre, penulis, penerbit, lokasi, stock) VALUES (?,?,?,?,?,?)";
    final String update = "UPDATE dataperpus SET judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? WHERE id=?";
    final String delete = "DELETE FROM dataperpus WHERE id=?";

    public DataPerpusDAO() {
        koneksi = Connector.konek();
    }

    @Override
    public void insert(DataPerpus data) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, data.getJudul());
            statement.setString(2, data.getGenre());
            statement.setString(3, data.getPenulis());
            statement.setString(4, data.getPenerbit());
            statement.setString(5, data.getLokasi());
            statement.setInt(6, data.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataPerpus data) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(update);
            statement.setString(1, data.getJudul());
            statement.setString(2, data.getGenre());
            statement.setString(3, data.getPenulis());
            statement.setString(4, data.getPenerbit());
            statement.setString(5, data.getLokasi());
            statement.setInt(6, data.getStock());
            statement.setInt(7, data.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<DataPerpus> getAll() {
        List<DataPerpus> data = null;
        try {
            data = new ArrayList<DataPerpus>();
            Statement ss = koneksi.createStatement();
            ResultSet rs = ss.executeQuery(select);
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                data.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }

    @Override
    public List<DataPerpus> cariJudul(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectJudul);
            statement.setString(1, data.getJudul());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<DataPerpus> cariGenre(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectGenre);
            statement.setString(1, data.getGenre());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<DataPerpus> cariPenulis(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectPenulis);
            statement.setString(1, data.getPenulis());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<DataPerpus> cariPenerbit(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectPenerbit);
            statement.setString(1, data.getPenerbit());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<DataPerpus> cariLokasi(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectLokasi);
            statement.setString(1, data.getLokasi());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }

    @Override
    public List<DataPerpus> cariStock(DataPerpus data) {
        List<DataPerpus> datat = null;
        PreparedStatement statement = null;
        try {
            datat = new ArrayList<DataPerpus>();
            statement = koneksi.prepareStatement(selectStock);
            statement.setInt(1, data.getStock());
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DataPerpus datap = new DataPerpus();
                datap.setId(rs.getInt("id"));
                datap.setJudul(rs.getString("judul"));
                datap.setGenre(rs.getString("genre"));
                datap.setPenulis(rs.getString("penulis"));
                datap.setPenerbit(rs.getString("penerbit"));
                datap.setLokasi(rs.getString("lokasi"));
                datap.setStock(rs.getInt("stock"));
                datat.add(datap);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerpusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datat;
    }


}
