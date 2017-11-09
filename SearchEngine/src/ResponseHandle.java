import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResponseHandle 
	{
	private List<String> links = new LinkedList<String>();

		public void crawl(String url,String user_agent)
		{	
		try {
			Connection connection = Jsoup.connect(url).userAgent(user_agent);
			Document HTMLDocument = connection.get();
			
			String page = HTMLDocument.text(); 
			
			URLProcess p = new URLProcess();
			p.addPagewithURL(page, url);
			
			Elements linkOnPage = HTMLDocument.select("a[href]");
				
			for(Element link : linkOnPage)
			{
				this.links.add(link.absUrl("href"));
			}
			
		} catch (IOException ioe) {
			
			System.out.println("HTTP request not successful " + ioe);
		}
	}
	
	public static Set<String> search(String line) {
		String[] words = line.split(" ");
		return searchWords(words);
	}
	
	public static Set<String> searchWords(String[] words) {
		Set<String>result = new HashSet<>();
		for (String word : words) {
			Set<String> wordResult = searchWord(word);
			if (wordResult != null) result.addAll(wordResult);
		}
		return result;
	}
	
	public static Set<String> searchWord(String searchWord){
		
		char[] words = searchWord.toCharArray();
		CompressedTrie root = URLProcess.trie;
		for (int i = 0; i < words.length; i++) {
			root = root.getChild(words[i]);
			if (root == null) return null;
		}
		return root.urls;
		
	}
	
	public List<String> getLinks(){
		return this.links;
	}

}
