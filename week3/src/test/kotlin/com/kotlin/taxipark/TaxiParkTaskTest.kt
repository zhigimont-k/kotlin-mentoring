package com.kotlin.taxipark

import com.kotlin.nicestring.generateTaxiPark
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TaxiParkTaskTest {

    @Test
    fun testFindFakeDrivers(){
        var park = generateTaxiPark()
        var expectedDrivers = ArrayList<Driver>()
        expectedDrivers.add(park.allDrivers.toList().get(15))
        expectedDrivers.add(park.allDrivers.toList().get(16))
        expectedDrivers.add(park.allDrivers.toList().get(17))
        assertEquals(expectedDrivers.toSet(), park.findFakeDrivers())
    }

    @Test
    fun testFindFaithfulPassengers(){
        var park = generateTaxiPark()
        var expectedPassengers = ArrayList<Passenger>()
        expectedPassengers.add(park.allPassengers.toList().first())
        assertEquals(expectedPassengers.toSet(), park.findFaithfulPassengers(2))
    }

    @Test
    fun testFindFrequentPassengers(){
        var park = generateTaxiPark()
        var expectedPassengers = ArrayList<Passenger>()
        expectedPassengers.add(park.allPassengers.toList().first())
        assertEquals(expectedPassengers.toSet(), park.findFrequentPassengers(park.allDrivers.first()))
    }

    @Test
    fun testFindSmartPassengers(){
        var park = generateTaxiPark()
        assertEquals(park.allPassengers.toList().subList(0, 15).toSet(), park.findSmartPassengers())
    }

    @Test
    fun testFindTheMostFrequentTripDurationPeriod(){
        var park = generateTaxiPark()
        assertEquals(20..29, park.findTheMostFrequentTripDurationPeriod())
    }

    @Test
    fun testCheckParetoPrinciple() {
        var park = generateTaxiPark()
        assertFalse(park.checkParetoPrinciple())
    }
}