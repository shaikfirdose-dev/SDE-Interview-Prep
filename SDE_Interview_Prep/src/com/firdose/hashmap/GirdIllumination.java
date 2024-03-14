
Leetcode (hard): https://leetcode.com/problems/grid-illumination/
T.C:O(L+Q)
S.C:O(L)

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        HashMap<Integer, Integer> m3 = new HashMap<>();
        HashMap<Integer, Integer> m4 = new HashMap<>();
        HashMap<Integer, Integer> m5 = new HashMap<>();

        for(int l=0;l<lamps.length;l++){
            int x = lamps[l][0];
            int y = lamps[l][1];

            m1.put(x, m1.getOrDefault(x,0)+1);
            m2.put(y, m2.getOrDefault(y,0)+1);
            m3.put(x-y, m3.getOrDefault(x-y,0)+1);
            m4.put(x+y, m4.getOrDefault(x+y,0)+1);
            m5.put(x*n+y, m5.getOrDefault(x*n+y,0)+1);
        }

        int[][] dir = {{0,0},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};
        int[] ans = new int[queries.length];
        for(int q=0;q<queries.length;q++){
            int x = queries[q][0];
            int y = queries[q][1];

            if(m1.getOrDefault(x,0)>0 || m2.getOrDefault(y,0)>0 || m3.getOrDefault(x-y,0)>0 || m4.getOrDefault(x+y,0)>0 || m5.containsKey(x*n+y)==true){
                ans[q]=1;
            }

            for(int d=0;d<dir.length;d++){
                int x1 = x+dir[d][0];
                int y1 = y+dir[d][1];

                if(x1>=0 && y1>=0 && x1<n && y1<n && m5.containsKey(x1*n+y1)==true){
                    int times = m5.get(x1*n+y1);
                    m1.put(x1, m1.getOrDefault(x1,0)-times);
                    m2.put(y1, m2.getOrDefault(y1,0)-times);
                    m3.put(x1-y1, m3.getOrDefault(x1-y1,0)-times);
                    m4.put(x1+y1, m4.getOrDefault(x1+y1,0)-times);
                    m5.remove(x1*n+y1);
                }
            }
        }
        return ans;
    }
}
