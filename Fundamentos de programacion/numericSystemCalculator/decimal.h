//Villalobos Rivera Luis Adrian (c)
//220120379
//1ISC T/M
#include <string>

using namespace std;

class Decimal
{
private:
    string value;
public:
    Decimal(/* args */);
    Decimal(string);
    ~Decimal();
};

Decimal::Decimal(/* args */)
{
}

Decimal::Decimal(string value)
{
    this->value = value;
}

Decimal::~Decimal()
{
}
