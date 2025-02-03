class PassingArray{

  static void printArray(int arr[]){
    for(int i: arr){
      System.out.println(i);
    }
  }

  public static void main(String[] args){
    int num[]={2,5,7,8,1}; // declare and initialize an array
    printArray(num);
    printArray(new int[]{20,50,7,80,100}); // passing anonymous array to method
  }
}