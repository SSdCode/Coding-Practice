#include<iostream>

using namespace std;
int main(){

    int arr[5];
    cout<<"Enter five numbers:";

    for (int i = 0; i < sizeof(arr)/sizeof(arr[0]); i++){
        cin>>arr[i];
    }

    cout<<"Reversed array: ";

    for (int i = (sizeof(arr)/sizeof(arr[0]))-1; i >=0 ; i--){
        cout<<arr[i]<<" ";
    }
    cout<<"\n\n";


    return 0;
}