// File: ~/.groovy/OutputTransforms.groovy
import javax.swing.JLabel
transforms << { result ->
  if (result.class.name.toString().endsWith('RealMatrix')) {
    return new JLabel(matrixAsHTML(result))
  }
}

def matrixAsHTML(m) {
  def leftb = ['\u23a1', '\u23a2', '\u23a3']
  def rightb = ['\u23a4', '\u23a5', '\u23a6']
  def rows = m.rowDimension
  """<html>
  <style type="text/css">
  table.matrix { margin: 0; border-collapse: collapse; border-spacing: 0; }
  .matrix td{ text-align: center; line-height: 0em; padding: 0; margin: $rows; }
  </style>
  <table class="matrix"><tbody>
    ${(0..<rows).collect{ r -> r == 0 ?
      '<tr>' + bracket(rows, *leftb) + rowAsHTML(m.getRow(r)) +
               bracket(rows, *rightb) + '</tr>' :
      '<tr>' + rowAsHTML(m.getRow(r)) + '</tr>' }.join()}
  </tbody></table>
  </html>
  """
}

def rowAsHTML(double[] d) {
  d.collect{"<td>$it</td>"}.join()
}

def bracket(rows, top, middle, bottom) {
  $/<td rowspan="${rows+1}">$top<br>${"$middle<br>" * (rows-1)}$bottom</td>/$
}
