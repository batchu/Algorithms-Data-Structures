package net.batchu.exercises

import org.junit.{Assert, Test}

/**
  * Created by Prashanth Batchu on 6/3/2017.
  */
class IntervalAggregatorTest {

  @Test
  def mergeInterval_shouldDealWithNullInputs(): Unit = {

    try
      val interval = IntervalAggregator.mergeInterval(null, null)

    catch {
      case _: IllegalArgumentException => Assert.assertTrue(true)
    }

  }

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

  @Test
  def mergeInterval_shouldMergeWhenThereIsAnOverlapWithInputValues(): Unit = {

    var i = Array(1 -> 3, 5 -> 9, 15 -> 18)
    var x = 3 -> 9
    val interval = IntervalAggregator.mergeInterval(i, x)
    Assert.assertEquals(interval.length, 2)

  }

  @Test
  def mergeInterval_shouldMergeWithEntireIntervalsWhenInputIsASuperSet(): Unit = {

    var i = Array(1 -> 3, 5 -> 9, 15 -> 18)
    var x = 1 -> 99999
    val interval = IntervalAggregator.mergeInterval(i, x)
    Assert.assertEquals(interval.length, 1)

  }

}
