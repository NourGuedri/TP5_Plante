package web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.IPlanteDao;
import dao.PlanteDaoImpl;
import metier.entities.Plante;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IPlanteDao metier;
@Override
public void init() throws ServletException {
metier = new PlanteDaoImpl();
}
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
String path=request.getServletPath();
if (path.equals("/index.do"))
{
request.getRequestDispatcher("plantes.jsp").forward(request,response);
}
else if (path.equals("/chercher.do"))
{
String motCle=request.getParameter("motCle");
PlanteModele model= new PlanteModele();
model.setMotCle(motCle);
List<Plante> plantes = metier.plantesParMC(motCle);
model.setPlantes(plantes);
request.setAttribute("model", model);
request.getRequestDispatcher("plantes.jsp").forward(request,response);
}
else if (path.equals("/saisie.do") )
{
request.getRequestDispatcher("saisiePlante.jsp").forward(request,response);
}
else if (path.equals("/save.do") && 
request.getMethod().equals("POST"))
{
 String nom=request.getParameter("nom");
String couleur = request.getParameter("couleur");
Plante p = metier.save(new Plante(nom,couleur));
request.setAttribute("plante", p);
request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
else if (path.equals("/supprimer.do"))
{
 Long id= Long.parseLong(request.getParameter("id"));
 metier.deletePlante(id);
 response.sendRedirect("chercher.do?motCle=");
}
else if (path.equals("/editer.do") )
{
Long id= Long.parseLong(request.getParameter("id"));
Plante p = metier.getPlante(id);
 request.setAttribute("plante", p);
request.getRequestDispatcher("editerPlante.jsp").forward(request,response);
}
else if (path.equals("/update.do") )
{
Long id = Long.parseLong(request.getParameter("id"));
String nom=request.getParameter("nom");
String couleur = request.getParameter("couleur");
Plante p = new Plante();
p.setIdPlante(id);
p.setNomPlante(nom);
p.setCouleur(couleur);
metier.updatePlante(p);
request.setAttribute("plante", p);
request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}


@Override
protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws 
ServletException, IOException {
doGet(request,response);
}
}