import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompressedTrie {
	public List<CompressedTrie> children;
	public char val;
	public Set<String> urls;
	public CompressedTrie(char v) {
		children = null;
		urls = null;
		this.val = v;
	}
	public void addUrls(String url) {
		if (urls == null) urls = new HashSet<>();
		if (!urls.contains(url)) urls.add(url);
	}
	
	public Set<String> getUrls() {
		return urls;
	}

	public void addChild(CompressedTrie trie) {
		if (children == null) {
			children = new ArrayList<>();
		}
		if (!hasChild(trie)) {
			children.add(trie);
		}
	}
	
	public void addChild(char c) {
		if (children == null) {
			children = new ArrayList<>();
		}
		if (!hasChild(c)) {
			children.add(new CompressedTrie(c));
		}
	}
	
	public boolean hasChildren() {
		return children != null;
	}
	
	public boolean hasChild(CompressedTrie trie) {
		if (children == null) return false;
		return children.contains(trie);
	}
	
	public boolean hasChild(char c) {
		if (children == null) return false;
		for (CompressedTrie trie : children) {
			if (trie.val == c) {
				return true;
			}
		}
		return false;
	}
	
	public CompressedTrie getChild(char c) {
		if (children == null) return null;
		for (CompressedTrie trie : children) {
			if (trie.val == c) {
				return trie;
			}
		}
		return null;
	}
}
