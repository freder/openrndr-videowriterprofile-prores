package org.openrndr.ffmpeg


// https://ottverse.com/ffmpeg-convert-to-apple-prores-422-4444-hq/
class ProResProfile : VideoWriterProfile() {
    override var fileExtension = "mkv"

    val CODEC_PRORES_KS = "prores_ks"
    val CODEC_PRORES_AS = "prores_as"
    var videoCodec = CODEC_PRORES_KS as String?

    var vendor = "apl0" as String?
    var profile = "3" as String? // 422 HQ
    var bitsPerMb = "8000" as String? // How many bits to allot for coding one macroblock. Different profiles use between 200 and 2400 bits per macroblock, the maximum is 8000.
    var pixelFormat = "yuv422p10le" as String?
    var userArguments = emptyArray<String>()

    override fun arguments(): Array<String> {
        val pixelFormatArguments = pixelFormat?.let {
            arrayOf("-pix_fmt", it)
        } ?: emptyArray()
        val profileArguments = profile?.let {
            arrayOf("-profile:v", it)
        } ?: emptyArray()
        val videoCodecArguments = videoCodec?.let {
            arrayOf("-c:v", it)
        } ?: emptyArray()
        val vendorArguments = vendor?.let {
            arrayOf("-vendor", it)
        } ?: emptyArray()
        val bitsPerMbArguments = bitsPerMb?.let {
            arrayOf("-bits_per_mb", it)
        } ?: emptyArray()

        val arguments =
            videoCodecArguments +
            profileArguments +
            vendorArguments +
            bitsPerMbArguments +
            pixelFormatArguments +
            userArguments

        return arguments
    }
}