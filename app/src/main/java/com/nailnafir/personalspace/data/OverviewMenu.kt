package com.nailnafir.personalspace.data

import com.nailnafir.personalspace.R

data class OverviewMenuItem(
    val title: String,
    val count: Int,
    val iconResId: Int
)

val overviewMenu = listOf(
    OverviewMenuItem(
        title = "Pekerjaan",
        count = 120,
        iconResId = R.drawable.baseline_home_repair_service_24
    ),
    OverviewMenuItem(
        title = "Pesan",
        count = 12,
        iconResId = R.drawable.baseline_chat_24
    ),
)