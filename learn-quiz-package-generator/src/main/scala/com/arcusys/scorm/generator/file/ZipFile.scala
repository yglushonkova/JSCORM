package com.arcusys.scorm.generator.file

import java.io.{ InputStream, File, FileInputStream, FileOutputStream }
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import java.nio.channels.FileChannel.MapMode._

class ZipFile(filename: String) {
  private val zipFile = new ZipOutputStream(new FileOutputStream(filename))

  def addEntry(entryFilename: String, entryData: String) = {
    // Add ZIP entry to output stream.
    zipFile.putNextEntry(new ZipEntry(entryFilename))

    // Transfer bytes from the data to the ZIP file
    zipFile.write(entryData.getBytes("UTF-8"))
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(sourceFilename: String, destinationFilename: String) {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))

    // Transfer bytes from the file to the ZIP file
    val file = new File(sourceFilename)
    if (file.exists) {
      val in = new FileInputStream(file)
      val bytes = new Array[Byte](file.length.toInt)
      in.read(bytes)
      in.close()

      zipFile.write(bytes)
    }
    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(sourceStream: InputStream, destinationFilename: String) {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))

    // Transfer bytes from the file to the ZIP file

    try {
      var b = sourceStream.read
      while (b >= 0) {
        zipFile.write(b)
        b = sourceStream.read
      }
      sourceStream.close()
    } catch {
      case _ =>
    }

    // Complete the entry
    zipFile.closeEntry()
  }

  def addFile(destinationFilename: String, data: Array[Byte]) {
    zipFile.putNextEntry(new ZipEntry(destinationFilename))
    zipFile.write(data)
    zipFile.closeEntry()
  }

  def close() {
    zipFile.close()
  }
}
