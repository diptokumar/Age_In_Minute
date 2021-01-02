package com.example.myapplication
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btnDatePicker.setOnClickListener{view->
    clickDatepicker(view)


}
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatepicker(view: View){
        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get(Calendar.YEAR)
        val month = mycalendar.get(Calendar.MONTH)
        val dayOfMonth = mycalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->   Toast.makeText(
                this, "DatePicker works $year $month $dayOfMonth" , Toast.LENGTH_LONG
        ).show()
        val selecteddate = "$dayOfMonth/${month+1}/$year"
            tvselecteddate.setText(selecteddate)
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val thedate = sdf.parse(selecteddate)
            val selecteddateinmin = thedate!!.time / 60000
            val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentdateinmin = currentdate!!.time/ 60000
            val difference = currentdateinmin - selecteddateinmin
            Selecteddateinmin.setText(difference.toString())
        },year,month,dayOfMonth)

        dpd.datePicker.setMaxDate(Date().time- 8640000)
        dpd.show()
    }
}