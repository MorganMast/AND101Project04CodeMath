package com.example.and101_project04_codemath

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import java.math.BigDecimal
//import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.and101_project04_codemath.ui.theme.AND101Project04CodeMathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.btnCalculate)
        val resultTextView: TextView = findViewById(R.id.txtV5)
        val edtTxt: EditText = findViewById(R.id.edtTxt)

        calculateButton.setOnClickListener {
            val ticketNum: BigDecimal = edtTxt.text.toString().toBigDecimalOrNull() ?: BigDecimal.ZERO
            val result = performCalculation(ticketNum)
            val formattedResult = String.format("%.12f", result)

            resultTextView.text = formattedResult + "%"
        }
    }

    private fun performCalculation(ticketNum: BigDecimal): BigDecimal {
        val powerballOdds = BigDecimal("292201338.00")
        return ticketNum.divide(powerballOdds, 20, BigDecimal.ROUND_HALF_UP)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AND101Project04CodeMathTheme {
        Greeting("Android")
    }


}
/*
Not enough information to infer type variable T:21
Too many arguments for private final fun performCalculation(): Int defined in com.example.and101_project04_codemath.MainActivity :25
Unresolved reference: ticketNum:27
 */