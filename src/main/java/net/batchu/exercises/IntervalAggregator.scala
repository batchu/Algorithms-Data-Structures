package net.batchu.exercises

/**
  * Created by Prashanth Batchu on 6/3/2017.
  */
object IntervalAggregator {

  def main(args: Array[String]) = {
    var i = Array(1 -> 3, 5 -> 9, 15 -> 18)
    var x = 11 -> 13
    val interval = mergeInterval(i, x)
    interval.foreach{case(x)=>print("("+x._1+","+x._2+")\n")}
  }

  def mergeInterval(i: Array[(Int, Int)], x: (Int, Int)) = {

    val c = i.partition(u => (((u._2-u._1)+(x._2-x._1))> ((u._2 max x._2)-(u._1 min x._1))))

    val a = c._1 :+ x
    val l = a.map((x: (Int, Int)) => x._1 min x._2)
    val r = a.map((x: (Int, Int)) => x._1 max x._2)

     c._2 :+ (l.min -> r.max)

  }

}


