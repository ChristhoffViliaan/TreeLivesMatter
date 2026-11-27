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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.ui.theme.BackgroundCream
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.ButtonInactiveGreen
import com.vp.treelivesmatter.ui.theme.CardBackgroundGreen
import com.vp.treelivesmatter.ui.theme.CardTextGreen
import com.vp.treelivesmatter.ui.theme.InputBorder
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun PrivacyPolicyScreen(
    onBackClick: () -> Unit = {},
    onContinueClick: () -> Unit = {}
) {
    var isChecked by remember { mutableStateOf(false) }

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
                            text = "Privacy Policy",
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
                        text = "LeafLife is committed to protecting your privacy. This policy explains how we collect, use, and safeguard your personal information.",
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
                    title = "1. Information We Collect",
                    content = "We collect information you provide directly: name, email address, and password when you register. We also collect donation history, tree-funding records, and Leaf Points activity. When using the map or field update features, location data may be collected with your permission."
                )

                // Section 2
                SectionItem(
                    title = "2. How We Use Your Information",
                    content = "We use your information to: operate and improve LeafLife; process donations and issue receipts; assign and track unique tree IDs; calculate and display your environmental impact; send notifications about tree growth updates and campaigns; and comply with legal obligations."
                )

                // Section 3
                SectionItem(
                    title = "3. Tree Tracking Data",
                    content = "GPS coordinates and growth data associated with your funded trees are stored to provide the tracking feature. This data is linked to your account and may be aggregated anonymously for environmental impact reporting. It is never sold to third parties."
                )

                // Section 4
                SectionItem(
                    title = "4. Payment Information",
                    content = "LeafLife does not store your full payment credentials. Payment processing is handled by trusted payment gateway partners compliant with PCI-DSS standards. We retain only transaction metadata (amount, date, status) for your records."
                )

                // Section 5
                SectionItem(
                    title = "5. Information Sharing",
                    content = "We do not sell your personal data. We share data with campaign organizers only to the extent necessary to fulfill your donation (e.g., tree planting location and quantity). We may share aggregated, anonymized data for environmental research and reporting."
                )

                // Section 6
                SectionItem(
                    title = "6. Data Retention",
                    content = "We retain your account data for as long as your account is active. Donation and tree records are retained for a minimum of 7 years for legal and environmental impact reporting purposes. You may request deletion of your account data subject to these retention requirements."
                )

                // Section 7
                SectionItem(
                    title = "7. Security",
                    content = "We use industry-standard encryption (TLS) for data in transit and at rest. We enforce access controls and conduct regular security reviews. However, no system is completely secure; we encourage you to use a strong, unique password."
                )

                // Section 8
                SectionItem(
                    title = "8. Your Rights",
                    content = "You have the right to access, correct, or request deletion of your personal data. You may also opt out of marketing emails at any time via the Notifications settings. For requests, contact privacy@leaflife.id."
                )

                // Section 9
                SectionItem(
                    title = "9. Cookies and Analytics",
                    content = "The LeafLife app uses local storage and session state for app functionality. We use anonymized analytics to understand feature usage and improve the product. We do not use third-party advertising trackers."
                )

                // Section 10
                SectionItem(
                    title = "10. Children",
                    content = "LeafLife is not intended for users under 13 years of age. We do not knowingly collect data from children. If you believe a child has registered, contact us immediately."
                )

                // Section 11
                SectionItem(
                    title = "11. Changes to This Policy",
                    content = "We may update this Privacy Policy periodically. We will notify you of material changes via in-app notification or email. Continued use after changes constitutes acceptance."
                )

                // Section 12
                SectionItem(
                    title = "12. Contact",
                    content = "For privacy-related questions, contact our Data Protection team at privacy@leaflife.id or write to: PT Hijau Digital Nusantara, Jakarta, Indonesia."
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Footer Text
                Text(
                    text = "LeafLife Indonesia · PT Hijau Digital Nusantara\nJakarta, Indonesia · privacy@leaflife.id",
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

            // Bottom Sticky Action Area
            Surface(
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Checkbox Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = ButtonActiveGreen,
                                uncheckedColor = InputBorder
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = buildAnnotatedString {
                                append("I have read and agreed to LeafLife's ")
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = ButtonActiveGreen
                                    )
                                ) {
                                    append("Terms of Service")
                                }
                                append(" and ")
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = ButtonActiveGreen
                                    )
                                ) {
                                    append("Privacy Policy")
                                }
                            },
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = TextPrimary,
                                lineHeight = 18.sp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Continue Button
                    Button(
                        onClick = onContinueClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isChecked) ButtonActiveGreen else ButtonInactiveGreen,
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(0.dp)
                    ) {
                        Text(
                            text = "Continue to Sign In  >",
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

@Preview(name = "Privacy Policy - Unchecked", showBackground = true, showSystemUi = true)
@Composable
fun PrivacyPolicyScreenUncheckedPreview() {
    TreeLivesMatterTheme {
        PrivacyPolicyScreen()
    }
}
