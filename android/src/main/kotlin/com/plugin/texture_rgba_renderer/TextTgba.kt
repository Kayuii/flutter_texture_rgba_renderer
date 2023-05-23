package com.plugin.texture_rgba_renderer

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import io.flutter.view.TextureRegistry
import java.nio.ByteBuffer

class TextRgba(private var textureRegistry: TextureRegistry?) {
    var textureEntry: TextureRegistry.SurfaceTextureEntry? = null
    private var bitmap: Bitmap? = null
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        fun new(textureRegistry: TextureRegistry?): TextRgba {
            val textRgba = TextRgba(textureRegistry)
            textRgba.textureEntry = textureRegistry?.createSurfaceTexture()
            return textRgba
        }
    }

    val textureId: Long
        get() = textureEntry?.id() ?: -1

}



    // fun markFrameAvailable(byteArray: ByteArray, width: Int, height: Int) {
    //     val buffer = ByteBuffer.wrap(byteArray)
    //     bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    //     bitmap?.copyPixelsFromBuffer(buffer)

    //     // Notify Flutter that a new frame is available.
    //     handler.post {
    //         textureEntry?.surfaceTexture()?.let { surfaceTexture ->
    //             surfaceTexture.setDefaultBufferSize(bitmap?.width ?: 0, bitmap?.height ?: 0)
    //             surfaceTexture.updateTexImage()
    //         }
    //     }
    // }

    // private fun markFrameAvailable(buffer: ByteBuffer, len: Int, width: Int, height: Int): Boolean {
    //     bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    //     bitmap!!.copyPixelsFromBuffer(buffer)
    //     // this.width = width
    //     // this.height = height

    //     return if (textureId != -1L && bitmap != null) {
    //         registry?.textureFrameAvailable(textureId)
    //         true
    //     } else {
    //         false
    //     }
    // }

    // fun markFrameAvailable(data: ByteArray, width: Int, height: Int): Boolean {
    //     val buffer = ByteBuffer.wrap(data)
    //     return markFrameAvailable(buffer, data.size, width, height)
    // }

    // TODO: Implement other methods here...
