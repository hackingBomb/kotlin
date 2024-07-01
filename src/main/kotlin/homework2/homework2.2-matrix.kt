package org.example.homework2


fun printMtrx(mtrx_name: String, mtrx_data: Array<DoubleArray>){
    println("%s = ".format(mtrx_name))
    for(i in 0..(mtrx_data.size - 1)) {
        for (j in 0..(mtrx_data[0].size - 1)) {
            print("%10.2f ".format(mtrx_data[i][j]))
        }
        println()
    }
    println()
}

fun addMtrx(mA_data: Array<DoubleArray>, mB_data: Array<DoubleArray>): Array<DoubleArray>{

    var sumMtrx = Array(mA_data.size, {DoubleArray(mA_data[0].size,{0.0})})
    for(i in 0..(mA_data.size - 1)) {
        for(j in 0..(mA_data[0].size - 1)) {
            sumMtrx[i][j] = mA_data[i][j] + mB_data[i][j]
        }
    }


    return sumMtrx
}

fun subMtrx(mA_data: Array<DoubleArray>, mB_data: Array<DoubleArray>): Array<DoubleArray>{
    var subMtrx = Array(mA_data.size, {DoubleArray(mA_data[0].size,{0.0})})
    for(i in 0..(mA_data.size - 1)) {
        for(j in 0..(mA_data[0].size - 1)) {
            subMtrx[i][j] = mA_data[i][j] - mB_data[i][j]
        }
    }

    return subMtrx
}
// TODO: 여기 고쳐야함
fun mulMtrx(mA_data: Array<DoubleArray>, mB_data: Array<DoubleArray>): Array<DoubleArray>{
    var mulMtrx = Array(mA_data.size, {DoubleArray(mA_data[0].size, { 0.0 })})
    for(i in 0..mulMtrx[0].size-1){
        for(j in 0..mulMtrx.size - 1) {
            var tempMul = DoubleArray(mulMtrx[0].size)
            for(k in 0..mulMtrx[0].size - 1) {
                tempMul[k] = mA_data[i][k] * mB_data[k][j]
            }
            for(k in 0..tempMul.size - 1) {
                mulMtrx[i][j] += tempMul[k]
            }
        }
    }
    return mulMtrx
}


fun main(args: Array<String>) {
    val mA = arrayOf(
        doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0),
        doubleArrayOf(6.0, 7.0, 8.0, 9.0, 10.0),
        doubleArrayOf(11.0, 12.0, 13.0, 14.0, 15.0)
    )
    val mB = arrayOf(
        doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 1.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 1.0, 0.0, 0.0)
    )
    val mAddAB: Array<DoubleArray>
    val mSubAB: Array<DoubleArray>
    print("mA (nRow = %d, nCol = %d)\n".format(mA.size, mA[0].size))
    printMtrx("mA", mA)
    printMtrx("mB", mB)

    mAddAB = addMtrx(mA, mB)
    printMtrx("mAddAB", mAddAB)

    mSubAB = subMtrx(mA, mB)
    printMtrx("mSubAB", mSubAB)
    val mC = arrayOf(
        doubleArrayOf(1.0, 0.0, 0.0),
        doubleArrayOf(0.0, 1.0, 0.0),
        doubleArrayOf(0.0, 0.0, 1.0),
        doubleArrayOf(0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0)
    )
    val mMulAC: Array<DoubleArray>
    printMtrx("mA", mA)
    printMtrx("mC", mC)

    mMulAC = mulMtrx(mA, mC)
    printMtrx("mMulAC", mMulAC)


}