import java.nio.file.*;
import java.util.*;

public class Translator {

  private final Map<String, String> dictionary = new HashMap<>();

  public void loadDictionary(String path) throws InvalidFileFormatException, FileReadException {
    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(path));
    } catch (Exception e) {
      throw new FileReadException("Cannot read file: " + path, e);
    }

    for (String line : lines) {
      if (!line.contains("|")) {
        throw new InvalidFileFormatException("Missing '|' in line: " + line);
      }
      String[] parts = line.split("\\|", 2);
      if (parts.length < 2) {
        throw new InvalidFileFormatException("Invalid format: " + line);
      }
      String key = parts[0].trim().toLowerCase();
      String value = parts[1].trim();
      dictionary.put(key, value);
    }
  }

  public String translate(String input) {
    List<String> keys = new ArrayList<>(dictionary.keySet());
    keys.sort((a, b) -> Integer.compare(b.length(), a.length()));

    StringBuilder result = new StringBuilder(input);
    String originalLower = input.toLowerCase();

    for (String key : keys) {
      int index;
      while ((index = originalLower.indexOf(key)) != -1) {
        String replacement = dictionary.get(key);
        result.replace(index, index + key.length(), replacement);
        originalLower = result.toString().toLowerCase();
      }
    }

    return result.toString();
  }
}
