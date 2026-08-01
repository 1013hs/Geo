package com.geosurvey.toolbox.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geosurvey.toolbox.GlassCard

@Composable
fun WatermarkCameraScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        GlassCard {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "📷 水印相机",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00BCD4)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "阶段8开发中...\n\n将集成：\n• CameraX相机\n• 自定义水印叠加\n• 坐标/时间/产状信息\n• 字体/位置/透明度调整",
                    fontSize = 14.sp,
                    color = Color(0xFF80DEEA),
                    lineHeight = 24.sp
                )
            }
        }
    }
}
