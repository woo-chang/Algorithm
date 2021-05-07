#include <iostream>

using namespace std;

int result[500];
int arr[500];

int findIndex(int start)
{
    int ret = 0;
    int max = 0;
    for(int i=start-1; i>=0; i--) {
        if (arr[i] < arr[start]) {
            if (result[i] > max) {
                max = result[i];
                ret = i;
            }
        }
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(false);

    int T;
    cin >> T;
    while(T--) {
        int N;
        int minNum=100001, max=0;
        cin >> N;
        for(int i=0; i<N; i++) {
            cin >> arr[i];
            if (arr[i] <= minNum) {
                minNum = arr[i];
                result[i] = 1;
            }
            else {
                int sub = findIndex(i);
                result[i] = result[sub] + 1;
            }
            
            if (result[i] > max) max = result[i];
        }
        cout << max << endl;
    }

    return 0;
}