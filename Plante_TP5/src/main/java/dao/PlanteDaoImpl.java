package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Plante;
import util.JPAutil;
public class PlanteDaoImpl implements IPlanteDao {
private EntityManager entityManager=JPAutil.getEntityManager("Plante_TP5");
@Override
public Plante save(Plante p) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(p);
tx.commit();
return p;
}
@Override
public List<Plante> plantesParMC(String mc) {
List<Plante> pls =
entityManager.createQuery("select p from Plante p where p.nomPlante like :mc").setParameter("mc", "%"+mc+"%").getResultList();
 return pls;
}
@Override
public Plante getPlante(Long id) {
 return entityManager.find(Plante.class, id);
}
@Override
public Plante updatePlante(Plante p) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(p);
tx.commit();
return p;
}
@Override
public void deletePlante(Long id) {
	Plante plante = entityManager.find(Plante.class, id);
entityManager.getTransaction().begin();
entityManager.remove(plante);
entityManager.getTransaction().commit();
}
}