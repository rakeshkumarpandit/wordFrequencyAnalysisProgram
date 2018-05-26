import java.util.HashMap;

public class TrieNode {

  private HashMap<Character, TrieNode> children;

  public TrieNode() {
    this.children = new HashMap<>();
    this.content = null;
  }

  private String content;
  private boolean isWord = false;
  private long freq = 0;

  public long getFreq() {
    return freq;
  }

  public void setFreq(long freq) {
    this.freq = freq;
  }

  public void setChildren(HashMap<Character, TrieNode> children) {
    this.children = children;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setWord(boolean word) {
    isWord = word;
  }

  public HashMap<Character, TrieNode> getChildren() {

    return children;
  }

  public String getContent() {
    return content;
  }

  public boolean isWord() {
    return isWord;
  }

  public void increaseFreq() {
    synchronized (this){
      this.freq++;
    }
  }
}