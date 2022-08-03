interface Account {
    val nickname: String
}
class AccountClazz(val name: String) {
    var address: String = "unspecifited"
        set(value: String) {
            println("""
                Addresss was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}
class PrivateAccount(override val nickname: String) : Account

class SubscribeAccount(val email: String) : Account {
    override val nickname: String
        get() = email.substringBefore("@")
}

class FacebookAccount(val accountId: Int) : Account {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "facebook nickname"
    }
}

fun main(args: Array<String>) {
    println(PrivateAccount("test@kotilnlang.org").nickname)
    println(SubscribeAccount("test@kotlinlang.org").nickname)

    val account = AccountClazz("Alice")
    account.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}