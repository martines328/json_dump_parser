
import com.google.gson.Gson
import files.Data
import org.w3c.dom.Node
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

    val list : MutableList<String> = mutableListOf()
    try {

        Files.walk(path)
            .filter { item -> Files.isRegularFile(item) }
            .forEach { item -> list.add(item.toString()) }

        println(list)
        return list
    }catch (ex: IOException){ex.printStackTrace()}
    return list
}

fun readFile(pathNameList: MutableList<String>){

    pathNameList.iterator().forEach { item ->

        print("\n Data from file --- $item \n")

        var jsonData = File(item).forEachLine {

           try {
              getJsonDataFromFile(it)

           } catch (ex: Exception){ex.printStackTrace()}
        }

    }

}

fun getJsonDataFromFile( jsondata : String) :String? {

    val data: Data = Gson().fromJson<Data>(jsondata, Data::class.java)
    if (data.text != null) println(data.text + " " + data.from + " " + data.to)

    return null
}
