package com.cxzcodes.activity

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.Schedule
import com.cxzcodes.adapter.DayWiseAdapter
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.helper.Utils.b_schedule
import com.cxzcodes.helper.Utils.i_schedule
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.databinding.ActivityDayWiseBinding

class DayWiseActivity : AppCompatActivity() {

    private var list = mutableListOf<Schedule>()
    private var thirdcate = mutableListOf<Schedule>()
    lateinit var binding: ActivityDayWiseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDayWiseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val day = intent.getIntExtra("day", 0)

        val type = intent.getIntExtra("type", 0)
        binding.ivback.setOnClickListener {
            finish()
        }
        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)
        getList(day, type)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val adapter = DayWiseAdapter(list, this)
        recyclerView.adapter = adapter
d("DATA",list.toString())
    }

    private fun getList(day: Int, type: Int) {

        var tempList = mutableListOf<Schedule>()
//        for (data in b_schedule) {
//
//            if (data.days == "d1" || data.days == "d2") {
//                tempList.add(data)
//                d("DATA",data.days)
//
//            }
//        }
        list = when (type) {
            0 -> {

                when (day) {
                    0 -> {
                        for (data in b_schedule) {
                            if (data.days == "d1"  ) {
                                tempList.add(data)
                                d("DATA",data.days)

                            }
                        }
                        tempList
                    }

                    1 -> {
                        for (data in b_schedule) {

                            if (data.days == "d2" ) {
                                tempList.add(data)

                            }
                        }
                        tempList
                    }

                    2 -> {
                        for (data in b_schedule) {
                            if (data.days == "d3"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    3 -> {
                        for (data in b_schedule) {
                            if (data.days == "d5"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    4 -> {
                        for (data in b_schedule) {
                            if (data.days == "d6" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    5 -> {
                        for (data in b_schedule) {
                            if (data.days == "d7"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    6 -> {
                        for (data in b_schedule) {
                            if (data.days == "d9"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    7 -> {
                        for (data in b_schedule) {
                            if (data.days == "d10" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    8 -> {
                        for (data in b_schedule) {
                            if (data.days == "d11" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    9 -> {
                        for (data in b_schedule) {
                            if (data.days == "d13" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    10 -> {
                        for (data in b_schedule) {
                            if (data.days == "d14" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    11 -> {
                        for (data in b_schedule) {
                            if (data.days == "d15"||data.days == "d16") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    12 -> {
                        for (data in b_schedule) {
                            if (data.days == "d17"||data.days == "d18") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    13 -> {
                        for (data in b_schedule) {
                            if (data.days == "d19"||data.days == "d20") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    14 -> {
                        for (data in b_schedule) {
                            if (data.days == "d21"||data.days == "d22") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    15 -> {
                        for (data in b_schedule) {
                            if (data.days == "d23"||data.days == "d24") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    16 -> {
                        for (data in b_schedule) {
                            if (data.days == "d25"||data.days == "d26") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

//                    17 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "27"||data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }

//                    18 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d19"|| data.days == "d20") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    19 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d20") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    20 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d21") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    21 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d22") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    22 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d23") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    23 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d24") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    24 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d25") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    25 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d26") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    26 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d27") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    27 -> {
//                        for (data in b_schedule) {
//                            if (data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
                    else -> {
                        for (data in b_schedule) {
                            if (data.days == "d27"||data.days == "d28") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                }

            }

            1 -> {
                when (day) {
                    0 -> {
                        for (data in i_schedule) {
                            if (data.days == "d1"  ) {
                                tempList.add(data)
                                d("DATA",data.days)

                            }
                        }
                        tempList
                    }

                    1 -> {
                        for (data in i_schedule) {

                            if (data.days == "d2" ) {
                                tempList.add(data)

                            }
                        }
                        tempList
                    }

                    2 -> {
                        for (data in i_schedule) {
                            if (data.days == "d3"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    3 -> {
                        for (data in i_schedule) {
                            if (data.days == "d5"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    4 -> {
                        for (data in i_schedule) {
                            if (data.days == "d6" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    5 -> {
                        for (data in i_schedule) {
                            if (data.days == "d7"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    6 -> {
                        for (data in i_schedule) {
                            if (data.days == "d9"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    7 -> {
                        for (data in i_schedule) {
                            if (data.days == "d10" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    8 -> {
                        for (data in i_schedule) {
                            if (data.days == "d11" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    9 -> {
                        for (data in i_schedule) {
                            if (data.days == "d13" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    10 -> {
                        for (data in i_schedule) {
                            if (data.days == "d14" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    11 -> {
                        for (data in i_schedule) {
                            if (data.days == "d15"||data.days == "d16") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    12 -> {
                        for (data in i_schedule) {
                            if (data.days == "d17"||data.days == "d18") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    13 -> {
                        for (data in i_schedule) {
                            if (data.days == "d19"||data.days == "d20") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    14 -> {
                        for (data in i_schedule) {
                            if (data.days == "d21"||data.days == "d22") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    15 -> {
                        for (data in i_schedule) {
                            if (data.days == "d23"||data.days == "d24") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    16 -> {
                        for (data in i_schedule) {
                            if (data.days == "d25"||data.days == "d26") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

//                    17 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "27"||data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    18 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d19") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    19 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d20") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    20 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d21") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    21 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d22") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    22 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d23") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    23 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d24") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    24 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d25") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    25 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d26") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    26 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d27") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    27 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    28 -> {
//                        for (data in i_schedule) {
//                            if (data.days == "d29") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }


                    else -> {
                        for (data in i_schedule) {
                            if (data.days == "d27"||data.days == "d28") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                }

            }

            else -> {
                when (day) {
                    0 -> {
                        for (data in a_schedule) {
                            if (data.days == "d1"  ) {
                                tempList.add(data)
                                d("DATA",data.days)

                            }
                        }
                        tempList
                    }

                    1 -> {
                        for (data in a_schedule) {

                            if (data.days == "d2" ) {
                                tempList.add(data)

                            }
                        }
                        tempList
                    }

                    2 -> {
                        for (data in a_schedule) {
                            if (data.days == "d4"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    3 -> {
                        for (data in a_schedule) {
                            if (data.days == "d5"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    4 -> {
                        for (data in a_schedule) {
                            if (data.days == "d7" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    5 -> {
                        for (data in a_schedule) {
                            if (data.days == "d8"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    6 -> {
                        for (data in a_schedule) {
                            if (data.days == "d10"  ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    7 -> {
                        for (data in a_schedule) {
                            if (data.days == "d11" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    8 -> {
                        for (data in a_schedule) {
                            if (data.days == "d13" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    9 -> {
                        for (data in a_schedule) {
                            if (data.days == "d14" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    10 -> {
                        for (data in a_schedule) {
                            if (data.days == "d16" ) {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    11 -> {
                        for (data in a_schedule) {
                            if (data.days == "d17"||data.days == "d18") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    12 -> {
                        for (data in a_schedule) {
                            if (data.days == "d19"||data.days == "d20") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    13 -> {
                        for (data in a_schedule) {
                            if (data.days == "d21"||data.days == "d22") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    14 -> {
                        for (data in a_schedule) {
                            if (data.days == "d23"||data.days == "d24") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    15 -> {
                        for (data in a_schedule) {
                            if (data.days == "d25"||data.days == "d26") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

                    16 -> {
                        for (data in a_schedule) {
                            if (data.days == "d27"||data.days == "d28") {
                                tempList.add(data)
                            }
                        }
                        tempList
                    }

//                    17 -> {
//                        for (data in a_schedule) {
//                            if (data.days == "27"||data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    18 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d19") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    19 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d20") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    20 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d21") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    21 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d22") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    22 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d23") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    23 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d24") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    24 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d25") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    25 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d26") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    26 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d27") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    27 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d28") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }
//
//                    28 -> {
//                        for (data in Utils.a_schedule) {
//                            if (data.days == "d29") {
//                                tempList.add(data)
//                            }
//                        }
//                        tempList
//                    }

                    else -> {
                        for (data in Utils.a_schedule) {
                            if (data.days == "d29"||data.days == "d30") {
                                tempList.add(data)
                            }
                        }
                        tempList

                    }

                }

            }
        }

        Log.d("DATA", "Resulting List: $list")

    }
}