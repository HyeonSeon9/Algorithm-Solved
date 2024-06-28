import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] dataCol={"code","date","maximum","remain"};
        
        int extNum=0;
        int sortNum=0;
        
        for(int i=0;i<dataCol.length;i++){
            if(dataCol[i].equals(ext)){
                extNum=i;
            }
            if(dataCol[i].equals(sort_by)){
                sortNum=i;
            }
        }
        
        final int en=extNum;
        final int sn = sortNum;
        
        int[][] result = Arrays.stream(data).filter(x -> x[en]<val_ext).toArray(int[][]::new);
        
        Arrays.sort(result,(o1,o2) -> o1[sn]-o2[sn]);
        
        return result;
    }
}