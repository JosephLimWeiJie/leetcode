class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // Ignore a-z & A-Z & '+' to mean one or more occurrence of that element
        String[] arrOfWords = paragraph.split("[^a-zA-Z]+"); 
        HashMap<String, Integer> hashMap = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        
        int count = 0;
        String ans = "";
        
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        for (String word : arrOfWords) {
            // Remove unwanted characters
            word =  word.toLowerCase().replaceAll("[!?',;.]+", "");
            
            if (!bannedSet.contains(word)) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
                
                if (hashMap.get(word) > count) {
                    count = hashMap.get(word);
                    ans = word;
                }
            }
        }        
        return ans;
    }
}
