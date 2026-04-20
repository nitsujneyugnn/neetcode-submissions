class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result+= str + "À";
        } 
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            String curr = str.substring(i, i + 1);
            if (!curr.equals("À")) {
                s += curr;
            } else {
                result.add(s);
                s = "";
            }
        }
        return result;
    }

    
}
