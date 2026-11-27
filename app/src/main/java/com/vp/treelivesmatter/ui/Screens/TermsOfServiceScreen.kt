package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.vp.treelivesmatter.ui.theme.CardBackgroundGreen
import com.vp.treelivesmatter.ui.theme.CardTextGreen
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun TermsOfServiceScreen(
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top App Bar Header
            Surface(
                shadowElevation = 2.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = TextPrimary
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Column {
                        Text(
                            text = "Terms of Service",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                        )
                        Text(
                            text = "Last updated: August 2026",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextSecondary
                            )
                        )
                    }
                }
            }

            // Scrollable Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(BackgroundCream)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Callout Banner
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = CardBackgroundGreen,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Please read these Terms of Service carefully before using LeafLife. By using the app, you agree to be bound by these terms.",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = CardTextGreen,
                            lineHeight = 20.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Section 1
                SectionItem(
                    title = "1. Acceptance of Terms",
                    content = "By creating an account or using TreeLivesMatter, you agree to these Terms of Service. If you do not agree, do not use the platform. We may update these terms at any time; continued use constitutes acceptance of the revised terms."
                )

                // Section 2
                SectionItem(
                    title = "2. Platform Description",
                    content = "LeafLife is a sustainability platform that connects donors with verified reforestation campaign organizers. TreeLivesMatter acts as an intermediary, facilitating donations and providing tree-tracking technology. We do not directly conduct reforestation activities."
                )

                // Section 3
                SectionItem(
                    title = "3. Donations and Payments",
                    content = "All donations are processed securely. A platform fee of 10% is deducted from each donation to fund operations, GPS tracking technology, satellite monitoring, and the field verification program. The remaining 90% is allocated to tree planting and campaign operations. Donations are non-refundable once processed."
                )

                // Section 5
                SectionItem(
                    title = "5. Campaign Organizers",
                    content = "Campaign organizers are independently verified by TreeLivesMatter before their campaigns are made public. Verification includes document review and field assessment. TreeLivesMatter reserves the right to reject or suspend campaigns that do not meet verification standards."
                )

                // Section 6
                SectionItem(
                    title = "6. Environmental Impact Estimates",
                    content = "CO₂ absorption, biodiversity, and other impact figures shown are estimates based on scientific species data. Actual outcomes depend on tree survival rates, local conditions, and growth trajectories. These figures are indicative, not guaranteed."
                )

                // Section 7
                SectionItem(
                    title = "7. Leaf Points and Rewards",
                    content = "Leaf Points are earned for each tree funded and can be redeemed for rewards listed in the app. Points have no cash value and cannot be transferred. LeafLife reserves the right to modify, suspend, or discontinue the rewards program at any time."
                )

                // Section 8
                SectionItem(
                    title = "8. User Conduct",
                    content = "You agree not to misuse the platform, provide false information, attempt to circumvent the verification system, or interfere with other users or organizers. Violations may result in account suspension or termination."
                )

                // Section 9
                SectionItem(
                    title = "9. Intellectual Property",
                    content = "All content, branding, and technology on LeafLife are owned by or licensed to LeafLife. You may not reproduce, distribute, or create derivative works without explicit written permission."
                )

                // Section 10
                SectionItem(
                    title = "10. Limitation of Liability",
                    content = "To the fullest extent permitted by law, LeafLife is not liable for indirect, incidental, or consequential damages arising from use of the platform, donation outcomes, or campaign results."
                )

                // Section 11
                SectionItem(
                    title = "11. Governing Law",
                    content = "These terms are governed by the laws of the Republic of Indonesia. Disputes shall be resolved in the courts of Jakarta, Indonesia."
                )

                // Section 12
                SectionItem(
                    title = "12. Contact",
                    content = "For questions about these Terms, contact us at legal@leaflife.id."
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Footer Text
                Text(
                    text = "LeafLife Indonesia · PT Hijau Digital Nusantara\nJakarta, Indonesia · legal@leaflife.id",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextSecondary,
                        lineHeight = 18.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Bottom Sticky Button Area
            Surface(
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = onNextClick,
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
                            text = "Next: Privacy Policy  >",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SectionItem(
    title: String,
    content: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = content,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary,
                lineHeight = 19.sp
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TermsOfServiceScreenPreview() {
    TreeLivesMatterTheme {
        TermsOfServiceScreen()
    }
}
