package com.example.recyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclerview.module.ItemData

@Composable
fun DetailsScreen(id: Int) {
    val selectedItem = remember { getItemById(id) }
    selectedItem.let { item ->


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            if (item != null) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null, // Provide a meaningful description
                    modifier = Modifier
                        .fillMaxWidth()

                        .height(500.dp)

                )
            }

            if (item != null) {
                Text(
                    text = item.description,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }
            if (item != null) {
                Text(
                    text = item.price, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                        .padding(end = 25.dp)
                        .padding(top = 20.dp)
                        .align(alignment = Alignment.CenterHorizontally),

                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

fun getItemById(itemId: Int): ItemData? {
    val itemList = itemsList()
    return itemList.find { it.id == itemId }
}