package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Park
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.R
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun CelebrationTreeGraphic(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.treelivesmatter_icon),
        contentDescription = "TreeLivesMatter Brand Logo",
        modifier = modifier
            .size(136.dp)
            .clip(RoundedCornerShape(32.dp)),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun SuccessStepScreen(
    treeCount: Int = 1,
    campaign: DonationCampaign = DonationCampaign(),
    onTrackTreesClick: () -> Unit = {},
    onExploreClick: () -> Unit = {}
) {
    val leafPointsEarned = treeCount * campaign.pointsPerTree
    val co2ImpactKg = treeCount * campaign.co2PerTreeKg
    val co2Formatted = if (co2ImpactKg >= 1000) String.format("%.1fK", co2ImpactKg / 1000.0) else "$co2ImpactKg"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundCream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // Brand Logo Celebration Graphic
                CelebrationTreeGraphic()

                Spacer(modifier = Modifier.height(24.dp))

                // Headline
                Text(
                    text = "You just planted $treeCount\ntrees.",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkGreen,
                        lineHeight = 34.sp
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Subtitle
                Text(
                    text = "Your trees will be tracked from planting to growth. Watch them thrive!",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextSecondary,
                        lineHeight = 22.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Summary Stats Card
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
                        // Stat Row 1: Trees Funded
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFF7FAF6),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Outlined.Park,
                                    contentDescription = "Trees",
                                    tint = ButtonActiveGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Trees Funded",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = TextSecondary
                                    )
                                )
                            }
                            Text(
                                text = "+$treeCount Trees",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ButtonActiveGreen
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Stat Row 2: Leaf Points Earned
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFF7FAF6),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Outlined.Eco,
                                    contentDescription = "Leaf Points",
                                    tint = Color(0xFF65C466),
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Leaf Points Earned",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = TextSecondary
                                    )
                                )
                            }
                            Text(
                                text = "+$leafPointsEarned Points",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF65C466)
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Stat Row 3: Est CO2 Impact
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFF7FAF6),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Outlined.Cloud,
                                    contentDescription = "CO2 Impact",
                                    tint = TextSecondary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Est. CO₂ Impact",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = TextSecondary
                                    )
                                )
                            }
                            Text(
                                text = "~$co2Formatted kg/yr",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Information Banner
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFEAF5EE),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Language,
                            contentDescription = "Monitored",
                            tint = PrimaryDarkGreen,
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 2.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Your trees will be assigned unique TreeLivesMatter IDs and monitored with regular field update.",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryDarkGreen,
                                lineHeight = 19.sp
                            )
                        )
                    }
                }
            }

            // Bottom Buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Button(
                    onClick = onTrackTreesClick,
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
                    Text(
                        text = "Track My Trees",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(onClick = onExploreClick) {
                        Text(
                            text = "Explore More Campaigns",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = ButtonActiveGreen
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuccessStepScreenPreview() {
    TreeLivesMatterTheme {
        SuccessStepScreen()
    }
}
