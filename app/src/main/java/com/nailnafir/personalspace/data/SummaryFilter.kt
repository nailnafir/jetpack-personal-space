package com.nailnafir.personalspace.data

data class SummaryFilterItem(
    val label: String,
    val count: Int,
)

val summaryFilter = listOf(
    SummaryFilterItem(
        label = "Semua",
        count = summaryContent.count(),
    ),
    SummaryFilterItem(
        label = "Tugas",
        count = summaryContent.count { it.type == SummaryContentType.TUGAS },
    ),
    SummaryFilterItem(
        label = "Pekerjaan",
        count = summaryContent.count { it.type == SummaryContentType.PEKERJAAN },
    ),
    SummaryFilterItem(
        label = "Kontak",
        count = summaryContent.count { it.type == SummaryContentType.KONTAK },
    ),
)