package my.edu.tarc.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // onCreate = main() function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create the UI
        setContentView(R.layout.activity_main)

        // link the UI to code
        // if R fails to register id, rebuild project at the Build tab above
        val editTextCarPrice: EditText = findViewById(R.id.editTextCarPrice)
        val editTextDownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val editTextLoanPeriod: EditText = findViewById(R.id.editTextLoanPeriod)
        val editTextInterestRate: EditText = findViewById(R.id.editTextInterestRate)
        val textViewMonthlyPayment: TextView = findViewById(R.id.textViewMonthlyPayment)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonReset.setOnClickListener {
            // TODO: Write event handler for the buttonReset
        }

        buttonCalculate.setOnClickListener {
            // TODO: Write event handler for the buttonCalculate
            val carPrice = editTextCarPrice.text.toString().toIntOrNull()
            if (carPrice == null) {
                editTextCarPrice.setError(getString(R.string.value_required))
                return@setOnClickListener // terminate this function
            }
            // or (prefer second one)
            if (editTextDownPayment.text.isEmpty()) {
                editTextDownPayment.setError(getString(R.string.value_required))
                return@setOnClickListener // terminate this function
            }

            val downPayment = editTextDownPayment.text.toString().toInt()
            val loanPeriod = editTextLoanPeriod.text.toString().toShort()
            val interestRate = editTextInterestRate.text.toString().toFloatOrNull()

            val carLoan = carPrice - downPayment
            if (interestRate != null) {
                val interest = carLoan * interestRate * loanPeriod
                val monthly_repayment: Float = ((carLoan + interest) / loanPeriod / 12)

                textViewMonthlyPayment.text = String.format("%.2f", monthly_repayment) // preferred
                textViewMonthlyPayment.setText(monthly_repayment.toString())
            }
        }
    }
}