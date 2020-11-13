package com.osg.practicemvicomposenav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.osg.practicemvicomposenav.ui.PracticeMVIComposeNavTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeMVIComposeNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticeMVIComposeNavTheme {
    }
}
