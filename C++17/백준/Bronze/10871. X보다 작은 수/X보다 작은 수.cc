//
//  main.cpp
//  imbest
//
//  Created by Seung jun Yoo on 11/18/24.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int size, x;
    cin >> size >> x;
    vector<int> vec(size);

    
    for(int i = 0 ; i < size ; i++){
        cin >> vec[i];
    }
    
    for(int j = 0 ; j < size ; j++){
        if(vec[j] < x){
            cout << vec[j] << " ";
        }
    }
    cout << "\n";

    
    return 0;
}
