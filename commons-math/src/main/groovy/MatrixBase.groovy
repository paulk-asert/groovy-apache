import org.apache.commons.math3.linear.*

abstract class MatrixBase extends Script {
    MatrixBase() {
        super()
        RealMatrix.metaClass {
            plus << { RealMatrix ma -> delegate.add(ma) }
            plus << { double d -> delegate.scalarAdd(d) }
            multiply { double d -> delegate.scalarMultiply(d) }
            bitwiseNegate { -> new LUDecomposition(delegate).solver.inverse }
            constructor = { List l -> MatrixUtils.createRealMatrix(l as double[][]) }
        }
    }
}
