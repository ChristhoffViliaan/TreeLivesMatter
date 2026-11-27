package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vp.treelivesmatter.R
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.StepperInactive
import com.vp.treelivesmatter.ui.theme.StepperInactiveText
import com.vp.treelivesmatter.ui.theme.TextSecondary
import java.text.NumberFormat
import java.util.Locale

// Reusable Campaign Data Model
data class DonationCampaign(
    val id: String = "1",
    val title: String = "Restore the Mangroves of Demak",
    val location: String = "Demak, Central Java",
    val isVerified: Boolean = true,
    val treeType: String = "Trembesi (Samanea saman)",
    val pricePerTree: Int = 15000,
    val pointsPerTree: Int = 50,
    val co2PerTreeKg: Int = 28448,
    val imageResId: Int? = R.drawable.treelivesmatter_icon
)

fun formatRupiah(amount: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("id-ID"))
    return "Rp ${formatter.format(amount)}"
}


@Composable
fun DonationTopHeader() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Donate",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryDarkGreen
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Follow the steps to donate your trees",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextSecondary
                )
            )
        }
    }
    HorizontalDivider(color = Color(0xFFE2E8F0), thickness = 1.dp)
}

@Composable
fun DonationProgressCard(
    currentStep: Int, // 1, 2, 3, or 4
    campaign: DonationCampaign
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Donation Progress",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryDarkGreen
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Stepper Row
            val steps = listOf("Tree & Qty", "Review", "Payment", "Success")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                steps.forEachIndexed { index, title ->
                    val stepNum = index + 1
                    val isActive = stepNum == currentStep
                    val isPast = stepNum < currentStep

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(28.dp)
                                .background(
                                    color = if (isActive) ButtonActiveGreen else if (isPast) ButtonActiveGreen.copy(alpha = 0.8f) else StepperInactive,
                                    shape = CircleShape
                                )
                        ) {
                            Text(
                                text = "$stepNum",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isActive || isPast) Color.White else StepperInactiveText
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = title,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                                color = if (isActive) PrimaryDarkGreen else TextSecondary,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    if (index < steps.size - 1) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .height(2.dp)
                                .background(if (stepNum < currentStep) ButtonActiveGreen else StepperInactive)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campaign Info Box
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFEAF0EB),
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (campaign.imageResId != null) {
                    Image(
                        painter = painterResource(id = campaign.imageResId),
                        contentDescription = campaign.title,
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .background(ButtonActiveGreen, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🌴", fontSize = 24.sp)
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = campaign.title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryDarkGreen
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "📍 ${campaign.location} ${if (campaign.isVerified) "· Verified Campaign" else ""}",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = TextSecondary
                        )
                    )
                }
            }
        }
    }
}
