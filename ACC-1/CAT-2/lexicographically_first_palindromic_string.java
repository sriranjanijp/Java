class Main{
    public static void main(String []args){
        String s = "aabcc";
        int l = s.length();
        char []arr = new char[l]; 
        for(int i = 0; i<l; i++){
            arr[i] = s.charAt(i);
        }
    }
}