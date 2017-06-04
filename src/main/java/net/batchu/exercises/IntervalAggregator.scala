package net.batchu.exercises

/**
  * Created by Prashanth Batchu on 6/3/2017.
  */
object IntervalAggregator {

  /*
    Merges the input interval into an existing Array of Intervals
    First argument is an Array of Tuples (Int, Int). The second argument is the new interval that needs to be merged in to the first argument properly
    Refer to IntervalAggregatorTest.scala for the accompanying unit tests

    Notes: The method treats the inputs as well as intermediate transformations as immutable. This is referentially transparent so it can be run in a multithreaded environment without the fear of a lock condition.
   */
  def mergeInterval(arr: Array[(Int, Int)], interval: (Int, Int)) = {

    //Input validation
    if(arr==null || interval==null) throw new IllegalArgumentException("Input validation failure")

    /*
    Partition the Array of Tuples in to two parts.
    The first partition (split._1) includes all the tuples that overlap with the new Interval
    The second partition (split._2) includes all the disjoint intervals

    Logic for splitting:
      There's an overlap between two intervals if the width of two intervals is greater than the max and min of the two intervals
     */
    val split = arr.partition(u => (((u._2-u._1)+(interval._2-interval._1))>= ((u._2 max interval._2)-(u._1 min interval._1))))

    //Add the new interval to the overlapping tuples pool
    val overlapArr = split._1 :+ interval

    //Calculate the starting interval amongst the overlapping tuples pool
    val x = overlapArr.map((x: (Int, Int)) => x._1 min x._2)

    //Calculate the new merged interval
    val y = overlapArr.map((x: (Int, Int)) => x._1 max x._2)

    //Add the merged interval to the second partition which holds the disjoint intervals and return
    //Note that the return is implicit in Scala
     split._2 :+ (x.min -> y.max)
  }
}


