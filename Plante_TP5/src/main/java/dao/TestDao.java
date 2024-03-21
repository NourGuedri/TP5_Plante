package dao;
import java.util.List;
import metier.entities.Plante;
public class TestDao {
public static void main(String[] args) {
	PlanteDaoImpl pdao= new PlanteDaoImpl();
	Plante plante= pdao.save(new Plante("Lavande","Violet"));
System.out.println(plante);
List<Plante> plantes =pdao.plantesParMC("HP");
for (Plante p : plantes)
System.out.println(p);
}
}
