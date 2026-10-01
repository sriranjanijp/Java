
class Max{
    public static void main(String []args){
        int []arr = {1,2,3,5,3,2,1};
        int []pre_sum = new int[arr.length];
        int []suf_sum = new int[arr.length];
        pre_sum[0] = 0;
        suf_sum[arr.length-1] = arr[arr.length-1];

        for(int i = 1; i<arr.length; i++){
            pre_sum[i] = pre_sum[i-1]+arr[i-1];
        }
        for(int i = arr.length-2; i>=0; i--){
            suf_sum[i] = suf_sum[i+1]+arr[i];
        }

        int index = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<arr.length; i++){
            if(pre_sum[i] == suf_sum[i]){
                System.out.println(i);
                return;
            }
            min = Math.abs(pre_sum[i] - suf_sum[i]) < min ? Math.abs(pre_sum[i] - suf_sum[i]) : min;
        }
        System.out.println("ans is " + min);
    }
}