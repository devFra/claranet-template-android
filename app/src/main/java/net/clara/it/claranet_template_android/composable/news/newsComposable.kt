package net.clara.it.claranet_template_android.composable.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import net.clara.it.claranet_template_android.model.News
import java.util.*

@Composable
fun newsComposable(news: News?){
    Column {
        Image(
            painter = rememberAsyncImagePainter("${news?.image}"),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(15.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                // Topic
                Text(
                    ("${news?.topic}").uppercase(Locale.getDefault()),
                    style = TextStyle(Color.Red),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Spacer(modifier = Modifier.width(5.dp))
                Text("-")
                Spacer(modifier = Modifier.width(5.dp))
                // Date
                Text("${news?.data}")

            }
            Spacer(modifier = Modifier.height(3.dp))
            // Title
            Text(
                "${news?.title}",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            // Body
            Text(
                "${news?.body}",
                fontSize = 17.sp,
            )
        }
    }
    Spacer(modifier = Modifier.height(15.dp))


}