public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, List<String>> neighbors = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                neighbors.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return ans;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neighborWord : neighbors.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visited.contains(neighborWord)) {
                            visited.add(neighborWord);
                            q.offer(neighborWord);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}