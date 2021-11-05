#ifndef MATRIX_H
#define MATRIX_H

typedef unsigned int uint;

class Matrix {

private:
    uint rows;
    uint cols;
    double ** arr;
public:
    /**
     * A default constructor which creates a matrix
     * based on inputted rows and cols and intializes
     * all elements to 0.
     *
     * @param cols the number of cols in the matrix
     * @param rows the number of rows in the matrix
     */
    Matrix(uint rows, uint cols);// constructor (all elements intialized to 0)

    /**
     * A copy constructor.
     *
     * @param m The matrix to be copied.
     */
    Matrix(const Matrix & m); //copy constructor

    /**
     * The Destructor. Deallocates the dynamically created 2D array.
     */
    ~Matrix();  // destructor

    /**
     * Adds scalar to the matrix. Adds all values
     * in the matrix by the double s.
     * @param s The value to add to the matrix
     * */
    Matrix add(double s) const; //add scalar to this matrix

/**
 * Creates a new Matrix whose values are assigned as the orignal's
 * added by M's value.
 *
 * @param m The matrix to add to this one.
 *
 */
    Matrix add(const Matrix & m) const; //add this matrix to another matrix

/**
 * Subtracts double value s from this matrix.
 * Creates a new Matrix and assigns its values based on the orignal's
 * subtracted by s.
 *
 * @param s the double value to subtract scalar from matrix
 *
 */
    Matrix subtract(double s) const; //subtract scalar from this matrix

/**
 * Subtract another matrix from this matrix
 * Creates a new Matrix and sets its values equal
 * to the orignal Matrix's values - M's value at that index.
 *
 * @param m The matrix to subtract from this one.
 *
 */
    Matrix subtract(const Matrix & m) const; //subtract another matrix from this matrix


/**
 * Multiplies this matrix by a scaler.
 * Goes through each matrix value and multiplies it by s.
 *
 *@param s The double value that acts as scalar to multiply the matrix by.
 *
 */
    Matrix multiply(double s) const; //mulitply this matrix by a scaler

/**
 * Multiplies this matrix by another. Creates a new Matrix
 * and sets its value equal to the original Matrix's mulitplied
 * by M's value.
 *
 * @param m The matrix to mulitply this one by.
 *
 */
    Matrix multiply(const Matrix & m) const; //multiply this matrix by another matrix

/**
 * Divides this matrix by scalar. Creates a new Matrix and
 * sets it's values equal to the orignal's divided by the scalar.
 *
 * @param s The double value that is the scalar with which this matrix is divided by.
 *
 */
    Matrix divide(double s) const; //divide this matrix by a scaler

/**
 * Creates a new Matrix which is a transpose of the original.
 * Assings the new one to basically switch the rows and columns for it's values.
 *
 *
 */
    Matrix t() const; // transpose of this matrix

/**
 *  Returns the number of rows in the Matrix.
 *
 */
    const uint numRows() const;  //returns the number of row
/**
 *  Returns number of columns in the matrix.
 *
 */
    const uint numCols() const;  //returns the number of cols

/**
 * Gets/Sets the value at inputted row,col.
 *
 * @param row the row where the value is
 * @param col the Column where the value is
 * */
    double & at(uint row, uint col); //get/set element at row,col

/**
 * Gets the value when using a const object. Can't be set as it is constant.
 *
 * @param row the row where the value is at
 * @param col the column where the value is at
 * */
    const double & at (uint row, uint col) const; //get/set at row,col(when using const object)


    /**
     * A helper method created to print out the Matrix. Used for
     * debugging.
     *
     * @param m The Matrix to print.
     * */
    void test(const Matrix & m) const;

};
#endif
