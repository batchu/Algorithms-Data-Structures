package net.batchu.exercises

import org.junit.{Assert, Test}

/**
  * Created by uhsarp on 6/3/2017.
  */
class IntervalAggregatorTest {

  @Test
  def mergeInterval_shouldAddToCollectionWhenThereIsNoOverlap(): Unit = {

    var i = Array(1 -> 3, 5 -> 9, 15 -> 18)
    var x = 11 -> 13
    Assert.assertEquals(IntervalAggregator.mergeInterval(i, x).length, 4)

  }

  @Test
  def mergeInterval_shouldAddToCollectionWhenInputIsEmpty(): Unit = {

    var i: Array[(Int, Int)] = new Array[(Int, Int)](0)
    var x = 11 -> 13
    Assert.assertEquals(IntervalAggregator.mergeInterval(i, x).length, 1)

  }


}
