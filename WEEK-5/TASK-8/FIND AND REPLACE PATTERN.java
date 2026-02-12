class Solution {
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
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char c1 = pattern.charAt(i);
            char c2 = word.charAt(i);
            
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2)
                    return false;
            } else {
                if (map2.containsKey(c2))
                    return false;
                
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }
        
        return true;
    }
}
