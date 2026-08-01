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
fun AttitudeScreen() {
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
                    "📐 产状测量",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00BCD4)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "阶段6开发中...\n\n将集成：\n• 加速度计/陀螺仪传感器\n• 倾向/倾角/走向计算\n• 磁偏角自动校正\n• 数据库记录",
                    fontSize = 14.sp,
                    color = Color(0xFF80DEEA),
                    lineHeight = 24.sp
                )
            }
        }
    }
}
