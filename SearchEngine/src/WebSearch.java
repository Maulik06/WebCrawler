import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Set;
/**
 * Servlet implementation class WebSearch
 */
@WebServlet("/WebSearch")
public class WebSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Search Engine";
			
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
				
	      out.println(docType + "<html>\n" +
	         "<head><title>" + title + "</title><link rel=\"stylesheet\" href=\"style.css\"></head>\n" +
	         "<body><a href=\"index.html\">Search Again</a><br><h1 align=\"center\">" + 
	         "Search Result for: " +request.getParameter("search_term")+ "</h1>\n");
	      
	      String search_string = "";
				
				search_string = request.getParameter("search_term");
				Set<String> urls = ResponseHandle.search(search_string);
				Iterator<String> iterator = urls.iterator();
				if(!iterator.hasNext()) {
					out.println("<br><br><h1>No Results found</h1>");
				}
				while (iterator.hasNext()) {
					String nextURL = iterator.next();
					out.println("<h4><a href=\""+nextURL +"\">"+nextURL+"</a></h4>");
					
				}
			
	         out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
