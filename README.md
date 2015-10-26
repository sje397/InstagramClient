# Project 1 - *InstagramClient*

**InstagramClient* is an android app that allows a user to check out popular photos from Instagram. The app utilizes Instagram API to display images and basic image information to the user.

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current popular photos** from Instagram
* [x] For each photo displayed, user can see the following details:
  * [x] Graphic, Caption, Username
  * [x] Relative timestamp, like count, user profile image

The following **optional** features are implemented:

* [x] User can **pull-to-refresh** popular stream to get the latest popular photos
* [ ] Show latest comments for each photo
* [x] Display each user profile image using a [RoundedImageView](https://github.com/vinc3m1/RoundedImageView)
* [ ] Display a nice default placeholder graphic for each image during loading
* [x] Improved the user interface through styling and coloring (using icons from FontAwesome)

The following **bonus** features are implemented:

* [ ] Show last 2 comments for each photo
* [ ] Allow user to view all comments for an image within a separate activity or dialog fragment
* [ ] Allow video posts to be played in full-screen using the VideoView

The following **additional** features are implemented:

* [x] Uses RoboJuice for a little injection goodness
* [x] Uses Jackson for json parsing


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='InstagramClient.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [JodaTime Android](https://github.com/dlew/joda-time-android) - Useful Time classes
- [Jackson](https://github.com/FasterXML/jackson) - Json parsing
- [RoundedImageView](https://github.com/vinc3m1/RoundedImageView) - Easily add round images to UI
- [Android Iconify](https://github.com/JoanZapata/android-iconify) - IconTextView for displaying FontAwesome icons

## License

    Copyright 2015 Scott Ellis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
