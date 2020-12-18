package com.kotlin.taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers.filter { it !in trips.map { trip -> trip.driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers.filter { trips.filter { trip -> it in trip.passengers }.count() >= minTrips }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    allPassengers.filter { trips.filter { trip -> trip.driver == driver && it in trip.passengers}.count() > 1}.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    allPassengers.filter { trips.filter { trip -> it in trip.passengers && trip.discount != null }.count() >
            trips.filter { trip ->  it in trip.passengers && trip.discount == null }.count() }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return trips.groupBy { (it.duration / 100)..(it.duration / 100 + 9) }.maxByOrNull { (_, durationsInRange) -> durationsInRange.size }?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    return trips.groupBy { it.driver }.map { (_, tripsByDriver) -> tripsByDriver.sumByDouble { it.cost } }
        .sortedDescending().take((allDrivers.size * 0.2).toInt()).sum() >
            0.8 * trips.sumByDouble { it.cost }
}