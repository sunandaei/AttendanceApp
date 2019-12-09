package com.sunanda.attendance_kotlin.helper

import android.os.Environment

import java.io.File

class fetchAlbumDirectory : AlbumStorageDirFactory() {

    override fun getAlbumStorageDir(albumName: String): File {
        return File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            ),
            albumName
        )
    }
}