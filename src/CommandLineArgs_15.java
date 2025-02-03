class CommandLineArgs_15{

  // example-1
  // public static void main(String... krishna){
  //   int sum=0;
  //   for(int i=0;i<krishna.length;i++){
  //       int n = Integer.parseInt(krishna[i]);//convert string into integer 6,10,30
  //     sum+=n;
  //   }
  //   System.out.println(sum); //46
  // }
//example-2
//internally jym create like that String[] arr = {'6','10','30'}
// which will be passed into main Method as command line args
// inside String[] args so args contains array of string such as arr

  public static void main(String[] args){
    int sum=0;
    for(int i=0;i<args.length;i++){
        int n = Integer.parseInt(args[i]);//convert string into integer 6,10,30
      sum+=n;
    }
    System.out.println(sum); //46
  }


  // public static void main(String[] args){
  //   int sum=0;
  //   String[] arr = {"10","20","30"};
    
  //   for(int i=0;i<arr.length;i++){
  //       int n = Integer.parseInt(arr[i]);//convert string into integer 10,20,30
  //     sum+=n;
  //   }
  //   System.out.println(sum); //60
  // }
}