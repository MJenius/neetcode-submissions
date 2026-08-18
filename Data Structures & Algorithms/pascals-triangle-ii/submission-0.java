class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        if (rowIndex==0) return curr;
        List<Integer> prev = getRow(rowIndex-1);
        for (int i=1;i<rowIndex;i++) curr.add(prev.get(i-1)+prev.get(i));
        curr.add(1);
        return curr;
    }
}