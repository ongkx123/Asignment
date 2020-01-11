package com.example.asignment

class ImageModel {
    var name:String?= null
    var image:String?= null
    var description:String?= null

    constructor(){

    }

    constructor(name: String?, image: String?, description: String?) {
        this.name = name
        this.image = image
        this.description = description
    }
}