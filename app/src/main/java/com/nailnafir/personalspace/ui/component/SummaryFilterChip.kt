package com.nailnafir.personalspace.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.xs

@Composable
fun SummaryFilterChip(
    label: String,
    count: Int,
    selected: Boolean,
    onClick: () -> Unit,
) {
    ElevatedFilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
            )
            Spacer(modifier = Modifier.width(xs))
            Text(
                text = "($count)",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Light
                ),
            )
        },
        colors = FilterChipDefaults.elevatedFilterChipColors(
            containerColor = MaterialTheme.colorScheme.background,
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.background,
        ),
        shape = RoundedCornerShape(md),
        elevation = FilterChipDefaults.filterChipElevation(xs / 2),
    )
}