package net.batchu.exercises

/**
  * Created by Prashanth Batchu on 6/3/2017.
  */
object IntervalAggregator {

  /*
    Merges the input interval into an existing Array of Intervals

   */
  def mergeInterval(arr: Array[(Int, Int)], interval: (Int, Int)) = {

    if(arr==null || interval==null) throw new IllegalArgumentException("Input validation failure")
    val split = arr.partition(u => (((u._2-u._1)+(interval._2-interval._1))>= ((u._2 max interval._2)-(u._1 min interval._1))))

    val overlapArr = split._1 :+ interval
    val x = overlapArr.map((x: (Int, Int)) => x._1 min x._2)
    val y = overlapArr.map((x: (Int, Int)) => x._1 max x._2)

     split._2 :+ (x.min -> y.max)
  }
}


