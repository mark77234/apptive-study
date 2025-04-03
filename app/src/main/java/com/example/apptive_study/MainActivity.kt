package com.example.apptive_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apptive_study.ui.theme.ApptivestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApptivestudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Professors(
                        name = "이완직 교수님",
                        now = 3,
                        image = painterResource(id = R.drawable.leewanjig_professor),
                        profileSize = 100,
                        drawSize = 300,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Professors(name: String, now: Int, image: Painter,profileSize: Int,drawSize: Int, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .width(drawSize.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = image,
                contentDescription = "교수님 사진",
                modifier = Modifier
                    .size(profileSize.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .height(profileSize.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$now minutes ago",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.leewanjig_draw), // 그림 이미지 추가 필요
            contentDescription = "Sample Drawing",
            modifier = Modifier
                .align(Alignment.Start)
                .height(if (!isExpanded) 0.dp else drawSize.dp)
                .clickable { isExpanded = !isExpanded}
        )
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApptivestudyTheme {
        Professors(
            name = "이완직 교수님",
            now = 3,
            image = painterResource(id = R.drawable.leewanjig_professor),
            profileSize = 100,
            drawSize = 300
        )
    }
}