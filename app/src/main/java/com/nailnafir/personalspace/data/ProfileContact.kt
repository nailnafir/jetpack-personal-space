package com.nailnafir.personalspace.data

import com.nailnafir.personalspace.R

data class ProfileContact(
    val iconResId: Int,
    val label: String,
    val type: String,
)

val profileContactItem = listOf(
    ProfileContact(
        iconResId = R.drawable.baseline_link_24,
        type = "Situs",
        label = "https://nailnafir.github.io/"
    ),
    ProfileContact(
        iconResId = R.drawable.baseline_email_24,
        type = "Email",
        label = "nail.nafir@gmail.com"
    ),
    ProfileContact(
        iconResId = R.drawable.baseline_phone_24,
        type = "Telepon",
        label = "+62 812 8807 0110"
    ),
)