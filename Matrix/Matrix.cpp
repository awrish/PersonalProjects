#include <iostream>
#include "Matrix.h"

typedef unsigned int uint;

using namespace std;

/**
 * Initailizes the Matrix values to 0.
 */
Matrix::Matrix(uint rows, uint cols) {
    arr = new double * [rows];
    for (uint i = 0; i < rows; i++){
        arr[i] = new double  [cols];
    } //for

    for (uint i = 0; i < rows; i++) {
        for (uint j = 0; j < cols; j++) {
            arr[i][j] = 0;
        } //for
    } // outer for
    this->rows = rows;
    this->cols = cols;

} //constructor

Matrix::Matrix(const Matrix & m) {
    uint mRows = m.numRows();
    uint mCols = m.numCols();

    arr = new double * [mRows];
    for (uint i = 0; i < mRows; i++) {
        arr[i] = new double [mCols];
    } //for

    for (uint i = 0; i < mRows; i++) {
        for (uint j = 0; j < mCols; j++) {
            arr[i][j] = m.at(i,j);
        }
    }

    this->rows = mRows;
    this->cols = mCols;

} // copy constructor



/**
 * Creates a new matrix and sets values
 * equal to the values in the original matrix
 * plus the value to be added.
 *
 */
Matrix Matrix::add(double s) const {

    Matrix temp(rows,cols);
    for (uint i = 0; i < rows; i++) {
        for (uint j = 0; j < cols; j++) {
            temp.at(i,j) = arr[i][j] + s;
        } //for
    } //outer
    return temp;

} //add



Matrix Matrix::add(const Matrix & m) const {
    Matrix tempAdd(m.numRows(), m.numCols());
    for (uint i = 0; i < m.numRows(); i++) {
        for (uint j = 0; j < m.numCols(); j++) {
            tempAdd.at(i,j) = m.at(i,j) + this->at(i,j);
        }
    } //outer
    return tempAdd;

} //add Matrix to another Matrix

Matrix Matrix::subtract(double s) const {

    Matrix tempSub(this->rows, this->cols);
    for (uint i = 0; i < this->rows; i++) {
        for (uint j = 0; j < this->cols; j++) {
            tempSub.at(i,j) = this->at(i,j) - s;
        }
    } //outer

    return tempSub;

} //subtract

Matrix Matrix::subtract(const Matrix & m) const {
    if (this->rows == m.numRows() && this->cols == m.numCols()) {
        Matrix tempSub(this->rows, this->cols);
        for (uint i = 0; i < this->rows; i++) {
            for (uint j = 0; j < this->rows; j++) {
                tempSub.at(i,j) = this->at(i,j) - m.at(i,j);
            }
        } //outer
        return tempSub;
    } else {
        cout << "Unequal " << endl;
        return m;
    }


} //subtact

Matrix::~Matrix() {
    for (uint i = 0; i < rows; i++) {
        delete[] arr[i];
    } //for

    delete[] arr;
} //destructor

const uint Matrix::numRows() const {
    return this->rows;
} //numRows


const uint Matrix::numCols() const {
    return this->cols;
} //numCols



double & Matrix::at(uint row, uint col) {

    return this->arr[row][col];

} //at

const double & Matrix::at (uint row, uint col) const {
    return this->arr[row][col];

} //at

Matrix Matrix::multiply (double s) const {

    Matrix temp(this->rows, this->cols);
    for (uint i = 0; i < rows; i++) {
        for (uint j = 0; j < cols; j++) {
            temp.at(i,j) = arr[i][j] * s;
        }
    } //outer

    return temp;
} //multiply

Matrix Matrix::multiply (const Matrix & m) const {
    if (this->cols == m.numRows()) {
        Matrix temp(this->rows, m.numCols());
        double prod = 0;
        for (uint i = 0; i < temp.numRows(); i++) {
            for (uint j = 0; j < temp.numCols(); j++) {
                prod = 0;
                for (uint a = 0; a < this->cols; a++) {
                    prod += this->at(i,a) * m.at(a,j);
                } // multiply
                temp.at(i,j) = prod;
            }
        } //outer
        return temp;
    } else {
        cout << "Unequal " << endl;
        return m;

    }
} //





Matrix Matrix::divide (double s) const {

    Matrix temp(this->rows, this->cols);
    for (uint i = 0; i < rows; i++) {
        for(uint j = 0; j < cols; j++) {
            temp.at(i,j) = arr[i][j] / s;
        }
    } //outer

    return temp;


} //divide

Matrix Matrix::t() const {

    Matrix temp(this->cols, this->rows);
    for (uint i = 0; i < temp.numRows(); i++) {
        for (uint j = 0; j < temp.numCols(); j++) {
            temp.at(i,j) = this->at(j,i);
        }
    } //outer

    return temp;

}


void Matrix::test(const Matrix & m) const {

    for (uint i = 0; i < m.numRows(); i++) {
        cout << "[";
        for (uint j = 0; j < m.numCols(); j++) {
            cout << m.at(i,j);
            if (j != m.numCols() - 1)
                cout << ", ";
            if (j == m.numCols() - 1)
                cout << "]" << endl;
        }
    }
    cout << endl;

} //print
