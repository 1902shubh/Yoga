package com.cxzcodes.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.Schedule
import com.cxzcodes.adapter.DayAdapter
import com.cxzcodes.adapter.DayWiseAdapter
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.helper.Utils.b_schedule
import com.cxzcodes.helper.Utils.i_schedule
import com.cxzcodes.yoga.R

class DayWiseActivity : AppCompatActivity() {

    private var list = mutableListOf<Schedule>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_wise)

        val day = intent.getIntExtra("day", 0)
        val type = intent.getIntExtra("type", 0)


       getList(day, type)






        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = DayWiseAdapter(list, this)
        recyclerView.adapter = adapter
    }

    private fun getList(day: Int, type: Int) {

        var tempList = mutableListOf<Schedule>()

       list =  when(type){
            0 -> {

                when(day){
                    0-> {
                        for (data in a_schedule){
                            if (data.days == "d1"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }
                    else -> {
                        for (data in a_schedule){
                            if (data.days == "d9"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                }

            }

            1 -> {
                when(day){
                    0-> {
                        for (data in b_schedule){
                            if (data.days == "d1"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }
                    1-> {
                        for (data in b_schedule){
                            if (data.days == "d2"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }
                    2-> {
                        for (data in b_schedule){
                            if (data.days == "d3"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }
                    else -> {
                        for (data in b_schedule){
                            if (data.days == "d29"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                }

            }

            else ->{
                when(day){
                    0-> {
                        for (data in i_schedule){
                            if (data.days == "d1"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }
                    else -> {
                        for (data in i_schedule){
                            if (data.days == "d29"){
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                }

            }
        }



    }
}