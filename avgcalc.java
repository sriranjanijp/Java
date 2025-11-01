import java.io.*;

public class avgcalc {
    public static void main(String []args)
    {
        String inputFile = "yourmom.txt";
        String outputFile = "mythatha.txt";
        

        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String in = br.readLine();
            String[] num = in.split(" ");

            try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(inputFile)))
            {
                for(int i = 0; i<3; i++){
                    dos.writeInt(Integer.parseInt(num[i]));
                }
            }

            int []arr = new int[3];
            try(DataInputStream dis = new DataInputStream(new FileInputStream(inputFile)))
            {
                for(int i = 0; i<3; i++)
                {
                    arr[i] = dis.readInt();
                }
            }

            int avg = 0;
            for(int i = 0; i<3; i++){
                avg += arr[i];
            }

            System.out.println(avg);
        }
        catch (IOException | NumberFormatException e) {
        {
            e.printStackTrace();
        }
    }
}
}
