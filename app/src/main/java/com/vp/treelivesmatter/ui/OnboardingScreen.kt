package com.vp.treelivesmatter.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vp.treelivesmatter.R
import com.vp.treelivesmatter.ui.theme.ButtonActiveGreen
import com.vp.treelivesmatter.ui.theme.ButtonInactiveGreen
import com.vp.treelivesmatter.ui.theme.InputBorder
import com.vp.treelivesmatter.ui.theme.PrimaryDarkGreen
import com.vp.treelivesmatter.ui.theme.TextPlaceholder
import com.vp.treelivesmatter.ui.theme.TextPrimary
import com.vp.treelivesmatter.ui.theme.TextSecondary
import com.vp.treelivesmatter.ui.theme.TreeLivesMatterTheme

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.treelivesmatter_icon),
        contentDescription = "TreeLivesMatter Logo",
        modifier = modifier
            .size(112.dp)
            .clip(RoundedCornerShape(26.dp)),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun OnboardingScreen(
    initialName: String = ""
) {
    var name by remember { mutableStateOf(initialName) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 48.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Upper Content Group
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // Logo
                AppLogo()

                Spacer(modifier = Modifier.height(28.dp))

                // Heading Title
                Text(
                    text = "Welcome to\nTreeLivesMatter",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkGreen,
                        lineHeight = 36.sp
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Subtitle
                Text(
                    text = "What is your name?",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextSecondary
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(36.dp))

                // Input Field Container
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Enter your Name",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextSecondary
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Your Name",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPlaceholder
                                )
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = InputBorder,
                            unfocusedBorderColor = InputBorder,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    // Continue Button
                    val isEntered = name.isNotBlank()
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isEntered) ButtonActiveGreen else ButtonInactiveGreen,
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(0.dp)
                    ) {
                        Text(
                            text = "Continue",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    }
                }
            }

            // Bottom Terms & Privacy Disclaimer
            Text(
                text = buildAnnotatedString {
                    append("By continuing, you agree to TreeLivesMatter's ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = ButtonActiveGreen
                        )
                    ) {
                        append("Terms\nof Service")
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
                    append(".")
                },
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextSecondary,
                    lineHeight = 18.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(name = "Empty State", showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenEmptyPreview() {
    TreeLivesMatterTheme {
        OnboardingScreen(initialName = "")
    }
}

@Preview(name = "Filled State", showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreenFilledPreview() {
    TreeLivesMatterTheme {
        OnboardingScreen(initialName = "Christhoff")
    }
}
