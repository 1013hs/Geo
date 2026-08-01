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
fun SettingsScreen() {
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
                    "⚙️ 系统设置",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00BCD4)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "配置中心\n\n将集成：\n• 坐标系切换(WGS84/CGCS2000)\n• 高斯-克吕格投影参数\n• 定位参数调整\n• 数据管理",
                    fontSize = 14.sp,
                    color = Color(0xFF80DEEA),
                    lineHeight = 24.sp
                )
            }
        }
    }
}
