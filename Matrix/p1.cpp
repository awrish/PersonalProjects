#include <iostream>
#include "Matrix.h"

using namespace std;

/**
 * Driver code for Matrix project.
 * Used for testing function implementations.
 */
int main() {

    cout << "Matrix first " << endl;
    Matrix first(2,2);

    first.at(0,0) = 2;
    first.at(0,1) = 4;
    first.at(1,0) = 3.5;
    first.at(1,1) = 6;

    first.test(first);
    cout << "Matrix Second Copy of First " << endl;
    Matrix sec(first);
    sec.test(sec);
    cout << "Matrix second changed " << endl;
    sec.at(0,0) = 1;
    sec.at(0,1) = 2;
    sec.at(1,0) = 3;
    sec.at(1,1) = 8;
    sec.test(sec);

    cout << "Addition Test: add 10 to first " << endl;
    Matrix add = first.add(10);
    add.test(add);

    cout << "Add first to second " << endl;
    Matrix addMat = first.add(sec);
    addMat.test(addMat);

    cout << "Subtraction Test: sub 5 from second" << endl;
    Matrix sub1 = first.subtract(5);
    sub1.test(sub1);

    cout << "Sub first from second" << endl;
    Matrix sub2 = sec.subtract(first);
    sub2.test(sub2);

    cout << "Multiplication Test: second by 3 " << endl;
    Matrix mult1 = sec.multiply(3);
    mult1.test(mult1);

    cout << "Mult first by second " << endl;
    Matrix mult2 = first.multiply(sec);
    mult2.test(mult2);

    cout << "Division Test: Divide first by 3 " << endl;
    Matrix div = first.divide(3);
    div.test(div);

    cout << "Transpose Second Matrix " << endl;
    Matrix T = sec.t();
    T.test(T);

    cout << "Number of Rows Of first " << endl;
    cout << first.numRows() << endl;

    Matrix cols(5,6);
    cout << "Number of Rows of Cols Matrix (Should be 6" << endl;
    cout << cols.numCols() << endl;




    cout << "Example from pdf " << endl;
    Matrix a(2, 2);
    a.at(0,0) = 1.5;
    a.at(0,1) = 2.0;
    a.at(1,0) = 1.0;
    a.at(1,1) = 3.5;
//    a.test(a);

    Matrix b(2, 1);
    b.at(0,0) = 3.5;
    b.at(1, 0) = 2.0;
//    b.test(b);

    Matrix c = a.multiply(b);
    cout << "[ " << c.at(0,0) << " ]" << endl;
    cout << "[ " << c.at(1,0) << " ]" << endl;

} //main
