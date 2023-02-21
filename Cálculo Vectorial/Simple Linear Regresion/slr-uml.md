# SLR UML Abstraction and Modelling

## Abstraction

+ DataSet
+ SLR
+ Main

## Modelling

@startuml
class DataSet{
- x[]: double
- y[]: double
+ DataSet()
+ DataSet(x[]:double, y[]:double)
+ getX(): double[]
+ getY(): double[]
}
@enduml
@startuml
class SLR{
- ds: DataSet
- beta0:double
- beta1:double
+ SLR()
+ SLR(ds:DataSet)
+ calculateB0():double
+ calculateB1():double
+ printRegressionEq():void
+ toPredict(x:double):double
}
@enduml