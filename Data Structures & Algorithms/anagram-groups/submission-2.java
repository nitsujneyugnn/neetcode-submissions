class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(s);
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
