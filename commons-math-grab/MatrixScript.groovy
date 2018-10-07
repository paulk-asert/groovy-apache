@Grab('org.apache.commons:commons-math3:3.6.1')
import org.apache.commons.math3.linear.*

RealMatrix.metaClass {
    plus << { RealMatrix ma -> delegate.add(ma) }
    plus << { double d -> delegate.scalarAdd(d) }
    multiply { double d -> delegate.scalarMultiply(d) }
    bitwiseNegate { -> new LUDecomposition(delegate).solver.inverse }
    constructor = { List l -> MatrixUtils.createRealMatrix(l as double[][]) }
}

def m = [[1d,2d,3d], [2d,5d,3d]] as RealMatrix
def n = [[1d,2d], [2d,5d], [1d,7d]] as RealMatrix
def o = m * n
def p = (~o + 1) * 2
o + p ** 2
