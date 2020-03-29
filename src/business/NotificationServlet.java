package business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		List<FoodItem> groceries = dao.getAlldata();
		String all = "";
		for(FoodItem grocery: groceries) {
			boolean b = grocery.waste();
			if(b) all += "WASTE ALERT! There is waste for " + grocery.getName() + "!<br>";
			boolean c = grocery.twoDaysBeforeExpiration();
			if(c) all += "There are 2 days left until " + grocery.getName() + " expires, better eat it or give it away!<br>";
		}
		System.out.println(all);
		HttpSession session = request.getSession(true); 
		if(session!=null) {
			request.setAttribute("err", all);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
	}

}
