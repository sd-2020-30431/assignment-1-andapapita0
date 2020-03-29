package business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int calorie_value = Integer.parseInt(request.getParameter("calorie_value"));
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date purchase_date = null, expiration_date = null, consumption_date = null;
        try {
			purchase_date = sdformat.parse(request.getParameter("purchase_date"));
			expiration_date = sdformat.parse(request.getParameter("expiration_date"));
			consumption_date = sdformat.parse(request.getParameter("consumption_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        FoodItem food = new FoodItem(name, quantity, calorie_value, purchase_date, expiration_date, consumption_date);
        FoodItemDao dao = new FoodItemDao();
        dao.addFoodItem(food);
        request.setAttribute("add", "Added successfully!");
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
