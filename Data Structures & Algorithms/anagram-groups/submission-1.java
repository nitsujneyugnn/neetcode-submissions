class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Bruteforce solution, use map, key = sorted word, value = list of strings that are anagrams
        // For each string, sort it, check if in map, update
        // Put map values into a List and return it
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
