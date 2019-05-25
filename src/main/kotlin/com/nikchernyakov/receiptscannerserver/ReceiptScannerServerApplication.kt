package com.nikchernyakov.receiptscannerserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReceiptScannerServerApplication

fun main(args: Array<String>) {
    runApplication<ReceiptScannerServerApplication>(*args)
}
