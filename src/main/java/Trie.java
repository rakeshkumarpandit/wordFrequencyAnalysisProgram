import java.util.HashMap;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  /**
   * inserts the word in trie
   * @param word input word
   */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      current = current.getChildren()
          .computeIfAbsent(word.charAt(i), c -> new TrieNode());
    }
    current.setWord(true);
    current.increaseFreq();
  }

  /**
   * returns frequency of word
   * @param word
   * @return
   */
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


  /**
   * prints all words with their frequency
   */
  public void printWordsFrequency() {
    char array[] = new char[1000000000];//array for storing words
    printWordsFrequency(root, array, 0);
  }

  private void printWordsFrequency(TrieNode root, char str[], int level) {
    if (root.isWord()) {
      System.out.println(getString(str, level) + " occurred " + root.getFreq() + " times");
    }
    HashMap<Character, TrieNode> children = root.getChildren();
    for (Character ch : children.keySet()) {
      str[level] = ch;
      printWordsFrequency(children.get(ch), str, level + 1);
    }
  }

  /**
   * return string value of the character array
   * @param array input character array
   * @param level length of character array
   * @return
   */
  private String getString(char[] array, int level) {
    if (array == null) {
      return null;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (char ch : array) {
      stringBuilder.append(ch);
      level--;
      if (level == 0) {
        break;
      }
    }
    return stringBuilder.toString();
  }

}