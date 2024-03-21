package metier.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "PLANTES")
public class Plante implements Serializable{
@Id
@Column (name="ID_Plante")
private Long idPlante;
@Column (name="NOM_Plante")
private String nomPlante;
@Column (name="Couleur")
private String couleur;
public Plante() {
super();
}
public Plante(String nomPlante, String couleur) {
super();
this.nomPlante = nomPlante;
this.couleur = couleur;
}
public Long getIdPlante() {
return idPlante;
}
public void setIdPlante(Long idPlante) {
this.idPlante = idPlante;
}
public String getNomPlante() {
return nomPlante;
}
public void setNomPlante(String nomPlante) {
this.nomPlante = nomPlante;
}
public String getCouleur() {
return couleur;
}
public void setCouleur(String couleur) {
this.couleur = couleur;
}
@Override
public String toString() {
return "Plante [idPlante=" + idPlante + ", nomPlante=" +
		nomPlante + ", couleur=" + couleur + "]";
}
}