class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Boolean> seen = new HashMap<>();
        for(int r = 0; r < heights.length; r++){
            for(int c = 0; c < heights[0].length; c++){
                if(seen.getOrDefault(r * heights[0].length + c, false)){
                    res.add(new LinkedList<>(List.of(r, c)));
                } else {
                    Set<Integer> visited = new HashSet<>();
                    boolean[] oceans = new boolean[2];
                    dfs(oceans, heights, r, c, seen, visited);
                    if(oceans[0] && oceans[1]){
                        seen.put(r * heights[0].length + c, true);
                        res.add(new LinkedList<>(List.of(r, c)));
                    }
                }
            }
        }
        return res;
    }

    private void dfs(boolean[] oceans, int[][] heights, int r, int c, Map<Integer, Boolean> seen, Set<Integer> visited){
        int i = r * heights[0].length + c;

        if(visited.contains(i)) return;
        visited.add(i);

        if(seen.getOrDefault(r * heights[0].length + c, false)){
            oceans[0] = true;
            oceans[1] = true;
            return;
        } 

        if(r == 0 || c == 0) oceans[0] = true;
        if(r == heights.length - 1 || c == heights[0].length - 1) oceans[1] = true;

        if(r > 0 && heights[r - 1][c] <= heights[r][c]) dfs(oceans, heights, r - 1, c, seen, visited);
        if(r < heights.length - 1 && heights[r + 1][c] <= heights[r][c]) dfs(oceans, heights, r + 1, c, seen, visited);
        
        if(c > 0 && heights[r][c - 1] <= heights[r][c]) dfs(oceans, heights, r, c - 1, seen, visited);
        if(c < heights[0].length - 1 && heights[r][c + 1] <= heights[r][c]) dfs(oceans, heights, r, c + 1, seen, visited);
        
        return;
    }
}
