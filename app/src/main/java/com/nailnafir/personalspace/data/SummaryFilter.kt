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
        count = summaryContent.count { it.type == SummaryContentType.TASK },
    ),
    SummaryFilterItem(
        label = "Pekerjaan",
        count = summaryContent.count { it.type == SummaryContentType.WORK },
    ),
    SummaryFilterItem(
        label = "Pesan",
        count = summaryContent.count { it.type == SummaryContentType.MESSAGE },
    ),
    SummaryFilterItem(
        label = "Blog",
        count = summaryContent.count { it.type == SummaryContentType.BLOG },
    ),
)