package com.vp.treelivesmatter.ui.Screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.LightGreenBadgeBg
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun ReviewStepScreen(
    campaign: DonationCampaign = DonationCampaign(),
    treeCount: Int = 1,
    onPaymentClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    val totalAmount = treeCount * campaign.pricePerTree
    val treePlantingShare = (totalAmount * 0.90).toInt()
    val platformFeeShare = (totalAmount * 0.10).toInt()
    val leafPointsEarned = treeCount * campaign.pointsPerTree
    val co2ImpactKg = treeCount * campaign.co2PerTreeKg

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
                    .padding(16.dp)
            ) {
                // Donation Progress Card (Step 2)
                DonationProgressCard(currentStep = 2, campaign = campaign)

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Review your contribution",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkGreen
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Detailed Review Table Card
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
                        ReviewRow(label = "Campaign", value = campaign.title, isBoldValue = true)
                        ReviewRow(label = "Location", value = campaign.location, isBoldValue = true)
                        ReviewRow(label = "Tree type", value = campaign.treeType, isBoldValue = true)
                        ReviewRow(label = "Trees to fund", value = "$treeCount trees", isBoldValue = true)
                        ReviewRow(label = "Price per tree", value = formatRupiah(campaign.pricePerTree), isBoldValue = true)
                        ReviewRow(label = "Subtotal", value = formatRupiah(totalAmount), isBoldValue = true)
                        ReviewRow(label = "To tree planting (90%)", value = formatRupiah(treePlantingShare), isBoldValue = true)
                        ReviewRow(label = "TreeLivesMatter fee (10%)", value = formatRupiah(platformFeeShare), isBoldValue = true)

                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(color = Color(0xFFE2E8F0), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total paid",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextSecondary
                                )
                            )
                            Text(
                                text = formatRupiah(totalAmount),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ButtonActiveGreen
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Estimated Impact Card
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
                            text = "Estimated impact",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "~${String.format("%,d", co2ImpactKg)} kg CO₂ absorbed per year",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Estimated based on projected tree growth and environmental impact data from the TreeLivesMatter's scientific database. Actual impact depends on survival rate and measured growth.",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextSecondary,
                                lineHeight = 18.sp
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Leaf Points Box
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = LightGreenBadgeBg,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Leaf Points earned",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF65C466)
                                )
                            )
                            Text(
                                text = "+$leafPointsEarned 🍃",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF65C466)
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Payment Primary Button
                Button(
                    onClick = onPaymentClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonActiveGreen,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(0.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Payment",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Next",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Back Button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(onClick = onBackClick) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = ButtonActiveGreen,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Back",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ButtonActiveGreen
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ReviewRow(
    label: String,
    value: String,
    isBoldValue: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary
            )
        )
        Text(
            text = value,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = if (isBoldValue) FontWeight.Bold else FontWeight.Normal,
                color = TextPrimary
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReviewStepScreenPreview() {
    TreeLivesMatterTheme {
        ReviewStepScreen()
    }
}
