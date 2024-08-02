package com.android.mvvm_with_jetpack.features.screen.listScreen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import coil.compose.rememberImagePainter
import com.android.mvvm_with_jetpack.data.model.Article
import com.android.mvvm_with_jetpack.ui.theme.MVVMExampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay


class MainActivity : ComponentActivity() {


//    public var list:ArrayList<String> = ArrayList<String>()
//var stringdata :String="DFsdfs"
//    private val listScreenViewModell: ListScreenViewModel by viewModels()


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val newsViewModel: ListScreenViewModel by viewModels()
            val articles by newsViewModel.articles

            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("Jetpack Compose MVVM News") })
                },
                content = {
                    NewsList(articles = articles)
                }
            )


        }



    }
    @Composable
    private fun TestDAta(data:String) {
        Text(text = data)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMExampleTheme {
//        allBtn()
    }
}


@Composable
fun ItemList(items: List<Article>) {
    LazyColumn {
        items(items) { item ->
            ListItem(item = item)
        }
    }
}


@Composable
fun ListItem(item: Article) {
    Row(modifier = Modifier.padding(8.dp)) {

        Image(
            painter = rememberImagePainter(item.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = item.title)
    }
}

@Composable
fun NewsList(articles: List<Article>) {
    LazyColumn {
        items(articles) { article ->
            NewsItem(article)
        }
    }
}

@Composable
fun NewsItem(article: Article) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = article.title, style = MaterialTheme.typography.titleSmall)
        article.urlToImage?.let { urlToImage ->
            Image(
                painter = rememberImagePainter(urlToImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }
        Text(text = article.description ?: "", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
    }
}
