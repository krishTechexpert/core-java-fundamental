package Basic.src.StringDemo;

//input: programming
//output: poraming

/*
* There are 4 approaches
*
* 1.) using java 8
* 2.) using indexOf method of String class
* 3.) using Chracter array
* 4.) using Set interface  method
* */

import javax.xml.stream.events.Characters;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateChracters {
    public static void main(String[] args) {
        String str="programming";

        // approach1
        StringBuilder sb1=new StringBuilder();
        str.chars().distinct().forEach(c -> sb1.append( (char)c));
        //System.out.println(sb1); //progamin


        // approach 2
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            int index = str.indexOf(ch,i+1);// (p,1)
            // index 1 sy start kro and check kro ki there is any p chracteres
            // if yes then return index otherwise return -1, and repeat this process

            // suppose (r,2) and try to find out r from index 2, and you will find
            // that r is already present then return index of that r chracters

            if(index ==-1) {
                sb2.append(ch);
            }
        }
        //System.out.println(sb2);//poraming

        //Approach-3
        char[] ch =str.toCharArray();
        StringBuilder sb3=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            boolean repeated=false;
            for(int j=i+1;j<ch.length;j++) {
                if (ch[i] == ch[j]) {
                    repeated = true;
                    break;
                }
            }
            if(!repeated){
                sb3.append(ch[i]);
            }
        }
        //System.out.println(sb3); //poraming



        // approach4
        StringBuilder sb4=new StringBuilder();
        Set<Character> set =  new LinkedHashSet();

        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        System.out.println(set);//[p, r, o, g, a, m, i, n]
        for(Character c: set){
            sb4.append(c);
        }
        System.out.println(sb4);//progamin
    }

}
