class CountSquares {
    private Map<Integer,Map<Integer,Integer>> pointsCount;
    public CountSquares() {
        pointsCount=new HashMap<>();
    }
    
    public void add(int[] point) {
        int x=point[0],y=point[1];
        pointsCount.putIfAbsent(x,new HashMap<>());
        pointsCount.get(x).put(y,pointsCount.get(x).getOrDefault(y,0)+1);
    }
    
    public int count(int[] point) {
        int x1=point[0];
        int y1=point[1];
        int ans=0;
        if (!pointsCount.containsKey(x1)) return 0;
        for (Map.Entry<Integer,Integer> entry: pointsCount.get(x1).entrySet()) {
            int y2=entry.getKey();
            int countY2=entry.getValue();
            if (y2==y1) continue;
            int side=Math.abs(y2-y1);
            ans+=countSquares(x1,y1,y2,x1+side,y1,countY2);
            ans+=countSquares(x1,y1,y2,x1-side,y1,countY2);
        }
        return ans;
    }
    private int countSquares(int x1,int y1,int y2,int x3,int y3,int countY2) {
        if (pointsCount.containsKey(x3)) {
            Map<Integer,Integer> x3points=pointsCount.get(x3);
            return x3points.getOrDefault(y1,0)*x3points.getOrDefault(y2,0)*countY2;
        }
        return 0;
    }
}
