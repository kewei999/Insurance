package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
     Toast.makeText(this,"position= "+ position, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener=this
        buttonCalculate.setOnClickListener{
            calculatePremium()


        }

        buttonReset.setOnClickListener{
            reset()
        }

    }

    private fun reset(){
        spinnerAge.setSelection(0)
        if(checkBoxSmoker.isChecked){
            checkBoxSmoker.toggle()
        }
        radioGroupGender.clearCheck()
        textViewInsurancePremium.text=getString(R.string.insurance_premium)
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId
        var premium=0

        premium=when(position){
            0->60
            1->70
            2->90
            3->120
            else->150
        }

        if (gender == R.id.radioButtonMale) {
            premium+=when(position){
                0->0
                1->50
                2->100
                3->150
                else->200
            }
        }

        if (checkBoxSmoker.isChecked) {
            premium+=when(position){
                0->0
                1->100
                2->150
                3->200
                4->250
                else->300
            }
        }

        textViewInsurancePremium.text="RM$premium";
    }
}
