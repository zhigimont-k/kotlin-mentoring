package com.kotlin.nicestring

import com.kotlin.taxipark.Driver
import com.kotlin.taxipark.Passenger
import com.kotlin.taxipark.TaxiPark
import com.kotlin.taxipark.Trip

fun generateTaxiPark() : TaxiPark {
    var allDrivers = ArrayList<Driver>()
    for (i in 0..17) {
        allDrivers.add(Driver("driver_$i"))
    }
    var allPassengers = ArrayList<Passenger>()
    for (i in 0..30) {
        allPassengers.add(Passenger("passenger_$i"))
    }
    var trips = ArrayList<Trip>()
    for (i in 1..15) {
        trips.add(Trip(allDrivers.get(i-1), allPassengers.subList(i-1, i).toSet(), i*2, i*2.0, i/100.0))
    }
    trips.add(Trip(allDrivers.first(), setOf(allPassengers.first()), 25, 50.0, 0.5))
    trips.add(Trip(allDrivers.first(), setOf(allPassengers.first()), 28, 40.0, 0.5))
    return TaxiPark(allDrivers.toSet(), allPassengers.toSet(), trips)
}