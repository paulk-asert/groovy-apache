@BaseScript(MatrixBase)
import groovy.transform.BaseScript
import org.apache.commons.math3.linear.RealMatrix

def m = [[1d,2d,3d], [2d,5d,3d]] as RealMatrix
def n = [[1d,2d], [2d,5d], [1d,7d]] as RealMatrix
def o = m * n
def p = (~o + 1) * 2
println o + p ** 2
