package Basic.src.SortingDemo;
/*

 * [1,2,3,4,5] -> increase order
 * [5,4,3,2,1] -> decrease order

 Bubble sort
* Large elements comes to the end of array by swapping with adjacent elements
* example n=5
* 7,8,3,1,2
*  i=0
*       j=0, a[0]>a[j+1] 7>8 no [7,8,3,1,2]
        j=1, a[j]>a[j+1] 8>3 yes then swap [7,3,8,1,2]
        j=2 a[2]>a[2+1] 8>1 yes then swap [7,3,1,8,2]
        j=3 a[3]>a[3+1] 8>2 yes then swap [7,3,1,2,8]
        j=4 4<4 fail then i makes i=1;

    i=1, arr [7,3,1,2,8] j<len=4-1=3,
        j=0, a[0]>a[1] 7>3 yes then swap [3,7,1,2,8]
        j=1, a[1]>a[2] 7>1 yes then swap [3,1,7,2,8]
        j=2, a[2]>a[3] 7>2 yes then swap [3,1,2,7,8] we can stop  here
        j=3, 3<4 yes a[3]>a[4] 7>8 swap[3,1,2,7,8] no need to compare this statement b'coz we already know max last element in end
*
    i=2, arr[3,1,2,7,8] j<len=4-2=2
        j=0, a[0]>a[1] 3>1 yes then swap [1,3,2,7,8]
        j=1; a[1]>a[2] 3>2 yes then swap [1,2,3,7,8]
        2>2 no fail
    i=3, arr[1,2,3,7,8] j<4-3=1
    j=0, a[0]>a[1] 1>2 no
    1<1 stop fail
    finally our array is sorted [1,2,3,7,8]
* */
public class BubbleSortDemo {
    public static void bubbleSort(int arr[]){
        int len=arr.length-1;//5-1=4
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" "); // 1 2 3 7 8
        }
    }
    public static void main(String[] args) {
        int arr[] ={7,8,3,1,2};
        bubbleSort(arr);
    }

}
