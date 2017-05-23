/**
  * Created by uhsarp on 5/21/2017.
  */
class StockAdvisor {


  def advise(arr: Array[Double]): Double = {

    var lowest: Double = Double.MinValue
    var highest: Double = Double.MinValue
    var diff: Double = Double.MinValue

    for (curr <- arr) {
      if (lowest < 0 && highest < 0) {
        lowest = curr
        highest = curr
      }
      if (highest < curr) highest = curr
      if (curr < lowest) {
        lowest = curr
        highest = 0.00
      }
      if(diff< highest - lowest) diff = highest-lowest
    }
    return diff

  }
}


