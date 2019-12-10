package com.sunanda.attendance_kotlin.model

import java.io.Serializable

class NewTaskPojo : Serializable {

    var _id: String? = null
    var user_id: String? = null
    var address: String? = null
    var task: String? = null
    var lat: String? = null
    var lon: String? = null
    var type: String? = null
    var date_from: String? = null
    var date_to: String? = null
    var imageName: String? = null
    var time: String? = null
}