package org.example.day4

import java.io.FileInputStream
import java.io.IOException
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStreamReader
import kotlin.jvm.Throws

@Throws(IOException::class)
fun main(args: Array<String>){
//    val file_name = "src/main/kotlin/day4/student_records.txt"
//    var fin: FileReader? = null
//    fin = FileReader(file_name)
//    var ch: Int
//    while (fin.read().also {ch = it } != -1)
//        print(ch.toChar())
//    fin.close()



//    val kor_str = "대한민국 한글"
//    val kor_bytes = kor_str.toByteArray()
//    val str_byte = String(kor_bytes)
//    println(str_byte)

    var cin : InputStreamReader = InputStreamReader(System.`in`)
    val fout : FileWriter

    var ch : Int
    var fout_name : String = "src/main/kotlin/day4/keyboard_input_text.txt"
    System.out.printf("Input text sentences (Ctrl-D to end) : ")
    try {
        fout = FileWriter(fout_name)
        while (true) {
            ch = cin.read()
            if (ch == -1) {
                break
            }
            fout.write(ch)
        }
        cin.close()
        fout.close()
    } catch (e: IOException) {
        System.out.printf("Exception in input/output !!")
    }

    val fin_name : String = "src/main/kotlin/day4/keyboard_input_text.txt"
    val fin : FileInputStream
    System.out.printf("\nContents of textfile (%s) : \n", fin_name)
    try {
        fin = FileInputStream(fin_name)
        cin = InputStreamReader(fin, "UTF-8")
        System.out.printf("Encoding char set = %s\n", cin.getEncoding())
        while(true){
            ch = cin.read()
            if (ch == -1) {
                break
            }
            System.out.printf("%c", ch)
        }
        cin.close()
        fin.close()
    } catch (e: IOException) {
        System.out.printf("IOException in text reading !!\n")
    }


}