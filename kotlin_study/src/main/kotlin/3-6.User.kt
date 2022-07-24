class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address")
    }
}

fun improveSaveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if(value.isNotEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address");
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if(value.isNotEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName"
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address");
}

fun saveUserWithExtensionFun(user: User){
    user.validateBeforeSave()
}
