class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        Map<Integer, List<String>> byLength = new HashMap<>();
        for (String str : strs) {
            if (!byLength.containsKey(str.length())) {
                byLength.put(str.length(), new ArrayList<String>());
            }
            byLength.get(str.length()).add(str);
        }

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int key : byLength.keySet()) {
            List<String> curr = byLength.get(key);
            for (String str : curr) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String s = new String(chars);
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(str);
            }
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
