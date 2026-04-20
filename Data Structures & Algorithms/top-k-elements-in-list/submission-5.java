class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // track unique num + appearances
       HashMap<Integer, Integer> map  = new HashMap<>();
       int[] kInts = new int[k];

       for(int i = 0; i < nums.length; i++){
          map.putIfAbsent(nums[i], 0);
          map.put(nums[i], map.get(nums[i]) + 1);
       } 
       Set<Integer> keys = map.keySet();
       List<Integer> valuesList = new ArrayList<>(map.values());
        int[] vals =  new int[map.size()];
        for(int i = 0; i < map.size(); i++){
            vals[i] =  valuesList.get(i);
        }
        Arrays.sort(vals);
        int max = 0;
        while(max < k){
            for(Integer key : keys) {
            int m = vals[vals.length - 1 - max];
            if(map.get(key) == m){
                kInts[max] = key;
                map.remove(key);
                max++;
                break;
            }
            }
        }

        return kInts;
        }
       

    }