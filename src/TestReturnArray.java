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
      System.out.println("Before array:"+Arrays.toString(arr));//Before array:[10, 20, 30, 40, 50]
      int total = sumArray(arr);//call by reference
      System.out.println("Final total is "+total); // 150
      System.out.println("Array after manipulation: "+Arrays.toString(arr)); //Array after manipulation: [100, 200, 300, 400, 500]

  }
}