package Controller;
import java.util.List;
import DAOImplement.dataMovieImplement;
import DAOdataMovie.dataMovieDAO;
import Model.*;
import View.mainView;
import javax.swing.JOptionPane;

public class dataMoviecontroller {
    mainView frame;
    dataMovieImplement impdatamovie;
    List<dataMovie> dm;
    
    public dataMoviecontroller (mainView frame){
        this.frame = frame;
        impdatamovie = new dataMovieDAO();
        dm = impdatamovie.getAll();
    }
    public void isitable (){
        dm = impdatamovie.getAll();
        modeltableDatamovie mp = new modeltableDatamovie(dm);
        frame.getTabledataMovie().setModel(mp);
        frame.getTabledataMovie().getColumnModel().getColumn(0).setMinWidth(150);
    }

   public void insert() {
    dataMovie dm = new dataMovie();
    dm.setJudul(frame.getjTextJudul().getText());
    
    try {
        double alur = Double.parseDouble(frame.getjTextAlur().getText());
        double penokohan = Double.parseDouble(frame.getjTextPenokohan().getText());
        double akting = Double.parseDouble(frame.getjTextAkting().getText());

        if (isValidRating(alur) && isValidRating(penokohan) && isValidRating(akting)) {
            double nilai = (alur + penokohan + akting) / 3;
            String tempNilai = String.format("%.3f", nilai);
            double tempNilaiDouble = Double.parseDouble(tempNilai);
            
            dm.setNilai(tempNilaiDouble);
            dm.setAlur(alur);
            dm.setPenokohan(penokohan);
            dm.setAkting(akting);

            impdatamovie.insert(dm);
            
            JOptionPane.showMessageDialog(null, "Data Movie Berhasil Ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nilai Rating Harus 1-5!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
    }
}

private boolean isValidRating(double value) {
    return value >= 1 && value <= 5;
}

    
   public void update(){
    dataMovie dm = new dataMovie();
    dm.setJudul(frame.getjTextJudul().getText());
    try {
        double alur = Double.parseDouble(frame.getjTextAlur().getText());
        double penokohan = Double.parseDouble(frame.getjTextPenokohan().getText());
        double akting = Double.parseDouble(frame.getjTextAkting().getText());
        
        // Calculate nilai and format it to three decimal places
        if (isValidRating(alur) && isValidRating(penokohan) && isValidRating(akting)) {
        double nilai = (alur + penokohan + akting) / 3;
        String formattedNilai = String.format("%.3f", nilai);
        double formattedNilaiDouble = Double.parseDouble(formattedNilai);
        
        dm.setNilai(formattedNilaiDouble);
        dm.setAlur(alur);
        dm.setPenokohan(penokohan);
        dm.setAkting(akting);
        impdatamovie.update(dm);
        JOptionPane.showMessageDialog(null, "Data Movie Berhasil Diedit!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nilai Rating Harus 1-5!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid input: " + e.getMessage());
    }
   }
   
   public void delete(){
       int selectedRow = frame.getTabledataMovie().getSelectedRow();
       
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(frame, "Pilih Dulu Yang Mau Dihapus Dong Masbro", "No row selected", JOptionPane.WARNING_MESSAGE);
    } else {
        String judul = frame.getjTextJudul().getText();
       impdatamovie.delete(judul);
       JOptionPane.showMessageDialog(null, "Data Movie Berhasil Dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
   }
}

