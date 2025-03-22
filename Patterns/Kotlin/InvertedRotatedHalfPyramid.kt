fun main(){
        var count = 4

        for (i in count downTo 1) {
            for(j in 0..count){
                if(j>=i)
                    print(j)
                else
                    print(" ")
            }
                println()
        }
}
