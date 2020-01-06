package machine

import java.util.Scanner

var currentMoney = 550
var currentWater = 400
var currentMilk = 540
var currentCoffeeBeans = 120
var currentCups = 9
var exit = false

fun main() {
    val scanner = Scanner(System.`in`)

    while(!exit) {
        print("Write action (buy, fill, take, remaining, exit): ")

        val action = scanner.next()

        when (action) {
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                val coffeeType = scanner.next()
                buyCoffee(coffeeType)
            }
            "fill" -> {
                fillMachine()
            }
            "take" -> {
                takeMoney()
            }
            "remaining" -> {
                showCurrent()
            }
            "exit" -> {
                exit = true
            }
            else -> println("Wrong action")
        }
        println()
    }
}

fun showCurrent() {
    println("The coffee machine has:\n" +
            "$currentWater of water\n" +
            "$currentMilk of milk\n" +
            "$currentCoffeeBeans of coffee beans\n" +
            "$currentCups of disposable cups\n" +
            "$currentMoney of money")
}

fun buyCoffee(coffeeType: String) {
    when (coffeeType) {
        "1" -> {
            makeCoffee(250, 0, 16, 4)
        }
        "2" -> {
            makeCoffee(350, 75, 20, 7)
        }
        "3" -> {
            makeCoffee(200, 100, 12, 6)
        }
        "back" -> {

        }
        else -> {
            println("wrong type of coffee")
        }
    }
}

fun makeCoffee(water: Int, milk: Int, beans: Int, money: Int) {
    if (
        currentWater >= water &&
        currentMilk >= milk &&
        currentCoffeeBeans >= beans &&
        currentCups > 0
    ) {
        println("I have enough resources, making you a coffee!")
        currentWater -= water
        currentMilk -= milk
        currentCoffeeBeans -= beans
        currentMoney += money
        currentCups --
    } else {

        var notEnough = when {
            currentWater < water -> "water"
            currentMilk < milk -> "milk"
            currentCoffeeBeans < beans -> "coffee beans"
            currentCups < 1 -> "cups"
            else -> ""
        }
        println("Sorry, not enough $notEnough!")
    }
}

fun fillMachine() {
    val scanner = Scanner(System.`in`)
    print("Write how many ml of water do you want to add: ")
    currentWater += scanner.nextInt()
    print("Write how many ml of milk do you want to add: ")
    currentMilk += scanner.nextInt()
    print("Write how many grams of coffee beans do you want to add: ")
    currentCoffeeBeans += scanner.nextInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    currentCups += scanner.nextInt()
}

fun takeMoney () {
    println("I gave you \$$currentMoney")
    currentMoney = 0
}
