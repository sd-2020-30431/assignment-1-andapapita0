package business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class GroceryListServlet
 */
@WebServlet("/GroceryListServlet")
public class GroceryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroceryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		List<FoodItem> groceries = dao.getAlldata();
		for(FoodItem grocery: groceries) {
			String s = grocery.toString();
			System.out.println(s);
			request.setAttribute("history", s);
			//request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
	}

	

}
