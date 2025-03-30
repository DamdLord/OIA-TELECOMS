package com.example.oiatelecoms.auth
import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.Executor

fun isBiometricAvailable(activity: FragmentActivity): Boolean {
    val biometricManager = BiometricManager.from(activity)
    return when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
        BiometricManager.BIOMETRIC_SUCCESS -> true
        else -> false
    }
}

fun showBiometricPrompt(
    activity: FragmentActivity,
    onSuccess: () -> Unit,
    onFailure: (String) -> Unit
) {
    val executor: Executor = ContextCompat.getMainExecutor(activity)

    val biometricPrompt = BiometricPrompt(
        activity,  // No casting needed
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onFailure(errString.toString())
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                onFailure("Authentication failed. Try again.")
            }
        })

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Biometric Authentication")
        .setSubtitle("Use your fingerprint or face to unlock")
        .setNegativeButtonText("Cancel")
        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
        .build()

    biometricPrompt.authenticate(promptInfo)
}

@Composable
fun BiometricAuth(
    onSuccess: () -> Unit,
    onFailure: (String) -> Unit,
    activity: FragmentActivity,
    modifier: Modifier
    ) {
    var errorMessage by remember { mutableStateOf<String?>(null) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = {
            try {
                if (isBiometricAvailable(activity)) {
                    showBiometricPrompt(
                        activity,
                        onSuccess = onSuccess,
                        onFailure = onFailure
                    )
                } else {
                    errorMessage = "Biometric isn't available"
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.localizedMessage}"
            }
        }, modifier.size(75.dp)) {
            Icon(imageVector = Icons.Default.Fingerprint, contentDescription = "Biometrics", modifier.size(70.dp))
        }
        errorMessage?.let { message ->
            Text(text = message, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 8.dp))
        }
    }
}
