package kekw.ngs.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kekw.ngs.superheroapp.model.HeroesRepository
import kekw.ngs.superheroapp.ui.theme.SuperHeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeroApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HeroApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)){
            items(HeroesRepository.heroes){
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SuperHeroAppTheme(darkTheme = false) {
        HeroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun AppDarkThemePreview() {
    SuperHeroAppTheme(darkTheme = true) {
        HeroApp()
    }
}