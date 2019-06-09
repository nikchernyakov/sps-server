package com.nikchernyakov.receiptscannerserver.controllers

import data.document.PurchaseInfo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import service.SalesReceiptScanner
import java.io.File


@Controller
class MainController {

    var salesReceiptScanner = SalesReceiptScanner("src/main/resources/tess/data")

    @GetMapping("/")
    fun index(): String = "index.html"

    @PostMapping("/upload")
    @ResponseBody
    fun handleFileUpload(@RequestParam("file") file: MultipartFile): PurchaseInfo? {
        return if (!file.isEmpty) {
            try {
                val resultFile = File("file-uploaded.jpg")
                val stream = BufferedOutputStream(FileOutputStream(resultFile))
                stream.write(file.bytes)
                stream.close()
                salesReceiptScanner.doScan(resultFile).purchaseInfo
            } catch (e: Exception) {
                null
            }

        } else {
            null
        }
    }

    @PostMapping("/uploadPhoto")
    fun handlePhotoUpload(@RequestPart(name = "img") file: MultipartFile): PurchaseInfo? {
        return if (!file.isEmpty) {
            try {
                val resultFile = File("file-uploaded.jpg")
                val stream = BufferedOutputStream(FileOutputStream(resultFile))
                stream.write(file.bytes)
                stream.close()
                salesReceiptScanner.doScan(resultFile).purchaseInfo
            } catch (e: Exception) {
                null
            }

        } else {
            null
        }
    }
}