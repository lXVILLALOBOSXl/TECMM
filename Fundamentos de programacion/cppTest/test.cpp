#include <iostream>

using namespace std;

int getOption();
void makePyramid(int);

int main(){
    while (true)
    {
        makePyramid(getOption());
    }
    return 0;
}

int getOption(){
    int rows;
    do
    {
        cout<<"How many rows do you want?: ";
        cin>>rows;
        if(cin.fail() || rows < 1){
            cout<<"Invalid number, please try again. \n";
            cin.clear();
            cin.ignore(256,'\n');
            rows = -1;
        }
    } while (rows == -1);
    return rows;
}

void makePyramid(int rows){
    for (int x = 0; x < rows; x++)
    {
        cout<<"*";
        for (int y = 0; y < x; y++)
        {
            cout<<"*";
        }
        cout<<"\n";
    }
    
}