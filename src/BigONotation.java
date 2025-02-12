public class BigONotation {
    private int[] theArray;
    private int arraySize;
    private int itemsInArray=0;
    static long startTime;
    static long endTime;

    BigONotation(int size){
        arraySize=size;
        theArray = new int[size];
    }
    //O(1)
    public void addItemToArray(int newItem){
        startTime = System.currentTimeMillis();//return time in miliseconds
        theArray[itemsInArray++] = newItem;// if we consider theArray size is 1000 then we store new item at position 1000 b'coz 999 elements is already fulled
        endTime=System.currentTimeMillis();
        System.out.println("Insert single item  Took Time: "+ (endTime - startTime));//Insert single item  Took Time: 0

    }

    //O(N)--Linear Search
    public void linearSearchForValue(int value){
        boolean valueInArray=false;
        String indexsWithValue="";
        startTime = System.currentTimeMillis();//return time in miliseconds

        for(int i=0;i<arraySize;i++){
            if(theArray[i] == value) {
                valueInArray=true;
                indexsWithValue += i + " ";
            }
        }
        System.out.println("Value Found: "+ valueInArray+ " at index "+indexsWithValue);
        endTime=System.currentTimeMillis();
        System.out.println("Linear Search Took Time: "+ (endTime - startTime));
    }

    public void generateRandomArray(){
        for(int i=0;i<arraySize;i++){
            theArray[i] = (int)(Math.random() * 1000) +10;
        }
        itemsInArray = theArray.length-1;//999

        for(int a: theArray) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        BigONotation testAlgo2 =  new BigONotation(1000);
        testAlgo2.generateRandomArray();
        testAlgo2.addItemToArray(2);//new element added in the last
        testAlgo2.linearSearchForValue(2);//27 ms and value find at index 999

        BigONotation testAlgo3 =  new BigONotation(100000);
        testAlgo3.generateRandomArray();
        testAlgo3.addItemToArray(2);//new element added in the last
        testAlgo3.linearSearchForValue(2);//5 sec and value find at index 99999

        //time can be increase and decrease depends on your system configuration
    }


}
