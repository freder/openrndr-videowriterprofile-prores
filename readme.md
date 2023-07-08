example:

```kotlin
// ...
val recorder = ScreenRecorder().apply {
    prores {
        fileExtension = "mov"
        bitsPerMb = "5000"
        // ...
    }
}
extend(recorder)
// ...
```
