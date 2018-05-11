package jp.cordea.pancake

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction

class PancakeSliceProvider : SliceProvider() {

    companion object {
        private const val Header = "/header"
        private const val Checkable = "/checkable"
        private const val Grid = "/grid"
    }

    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    override fun onMapIntentToUri(intent: Intent?): Uri {
        return super.onMapIntentToUri(intent)
    }

    override fun onBindSlice(sliceUri: Uri?): Slice? {
        sliceUri?.let {
            return when (sliceUri.path) {
                Header -> createHeaderSlice(sliceUri)
                Checkable -> createCheckableSlice(sliceUri)
                Grid -> createGridSlice(sliceUri)
                else -> null
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
                            setPrimaryAction(SliceAction(
                                    createStartActivityIntent(),
                                    IconCompat.createWithResource(
                                            context,
                                            R.drawable.ic_launcher_background
                                    ),
                                    "Go"
                            ))
                        }
                    }
                    .build()

    private fun createCheckableSlice(uri: Uri): Slice =
            ListBuilder(context, uri, ListBuilder.INFINITY)
                    .addRow {
                        it.apply {
                            setTitle("Do you like a pancake?")
                            setPrimaryAction(SliceAction(
                                    createRespondToQuestionIntent(),
                                    "Like",
                                    false
                            ))
                        }
                    }
                    .build()

    private fun createGridSlice(uri: Uri): Slice =
            ListBuilder(context, uri, ListBuilder.INFINITY)
                    .addGridRow {
                        it.apply {
                            addCell {
                                it.apply {
                                    addImage(
                                            IconCompat.createWithResource(
                                                    context,
                                                    R.drawable.ic_launcher_background
                                            ),
                                            ListBuilder.LARGE_IMAGE

                                    )
                                    addTitleText("1")
                                    addText("")
                                }
                            }
                            addCell {
                                it.apply {
                                    addImage(
                                            IconCompat.createWithResource(
                                                    context,
                                                    R.drawable.ic_launcher_background
                                            ),
                                            ListBuilder.LARGE_IMAGE

                                    )
                                    addTitleText("1")
                                    addText("")
                                }
                            }
                            addCell {
                                it.apply {
                                    addImage(
                                            IconCompat.createWithResource(
                                                    context,
                                                    R.drawable.ic_launcher_background
                                            ),
                                            ListBuilder.LARGE_IMAGE

                                    )
                                    addTitleText("1")
                                    addText("")
                                }
                            }
                        }
                    }
                    .build()

    private fun createStartActivityIntent(): PendingIntent =
            PendingIntent.getBroadcast(
                    context,
                    0,
                    Intent(context, StartActivityBroadcastReceiver::class.java),
                    0
            )

    private fun createRespondToQuestionIntent(): PendingIntent =
            PendingIntent.getBroadcast(
                    context,
                    0,
                    Intent(context, RespondToQuestionBroadcastReceiver::class.java),
                    0
            )
}
