package kr.ac.kumoh.s20250000.s25w05intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import kr.ac.kumoh.s20250000.s25w05intent.ui.theme.S25W05IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S25W05IntentTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val intentItems: List<Pair<String, String>> = listOf(
        "유튜브" to "https://www.youtube.com/results?search_query=android+developers",
        "인스타그램" to "https://www.instagram.com/blackpinkofficial/",
        "페이스북" to "https://www.facebook.com/bangtan.official",
        "우리집 좌표" to "geo:36.145014,128.393047?z=17",
        "우리집 주소" to "geo:0,0?q=국립금오공과대학교",
        "전화" to "tel:054-478-7114",
        "문자" to "sms:054-478-7114",
        "유튜브" to "https://www.youtube.com/results?search_query=android+developers",
        "인스타그램" to "https://www.instagram.com/blackpinkofficial/",
        "페이스북" to "https://www.facebook.com/bangtan.official",
        "우리집 좌표" to "geo:36.145014,128.393047?z=17",
        "우리집 주소" to "geo:0,0?q=국립금오공과대학교",
        "전화" to "tel:054-478-7114",
        "문자" to "sms:054-478-7114",
        "유튜브" to "https://www.youtube.com/results?search_query=android+developers",
        "인스타그램" to "https://www.instagram.com/blackpinkofficial/",
        "페이스북" to "https://www.facebook.com/bangtan.official",
        "우리집 좌표" to "geo:36.145014,128.393047?z=17",
        "우리집 주소" to "geo:0,0?q=국립금오공과대학교",
        "전화" to "tel:054-478-7114",
        "문자" to "sms:054-478-7114",

    )

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(intentItems) { item ->
                IntentButton(item = item)
            }
        }
    }
}

@Composable
fun IntentButton(
    modifier: Modifier = Modifier,
    item: Pair<String, String>,
) {
    val context = LocalContext.current
    val (text, link) = item

    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {
            val uri = link.toUri()
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }
    ) {
        Text(text)
    }
}