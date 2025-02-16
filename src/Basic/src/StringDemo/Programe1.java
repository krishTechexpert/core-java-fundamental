package Basic.src.StringDemo;

/*WAP to string compression asked in amazon
 aaaabbbcc -> a3b2c2 // string compression
abc -> a1b1c1 string decompression
*
* */
public class Programe1 {
    public static StringBuilder compress(String str){
        int len = str.length();
        //abc->3
        //String newStr=""; it will get new memory on each append in String contstant pool
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<len;i++){ // O(n) , not O(n2) b'coz loop only runs for string lemgth
            // loop chelga for i=0,i=3,i=5,i=8;
            System.out.println("i="+i);
            Integer count=1;
            //2<2
            //aaabbcccdd 0<9
            while( i<len-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++; //same i used in for i=2 condition fail, the i will increment in for loop like i=3
            }
            newStr.append(str.charAt(i));
            if(count>1){
                newStr.append(count.toString());
            }
        }

        return newStr;
    }
    public static void main(String[] args) {
        String s = "aaabbcccdd";
        System.out.println(compress(s));
    }
}
