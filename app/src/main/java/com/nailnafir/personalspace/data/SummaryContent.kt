package com.nailnafir.personalspace.data

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class SummaryContentItem(
    val percentage: Int? = null,
    val like: Int? = null,
    val type: SummaryContentType,
    val title: String,
    val subtitle: String,
    val date: Date,
)

enum class SummaryContentType {
    TUGAS, PEKERJAAN, KONTAK
}

@SuppressLint("ConstantLocale")
private val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

val summaryContent = listOf(
    SummaryContentItem(
        percentage = 86,
        like = null,
        type = SummaryContentType.TUGAS,
        title = "Mempelajari ilmu kebal",
        subtitle = "Ilmu yang sangat disukai oleh manusia modern",
        date = sdf.parse("2025-01-01")!!
    ),
    SummaryContentItem(
        percentage = 77,
        like = null,
        type = SummaryContentType.TUGAS,
        title = "Rapat dengan direktur perusahaan",
        subtitle = "Pembahasan mengenai bisnis model kapitalisasi",
        date = sdf.parse("2025-01-08")!!
    ),
    SummaryContentItem(
        percentage = 38,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "NayBey Menikah",
        subtitle = "Undangan digital berbasis website dengan banyak fitur",
        date = sdf.parse("2025-01-31")!!
    ),
    SummaryContentItem(
        percentage = 94,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "Tayangin",
        subtitle = "Aplikasi pemesanan tiket bioskop online",
        date = sdf.parse("2025-02-02")!!
    ),
    SummaryContentItem(
        percentage = 100,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "Tayangin",
        subtitle = "Aplikasi mobile pemesanan tiket bioskop online",
        date = sdf.parse("2025-02-25")!!
    ),
    SummaryContentItem(
        percentage = 88,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "Pantau COVID-19",
        subtitle = "Aplikasi mobile pelacakan data COVID-19",
        date = sdf.parse("2025-02-25")!!
    ),
    SummaryContentItem(
        percentage = 79,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "L apa R?",
        subtitle = "Aplikasi mobile pemesanan makanan online",
        date = sdf.parse("2025-03-05")!!
    ),
    SummaryContentItem(
        percentage = 79,
        like = null,
        type = SummaryContentType.PEKERJAAN,
        title = "u-POS",
        subtitle = "Aplikasi mobile penjualan lengkap untuk UMKM",
        date = sdf.parse("2025-03-22")!!
    ),
    SummaryContentItem(
        percentage = null,
        like = 128,
        type = SummaryContentType.KONTAK,
        title = "Happy Anniversary",
        subtitle = "Selamat ulang tahun pernikahan ya sayangku",
        date = sdf.parse("2024-09-09")!!
    ),
    SummaryContentItem(
        percentage = null,
        like = 96,
        type = SummaryContentType.KONTAK,
        title = "Happy Wedding",
        subtitle = "Selamat menempuh hidup baru yaaa",
        date = sdf.parse("2023-09-09")!!
    ),
)