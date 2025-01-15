class BasicArray{
  
  public static void main(String[] args){
    // first way
    int num[] = new int[5];
  num[0]=10;
  num[1]=20;
  num[2]=30;
  num[3]=40;
  num[4]=50;
  for(int i=0;i<num.length;i++){
    System.out.println(num[i]);
  }

  //second way
  int arr[]={100,200,300,400,500};//declaration, instantiation and initialization
  for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
  }

  //third way with for each loop
  int val[] = new int[]{1,2,3,4,5};
  //for each loop
  for(int i:val){
    if(i==800) return;
    System.out.println(i);
  }


  }
}