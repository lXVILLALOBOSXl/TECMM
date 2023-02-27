/*
AUTOR:      Luis Villalobos
CURSO:      Estructura de Datos
PROGRAMA:   Understanding Flowcharts
FECHA:      19 de febrero del 2023
*/

#include <iostream>


typedef struct Snode
{
    const char *message;

    Snode *yes;
    Snode *no;

} Node;

Node *create(const char *message){
    
    Node *p = new Node;
    p -> message = message;
    p -> yes = nullptr;
    p -> no = nullptr;

    return p;
}


int main(int argc, char const *argv[])
{
    Node *n[14];

    n[0] = create("START");
    n[1] = create("DO YOU UNDERSTAND FLOW CHARTS?");
    n[2] = create("GOOD");
    n[3] = create("LETS GO DRINK");
    n[4] = create("HEY, I SHOULD TRY INSTALLING FREEBSD!");
    n[5] = create("OKAY. YOU SEE THE LINE LABELED \"YES\"?");
    n[6] = create("...AND YOU CAN SEE THE ONES LABELED \"NO\"?");
    n[7] = create("BUT YOU JUST FOLLOWED THEM TWICE!");
    n[8] = create("(THAT WASN'T A QUESTION.)");
    n[9] = create("SCREW IT!");
    n[10] = create("BUT YOU SEE THE ONES LABELED \"NO\".");
    n[11] = create("WAIT, WHAT?");
    n[12] = create("LISTEN.");
    n[13] = create("I HATE YOU.");

    n[0] -> yes = n[1];
    n[0] -> no = n[1];

    n[1] -> yes = n[2];
    n[1] -> no = n[5];

    n[2] -> yes = n[3];
    n[2] -> no = n[3];

    n[3] -> yes = n[4];
    n[3] -> no = n[4];

    n[5] -> yes = n[6];
    n[5] -> no = n[10];

    n[6] -> yes = n[2];
    n[6] -> no = n[7];

    n[7] -> yes = n[8];
    n[7] -> no = n[8];

    n[8] -> yes = n[9];
    n[8] -> no = n[9];

    n[9] -> yes = n[3];
    n[9] -> no = n[3];

    n[10] -> yes = n[11];
    n[10] -> no = n[12];

    n[12] -> yes = n[13];
    n[12] -> no = n[13];

    Node *p = n[0];
    char answer [4];
    
    do
    {

        printf("%s\n", p -> message);

        if(p == n[4] || p == n[11] || p == n[13]){
            p = nullptr;
        }else{
            if (p -> yes != p -> no){
                scanf("%s", answer);
            }else{
               strcpy(answer, "yes");
            }
            p = ((strcmp("yes", answer) == 0) ? p->yes : p->no);  
        } 


    } while (p);

    for (int i = 0; i < 14; i++)
    {
        delete n[i];
    }

    return 0;
}