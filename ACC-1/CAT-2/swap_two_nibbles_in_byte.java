
class Max{
    public static void main(String []args){
        int x = 0x78;
        System.out.printf("%X%n",((x & 0x0F) << 4 | (x & 0xF0) >> 4));
    }
}