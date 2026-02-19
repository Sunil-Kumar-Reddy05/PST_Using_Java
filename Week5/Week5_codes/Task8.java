import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> mapWP = new HashMap<>();
        Map<Character, Character> mapPW = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i), p = pattern.charAt(i);
            if (!mapWP.containsKey(w)) {
                mapWP.put(w, p);
            }
            if (!mapPW.containsKey(p)) {
                mapPW.put(p, w);
            }
            if (mapWP.get(w) != p || mapPW.get(p) != w) {
                return false;
            }
        }
        return true;
    }
}
