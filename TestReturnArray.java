import java.util.Arrays;
class TestReturnArray{
  
  static int sumArray(int arr[]){
    int sum=0;
    for(int i=0;i<arr.length;i++){
      sum+=arr[i];
      arr[i]=arr[i]*10;
    }
    return sum;
  }
  public static void main(String[] args){
      int arr[]={10,20,30,40,50};
      System.out.println("Before array:"+Arrays.toString(arr));
      int total = sumArray(arr);
      System.out.println("Final total is "+total);
      System.out.println("Array after manipulation: "+Arrays.toString(arr));
  }
}