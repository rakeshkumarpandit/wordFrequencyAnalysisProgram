import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFreqCalculator {

  private Trie trie;

  public WordFreqCalculator() {
    trie = new Trie();
  }

  public static void main(String[] args) throws FileNotFoundException {
    WordFreqCalculator wordFreqCalculator = new WordFreqCalculator();
    wordFreqCalculator.loadFile(args[0]);
    Scanner in = new Scanner(System.in);
    String input = null;
    do {
      System.out.println("Enter a word to search it's frequency");
      input = in.nextLine();
      System.out
          .println("Frequency of word " + input + " is :" + wordFreqCalculator.getWordFreq(input));
    } while (!input.equals("/"));
  }

  public void loadFile(String path) throws FileNotFoundException {
    try (Scanner in = new Scanner(new File(path), "UTF-8")) {
      System.out.println("please Wait, Loading File:" + path);
      while (in.hasNext()) {
        String word = in.nextLine();
        if (word == null || word.isEmpty()) {
          continue;
        }
        trie.insert(word);
      }
    }
    System.out.println("File loaded successfully");
  }

  public long getWordFreq(String word) {
    return trie.find(word);
  }
}
