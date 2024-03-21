 package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Plante;
public class PlanteModele {
private String motCle;
List<Plante> plantes = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Plante> getPlantes() {
return plantes;
}
public void setPlantes(List<Plante> plantes) {
this.plantes = plantes;
}
}