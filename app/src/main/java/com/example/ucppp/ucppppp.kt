package com.example.ucppp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ucppp(modifier: Modifier = Modifier) {
    // State for input fields
    var Origin by remember { mutableStateOf("") }
    var Departure by remember { mutableStateOf("") }
    var Arrival by remember { mutableStateOf("") }
    var selectedTrans by remember { mutableStateOf("") }

    // List of years for RadioButton selection
    val listTrans = listOf("Bus", "Ship", "Train", "Plane" )

    // State for submitted data
    var svOrigin by remember { mutableStateOf("") }
    var svDeparture by remember { mutableStateOf("") }
    var svArrival by remember { mutableStateOf("") }
    var svselectedTrans by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF)) // Light background for readability
    ) {
        // Header with profile picture and name
        ProfileHeader()

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
        ) {
            // Title
            Text(
                text = "Plan Your Adventures",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = "Let's plan an exquisite adventure")

            // Input container with rounded corners and background color
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF0B3599)) // Light gray for the form background
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Origin input field
                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = Origin,
                    onValueChange = { Origin = it },
                    label = { Text("Origin") },
                    placeholder = {
                        Row {
                            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Origin")
                        }
                    }
                )

                // Departure input field
                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = Departure,
                    onValueChange = { Departure = it },
                    label = { Text("Departure") },
                    placeholder = { Text("Departure") }
                )

                // Arrival input field
                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = Arrival,
                    onValueChange = { Arrival = it },
                    label = { Text("Arrival") },
                    placeholder = { Text("Arrival") }
                )

                // Trans selection with RadioButton
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    listTrans.forEach { item ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = selectedTrans == item,
                                onClick = { selectedTrans = item }
                            )
                            Text(text = item)
                        }
                    }
                }
            }

            // Submit button
            Button(
                onClick = {
                    svOrigin = Origin
                    svDeparture = Departure
                    svArrival = Arrival
                    svselectedTrans = selectedTrans
                },
                modifier = Modifier .padding(top = 16.dp)
                    .fillMaxWidth()
            ) { Text(text = "Submit") }

            // Display card for submitted data
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF0B3599)), // Dark blue for main card background
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF0B3599)) // Light blue for inner card background
                        .padding(8.dp)
                ) {
                    Detail(judul = "Origin", isinya = svOrigin)
                    Detail(judul = "Phone", isinya = svDeparture)
                    Detail(judul = "Address", isinya = svArrival)
                    Detail(judul = "Selected Trans", isinya = svselectedTrans)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0B3599)) // Blue background for header
            .padding(16.dp)
    ) {
        // Profile image with circular background
        Row (verticalAlignment = Alignment.Bottom){
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.barca), // Profile image resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(100.dp).clip(CircleShape)
                )
            }
            Box(
                modifier = Modifier
                    .offset(x = -57.dp)
                    .offset(y = 7.dp)
            ){
                Icon(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))

                    ,imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null, tint = Color.Green
                )
            }

        }

        Spacer(modifier = Modifier.width(8.dp))
        // User greeting
        Column {
            Text(text = "Rizki Agung Dzulikromi,", color = Color.White, fontSize = 20.sp)
            Text(
                text = "Sumatera Selatan",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        // Notification icon
        Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun Detail(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.1f),

            )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f),

            )
    }
}
