import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = {9,3,9,8,3,2};
        int narr[] = Arrays.copyOfRange(arr,1,3);

        for(int i =0;i<narr.length;i++)
        {
            System.out.print(narr[i]);
        }
        Arrays.sort(arr);
        System.out.println();
        for(int i =0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
        for(int i =0, j = 0;i<10 && j<5;i++,j++)
        {
            System.out.println(i + " " + j );
        }
        char c = 'a';
        System.out.println((char)65);
    }
}