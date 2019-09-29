package com.example.calculadoraAndroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class CalculadoraView : AppCompatActivity() {

    lateinit var visor: EditText
    lateinit var buttonMult: Button
    lateinit var buttonAdd: Button
    lateinit var buttonSub: Button
    lateinit var buttonDiv: Button
    lateinit var buttonResult: Button
    lateinit var buttonClean: Button
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var onCalcClick: View.OnClickListener
    lateinit var onCalcResultClick: View.OnClickListener
    lateinit var onCalcCleanClick: View.OnClickListener
    lateinit var calculadoraManager: CalculadoraManager

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_view)

        calculadoraManager = CalculadoraManager()

        visor = findViewById(R.id.visor)
        buttonMult = findViewById(R.id.buttonMult)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSub)
        buttonDiv = findViewById(R.id.buttonDiv)
        buttonResult = findViewById(R.id.buttonResult)
        buttonClean = findViewById(R.id.buttonClean)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        onCalcClick = View.OnClickListener {
            val btn = it as Button

            if (isValidEntry(btn.text.toString()))
                if (visor.text.toString() == "0") {
                    visor.setText("")
                    visor.setText(visor.text.toString() + btn.text.toString())
                } else
                    visor.setText(visor.text.toString() + btn.text.toString())

            visor.setSelection(visor.text.length)
        }

        onCalcResultClick = View.OnClickListener {
            if (visor.text.isNotEmpty())
                visor.setText(calculadoraManager.makeACount(visor.text.toString()))
        }

        onCalcCleanClick = View.OnClickListener {
            visor.setText("")
        }

        init()
    }

    private fun init() {
        buttonMult.setOnClickListener(onCalcClick)
        buttonAdd.setOnClickListener(onCalcClick)
        buttonSub.setOnClickListener(onCalcClick)
        buttonDiv.setOnClickListener(onCalcClick)
        buttonResult.setOnClickListener(onCalcResultClick)
        buttonClean.setOnClickListener(onCalcCleanClick)
        button0.setOnClickListener(onCalcClick)
        button1.setOnClickListener(onCalcClick)
        button2.setOnClickListener(onCalcClick)
        button3.setOnClickListener(onCalcClick)
        button4.setOnClickListener(onCalcClick)
        button5.setOnClickListener(onCalcClick)
        button6.setOnClickListener(onCalcClick)
        button7.setOnClickListener(onCalcClick)
        button8.setOnClickListener(onCalcClick)
        button9.setOnClickListener(onCalcClick)
        button0.setOnClickListener(onCalcClick)
    }

    private fun isValidEntry(entry: String) : Boolean {
        return visor.text.isNotEmpty() ||
               entry != "-" &&
               entry != "+" &&
               entry != "/" &&
               entry != "*"
    }
}
