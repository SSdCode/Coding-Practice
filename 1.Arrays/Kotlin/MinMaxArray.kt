fun main(){
    var arr = arrayOf(50,40,1,35,90)
    var max = arr[0]
    var min = arr[0]
    for (i in 0..arr.size-1) {
        if (arr[i] > max){
            max = arr[i];
        }
        if (arr[i] < min){
            min = arr[i];
        }    
    }
    print("\n Max = "+max+" \n Min = "+min)
}