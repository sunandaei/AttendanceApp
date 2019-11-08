package com.sunanda.attendance_kotlin

import java.io.File

abstract class AlbumStorageDirFactory {
    abstract fun getAlbumStorageDir(albumName: String): File
}
