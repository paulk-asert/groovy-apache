import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.apache.commons.math3.linear.RealMatrix

def importCustomizer = new ImportCustomizer()
importCustomizer.addImport('Matrix', RealMatrix.name)

def config = new CompilerConfiguration()
config.scriptBaseClass = MatrixBase.name
config.addCompilationCustomizers(importCustomizer)
def shell = new GroovyShell(this.class.classLoader, config)

shell.evaluate '''
def m = [[1d,2d,3d], [2d,5d,3d]] as Matrix
def n = [[1d,2d], [2d,5d], [1d,7d]] as Matrix
def o = m * n
def p = (~o + 1) * 2
println o + p ** 2
'''
