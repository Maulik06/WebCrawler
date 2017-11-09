import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InformationCollection 
	{
	private static final int MAX = 5;
	private List<String> pagesToVisit = new LinkedList<>();
	private Set<String> visitedPage = new HashSet<String>();
	
	
	public void search(String url,String user_agent) 
		{
		while(this.visitedPage.size()< MAX)
			{
			String currentUrl;
			ResponseHandle Response = new ResponseHandle();
			
			if(this.pagesToVisit.isEmpty())
				{
				currentUrl = url;
				this.visitedPage.add(url);
				}
			else{
				currentUrl = this.nextUrl();
				}
			
			Response.crawl(currentUrl,user_agent); 
			
			this.pagesToVisit.addAll(Response.getLinks());
			}	
		}

	private String nextUrl()
		{
		String nextURL;
		do
			{
				nextURL = this.pagesToVisit.remove(0);
			}while(this.visitedPage.contains(nextURL));
		
		this.visitedPage.add(nextURL);
		
		return nextURL;		
		}

}
