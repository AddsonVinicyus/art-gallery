package com.example.artgallery

import android.R.attr.elevation
import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace(modifier = Modifier
                        .wrapContentSize(Alignment.BottomCenter))
                }

            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier){

    var result by remember { mutableStateOf(1) }

    val imageResource = when(result){
        1 -> listOf(R.drawable.sala_de_aula, "Sala de aula", "Addson Vinicyus", "2025")
        2 -> listOf<Any>(R.drawable.pc, "Computador do quarto", "Addson Vinicyus", "2025")
        else -> listOf<Any>(R.drawable.livro, "Livro seminovo", "Addson Vinicyus", "2025")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ){

        Surface(
            color = Color.White,
            tonalElevation = 50.dp,
            modifier = modifier
                .padding(40.dp)
                .fillMaxWidth()
                .shadow(12.dp, RoundedCornerShape(0.dp))
        ) {
            Image(
                painter = painterResource(imageResource[0] as Int),
                contentDescription = null,
                modifier = modifier.padding(35.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Surface(
            color = Color(0xFFecebf4),
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier
                    .padding(15.dp)
            ) {
                Text(
                    text = imageResource[1] as String,
                    fontSize = 28.sp
                )
                Row() {
                    Text(
                        text = imageResource[2] as String,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier.width(5.dp))
                    Text(
                        text = imageResource[3] as String,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { result = if(result > 1) result - 1 else 1 }) {
                Text(
                    "Previous",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .size(width = 100.dp, height = 20.dp)
                )
            }
            Spacer(modifier = modifier.width(50.dp))
            Button(onClick = { result = if(result < (imageResource.size - 1)) result + 1 else imageResource.size - 1 }) {
                Text(
                    "Next",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .size(width = 100.dp, height = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ArtSpace()
    }
}