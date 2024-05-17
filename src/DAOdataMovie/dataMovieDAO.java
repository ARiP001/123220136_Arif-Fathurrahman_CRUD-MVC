package DAOdataMovie;

import java.sql.*;
import java.util.*;
import Connection.connector;
import Model.*;
import DAOImplement.dataMovieImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataMovieDAO implements dataMovieImplement {

    Connection connection;

    final String select = "SELECT * FROM movie;";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET alur = ?, penokohan = ?, akting = ?, nilai = ? WHERE judul = ?;";
    final String delete = "DELETE FROM movie WHERE judul = ?;";
    
    public dataMovieDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(dataMovie p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.getNilai());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                p.setJudul(rs.getString(select));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataMovie p) {
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            statement.setDouble(4, p.getNilai());
            statement.setString(5, p.getJudul());

            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
        }
    }

    
    @Override
    public List<dataMovie> getAll() {
        List<dataMovie> dm = null;
        try {
            dm = new ArrayList<dataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                dataMovie mv = new dataMovie();
                mv.setJudul(rs.getString("judul"));
                mv.setAlur(rs.getDouble("alur"));
                mv.setPenokohan(rs.getDouble("penokohan"));
                mv.setAkting(rs.getDouble("akting"));
                mv.setNilai(rs.getDouble("nilai"));
                dm.add(mv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dataMovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dm;
    }
}
