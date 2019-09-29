package com.example.calculadoraAndroid

import android.util.Log
import java.text.DecimalFormat
import kotlin.math.floor

class CalculadoraManager {

    private var resultado: Float = 0F

    fun makeACount(entrada: String): String {
        var count = 1

        val algarismos = entrada.split("+", "-", "*", "/").dropLastWhile { it.isEmpty() }.toTypedArray()

        resultado = algarismos[0].toFloat()

        for (element in entrada) {
            try {
                when (element) {
                    '+' -> {
                        resultado += algarismos[count].toFloat()
                        count++
                    }

                    '-' -> {
                        resultado -= algarismos[count].toFloat()
                        count++
                    }

                    '/' -> try {
                        resultado /= algarismos[count].toFloat()
                        count++
                    } catch (e: Exception) {
                        Log.e("Error na divisão", e.printStackTrace().toString())
                    }

                    '*' -> {
                        resultado *= algarismos[count].toFloat()
                        count++
                    }

                    else -> { Log.e("Error de entrada!", "Visor???") }
                }
            } catch (e: Exception) {
                Log.e("Error no operador",  e.printStackTrace().toString())
            }
        }

        return resultado.toString()
    }

    // Para arredondamento
    private fun toFloat(text: String): Float {
        return try {
            java.lang.Float.valueOf(text)
        } catch (e: Exception) {
            0f
        }
    }

    private fun toVisor(resultado: Float?): String {
        val numberResult: DecimalFormat = if (resultado == floor(resultado!!.toDouble()).toFloat() && !java.lang.Double.isInfinite(
                resultado.toDouble()
            )
        ) {
            DecimalFormat("#,##0")
        } else {
            DecimalFormat("#,##0.00")
        }
        return numberResult.format(resultado)
    }
}

