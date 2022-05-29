
# Face Track Android Application

This app can detect and recognize face in real time based on the trained data.
This app uses Image classification Machine learning model which is based on Supervised Learning algorithm.

# Index
1.) Working of the project

2.) Tech stacks used in the project

3.) Instruction for testing the app

4.) Application of the project


# Working of the app
The app has been trained for recognizing a criminal, lost dog or missing child.
Whenever these members are in the camera the app automatically recognizes them and 
makes sounds accordingly. Also the app instatly sends an sms to the concerned authorities
automatically.

# a) For the criminal
When the criminal has been recognized by the app's algorithm, the app starts sounding a
siren alarm so if there are people around the criminal, they can be aware and alert of
of the criminal and save themselves from any danger. Also if the criminal does not seem to have any
fire-power, the people can volunteer and grab the criminal until the concerned authorities arrive.

With the loud alarming siren the app would have already been sent an sms to the concerned authorities
about the exact pin point google map location where the criminal was spotted.
This will help in the tracking and narrowing down the radius of search.

Also this would put a psychological fear on any potential criminal that if they are identified by legal authorities 
escaping wouldn't be easy.

# b) For the missing child
If the camera detects the missing child it starts voicing "missing child" repeatedly and send an instant location sms to the investigation team.
The voicing of the app is also helpful in situations where a kidnapper has gained the innocent child's 
trust and the people around think the kidnapper to be the child's concerned person.

# c) For the Lost pet 
Similarly when the camera detects the lost dog it it starts voicing "Missing dog" so that the people 
around can know that the dog belongs to somebody and the concerned team will be soon at the location
looking for the dog as the camera has already shared the location of via sms. 

# Tech Stacks used

1) Tensorflow:

TensorFlow is an open-source end-to-end framework for building Machine Learning apps.
The image classification model for the app has been created using the Tensorflow 
library.

2) TensorFlowLite
TensorFlow Lite is an open-source, product ready, cross-platform deep learning framework that converts a pre-trained model in TensorFlow to a special format that can be optimized for speed or storage.

The special format model can be deployed on edge devices like mobiles using Android or iOS or Linux based embedded devices like Raspberry Pi or Microcontrollers to make the inference at the Edge.

The deployment of the Tensorflow model on Android was done using TensorFlowLite library

# Application
This could be deployed in survillance CCTV cameras and can also be used in Survillance drones.

### Model
Inside Assests folder zip file is there.

Resnet50 
16 batch size
100 epochs
Teachable ML

## Requirements

*   Android Studio 3.2 (installed on a Linux, Mac or Windows machine)

*   Android device in
    [developer mode](https://developer.android.com/studio/debug/dev-options)
    with USB debugging enabled

*   USB cable (to connect Android device to your computer)

## Build and run

### Step 1. Clone the TensorFlow examples source code

Clone the TensorFlow examples GitHub repository to your computer to get the demo
application.

```
https://github.com/AndroidArena/CurrencyDetectorAndroid.git
```

Open the TensorFlow source code in Android Studio. To do this, open Android
Studio and select `Open an existing project`, setting the folder to
`examples/lite/examples/image_classification/android`

<img src="images/classifydemo_img1.png?raw=true" />

### Step 2. Build the Android Studio project

Select `Build -> Make Project` and check that the project builds successfully.
You will need Android SDK configured in the settings. You'll need at least SDK
version 23. The `build.gradle` file will prompt you to download any missing
libraries.

The file `download.gradle` directs gradle to download the two models used in the
example, placing them into `assets`.

<img src="images/classifydemo_img4.png?raw=true" style="width: 40%" />

<img src="images/classifydemo_img2.png?raw=true" style="width: 60%" />

<aside class="note"><b>Note:</b><p>`build.gradle` is configured to use
TensorFlow Lite's nightly build.</p><p>If you see a build error related to
compatibility with Tensorflow Lite's Java API (for example, `method X is
undefined for type Interpreter`), there has likely been a backwards compatible
change to the API. You will need to run `git pull` in the examples repo to
obtain a version that is compatible with the nightly build.</p></aside>

### Step 3. Install and run the app

Connect the Android device to the computer and be sure to approve any ADB
permission prompts that appear on your phone. Select `Run -> Run app.` Select
the deployment target in the connected devices to the device on which the app
will be installed. This will install the app on the device.

<img src="images/classifydemo_img5.png?raw=true" style="width: 60%" />

<img src="images/classifydemo_img6.png?raw=true" style="width: 70%" />

<img src="images/classifydemo_img7.png?raw=true" style="width: 40%" />

<img src="images/classifydemo_img8.png?raw=true" style="width: 80%" />

To test the app, open the app called `TFL Classify` on your device. When you run
the app the first time, the app will request permission to access the camera.
Re-installing the app may require you to uninstall the previous installations.

## Assets folder
_Do not delete the assets folder content_. If you explicitly deleted the
files, choose `Build -> Rebuild` to re-download the deleted model files into the
assets folder.
