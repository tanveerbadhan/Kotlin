class PrestoCard {
    var balance: Double = 0.0
    var monthlyPass: Boolean = false
}

class Customer{
    var name: String = ""
    var isStudent: Boolean = false
    val card: PrestoCard = PrestoCard()

    constructor(n: String, iStu: Boolean = false) {
        name = n
        isStudent = iStu
        if(isStudent){
            card.balance = 20.0
        }
    }

    fun addMoney (amount: Double) {
        card.balance += amount
        println("${name} added $${amount} and now presto balance is $${card.balance}")
    }

    fun buyPass () {
        if(card.monthlyPass){
            println("${name} already has a monthly pass!")
        } else {
            if(isStudent){
                if(card.balance >= 156 * 0.85){
                    card.monthlyPass = true
                    card.balance -= 156 * 0.85
                    println("${name} successfully bought Monthly pass")
                } else {
                    println("${name} does not have enough balance to purchase a monthly pass")
                }
            } else {
                if(card.balance >= 156){
                    card.monthlyPass = true
                    card.balance -= 156
                    println("${name} successfully bought Monthly pass")
                } else {
                    println("${name} does not have enough balance to purchase a monthly pass")
                }
            }
        }

    }

    fun rideBus () {
        if(card.monthlyPass){
            println("${name} riden a bus and presto balance is now $${card.balance}")
        } else {
            if(card.balance >= 3.3){
                card.balance -= 3.3
                println("${name} riden a bus and presto balance is now $${card.balance}")
            } else {
                println("${name} Presto has not enough balance to ride a bus")
            }

        }
    }
}

fun main() {
    val ram = Customer("Ram Singh")
    ram.rideBus()
    ram.addMoney(5.0)
    ram.rideBus()

    val tanveer = Customer("Tanveer Singh")
    tanveer.addMoney(200.0)
    tanveer.buyPass()
    tanveer.buyPass()
    tanveer.rideBus()

}