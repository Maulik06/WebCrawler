import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebCrawler
 */
@WebServlet("/WebCrawler")
public class WebCrawler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebCrawler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Add new URL";
	      String url = request.getParameter("new_url");
			
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
				
	      out.println(docType + "<html>\n" +
	         "<head><title>" + title + "</title><link rel=\"stylesheet\" href=\"style.css\"></head>\n" +
	         "<body><h2 align=\"center\" display=\" block\">" + "URL Added: " +url+ "</h2>\n" +
	         "<h2><a href=\"index2.html\" align=\"center\" >Add more URL</a></h2><br><br>\n"+
	         "<h2><a href=\"index.html\" align=\"center\">Go to Search</a></h2>\n"+
	         "</body></html>");
	      
	      InformationCollection Info = new InformationCollection();
			Info.search(url,request.getHeader("User-Agent"));	
	      
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
