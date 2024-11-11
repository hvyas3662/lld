package com.hvyas.solid.designPattern.behavioral.chain_of_responsibility

//abstract handler
abstract class NoteDispatcher(private val nextDispatcher: NoteDispatcher?, protected val totalNoteNo: Int) {
    abstract val noteValue: Long
    open fun dispatchNote(withdrawalAmount: Long) {
        if (totalNoteNo > 0 && withdrawalAmount >= noteValue) {
            val noteCount = minOf((withdrawalAmount / noteValue).toInt(), totalNoteNo)
            val dispatchedAmount = noteCount * noteValue
            val remainingAmount = withdrawalAmount - dispatchedAmount

            if (noteCount > 0) println("$noteCount notes of $noteValue = $dispatchedAmount")

            if (remainingAmount > 0) {
                nextDispatcher?.dispatchNote(remainingAmount) ?: println("Insufficient funds to dispense remaining amount: $remainingAmount")
            }
        } else {
            nextDispatcher?.dispatchNote(withdrawalAmount) ?: println("Insufficient funds to dispense amount: $withdrawalAmount")
        }
    }
}

class Note2000Dispatcher(totalNoteNo: Int, noteDispatcher: NoteDispatcher?) : NoteDispatcher(noteDispatcher, totalNoteNo) {
    override val noteValue: Long = 2000L
    override fun dispatchNote(withdrawalAmount: Long) {
        if (((totalNoteNo * noteValue) >= withdrawalAmount) && withdrawalAmount >= noteValue) {
            val noteCount: Int = (withdrawalAmount / noteValue).toInt()
            val dispatchedAmount = noteCount * noteValue
            val remainingAmount = withdrawalAmount - dispatchedAmount
            println("$noteCount notes of $noteValue = $dispatchedAmount")
            if (remainingAmount > 0) super.dispatchNote(remainingAmount)
        } else {
            super.dispatchNote(withdrawalAmount)
        }
    }
}

class Note500Dispatcher(totalNoteNo: Int, noteDispatcher: NoteDispatcher?) : NoteDispatcher(noteDispatcher, totalNoteNo) {
    override val noteValue = 500L
    override fun dispatchNote(withdrawalAmount: Long) {
        if (((totalNoteNo * noteValue) >= withdrawalAmount) && withdrawalAmount >= noteValue) {
            val noteCount: Int = (withdrawalAmount / noteValue).toInt()
            val dispatchedAmount = noteCount * noteValue
            val remainingAmount = withdrawalAmount - dispatchedAmount
            println("$noteCount notes of $noteValue = $dispatchedAmount")
            if (remainingAmount > 0) super.dispatchNote(remainingAmount)
        } else {
            super.dispatchNote(withdrawalAmount)
        }
    }
}

class Note100Dispatcher(totalNoteNo: Int, noteDispatcher: NoteDispatcher?) : NoteDispatcher(noteDispatcher, totalNoteNo) {
    override val noteValue = 100L
    override fun dispatchNote(withdrawalAmount: Long) {
        if (((totalNoteNo * noteValue) >= withdrawalAmount) && withdrawalAmount >= noteValue) {
            val noteCount: Int = (withdrawalAmount / noteValue).toInt()
            val dispatchedAmount = noteCount * noteValue
            val remainingAmount = withdrawalAmount - dispatchedAmount
            println("$noteCount notes of $noteValue = $dispatchedAmount")
            if (remainingAmount > 0) super.dispatchNote(remainingAmount)
        } else {
            super.dispatchNote(withdrawalAmount)
        }
    }
}

class Atm {
    private val atmDispatcher = Note2000Dispatcher(200, Note500Dispatcher(1000, Note100Dispatcher(500, null)))
    fun withdrawalMoney(amount: Long) {
        if (amount <= 0 || amount % 100 != 0L) {
            println("Amount should be positive and multiple of 100")
            return
        }
        atmDispatcher.dispatchNote(amount)
    }
}

fun main() {
    Atm().withdrawalMoney(3000700)
}