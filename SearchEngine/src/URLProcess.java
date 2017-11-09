
public class URLProcess {
	public static CompressedTrie trie = new CompressedTrie('$');

	public void addPagewithURL(String page, String url) {
		
		String[] words = page.split(" ");
		for(String word : words){
			if(word.trim().length()>0  && WordFilter(word) && !this.isStoppingWord(word)){
				WordProcessing(word.trim(), url);
			}
		}	
	}
	
	private void WordProcessing(String w, String url) {
		String word = w.toLowerCase();
		int i = 0;
		CompressedTrie t = trie;
		while(i < word.length()) {
			t.addChild(word.charAt(i));
			t = t.getChild(word.charAt(i));
			i++;
		}
		t.addUrls(url);
	}

	private boolean WordFilter(String word) {
		if( word.equals("|")|| word.equals("+")|| word.equals("-")
				|| word.equals("#")|| word.equals("$")|| word.equals("%")
				|| word.equals("^")|| word.equals("&")|| word.equals("*")
				|| word.equals("(")|| word.equals(")")|| word.equals("_")
				|| word.equals(",") || word.equals(".") || word.equals("/")
				|| word.equals("==") ||word.equals("//") || word.equals("@")
				|| word.equals("\"")|| word.equals("[")|| word.equals("]")
				|| word.equals("\\")|| word.equals("/{")|| word.equals("}")
				|| word.equals("<")|| word.equals(">")|| word.equals("?")
				|| word.equals(";")|| word.equals("'")|| word.equals(":")
				|| word.equals("=")|| word.equals("!")
				){
			
			return false;	
		}
		return true;
	}

	
	public static String[] alphabet = {
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z"
	};
	
	public static String[] pronouns = {"i","we","they","her",
			"him","them","his","their","you","he","she","it",};
	
	public static String[] articles = {"the", "a", "an"};

	
	public static String[] prepositions = {
			"concerning","considering","off","aboard","about","above","across","after",
			"near", "of","on", "onto", "over", "opposite","outside","past","per","plus","save",
			"beside","besides","between","beyond","but","by","despite", "down", "during",
			"except", "following","for", "from","like", "minus","in", "inside","into",
			"against","along","among","around","as","exclude","at","before","behind","below",
			"up", "upon", "via","versus","with", "within", "without","unlike", "until",
			"since", "than", "to","through", "toward", "towards", "under" 
			
	};
	
		
	public static String[] html = {
			"a","abbr","b","base","button","cite","code","class", "href", "p", "head","div",  
			"html", "http", "body","figure","span",  "id", "name", "target", "style", "img", "src",
			"border","li", "width", "height","menu","q","small","align"
	};
	
	
	public boolean isStoppingWord(String w) {
		String word = w.toLowerCase();
		for (String str : articles) {
			if (word.equals(str)) return true;
		}
		for (String str : pronouns) {
			if (word.equals(str)) return true;
		}
		for (String str : prepositions) {
			if (word.equals(str)) return true;
		}
		for (String str : html) {
			if (word.equals(str)) return true;
		}
		for (String str : alphabet) {
			if (word.equals(str)) return true;
		}
		return false;
	}

}
