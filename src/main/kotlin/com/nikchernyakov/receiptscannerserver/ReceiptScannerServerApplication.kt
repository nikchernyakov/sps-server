package com.nikchernyakov.receiptscannerserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
open class ReceiptScannerServerApplication

fun main(args: Array<String>) {
    runApplication<ReceiptScannerServerApplication>(*args)
}
