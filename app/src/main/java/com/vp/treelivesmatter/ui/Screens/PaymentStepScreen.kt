package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun QrisCodeGraphic(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(200.dp)
            .background(
                color = Color(0xFFF0F4EC),
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(160.dp)) {
            val darkColor = Color(0xFF0C3823)
            val strokeWidth = 14.dp.toPx()
            val innerSize = 28.dp.toPx()
            val outerSize = 48.dp.toPx()

            // 1. Top-Left Corner Box
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(0f, 0f),
                size = Size(outerSize, outerSize),
                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                style = Stroke(width = strokeWidth)
            )
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(10.dp.toPx(), 10.dp.toPx()),
                size = Size(innerSize - 8.dp.toPx(), innerSize - 8.dp.toPx()),
                cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
            )

            // 2. Top-Right Corner Box
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(size.width - outerSize, 0f),
                size = Size(outerSize, outerSize),
                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                style = Stroke(width = strokeWidth)
            )
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(size.width - outerSize + 10.dp.toPx(), 10.dp.toPx()),
                size = Size(innerSize - 8.dp.toPx(), innerSize - 8.dp.toPx()),
                cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
            )

            // 3. Bottom-Left Corner Box
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(0f, size.height - outerSize),
                size = Size(outerSize, outerSize),
                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                style = Stroke(width = strokeWidth)
            )
            drawRoundRect(
                color = darkColor,
                topLeft = Offset(10.dp.toPx(), size.height - outerSize + 10.dp.toPx()),
                size = Size(innerSize - 8.dp.toPx(), innerSize - 8.dp.toPx()),
                cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
            )

            // 4. Center QR Pixel Pattern Dots
            val dotSize = 8.dp.toPx()
            val centerX = size.width * 0.5f
            val centerY = size.height * 0.5f

            val dots = listOf(
                Offset(centerX - 12.dp.toPx(), centerY - 12.dp.toPx()),
                Offset(centerX + 12.dp.toPx(), centerY - 12.dp.toPx()),
                Offset(centerX - 12.dp.toPx(), centerY + 12.dp.toPx()),
                Offset(centerX + 12.dp.toPx(), centerY + 12.dp.toPx()),
                Offset(centerX, centerY),
                Offset(centerX - 20.dp.toPx(), centerY),
                Offset(centerX + 20.dp.toPx(), centerY)
            )

            dots.forEach { dot ->
                drawRoundRect(
                    color = darkColor,
                    topLeft = Offset(dot.x - dotSize / 2, dot.y - dotSize / 2),
                    size = Size(dotSize, dotSize),
                    cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
                )
            }
        }
    }
}

@Composable
fun PaymentStepScreen(
    campaign: DonationCampaign = DonationCampaign(),
    treeCount: Int = 1,
    onPaymentSuccess: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    val totalAmount = treeCount * campaign.pricePerTree

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundCream
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            DonationTopHeader()

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Donation Progress Card (Step 3)
                DonationProgressCard(currentStep = 3, campaign = campaign)

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Scan to Pay",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkGreen
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Scan the QR code with any e-wallet app",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextSecondary
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // QR Code Card
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White,
                    shadowElevation = 2.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Interactive / Clickable QR Code for Demo Payment Simulation
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        ) {
                            QrisCodeGraphic()
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Total amount",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextSecondary
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = formatRupiah(totalAmount),
                            style = TextStyle(
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "QR code expires in 04:57",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextSecondary
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // "How to pay with QRIS" Instructions Card
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFEAF5EE)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "How to pay with QRIS",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        val steps = listOf(
                            "Open any e-wallet or mobile banking app",
                            "Tap \"Scan QR\" or \"Pay via QR\"",
                            "Scan the code above and confirm the amount",
                            "Payment is detected automatically"
                        )

                        steps.forEachIndexed { index, instruction ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .background(
                                            color = PrimaryDarkGreen,
                                            shape = CircleShape
                                        )
                                ) {
                                    Text(
                                        text = "${index + 1}",
                                        style = TextStyle(
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = instruction,
                                    style = TextStyle(
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = TextSecondary
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Simulate Payment Action or Cancel
                TextButton(
                    onClick = onPaymentSuccess,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .background(ButtonActiveGreen, RoundedCornerShape(16.dp))
                ) {
                    Text(
                        text = "Simulate Successful Payment",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(onClick = onCancelClick) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Cancel",
                            tint = ButtonActiveGreen,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Cancel",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = ButtonActiveGreen
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentStepScreenPreview() {
    TreeLivesMatterTheme {
        PaymentStepScreen()
    }
}
