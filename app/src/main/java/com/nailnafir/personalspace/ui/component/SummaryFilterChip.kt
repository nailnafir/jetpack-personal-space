package com.nailnafir.personalspace.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            containerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
            labelColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = FilterChipDefaults.filterChipElevation(if (selected) xs / 2 else 0.dp),
    )
}