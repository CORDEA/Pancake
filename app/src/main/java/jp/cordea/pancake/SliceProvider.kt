package jp.cordea.pancake

import android.content.Intent
import android.net.Uri
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder

class PancakeSliceProvider : SliceProvider() {

    companion object {
        private const val Header = "/header"
    }

    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    override fun onMapIntentToUri(intent: Intent?): Uri {
        return super.onMapIntentToUri(intent)
    }

    override fun onBindSlice(sliceUri: Uri?): Slice? {
        sliceUri?.let {
            if (sliceUri.path == Header) {
                return createHeaderSlice(sliceUri)
            }
        }
        return null
    }

    private fun createHeaderSlice(uri: Uri): Slice =
            ListBuilder(context, uri, ListBuilder.INFINITY)
                    .setHeader {
                        it.apply {
                            setTitle("Pancake")
                            setSubtitle("Recommended shops of pancake.")
                            setSummary("Pancakes always delicious.")
                        }
                    }
                    .addRow {
                        it.apply {
                            setTitle("1")
                            setSubtitle("")
                        }
                    }
                    .addRow {
                        it.apply {
                            setTitle("2")
                            setSubtitle("")
                        }
                    }
                    .setSeeMoreRow {
                        it.apply {
                            setTitle("Go to pancake wonderland")
                        }
                    }
                    .build()
}
