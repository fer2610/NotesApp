package com.ejercicios.notesappfinal.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ejercicios.notesappfinal.R

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logouni),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop

        )
        Text(
            text = "Proyecto: App de Notas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF16423C)
        )
        Button(
            onClick = { navController.navigate("notes_list") },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = "Iniciar")
        }
        Text(
            text = "Torres Viniegra Fernando Erubiel",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.End)
        )
    }
}