package com.gmail.vladkhinski.homework_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gmail.vladkhinski.homework_kotlin.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = requireNotNull(_binding) { "View was Destroyed" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btn0.setOnClickListener {
                val str = "0"
                mainView.append(str)
            }
            btn1.setOnClickListener {
                val str = "1"
                mainView.append(str)
            }
            btn2.setOnClickListener {
                val str = "2"
                mainView.append(str)
            }
            btn3.setOnClickListener {
                val str = "3"
                mainView.append(str)
            }
            btn4.setOnClickListener {
                val str = "4"
                mainView.append(str)
            }
            btn5.setOnClickListener {
                val str = "5"
                mainView.append(str)
            }
            btn6.setOnClickListener {
                val str = "6"
                mainView.append(str)
            }
            btn7.setOnClickListener {
                val str = "7"
                mainView.append(str)
            }
            btn8.setOnClickListener {
                val str = "8"
                mainView.append(str)
            }
            btn9.setOnClickListener {
                val str = "9"
                mainView.append(str)
            }
            plusButton.setOnClickListener {
                val str = "+"
                if (resultView.text != "") {
                    mainView.text = ""
                    mainView.text = resultView.text
                    resultView.text = ""
                }
                mainView.append(str)
            }
            minusButtonButton.setOnClickListener {
                val str = "-"
                if (resultView.text != "") {
                    mainView.text = ""
                    mainView.text = resultView.text
                    resultView.text = ""
                }
                mainView.append(str)
            }
            multiplyButton.setOnClickListener {
                val str = "*"
                if (resultView.text != "") {
                    mainView.text = ""
                    mainView.text = resultView.text
                    resultView.text = ""
                }
                mainView.append(str)
            }
            divButton.setOnClickListener {
                val str = "/"
                if (resultView.text != "") {
                    mainView.text = ""
                    mainView.text = resultView.text
                    resultView.text = ""
                }
                mainView.append(str)
            }
            clearButton.setOnClickListener {
                val str = mainView.text
                mainView.text = str.substring(0, str.length - 1)
                resultView.text = ""
            }
            closeBracketButton.setOnClickListener {
                val str = ")"
                mainView.append(str)
            }
            opnBracketButton.setOnClickListener {
                val str = "("
                mainView.append(str)
            }
            clearView.setOnClickListener {
                mainView.text = ""
                resultView.text = ""
            }
            dotButton.setOnClickListener {
                val str = "."
                mainView.append(str)
            }
            equalsButton.setOnClickListener {
                try {
                    val ex = ExpressionBuilder(mainView.text.toString()).build()
                    val result = ex.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        resultView.text = longResult.toString()
                    } else {
                        resultView.text = result.toString()
                    }
                } catch (e: Exception) {
                    Toast.makeText(root.context, "Invalid expression", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}