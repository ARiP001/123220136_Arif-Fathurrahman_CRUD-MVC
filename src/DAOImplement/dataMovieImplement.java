package DAOImplement;
import java.util.List;
import Model.*;

public interface dataMovieImplement {
      public void insert(dataMovie p);
      public void update(dataMovie p); 
      public void delete(String p); 
      public List<dataMovie> getAll(); 
}
