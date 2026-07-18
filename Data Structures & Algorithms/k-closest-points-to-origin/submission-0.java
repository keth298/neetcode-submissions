class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> kClosest = new PriorityQueue<>( (a, b) -> Double.compare(b.getKey(), a.getKey()));

        for(int[] point: points){
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if(kClosest.size() == k){
                kClosest.add(new Pair<>(distance, point));
                kClosest.remove();
            } else {
                kClosest.add(new Pair<>(distance, point));
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        for(Pair<Double, int[]> pair: kClosest){
            res[i] = pair.getValue();
            i++;
        }
        return res;
    }
}
