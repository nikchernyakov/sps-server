package com.nikchernyakov.receiptscannerserver.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import org.springframework.web.bind.annotation.ResponseBody
import service.SalesReceiptScanner
import java.io.File
import java.lang.StringBuilder


@Controller
class MainController {

    var salesReceiptScanner = SalesReceiptScanner()

    @GetMapping("/")
    fun index(): String = "index.html"

    @PostMapping("/upload")
    @ResponseBody
    fun handleFileUpload(@RequestParam("file") file: MultipartFile): String {
        return if (!file.isEmpty) {
            try {
                val resultFile = File("file-uploaded.jpg")
                val stream = BufferedOutputStream(FileOutputStream(resultFile))
                stream.write(file.bytes)
                stream.close()
                val sb = StringBuilder()
                salesReceiptScanner.doScan(resultFile).purchaseInfo.items.forEach { sb.append(it.toString()) }
                sb.toString()
            } catch (e: Exception) {
                "Вам не удалось загрузить file: + \n" + e.message;
            }

        } else {
            "Вам не удалось загрузить file потому что файл пустой."
        }
    }
}