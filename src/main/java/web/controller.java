package web;

import com.model.Client;
import com.model.Produit;
import dao.ClientDaoImpl;
import dao.IClientDao;
import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//import net.javaguides.todoapp.dao.TodoDao;
//import net.javaguides.todoapp.dao.TodoDaoImpl;
//import net.javaguides.todoapp.model.Todo;





/**
 * Servlet implementation class controller
 */
@WebServlet(name="cs",urlPatterns= {"*.php"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProduitDao metier;
    private IClientDao metierC;
    
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
			metier = new ProduitDaoImpl();
            metierC = new ClientDaoImpl();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String path=request.getServletPath();
			if(path.equals("/index.php")) {
				request.getRequestDispatcher("produits.jsp").forward(request, response);
			}
			else if(path.equals("/chercher.php")) {
				String motCle=request.getParameter("motCle");
				ProduitModel model=new ProduitModel();
				model.setMotCle(motCle);
				List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
				model.setProduits(produits);
				request.setAttribute("model", model);
				request.getRequestDispatcher("produits.jsp").forward(request, response);
			}
			else if(path.equals("/Saisie.php")) {
				request.setAttribute("produit", new Produit());
				request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
			}
			else if(path.equals("/SaveProduit.php")&&(request.getMethod().equals("POST"))) {
				String des=request.getParameter("designation");
				double prix=Double.parseDouble(request.getParameter("prix"));
				int quantite=Integer.parseInt(request.getParameter("quantite"));
				Produit p=metier.save(new Produit(des, prix, quantite));
				request.setAttribute("produit", p);
				request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
						
				
			}
			else if(path.equals("/Supprimer.php")) {
			    Long id=Long.parseLong(request.getParameter("id"));
			    metier.deleteProduit(id);
			   // request.getRequestDispatcher("produits.jsp").forward(request, response);
			    response.sendRedirect("chercher.php?motCle=");
			}
			else if(path.equals("/Edit.php")) {
			    Long id=Long.parseLong(request.getParameter("id"));
			    Produit p=metier.getProduit(id);
			    request.setAttribute("produit", p);
			    request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
			   
			}
			else if(path.equals("/UpdateProduit.php")&&(request.getMethod().equals("POST"))) {
				Long id=Long.parseLong(request.getParameter("id"));
				String des=request.getParameter("designation");
				double prix=Double.parseDouble(request.getParameter("prix"));
				int quantite=Integer.parseInt(request.getParameter("quantite"));
				Produit p=new Produit(des, prix, quantite);
				p.setId(id);
				metier.update(p);
				request.setAttribute("produit", p);
				request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
										
				
			}else if(path.equals("/SaisieClient.php")) {
                request.setAttribute("client", new Client());
                request.getRequestDispatcher("SaisieClient.jsp").forward(request, response);
            }
            else if(path.equals("/SaveClient.php")&&(request.getMethod().equals("POST"))) {
                String nom=request.getParameter("nom");
                String email=request.getParameter("email");
                String adresse=request.getParameter("adresse");

                Client p=metierC.save(new Client(nom, email, adresse));
                request.setAttribute("client", p);
                request.getRequestDispatcher("ConfirmationClient.jsp").forward(request, response);


            }
            else if(path.equals("/HomeClient.php")) {
                request.getRequestDispatcher("clients.jsp").forward(request, response);
            }
            else if(path.equals("/chercher.php")) {
                String motCle=request.getParameter("motCle");
                ClientModel model=new ClientModel();
                model.setMotCle(motCle);
                List<Client> clients=metierC.clientsParMC("%"+motCle+"%");
                model.setClients(clients);
                request.setAttribute("model", model);
                request.getRequestDispatcher("clients.jsp").forward(request, response);
            }
            else if(path.equals("/SupprimerC.php")) {
                Long id=Long.parseLong(request.getParameter("id"));
                metierC.deleteClient(id);
                response.sendRedirect("chercher.php?motCle=");
            }
            else if(path.equals("/UpdateClient.php")&&(request.getMethod().equals("POST"))) {
                Long id=Long.parseLong(request.getParameter("id"));
                String nom=request.getParameter("nom");
                String email=request.getParameter("email");
                String adresse=request.getParameter("adresse");
                Client c=new Client(nom, email, adresse);
                c.setId(id);
                metierC.update(c);
                request.setAttribute("client", c);
                request.getRequestDispatcher("ConfirmationClient.jsp").forward(request, response);

            }
            else if(path.equals("/EditC.php")) {
                Long id=Long.parseLong(request.getParameter("id"));
                Client c=metierC.getClient(id);
                request.setAttribute("client", c);
                request.getRequestDispatcher("EditClient.jsp").forward(request, response);

            }






























			else {
				response.sendError(response.SC_NOT_FOUND);
			}
			

		}


}
