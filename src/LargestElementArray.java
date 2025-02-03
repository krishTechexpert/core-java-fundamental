class LargestElementArray{
  
  static int findLargestElement(int arr[]){
    int largest=arr[0];
    for(int num:arr){
      if(num>largest){
        largest=num;
      }
    }
    return largest;
  }

  public static void main(String[] args){
    int arr[]={5,8,6,13,15,100};
    int result = findLargestElement(arr);
    System.out.println(result);
  }
}