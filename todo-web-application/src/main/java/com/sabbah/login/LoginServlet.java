package com.sabbah.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginService service = new LoginService();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/veiws/Login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean userValid = service.userValid(name, password);
		if(userValid) {
		
			/*
			 request.setAttribute("name", name);
		request.setAttribute("todos", todoservice.retrieveTodo());
		request.getRequestDispatcher("/WEB-INF/veiws/Welcome.jsp").forward(request, response);
		 */
			
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/ListTodo.do");
		}else {
			request.setAttribute("errorMassege", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/veiws/Login.jsp").forward(request, response);
		}
		
	}

}
