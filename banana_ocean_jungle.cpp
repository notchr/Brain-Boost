#include<iostream>
using namespace std;

// A simple type alias
typedef long long ll;

// Global constants
const int MAXN = 2000;

// Function definition
int power_of_2(int num) 
{ 
    int res = 1; 
    while (num--) 
        res *= 2; 
    return res; 
} 

// Function to find the minimum number of steps 
// to reach n from 0 
int minSteps(int n) 
{ 
    // table[i] will store minimum number of steps 
    // needed to reach i from 0. 
    int table[n+1]; 
  
    // Initialize all table values as 0 
    memset(table, 0, sizeof(table)); 
  
    // Base case (If given value is 0) 
    table[0] = 0; 
  
    // Go through all positive integers and 
    // use the previously computed values to 
    // compute the next value 
    for (int i=1; i<=n; i++) 
    { 
        // Compute minimum number of steps 
        // required to reach i 
        table[i] = 1 + table[i-1]; 
        if (i%2 == 0) 
            table[i] = min(1 + table[i/2], 
                            table[i]); 
        if (i%3 == 0) 
            table[i] = min(1 + table[i/3], 
                            table[i]); 
        if (i%5 == 0) 
            table[i] = min(1 + table[i/5], 
                            table[i]); 
        if (i%7 == 0) 
            table[i] = min(1 + table[i/7], 
                            table[i]); 
        if(i>=2)
            table[i] = min(1 + table[power_of_2(i)], 
                            table[i]);
    } 
  
    // Required minimum number of steps 
    return table[n]; 
} 

// Main function 
int main() 
{ 
    int n;
    cout << "Enter a number: ";
    cin >> n;

    cout << "Minimum number of steps required to "
         << "reach " << n << " is " << minSteps(n) 
         << endl; 
    return 0; 
}