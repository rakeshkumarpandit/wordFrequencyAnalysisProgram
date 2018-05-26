import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFreqCalculator {

  private Trie trie;

  public WordFreqCalculator() {
    trie = new Trie();
  }

  /**
   * Main function to start the execution
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    WordFreqCalculator wordFreqCalculator = new WordFreqCalculator();
    //pass the file name as argument to the main
    wordFreqCalculator.loadFile(args[0]);
    wordFreqCalculator.printWordsFrequency();
  }

  /**
   * Loads words of file into trie with frequency of each word
   * @param path path of file to be processed
   * @throws FileNotFoundException
   */
  public void loadFile(String path) throws FileNotFoundException {
    if (path == null || path.isEmpty()) {
      throw new IllegalArgumentException("Invalid file path: " + path);
    }
    try (Scanner in = new Scanner(new File(path), "UTF-8")) {
      System.out.println("please Wait, Loading File: " + path);
      while (in.hasNext()) {
        String word = in.nextLine();
        if (word == null || word.isEmpty()) {
          continue;
        }
        trie.insert(word);
      }
    }
    System.out.println("File loaded successfully\n");
  }

  /**
   * return the frequency of input word
   * @param word
   * @return
   */
  public long getWordFreq(String word) {
    return trie.find(word);
  }

  /**
   * prints all words with the frequency of occurance
   */
  public void printWordsFrequency() {
    trie.printWordsFrequency();
  }
}
