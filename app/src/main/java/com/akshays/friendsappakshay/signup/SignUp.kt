package com.akshays.friendsappakshay.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshays.friendsappakshay.R

@Composable
@Preview(device = Devices.PIXEL_4A)
fun SignUp(modifier: Modifier = Modifier) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        ScreenTitle(R.string.create_an_account)
        Spacer(modifier = Modifier.height(16.dp))
        EmailField(value = email,
            onValueChanged = {
                email = it
            })
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(value = password,
            onValueChanged = {
                password = it
            })
        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.signup))
        }

    }
}

@Composable
private fun PasswordField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    var isVisible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        label = {
            Text(stringResource(id = R.string.password))
        },
        trailingIcon = {

            VisibilityToggle(isVisible) {
                isVisible = !isVisible
            }


        },
        value = value, onValueChange = onValueChanged
    )
}

@Composable
private fun VisibilityToggle(isVisible: Boolean,
                             onToggle:() -> Unit) {
 //   var isVisible1 = isVisible
    IconButton(onClick = {
        onToggle()
    }) {
        Image(
            painter = if (isVisible) painterResource(id = R.drawable.ic_visible) else painterResource(id = R.drawable.in_invisible),
            contentDescription = stringResource(
                id = R.string.toggleVisibility
            )
        )
    }
}

@Composable
private fun EmailField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(stringResource(id = R.string.email))
        },
        value = value, onValueChange = onValueChanged
    )
}

@Composable
private fun ScreenTitle(stringRes: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = stringRes), style = typography.headlineLarge)
    }
}