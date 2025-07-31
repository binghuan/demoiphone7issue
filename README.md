# Project: Hissing Noise - iPhone 7 Issue Demo
<img src="Icon.png" style="height:256px;width:auto">

An Android demonstration app that simulates the infamous iPhone 7 "hissing noise" issue using proximity sensor technology.

Website: <a href="http://studiobinghuan.blogspot.tw/2016/10/hissing-noise.html?view=flipcard" target="_blank">http://studiobinghuan.blogspot.tw/2016/10/hissing-noise.html?view=flipcard</a>

## Overview

This Android application demonstrates the controversial "hissing noise" issue that was reported with iPhone 7 devices in 2016. The app uses the device's proximity sensor to trigger audio playback, creating an interactive experience that mimics the original iPhone 7 behavior.

## Features

- **Proximity Sensor Integration**: Uses Android's proximity sensor to detect when objects are near the device
- **Audio Playback**: Plays a continuous hissing noise when the proximity sensor is triggered (value = 0)
- **Automatic Sound Management**: Stops audio playback when the proximity sensor is not triggered
- **iPhone Visual Theme**: Displays an iPhone image as the background
- **Fullscreen Experience**: Runs in fullscreen mode with portrait orientation lock

## Technical Details

### Requirements
- **Minimum SDK**: Android 14 (Ice Cream Sandwich)
- **Target SDK**: Android 23 (Marshmallow)
- **Compile SDK**: Android 23
- **Build Tools**: 24.0.1
- **Gradle**: 2.2.1

### Key Components

#### MainActivity.java
- Implements `SensorEventListener` to monitor proximity sensor changes
- Manages `MediaPlayer` for audio playback of the hissing noise
- Handles sensor registration/unregistration during app lifecycle
- Automatically starts/stops audio based on proximity sensor readings

#### Audio Resource
- **File**: `app/src/main/res/raw/noise.mp3`
- **Usage**: Loops continuously when proximity sensor detects nearby objects
- **Trigger**: Activated when sensor value equals 0 (object detected)

#### UI Design
- **Layout**: Simple fullscreen layout with iPhone background image
- **Theme**: No title bar, fullscreen experience
- **Orientation**: Locked to portrait mode
- **Background**: iPhone device image (`app/src/main/res/drawable/iphone.png`)

## How It Works

1. **App Launch**: The app initializes the proximity sensor and sets up the audio player
2. **Sensor Monitoring**: Continuously monitors the proximity sensor for changes
3. **Audio Trigger**: When an object is detected near the sensor (value = 0), the hissing noise starts playing
4. **Audio Stop**: When no object is detected (value > 0), the audio stops immediately
5. **Lifecycle Management**: Properly handles sensor registration/unregistration during app pause/resume cycles

## Installation & Usage

### Building the Project
```bash
# Clone the repository
git clone <repository-url>

# Open in Android Studio or build with Gradle
./gradlew assembleDebug
```

### Running the App
1. Install the APK on an Android device with a proximity sensor
2. Launch the "Hissing Noise" app
3. Cover the proximity sensor (usually near the front camera/speaker) with your hand or finger
4. Listen for the hissing noise to start playing
5. Remove your hand to stop the noise

## Background: iPhone 7 Hissing Issue

This app was created to demonstrate the iPhone 7 "hissing noise" controversy from 2016, where some iPhone 7 devices would emit a subtle hissing sound during intensive processing. This Android implementation provides an interactive way to experience a similar audio effect triggered by proximity detection.

## Project Structure

```
app/
├── src/main/
│   ├── java/com/bh/android/demoiphone7/
│   │   └── MainActivity.java              # Main activity with sensor logic
│   ├── res/
│   │   ├── drawable/iphone.png           # iPhone background image
│   │   ├── layout/activity_main.xml      # Main layout file
│   │   ├── raw/noise.mp3                 # Hissing noise audio file
│   │   └── values/strings.xml            # App name and strings
│   └── AndroidManifest.xml               # App configuration
└── build.gradle                          # Module build configuration
```
