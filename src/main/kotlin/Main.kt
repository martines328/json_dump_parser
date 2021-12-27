import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


fun main(args: Array<String>) {

    val filePAth : Path  = Paths.get("src/main/kotlin/files/")
    val listOfPathName : MutableList<String> = fetchFilePath(filePAth)
    readFile(listOfPathName)






}

fun fetchFilePath(path: Path) : MutableList<String>{

    var list : MutableList<String> = mutableListOf()
    try {

        Files.walk(path)
            .filter { item -> Files.isRegularFile(item) }
            .forEach { item -> list.add(item.toString()) }

        return list
    }catch (ex: IOException){ex.printStackTrace()}
    return list
}

fun readFile(pathNameList: MutableList<String>){

    pathNameList.iterator().forEach { item ->
        



    }

}

fun getJsonDataFromFile( jsondata : String) :String? {
    val jsonString : String

    val jsonParser = JsonParser()
    val jsonObj = jsonParser.parse(jsondata)
    //var printName = jsonObj.
    return null
}
