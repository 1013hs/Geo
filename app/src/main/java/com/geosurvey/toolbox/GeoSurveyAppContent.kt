package com.geosurvey.toolbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geosurvey.toolbox.ui.screens.*

@Composable
fun GeoSurveyAppContent() {
    val navController = rememberNavController()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D1B1E),
                        Color(0xFF1A2F33),
                        Color(0xFF0D1B1E)
                    )
                )
            )
    ) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") { HomeScreen(navController) }
            composable("gnss") { GnssScreen() }
            composable("track") { TrackScreen() }
            composable("attitude") { AttitudeScreen() }
            composable("analysis") { AnalysisScreen() }
            composable("camera") { WatermarkCameraScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}

@Composable
fun HomeScreen(navController: androidx.navigation.NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        
        // 标题
        Text(
            text = "🏔️ 地质勘查工具箱",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00BCD4)
        )
        
        Text(
            text = "GeoSurvey Toolbox v1.0.0",
            fontSize = 14.sp,
            color = Color(0xFF80DEEA),
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // 功能网格
        val features = listOf(
            Triple("🛰️ GNSS定位", "高精度多星座定位", "gnss"),
            Triple("📍 轨迹记录", "后台持续记录轨迹", "track"),
            Triple("📐 产状测量", "岩层倾向倾角测量", "attitude"),
            Triple("📊 地质分析", "赤平投影与玫瑰花图", "analysis"),
            Triple("📷 水印相机", "地质调查水印照片", "camera"),
            Triple("⚙️ 系统设置", "坐标系与参数配置", "settings")
        )
        
        features.chunked(2).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                row.forEach { (title, desc, route) ->
                    FeatureCard(
                        title = title,
                        description = desc,
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate(route) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // 底部状态栏
        GlassCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatusIndicator("GPS", true)
                StatusIndicator("北斗", true)
                StatusIndicator("GLONASS", true)
                StatusIndicator("Galileo", true)
            }
        }
    }
}

@Composable
fun FeatureCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFE0F7FA)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                fontSize = 11.sp,
                color = Color(0xFF80DEEA)
            )
        }
    }
}

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(16.dp)
    val cardModifier = modifier
        .clip(shape)
        .background(
            color = Color(0x1AFFFFFF),
            shape = shape
        )
    
    if (onClick != null) {
        OutlinedCard(
            onClick = onClick,
            modifier = cardModifier,
            shape = shape,
            colors = CardDefaults.outlinedCardColors(
                containerColor = Color(0x1AFFFFFF)
            ),
            border = CardDefaults.outlinedCardBorder().copy(
                brush = androidx.compose.ui.graphics.SolidColor(Color(0x33FFFFFF))
            )
        ) {
            Column(content = content)
        }
    } else {
        Card(
            modifier = cardModifier,
            shape = shape,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x1AFFFFFF)
            )
        ) {
            Column(content = content)
        }
    }
}

@Composable
fun StatusIndicator(label: String, active: Boolean) {
    val color = if (active) Color(0xFF00E676) else Color(0xFF757575)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFFB0BEC5)
        )
    }
}
