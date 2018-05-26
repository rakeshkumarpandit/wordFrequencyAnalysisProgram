public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      current = current.getChildren()
          .computeIfAbsent(word.charAt(i), c -> new TrieNode());
    }
    current.setWord(true);
    current.increaseFreq();
  }

  public long find(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      if (node == null) {
        return 0;
      }
      current = node;
    }
    return current.isWord() ? current.getFreq() : 0;
  }

}