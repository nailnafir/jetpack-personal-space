package com.nailnafir.personalspace.data

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class SummaryContentItem(
    val percentageCount: Int? = null,
    val likeCount: Int? = null,
    val readCount: Int? = null,
    val type: SummaryContentType,
    val title: String,
    val subtitle: String,
    val date: Date,
)

enum class SummaryContentType {
    TASK, WORK, MESSAGE, BLOG
}

@SuppressLint("ConstantLocale")
private val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

val summaryContent = listOf(
    SummaryContentItem(
        percentageCount = 86,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.TASK,
        title = "Mempelajari ilmu kebal",
        subtitle = "Ilmu yang sangat disukai oleh manusia modern",
        date = sdf.parse("2025-01-01")!!
    ),
    SummaryContentItem(
        percentageCount = 77,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.TASK,
        title = "Rapat dengan direktur perusahaan",
        subtitle = "Pembahasan mengenai bisnis model kapitalisasi",
        date = sdf.parse("2025-01-08")!!
    ),
    SummaryContentItem(
        percentageCount = 38,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "NayBey Menikah",
        subtitle = "Undangan digital berbasis website dengan banyak fitur",
        date = sdf.parse("2025-01-31")!!
    ),
    SummaryContentItem(
        percentageCount = 94,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "Tayangin",
        subtitle = "Aplikasi pemesanan tiket bioskop online",
        date = sdf.parse("2025-02-02")!!
    ),
    SummaryContentItem(
        percentageCount = 100,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "Tayangin",
        subtitle = "Aplikasi mobile pemesanan tiket bioskop online",
        date = sdf.parse("2025-02-25")!!
    ),
    SummaryContentItem(
        percentageCount = 88,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "Pantau COVID-19",
        subtitle = "Aplikasi mobile pelacakan data COVID-19",
        date = sdf.parse("2025-02-25")!!
    ),
    SummaryContentItem(
        percentageCount = 79,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "L apa R?",
        subtitle = "Aplikasi mobile pemesanan makanan online",
        date = sdf.parse("2025-03-05")!!
    ),
    SummaryContentItem(
        percentageCount = 79,
        likeCount = null,
        readCount = null,
        type = SummaryContentType.WORK,
        title = "u-POS",
        subtitle = "Aplikasi mobile penjualan lengkap untuk UMKM",
        date = sdf.parse("2025-03-22")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = 128,
        readCount = null,
        type = SummaryContentType.MESSAGE,
        title = "Happy Anniversary",
        subtitle = "Selamat ulang tahun pernikahan ya sayangku",
        date = sdf.parse("2025-03-25")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = 96,
        readCount = null,
        type = SummaryContentType.MESSAGE,
        title = "Happy Wedding",
        subtitle = "Selamat menempuh hidup baru yaaa",
        date = sdf.parse("2025-03-25")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = null,
        readCount = 86,
        type = SummaryContentType.BLOG,
        title = "Menjadi superhero kesiangan",
        subtitle = "Diperuntukkan untuk para pemula",
        date = sdf.parse("2025-04-04")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = null,
        readCount = 113,
        type = SummaryContentType.BLOG,
        title = "Menghubungkan koneksi antara manusia dan Tuhan",
        subtitle = "Kita semua bisa terhubung dengan TUhan kok",
        date = sdf.parse("2025-04-25")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = null,
        readCount = 256,
        type = SummaryContentType.BLOG,
        title = "Sobat mengkodingan",
        subtitle = "Senang jika tidak bertemu 'undefined is not function'",
        date = sdf.parse("2025-05-01")!!
    ),
    SummaryContentItem(
        percentageCount = null,
        likeCount = null,
        readCount = 256,
        type = SummaryContentType.BLOG,
        title = "pro_gamer != programmer",
        subtitle = "Niat jadi pemain CS:GO malah jadi ngulik react.js",
        date = sdf.parse("2025-05-08")!!
    ),
)

data class SummaryContentDropdownItem(
    val icon: ImageVector,
    val title: String,
    val subtitle: String,
)

val summaryContentDropdown = listOf(
    SummaryContentDropdownItem(
        icon = Icons.Default.Edit,
        title = "Ubah",
        subtitle = "Ubah informasi",
    ),
    SummaryContentDropdownItem(
        icon = Icons.Default.Delete,
        title = "Hapus",
        subtitle = "Hapus permanen",
    )
)