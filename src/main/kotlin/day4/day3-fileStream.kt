package org.example.day4


import java.io.File


fun main(args: Array<String>) {
    val inputFile = "src/main/kotlin/day4/input.txt"
    val outputFile = "src/main/kotlin/day4/output.txt"

    val inputLines = File(inputFile).readLines()
    print("inputLines = \n")
    for(str_line in inputLines){
        print("\t%s\n".format(str_line))
    }

    val processedLines = processInput(inputLines)
    writeOutput(outputFile, processedLines)

    println("Data has been processed and written to $outputFile")
}


fun processInput(inputLines: List<String>): List<String> {
    return inputLines.map { it.toUpperCase() }

}

fun writeOutput(outputFile: String, lines: List<String>) {
    File(outputFile).bufferedWriter().use { out ->
        lines.forEach { line ->
            out.write(line)
            out.newLine()
        }
    }
}