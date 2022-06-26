
class PersonWithMarry(
        val name: String,
        var isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main(args: Array<String>){
    val person = PersonWithMarry("Jung", false)

    println(person.name)
    println(person.isMarried)
    person.isMarried = true
    println(person.isMarried)

}
