package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Result() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("string");
		request.setAttribute("string", string);
		try {
		if(string == null || string == "") {
			request.getRequestDispatcher("/WEB-INF/jsp/request.jsp").forward(request, response);
		}
		try {
			Language result = Json05.getLanguage(string);
			String message = result.documents[0].detectedLanguage.name;
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} catch(Exception e) {
		request.getRequestDispatcher("/WEB-INF/jsp/request.jsp");
	}
}

}
