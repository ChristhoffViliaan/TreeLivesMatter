package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.FeeBannerBackground
import com.vp.treelivesmatter.ui.theme.FeeBannerText
import com.vp.treelivesmatter.ui.theme.InputBorder
import com.vp.treelivesmatter.ui.theme.LightGreenBadgeBg
import com.vp.treelivesmatter.ui.theme.LightGreenBadgeText
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun TreeQuantityStepScreen(
    campaign: DonationCampaign = DonationCampaign(),
    onNextClick: (treeCount: Int) -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    var treeCount by remember { mutableIntStateOf(1) }

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
                // Donation Progress Card (Step 1)
                DonationProgressCard(currentStep = 1, campaign = campaign)

                Spacer(modifier = Modifier.height(24.dp))

                // How Many Trees Header
                Text(
                    text = "How many trees?",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkGreen
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Counter Control Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Minus Button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                color = Color(0xFFF1F3EC),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .clickable { if (treeCount > 1) treeCount-- }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Decrease",
                            tint = PrimaryDarkGreen
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp))

                    // Quantity Display
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "$treeCount",
                            style = TextStyle(
                                fontSize = 44.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )
                        Text(
                            text = "trees",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = TextSecondary
                            )
                        )
                    }

                    Spacer(modifier = Modifier.width(32.dp))

                    // Plus Button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                color = Color(0xFFE2F0DC),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = ButtonActiveGreen,
                                shape = RoundedCornerShape(14.dp)
                            )
                            .clickable { treeCount++ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Increase",
                            tint = ButtonActiveGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Quick Select Chips Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val presets = listOf(1, 3, 5)
                    presets.forEach { count ->
                        val isSelected = treeCount == count
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(horizontal = 6.dp)
                                .background(
                                    color = if (isSelected) Color(0xFFE2F0DC) else Color.White,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) ButtonActiveGreen else InputBorder,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable { treeCount = count }
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                        ) {
                            Text(
                                text = "$count tree${if (count > 1) "s" else ""}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) PrimaryDarkGreen else TextSecondary
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Donation Breakdown Card
                val totalAmount = treeCount * campaign.pricePerTree
                val treePlantingShare = (totalAmount * 0.90).toInt()
                val platformFeeShare = (totalAmount * 0.10).toInt()
                val leafPointsEarned = treeCount * campaign.pointsPerTree

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
                            text = "Donation breakdown",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Tree Calculation Line
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "$treeCount × ${campaign.treeType.split(" ").first()} @ ${formatRupiah(campaign.pricePerTree)}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = TextSecondary
                                )
                            )
                            Text(
                                text = formatRupiah(totalAmount),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryDarkGreen
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // 90% Share
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "To tree planting (90%)",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = TextSecondary
                                )
                            )
                            Text(
                                text = formatRupiah(treePlantingShare),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ButtonActiveGreen
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // 10% Fee
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "TreeLivesMatter platform fee (10%)",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = TextSecondary
                                )
                            )
                            Text(
                                text = formatRupiah(platformFeeShare),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextSecondary
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(color = Color(0xFFE2E8F0), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(16.dp))

                        // Total Paid
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total paid",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryDarkGreen
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
                                    fontWeight = FontWeight.Normal,
                                    color = TextSecondary
                                )
                            )
                            Text(
                                text = "+$leafPointsEarned 🍃",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ButtonActiveGreen
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Platform Fee Banner
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = FeeBannerBackground,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Platform fee supports TreeLivesMatter's operations, GPS tree tracking technology, satellite monitoring, and the field verification program.",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = FeeBannerText,
                            lineHeight = 18.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Primary Review Button
                Button(
                    onClick = { onNextClick(treeCount) },
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
                            text = "Review Contribution",
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

                // Cancel Button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
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
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TreeQuantityStepScreenPreview() {
    TreeLivesMatterTheme {
        TreeQuantityStepScreen()
    }
}
