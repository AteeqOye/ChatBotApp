package com.example.chatbotapp.utils
import com.example.chatbotapp.utils.Constants.OPEN_GOOGLE
import com.example.chatbotapp.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("head") && message.contains("ya tail") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hello") || message.contains("hi")-> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Han bsdk!"
                    2 -> "Muje tang karny a gya ha bsdk!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }
            message.contains("muddasser") -> {
                when (random) {
                    0 -> "Yes i know this person!" +
                            "Ateeq ka chota beta ha!"
                    1 -> "Cake of Bscs f19"
                    2 -> "son of ateeq"
                    else -> "error"
                }
            }
            message.contains("i'm good") -> {
                when (random) {
                    0 -> "Have a nice day!"
                    1 -> "Nice!"
                    2 -> "Alright, How about your work today!"
                    else -> "error"
                }
            }
            message.contains("whats up") -> {
                when (random) {
                    0 -> "Nothing special!"
                    1 -> "i'm busy right now"
                    2 -> "Good, How about your work today!"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different?"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}