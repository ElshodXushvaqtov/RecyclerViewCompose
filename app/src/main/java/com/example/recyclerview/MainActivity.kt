package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerview.ui.theme.RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val itemList: MutableList<ItemData> = mutableListOf()
                    itemList.add(ItemData(0, "Calvin 0", "$43", R.drawable.man_tshirt))
                    itemList.add(ItemData(1, "Calvin 1", "$43", R.drawable.man_tshirt))
                    itemList.add(ItemData(2, "Calvin 2", "$43", R.drawable.man_tshirt))
                    itemList.add(ItemData(3, "Calvin 3", "$43", R.drawable.man_tshirt))
                    itemList.add(ItemData(4, "Calvin 4", "$43", R.drawable.man_tshirt))

                    LazyVerticalGrid(

                        GridCells.Fixed(2)

                    ) {

                        items(itemList) {
                            Item(it)
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Item(itemData: ItemData) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Box() {

            Image(
                painter = painterResource(id = itemData.imageRes),
                contentDescription = null,
                Modifier
                    .width(180.dp)
            )
            IconButton(
                onClick = {},
                Modifier.align(Alignment.TopEnd)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = null
                )

            }
        }
        Text(text = itemData.description)
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center) {

            Text(text = "$52", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = itemData.price,
                textDecoration = TextDecoration.LineThrough,
                style = TextStyle(

                    color = Color(0xFF747474)

                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "20% OFF", style = TextStyle(

                    color = Color(0xFFFF6500)

                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.Center) {

            Image(
                painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier
                    .height(22.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "4.1")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "(87)", style = TextStyle(

                    color = Color(0xFF747474)

                )
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecyclerViewTheme {
    }
}