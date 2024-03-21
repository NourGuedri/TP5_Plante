package dao;
import java.util.List;
import metier.entities.Plante;
public interface IPlanteDao {
	public Plante save(Plante p);
	public List<Plante> plantesParMC(String mc);
	public Plante getPlante(Long id);
	public Plante updatePlante(Plante p);
	public void deletePlante(Long id);
}
