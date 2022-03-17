package com.bignerdranch.nyethack

import java.util.*
import kotlin.collections.HashMap

class VehicleMake(private val name: String, private val country: String) : Comparable<VehicleMake>{
    override fun toString(): String {
        return "[$name : $country]"
    }

    override fun compareTo(other: VehicleMake): Int {
        val countryComparationResult = country.compareTo(other.country)
        return if (countryComparationResult == 0) {
            name.compareTo(other.name)
        } else {
            countryComparationResult
        }
    }
}

fun main() {
//HashMap
//        val map = HashMap<String, Array<String>>()
//
//        map["Cadilac"] = arrayOf("Escalade", "STS", "CT6")
//        map["Chevrolet"] = arrayOf("Tahoe", "Epica", "Suburban")
//        map["ВАЗ"] = arrayOf("Калина", "Приора")
//        map["Nissan"] = arrayOf("Teana","Qashqai", "Patrol", "Juke")
//        map["Volkswagen"] = arrayOf("Polo", "EOS", "Jetta")
//
//        println("-----")
//
//        map.forEach{ (k, v) ->
//            println("$k: ${v.contentToString()}")
//        }
//
//        println("-----")
//
//        println(map["ВАЗ"].contentToString())

//LinkedHashMap
//        val map = LinkedHashMap<String, Array<String>>()
//
//        map["Cadilac"] = arrayOf("Escalade", "STS", "CT6")
//        map["Chevrolet"] = arrayOf("Tahoe", "Epica", "Suburban")
//        map["ВАЗ"] = arrayOf("Калина", "Приора")
//        map["Nissan"] = arrayOf("Teana","Qashqai", "Patrol", "Juke")
//        map["Volkswagen"] = arrayOf("Polo", "EOS", "Jetta")
//
//        println("-----")
//
//        map.forEach{ (k, v) ->
//            println("$k: ${v.contentToString()}")
//        }
//
//        println("-----")
//
//        println(map["ВАЗ"].contentToString())

//TreeHashMap
        val map = TreeMap<VehicleMake, Array<String>>()

        map[VehicleMake("Cadilac", "USA")] = arrayOf("Escalade", "STS", "CT6")
        map[VehicleMake("Chevrolet", "USA")] = arrayOf("Tahoe", "Epica", "Suburban")
        map[VehicleMake("ВАЗ", "Russia")] = arrayOf("Калина", "Приора")
        map[VehicleMake("Nissan", "Japan")] = arrayOf("Teana","Qashqai", "Patrol", "Juke")
        map[VehicleMake("Volkswagen", "Germany")] = arrayOf("Polo", "EOS", "Jetta")

        println("-----")

        map.forEach{ (k, v) ->
            println("$k: ${v.contentToString()}")
        }

        println("-----")

        println(map[VehicleMake("ВАЗ", "Russia")].contentToString())
    }
