package com.nailnafir.personalspace.ui.component

import android.os.Build
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.xs
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.extensions.format
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DividerProperties
import ir.ehsannarmani.compose_charts.models.DotProperties
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.PopupProperties
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

@Composable
fun OverviewChartCard() {
    val chartLabelHorizontal: List<String> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("dd/MM")
        (6 downTo 0).map {
            LocalDate.now().minusDays(it.toLong()).format(formatter)
        }
    } else {
        val formatter = SimpleDateFormat("dd/MM", Locale.getDefault())
        (6 downTo 0).map {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -it)
            formatter.format(calendar.time)
        }
    }

    Card(
        modifier = Modifier.padding(bottom = xs),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(xs / 2),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(md)
        ) {
            LineChart(
                modifier = Modifier.height(180.dp),
                dotsProperties = DotProperties(
                    enabled = true,
                    color = SolidColor(MaterialTheme.colorScheme.primary),
                ),
                data = listOf(
                    Line(
                        label = "Tugas",
                        values = listOf(4.0, 8.0, 2.0, 12.0, 6.0, 8.0, 4.0),
                        color = SolidColor(MaterialTheme.colorScheme.primary),
                        firstGradientFillColor = MaterialTheme.colorScheme.primary.copy(alpha = .5f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(1000, easing = EaseInOutCubic),
                    ),
                ),
                animationMode = AnimationMode.Together(
                    delayBuilder = {
                        it * 500L
                }),
                gridProperties = GridProperties(enabled = false),
                dividerProperties = DividerProperties(enabled = false),
                popupProperties = PopupProperties(
                    textStyle = MaterialTheme.typography.labelMedium,
                    contentBuilder = {
                        it.format(0)
                    },
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                indicatorProperties = HorizontalIndicatorProperties(
                    textStyle = MaterialTheme.typography.labelMedium,
                    contentBuilder = {
                        it.format(0)
                    },
                ),
                labelHelperProperties = LabelHelperProperties(textStyle = MaterialTheme.typography.labelMedium),
                labelProperties = LabelProperties(
                    enabled = true,
                    labels = chartLabelHorizontal,
                    textStyle = MaterialTheme.typography.labelMedium
                )
            )
        }
    }
}