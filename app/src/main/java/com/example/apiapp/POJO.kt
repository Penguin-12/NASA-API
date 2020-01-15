package com.example.apiapp

class POJO(
    copyright: String,
    date: String,
    explanation: String,
    hdurl: String,
    media_type: String,
    service_version: String,
    title: String,
    url: String
) {


    var copyright: String
        internal set
    var date: String
        internal set
    var explanation: String
        internal set
    var hdurl: String
        internal set
    var media_type: String
        internal set
    var service_version: String
        internal set
    var title: String
        internal set
    var url: String
        internal set

    init {
        this.copyright = copyright
        this.date = date
        this.explanation = explanation
        this.hdurl = hdurl
        this.media_type = media_type
        this.service_version = service_version
        this.title = title
        this.url = url
    }
}
