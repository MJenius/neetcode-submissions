class Solution {
        public int carFleet(int target, int[] pos, int[] speed) {
         int res = 0;
       double[] timeArr = new double[target];
       for (int i = 0; i < pos.length; i++)
        {
            timeArr[pos[i]]= (double)(target - pos[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;
    }
}